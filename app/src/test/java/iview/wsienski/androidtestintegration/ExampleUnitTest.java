package iview.wsienski.androidtestintegration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void calculator_addition_isCorrect(){
        assertEquals(4, Calculator.sum(2,2));
    }
}