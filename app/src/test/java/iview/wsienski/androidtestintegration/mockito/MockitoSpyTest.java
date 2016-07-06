package iview.wsienski.androidtestintegration.mockito;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

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

    @Spy
    List<String> spiedList = new ArrayList<String>();

    @Test
    public void whenUseSpyAnnotation_thenSpyIsInjected() {
        spiedList.add("one");
        spiedList.add("two");

        assertEquals(2, spiedList.size());

    }
}
