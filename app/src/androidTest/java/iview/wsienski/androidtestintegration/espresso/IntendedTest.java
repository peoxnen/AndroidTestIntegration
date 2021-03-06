package iview.wsienski.androidtestintegration.espresso;

import android.support.test.filters.Suppress;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import iview.wsienski.androidtestintegration.MainActivity;
import iview.wsienski.androidtestintegration.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Witold Sienski on 07.07.2016.
 */
public class IntendedTest {
    //TODO do poprawienia
    @Rule
    // third parameter is set to false which means the activity is not started automatically
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule(MainActivity.class, true, false);

    @Suppress
    @Test
    public void triggerIntentTest() {
        onView(withId(R.id.button_startSecondActivity)).perform(click());
        intended(toPackage("iview.wsienski.androidtestintegration.secondactivity"));
    }
}
