package iview.wsienski.androidtestintegration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Witold Sienski on 06.07.2016.
 */
public class JUnitVogTest {

    long time;

    @BeforeClass
    public void prepareOncBeforeTests(){

    }

    @Before
    public void prepareForEachTest() {
        time = 100;
    }

    @Test(timeout = 200)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(time);
    }

    @After
    public void afterEachTest(){
        time = 300;
    }

    @AfterClass
    public void afterOnceAfterTests(){

    }


    @Test(timeout = 200)
    public void testTimeoutLong() throws InterruptedException {
        Thread.sleep(time);
    }
}
