package iview.wsienski.androidtestintegration.espresso;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import iview.wsienski.androidtestintegration.MainActivity;
import iview.wsienski.androidtestintegration.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * Created by Witold Sienski on 07.07.2016.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testButton(){
        onView(withId(R.id.button))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    @Test
    public void testEditText(){
        onView(withId(getResourceId("edit_query"))).perform(typeText("test1"));
        onView(withText("test1")).check(matches(isDisplayed()));
    }

    @Test
    public void testToast() throws Exception {
        onView(withId(getResourceId("button"))).perform(click());
        onView(withText(startsWith("clicked"))).
                inRoot(withDecorView(
                        not(is(mActivityRule.getActivity().
                                getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    private static int getResourceId(String s) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        String packageName = targetContext.getPackageName();
        return targetContext.getResources().getIdentifier(s, "id", packageName);
    }

}
