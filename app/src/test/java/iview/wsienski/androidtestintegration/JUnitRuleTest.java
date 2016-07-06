package iview.wsienski.androidtestintegration;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Witold Sienski on 06.07.2016.
 */
public class JUnitRuleTest {
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testRule() throws IOException {
        File newFolder = tempFolder.newFolder("Temp Folder");
        assertTrue(newFolder.exists());
    }
}
