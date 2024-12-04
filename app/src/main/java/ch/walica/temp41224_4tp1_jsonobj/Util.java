package ch.walica.temp41224_4tp1_jsonobj;

import android.app.Activity;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class Util {

    public static String TAG = "my_log";

    public static String loadJSONFromAssets(String file, Activity activity) {
        String json = null;
        try {
            InputStream inputStream = activity.getAssets().open(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, "UTF-8");

        } catch(IOException e) {
            Log.d(TAG, "loadJSONFromAssets: " + e.getLocalizedMessage());
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
