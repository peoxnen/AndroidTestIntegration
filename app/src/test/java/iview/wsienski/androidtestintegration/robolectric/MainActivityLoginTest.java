package iview.wsienski.androidtestintegration.robolectric;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import iview.wsienski.androidtestintegration.BuildConfig;
import iview.wsienski.androidtestintegration.MainActivity;
import iview.wsienski.androidtestintegration.R;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by Witold Sienski on 09.07.2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk=22)
public class MainActivityLoginTest {

    private EditText editText;
    private Button button;

    @Before
    public void setUp() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        button = (Button) activity.findViewById(R.id.button_login);
        editText = (EditText) activity.findViewById(R.id.edit_query);
    }

    @Test
    public void loginSuccess() {
        editText.setText("password");
        button.performClick();

        ShadowApplication application = shadowOf(RuntimeEnvironment.application);
        assertThat("Next activity has started", application.getNextStartedActivity(), is(notNullValue()));
    }

    @Test
    public void loginWithEmptyField() {
        button.performClick();

        ShadowApplication application = shadowOf(RuntimeEnvironment.application);
        assertThat("Next activity should not started", application.getNextStartedActivity(), is(nullValue()));
        assertThat("Show error for field ", editText.getError(), is(CoreMatchers.notNullValue()));
    }

    @Test
    public void loginFailure() {
        editText.setText("x");
        button.performClick();

        ShadowApplication application = shadowOf(RuntimeEnvironment.application);
        assertThat("Next activity should not started", application.getNextStartedActivity(), is(nullValue()));
        assertThat("Show error for field ", editText.getError(), is(CoreMatchers.notNullValue()));
    }
}
