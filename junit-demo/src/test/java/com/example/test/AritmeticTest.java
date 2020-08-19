package com.example.test;

import com.example.Arithmetic;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AritmeticTest {

    private int a;
    private int b;
    private int expected;

    public AritmeticTest(int a, int b, int expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection parameters(){
        return Arrays.asList(new Object[][]{
                {10,20,30},
                {2,2,4},
                {1,1,3}
        });
    }

    @Test
    public void addTest() {
        Arithmetic arithmetic = new Arithmetic();
        int result = arithmetic.add(a, b);

        Assert.assertEquals(expected, result);
    }
}
