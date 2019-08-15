package com.example.rxapp;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isA;
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

    @Test
    public void testMoreThanOneReturnValue()  {
        Iterator<String> i= mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks").thenReturn("android");
        String actual= i.next()+" "+i.next()+" "+i.next();
        //assert
        String expected = "Mockito rocks android";
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnValueDependentOnMethodParameter()  {
        Comparable<String> c= mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        int expected = 1;
        int actual = c.compareTo("Mockito");
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnValueInDependentOnMethodParameter()  {
        Comparable<Integer> c= mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        //assert
        assertEquals(-1, c.compareTo(19));
    }

    @Test
    public void testReturnValueInDependentOnMethodParameter2()  {
        Comparable<Todo> c= mock(Comparable.class);
        when(c.compareTo(isA(Todo.class))).thenReturn(0);
        //assert
        assertEquals(0, c.compareTo(new Todo(3)));
    }

}
