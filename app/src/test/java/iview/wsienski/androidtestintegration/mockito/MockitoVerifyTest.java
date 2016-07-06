package iview.wsienski.androidtestintegration.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import iview.wsienski.androidtestintegration.Calculator;

import static org.mockito.Mockito.*;

/**
 * Created by Witold Sienski on 06.07.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoVerifyTest {

    @Mock
    Calculator calculator;

    @Test
    public void testMethodCallNumber(){
        calculator.exampleMethod();
        calculator.exampleMethod();
        verify(calculator, times(2)).exampleMethod();

    }

    @Test
    public void testNever(){
        verify(calculator, never()).exampleMethod();
    }

    @Test
    public void testAtLeastOnce(){
        calculator.exampleMethod();
        calculator.exampleMethod();
        verify(calculator, atLeastOnce()).exampleMethod();
    }

    @Test
    public void testAtLeast(){
        calculator.exampleMethod();
        calculator.exampleMethod();
        calculator.exampleMethod();
        verify(calculator, atLeast(3)).exampleMethod();
    }

    @Test
    public void testAtMost(){
        calculator.exampleMethod();
        verify(calculator, atMost(1)).exampleMethod();
    }
}
