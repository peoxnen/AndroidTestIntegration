package iview.wsienski.androidtestintegration.mockito;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import iview.wsienski.androidtestintegration.Calculator;
import iview.wsienski.androidtestintegration.Scores;

import static org.junit.Assert.assertEquals;

/**
 * Created by Witold Sienski on 06.07.2016.
 */
//TODO create better example of annotation InjectMocks use
@RunWith(MockitoJUnitRunner.class)
public class MockitoInjectMocksTest {

    @Mock
    Context context;

    @InjectMocks
    private Calculator calculator;

    @Test
    public void testShouldDoSomething() {
        calculator.exampleMethod();

    }

    @Mock
    Map<String, String> scores;

    @InjectMocks
    Scores dic = new Scores();

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(scores.get("adam")).thenReturn("two");
        assertEquals("two", dic.getScore("adam"));
    }
}
