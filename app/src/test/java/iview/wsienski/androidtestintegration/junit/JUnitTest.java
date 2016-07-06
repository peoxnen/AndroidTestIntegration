package iview.wsienski.androidtestintegration.junit;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

/**
 * Created by Witold Sienski on 05.07.2016.
 */
public class JUnitTest {

    @Test
    public void testAssertTrue() {
        assertTrue("failure | excepted true", true);
    }

    @Test
    public void testAsserFalse(){
        assertFalse("failure | excepted false", false);
    }

    // Core Hamcrest Matchers
    @Test
    public void testHarmestCoreMatchersNewInstance(){
        Object object = new Object();
        assertThat(object, sameInstance(object));
    }

    @Test
    public void testHarmestCoreMatchersAllOf(){
        assertThat("android-test-integration", allOf(startsWith("android"), containsString("test"), endsWith("integration")));
    }

    @Test
    public void testHarmestCoreMatchersNot(){
        assertThat("android-test-integration", not(nullValue()));
    }

    @Test
    public void testHarmestCoreMatchersAnyOf(){
        assertThat("android-test-integration", anyOf(startsWith("nice"), containsString("test"), endsWith("ends")));
    }

    @Test
    public void testHarmestCoreMatchersEveryItem(){
        assertThat(Arrays.asList(new String[] { "alpha", "adam", "angel" }), everyItem(startsWith("a")));

    }

    @Test
    public void testCombineMatcher(){
        assertThat(5, CombinableMatcher.either(equalTo(4)).or(equalTo(5)));
    }

    @Test
    public void testCombineMatcherEither(){
        assertThat(5, not(CombinableMatcher.either(equalTo(4)).or(equalTo(6))));
    }

    @Test
    public void testHasItems(){
        assertThat(Arrays.asList("small", "smaller","big"), hasItems("big", "small"));
    }

    @Test
    public void testBothStartWith(){
        assertThat("test",both(startsWith("te")).and(endsWith("st")));
    }

    @Test
    public void testSame() {
        Integer num1 = Integer.valueOf(1);
        Integer num2 = num1;
        assertSame("not same", num1, num2);
    }

    @Test
    public void testNotSame(){
        Integer num1 = Integer.valueOf(1);
        Integer num2 = Integer.valueOf(2);
        assertNotSame("same", num1, num2);
    }

    @Test
    public void testArrayEquals(){
        char[] tab1= "trial".toCharArray();
        char[] tab2= "trial".toCharArray();
        assertArrayEquals("arrays not same", tab1, tab2);
    }

    @Ignore
    @Test
    public void testNotNull(){
        String s = null;
        assertNotNull(s);
    }

    @Test(expected = NullPointerException.class)
    public void testExceptNullPointerExc(){
        String s = null;
        s.length();
    }

}
