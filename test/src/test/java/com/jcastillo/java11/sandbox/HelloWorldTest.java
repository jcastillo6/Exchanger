package com.jcastillo.java11.sandbox;

import static org.junit.jupiter.api.Assertions.*;
import static com.jcastillo.java11.sandbox.HelloWorld.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HelloWorldTest {


    @Test
    public void testImmutableCollections() {

        List<String> fruits = List.of("Mangosteen", "Durian fruit", "Longan");

        assertThrows(UnsupportedOperationException.class, () -> {
            fruits.add("Mango");
            fruits.remove(1);
        });

        assertEquals(3, fruits.size());

    }
    
    
    @Test
    public void testMergeSort() {
    	
    	int[] a = new int[] {4,2,1,6,3,0};
    	int[] as = new int[] {0,1,2,3,4,6};
    	mergeSort(a, a.length);
    	assertTrue(Arrays.equals(a, as));
    	
    }
}
