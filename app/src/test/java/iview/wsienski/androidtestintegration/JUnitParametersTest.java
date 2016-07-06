package iview.wsienski.androidtestintegration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Created by Witold Sienski on 06.07.2016.
 */
@RunWith(Parameterized.class)
public class JUnitParametersTest {

    @Parameterized.Parameter
    public String text;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Collection<String> coll = Arrays.asList("test1", "test2", "test3");
        Collection<Object[]> params = new ArrayList<Object[]>();
        for (String s : coll) {
            params.add(new Object[] { s });
        }
        return params;
    }


    @Test
    public void testContaintsTest(){
        assertTrue(text.contains("test"));
    }
}
