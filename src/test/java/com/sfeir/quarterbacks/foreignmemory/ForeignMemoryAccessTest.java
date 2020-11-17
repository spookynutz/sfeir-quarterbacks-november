package com.sfeir.quarterbacks.foreignmemory;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryHandles;
import jdk.incubator.foreign.MemorySegment;
import org.junit.jupiter.api.Test;

import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;

import static org.assertj.core.api.Assertions.assertThat;

public class ForeignMemoryAccessTest {

    @Test
    void should_be_able_to_store_value_in_memory_and_get_back_value_from_it(){
        // Given
        VarHandle integerHandle = MemoryHandles.varHandle(int.class, ByteOrder.nativeOrder());
        try (MemorySegment segment = MemorySegment.allocateNative(1024)) {

            MemoryAddress base = segment.baseAddress();

            // print memory address
            System.out.println(base);

            // Initialise la valeur 42 dans la memoire externe
            integerHandle.set(base, 42);

            // When
            Object actual = integerHandle.get(base);

            // Then
            // Recupere la valeur de la memoire externe
            int expected = 42;
            assertThat(actual).isEqualTo(expected);
        }
    }
}
