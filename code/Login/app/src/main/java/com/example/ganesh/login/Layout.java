package com.example.ganesh.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ganesh on 16/10/17.
 */

public class Layout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
    }

    public void findMeaningClicked(View v) {
        if (v.getId() == R.id.findMeaning) {

            EditText e1 = (EditText) findViewById(R.id.word);
            String s1 = e1.getText().toString();
            TextView t1 = (TextView) findViewById(R.id.Meaning);

            if (s1.equals("bat")) {
                t1.setText("A wooden object");
            }
            if (s1.equals("ball")) {
                t1.setText("A spherical object");
            }
        }
    }
}
