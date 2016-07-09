package iview.wsienski.androidtestintegration.robolectric;

import android.content.Intent;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import iview.wsienski.androidtestintegration.BuildConfig;
import iview.wsienski.androidtestintegration.MainActivity;
import iview.wsienski.androidtestintegration.R;
import iview.wsienski.androidtestintegration.SecondActivity;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Witold Sienski on 09.07.2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=22)
public class MainActivityTest {

    private MainActivity activity;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.buildActivity( MainActivity.class )
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( activity );
    }

    @Test
    public void testButton(){
        Button button = (Button) activity.findViewById( R.id.button_startSecondActivity );
        button.performClick();
        Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
        assertEquals(SecondActivity.class.getCanonicalName(), intent.getComponent().getClassName());
    }

}
