package iview.wsienski.androidtestintegration;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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

}
