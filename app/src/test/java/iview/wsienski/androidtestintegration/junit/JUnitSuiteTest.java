package iview.wsienski.androidtestintegration.junit;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import iview.wsienski.androidtestintegration.testcategories.SlowTests;

/**
 * Created by Witold Sienski on 05.07.2016.
 */
@RunWith(Categories.class)
@Categories.ExcludeCategory(SlowTests.class)
@Suite.SuiteClasses({
        ExampleUnitTest.class,
        JUnitTest.class,
        JUnitRuleTest.class
})
public class JUnitSuiteTest {
}
