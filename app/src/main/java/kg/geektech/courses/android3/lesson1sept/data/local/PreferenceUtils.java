package kg.geektech.courses.android3.lesson1sept.data.local;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {

    private static SharedPreferences mPreference;
    private final static String APP_PREF_NAME = "kg.geektech.lesson1";
    private final static String USER_NAME = "kg.geektech.lesson1.username";

    public static void init(Context context) {
        mPreference = context.getSharedPreferences(APP_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void saveUserName(String userName) {
        mPreference.edit().putString(USER_NAME, userName).apply();
    }

    public static String getUserName() {
        return mPreference.getString(USER_NAME, "");
    }

}
