package iview.wsienski.androidtestintegration.robolectric;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import iview.wsienski.androidtestintegration.BuildConfig;
import iview.wsienski.androidtestintegration.MainActivity;

/**
 * Created by Witold Sienski on 09.07.2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=22)
public class MaiAcivityLifeCycleTest {

    @Test
    public void testLifeCycle(){
        ActivityController controller = Robolectric.buildActivity(MainActivity.class).create().start().resume().visible();
        Activity activity = (Activity) controller.get();
    }

    @Test
    public void testLifeCycleWithIntent(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        ActivityController controller = Robolectric.buildActivity(MainActivity.class).withIntent(intent).create().start().resume().visible();
     }

    @Test
    public void testLifeCycleWithBundle(){
        Bundle savedInstanceState = new Bundle();
        ActivityController controller = Robolectric.buildActivity(MainActivity.class)
                .restoreInstanceState(savedInstanceState).create().start().resume().visible();
    }
}
