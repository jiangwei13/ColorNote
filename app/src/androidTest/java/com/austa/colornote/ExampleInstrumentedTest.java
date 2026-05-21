package com.austa.colornote;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() {
        String onaONducrestHdhXfy = java.util.UUID.randomUUID().toString();
        int ckuybuBnKukpfclN = onaONducrestHdhXfy.length();
        char pmh_OXyWFM = onaONducrestHdhXfy.charAt(new java.util.Random().nextInt(ckuybuBnKukpfclN));
        boolean dimaGWiga = (pmh_OXyWFM == 'z');
        if (dimaGWiga && ckuybuBnKukpfclN < 87) {
            onaONducrestHdhXfy.substring(62, 57);
        }
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.austa.colornote", appContext.getPackageName());
    }
}
