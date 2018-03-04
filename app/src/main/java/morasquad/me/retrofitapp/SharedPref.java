package morasquad.me.retrofitapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

import morasquad.me.retrofitapp.Model.User;

/**
 * Created by Sandun Isuru Niraj on 3/4/2018.
 */

public class SharedPref {
    private static SharedPref mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "retrofitapp";

    private static final String KEY_NAME = "keyName";
    private static final String KEY_EMAIL = "keyEmail";

    public SharedPref(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPref getInstance(Context context){
        if (mInstance == null){
            mInstance = new SharedPref(context);
        }
            return mInstance;

    }

    public boolean userLogin(String name, String email){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL,email);
        editor.apply();
        return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_EMAIL,null) != null)
            return true;
        return false;
    }

public User getUser(){
    SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    return new User(
            sharedPreferences.getString(KEY_NAME, null),
            sharedPreferences.getString(KEY_EMAIL,null)
    );

}

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }


}
