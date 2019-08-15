package com.example.rxapp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTests {

    @Test
    public void test1()  {
        //  create mock
        MyClass test = mock(MyClass.class);
       

        // define return value for method getUniqueId()
        when(test.getUniqueId()).thenReturn(43);

        // use mock in test....
        int expected =43;
        int actual = test.getUniqueId();
        assertEquals(expected, actual);
    }
}
