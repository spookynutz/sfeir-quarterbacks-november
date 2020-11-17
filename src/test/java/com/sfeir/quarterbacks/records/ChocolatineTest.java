package com.sfeir.quarterbacks.records;

import org.junit.jupiter.api.Test;

import java.lang.reflect.RecordComponent;

import static org.assertj.core.api.Assertions.assertThat;

class ChocolatineTest {

    @Test
    void should_not_be_empty_because_chocolatines_have_a_name_attribute(){
        // Given
        Class<Chocolatine> chocolatineClass = Chocolatine.class;

        // When
        RecordComponent[] actual = chocolatineClass.getRecordComponents();

        // Then
        // new RecordComponent(); -> only the JVM can create RecordComponents
        // Expecting empty but was:<[java.lang.String name]>
        assertThat(actual).isNotEmpty();
    }

    @Test
    void should_be_true_when_asking_if_chocolatines_are_records(){
        // Given
        Class<Chocolatine> chocolatineClass = Chocolatine.class;

        // When
        boolean actual = chocolatineClass.isRecord();

        // Then
        assertThat(actual).isTrue();
    }

}