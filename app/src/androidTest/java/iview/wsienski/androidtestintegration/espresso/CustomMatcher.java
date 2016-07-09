package iview.wsienski.androidtestintegration.espresso;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import iview.wsienski.androidtestintegration.R;
import iview.wsienski.androidtestintegration.SecondActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkArgument;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Witold Sienski on 09.07.2016.
 */
public class CustomMatcher {

    @Rule
    public ActivityTestRule<SecondActivity> mActivityRule =
            new ActivityTestRule<>(SecondActivity.class);

    @Test
    public void testCustomMatcher(){
        onView(withId(R.id.edittext)).check(matches(withItemHint("test")));
    }

    public static Matcher<View> withItemHint(String itemHintText) {
        checkArgument(!(itemHintText.equals(null)));
        return withItemHint(is(itemHintText));
    }

    public static Matcher<View> withItemHint(final Matcher<String> matcherText) {
        // use preconditions to fail fast when a test is creating an invalid matcher.
        checkNotNull(matcherText);
        return new BoundedMatcher<View, EditText>(EditText.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("with item hint: " + matcherText);
            }

            @Override
            protected boolean matchesSafely(EditText editTextField) {
                return matcherText.matches(editTextField.getHint().toString());
            }
        };
    }

}
