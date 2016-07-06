package iview.wsienski.androidtestintegration.mockito;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Witold Sienski on 06.07.2016.
 */
public class MockitoBasicTest {


    @Mock
    public List mockList = mock(List.class);

    @Test
    public void testAddToList(){
        mockList.add("test1");
        verify(mockList).add("test1");
    }

    @Test
    public void testNeverAddToList(){
        verify(mockList, never()).add("test1");
    }

    @Test
    public void testClearList(){
        mockList.clear();
        verify(mockList).clear();
    }

    @Test
    public void testReturn(){
        when(mockList.get(0)).thenReturn("test1");
        assertEquals(mockList.get(0), "test1");
    }

    @Test
    public void testManyReturnValue()  {
        Iterator i= mock(Iterator.class);
        when(i.next()).thenReturn("test1").thenReturn("test2");
        String res=i.next()+""+i.next();
        assertEquals("test1test2", res);
    }

    @Test
    public void testDependentOnParameter(){
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyString())).thenReturn(0);
        assertEquals(0, c.compareTo("test"));
    }

    @Test(expected=RuntimeException.class)
    public void testForIOException() {
        ArrayList s = mock(ArrayList.class);
        doThrow(new RuntimeException()).when(s).get(anyInt());
        s.get(22);
    }
}
