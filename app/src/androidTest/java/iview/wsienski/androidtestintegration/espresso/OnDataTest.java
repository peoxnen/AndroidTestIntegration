package iview.wsienski.androidtestintegration.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import iview.wsienski.androidtestintegration.SecondActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by Witold Sienski on 09.07.2016.
 */
@RunWith(AndroidJUnit4.class)
public class OnDataTest {

    @Rule
    public ActivityTestRule<SecondActivity> mActivityRule =
            new ActivityTestRule<>(SecondActivity.class);

    @Test
    public void testOnData(){
        onData(allOf(is(instanceOf(String.class)),is("Tennis"))).perform(click());
    }

    @Test
    public void testOnData2(){
        onData(allOf(is(instanceOf(String.class)))).atPosition(2).perform(click());
    }
}
