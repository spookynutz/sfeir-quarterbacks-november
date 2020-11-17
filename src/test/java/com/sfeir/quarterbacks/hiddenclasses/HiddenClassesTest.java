package com.sfeir.quarterbacks.hiddenclasses;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

public class HiddenClassesTest {

    @Test
    void should_be_able_to_find_the_meaning_of_life() throws Throwable {

        String encoded = encodeMySecretHiddenClass();

        byte[] classInBytes = Base64.getDecoder().decode(encoded);

        Class<?> proxy = MethodHandles
                .lookup()
                .defineHiddenClass(classInBytes, true, MethodHandles.Lookup.ClassOption.NESTMATE)
                .lookupClass(); // throws IllegalAccessException

        System.out.println(proxy.getName());

        MethodHandle methodHandle = MethodHandles
                .lookup()
                .findStatic(proxy, "whatIsTheMeaningOfLife", MethodType.methodType(Integer.class));

        Integer theMeaningOfLife = (Integer) methodHandle.invokeExact();

        assertThat(theMeaningOfLife).isEqualTo(42);
    }

    private String encodeMySecretHiddenClass() throws IOException {

        Class hiddenClass = MySecretHiddenClass.class;

        // com.sfeir.quarterbacks.hiddenclasses.MySecretHiddenClass
        String className = hiddenClass.getName();

        // com/sfeir/quarterbacks/hiddenclasses/MySecretHiddenClass.class
        String classAsPath = className.replace('.', '/') + ".class";

        byte[] bytes = hiddenClass.getClassLoader().getResourceAsStream(classAsPath).readAllBytes();

        return Base64.getEncoder().encodeToString(bytes);
    }

    @Test
    void the_unsafe_way_of_doing_things_that_has_been_deprecated() throws Throwable {

        String encoded = encodeMySecretHiddenClass();

        byte[] classInBytes = Base64.getDecoder().decode(encoded);

        Field theUnsafe = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        sun.misc.Unsafe unsafe = (sun.misc.Unsafe) theUnsafe.get(null);

        Class<?> proxy = unsafe.defineAnonymousClass(HiddenClassesTest.class, classInBytes, null);

        MethodHandle methodHandle = MethodHandles
                .lookup()
                .findStatic(proxy, "whatIsTheMeaningOfLife", MethodType.methodType(Integer.class));

        Integer theMeaningOfLife = (Integer) methodHandle.invokeExact();

        assertThat(theMeaningOfLife).isEqualTo(42);
    }
}
