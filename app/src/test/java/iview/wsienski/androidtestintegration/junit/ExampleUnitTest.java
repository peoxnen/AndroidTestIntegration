package iview.wsienski.androidtestintegration.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import iview.wsienski.androidtestintegration.Calculator;
import iview.wsienski.androidtestintegration.testcategories.FastTest;
import iview.wsienski.androidtestintegration.testcategories.SlowTests;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test @Category(SlowTests.class)
    public void addition_isCorrect() throws Exception {
        System.out.print("addition_isCorrect");
        assertEquals(4, 2 + 2);
    }
    @Test @Category(FastTest.class)
    public void calculator_addition_isCorrect(){
        System.out.print("calculator_addition_isCorrect");
        Assert.assertEquals(4, Calculator.sum(2,2));
    }
}