package CalculatorTest;

import Calculator.StackCalculator;
import ExceptionPackage.ConfigException;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static java.lang.Double.parseDouble;

public class StackCalculatorTest {
    StackCalculator calculator;
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeSuite
    public void createCalculator() {
        try {
            calculator = new StackCalculator("commandConfig.txt");
        } catch (ConfigException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testPrint() {
        testing("""
                PUSH 2.2
                PRINT
                """, 2.2);
    }

    @Test
    public void testSum() {
        testing("""
                PUSH 2.33
                PUSH 4.25
                +
                PRINT
                """, 2.33 + 4.25);
    }

    @Test
    public void testSub() {
        testing("""
                PUSH 2.36
                PUSH 4.22
                -
                PRINT
                """, 4.22 - 2.36);
    }

    @Test
    public void testDiv() {
        testing("""
                PUSH 63.87
                PUSH 92.54
                /
                PRINT
                """, 92.54 / 63.87);
    }

    @Test
    public void testMul() {
        testing("""
                PUSH 43.25
                PUSH 65.47
                *
                PRINT
                """, 65.47 * 43.25);
    }

    @Test
    public void testSqrt() {
        testing("""
                PUSH 456.342
                SQRT
                PRINT
                """, Math.sqrt(456.342));
    }

    @Test
    public void testPop() {
        testing("""
                PUSH 364.233
                POP
                """, 364.233);
    }

    @Test
    public void testDefine() {
        testing("""
                DEFINE a 435.244
                PUSH a
                PRINT
                """, 435.244);
    }

    @Test
    public void testSave() {
        testing("""
                PUSH 543.92
                SAVE a
                PUSH a
                +
                PRINT
                """, 543.92 + 543.92);
    }

    public void testing(String input, double output) {
        byte[] byteInput = input.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteInput);
        outputStream.reset();
        calculator.calc(inputStream, outputStream);
        double answer = parseDouble(outputStream.toString());
        Assert.assertEquals(answer, output);
    }
}