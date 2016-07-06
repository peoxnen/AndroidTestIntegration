package iview.wsienski.androidtestintegration.mockito;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Witold Sienski on 06.07.2016.
 */
public class MockitoSpyTest {

    @Test
    public void testSpyDoReturn(){
        List list = new ArrayList();
        List spy = spy(list);
        doReturn("test").when(spy).get(0);
        Assert.assertEquals("test", spy.get(0));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSpyThenReturn(){
        List list = new ArrayList();
        List spy = spy(list);
        when(spy.get(0)).thenReturn("foo");
        assertThat("test", not(spy.get(0)));

    }
}
