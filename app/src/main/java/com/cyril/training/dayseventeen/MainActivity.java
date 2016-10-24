package com.cyril.training.dayseventeen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    EditText mKeyEditText, mValueEditText;
    TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mKeyEditText= (EditText) findViewById(R.id.editText_for_key);
        mValueEditText= (EditText) findViewById(R.id.editText_for_value);
        mResultTextView= (TextView) findViewById(R.id.textView_for_result);
    }

    /**
     * Method to write data into Shared Preference on button click.
     * @param v
     */
    public void writeDataButton(View v)
    {
        // Checking if the EditTexts are empty.
        if((mKeyEditText.getText().length() != 0) && (mValueEditText.getText().length() != 0))
        {
            String key= sharedPreferenceKeyNameGenerator(mKeyEditText.getText().toString());
            String value= mValueEditText.getText().toString();

            // Writing data into Shared Prefs.
            writeStringDataIntoSharedPreferences(key, value);
        }
        else
        {
            shortToastAndVerboseLog("Please enter both KEY and VALUE.");
        }
    }

    /**
     * Method to read data from Shared Preferences on button click.
     * @param v
     */
    public void readDataButton(View v)
    {
        // Checking if key EditText is empty.s
        if(mKeyEditText.getText().length() != 0)
        {
            String key= sharedPreferenceKeyNameGenerator(mKeyEditText.getText().toString());

            // Reading data from the Shared Prefs.
            readStringDataFromSharedPreferences(key);
        }
        else
        {
            shortToastAndVerboseLog("Please enter KEY.");
        }
    }


    /**
     * Method used to generate a Shared Preference key name unique to the
     * application.
     * @param keyName
     * @return
     */
    public String sharedPreferenceKeyNameGenerator(String keyName)
    {
        String appPackageName= getApplicationContext().getPackageName();
        String sharedPrefName= appPackageName + "." +keyName;

        return sharedPrefName;
    }

    /**
     * Method used to write data into Shared Preferences
     * @param key
     * @param value
     */
    public void writeStringDataIntoSharedPreferences(String key, String value)
    {
        SharedPreferences sharedPreferences= getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();

        if(sharedPreferences.contains(key))
        {
            shortToastAndVerboseLog("Key-value pair stored successfully.");
        }
        else
        {
            shortToastAndVerboseLog("Key-value pair could not be stored.");
        }
    }

    /**
     * Method used to read data from Shared Preferences.
     * @param key
     * @return
     */
    public String readStringDataFromSharedPreferences(String key)
    {
        String value;
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        if(sharedPreferences.contains(key))
        {
            value= sharedPreferences.getString(key, "Default String value");
            mResultTextView.setText(value);
        }
        else
        {
            value = "Given key is not available";
            mResultTextView.setText(value);
        }
        return value;
    }


    /**
     * Method to show short Toast and print a message in Verbose Log, based on user input.
     * @param message
     */
    public void shortToastAndVerboseLog(String message)
    {
        Log.v("day17", message);

        Toast toast= Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0/*X offset*/, 200/*Y offset*/);
        toast.show();
    }

    public void gotoActivity2Button(View v)
    {
        Intent intent= new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


}
