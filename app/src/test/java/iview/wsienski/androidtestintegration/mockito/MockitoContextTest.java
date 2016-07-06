package iview.wsienski.androidtestintegration.mockito;

import android.content.Context;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import iview.wsienski.androidtestintegration.Calculator;
import iview.wsienski.androidtestintegration.R;

import static org.mockito.Mockito.when;

/**
 * Created by Witold Sienski on 06.07.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoContextTest {

    @Mock
    Context context;

    @Test
    public void testCalculator(){
        Calculator calculator = new Calculator(context);
        when(context.getString(R.string.app_name))
                .thenReturn("AndroidTestIntegration");
        Assert.assertEquals("AndroidTestIntegration",
                calculator.getDefaultValue());
    }
}
