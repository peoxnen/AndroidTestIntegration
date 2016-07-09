package iview.wsienski.androidtestintegration.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import iview.wsienski.androidtestintegration.R;
import iview.wsienski.androidtestintegration.SecondActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Witold Sienski on 09.07.2016.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTest {

    @Rule
    public ActivityTestRule<SecondActivity> mActivityRule =
            new ActivityTestRule<>(SecondActivity.class);

    @Test
    public void buttonShouldUpdateText(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textview)).check(matches(withText("test")));
    }
}
