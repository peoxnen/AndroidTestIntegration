package iview.wsienski.androidtestintegration.espresso;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import iview.wsienski.androidtestintegration.MainActivity;
import iview.wsienski.androidtestintegration.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Witold Sienski on 07.07.2016.
 */
public class IntentTest {
    @Rule
    // third parameter is set to false which means the activity is not started automatically
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule(MainActivity.class, true, false);

    @Test
    public void demonstrateIntentPrep() {
        Intent intent = new Intent();
        intent.putExtra("EXTRA", "Test");
        rule.launchActivity(intent);
        onView(withId(R.id.edit_query)).check(matches(withText("Test")));
    }
}
