package com.killian.simple.simplestart;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity //implements View.OnClickListener
{
    private Button newChar;
    private Button chars;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newChar = (Button) findViewById(R.id.newChar);
        //newChar.setOnClickListener(this);
    }

    //Activity to create a character, called on press of the character create button
    public void charCreate(View view)
    {
        Intent intent = new Intent(this, CreationActivity.class);
        startActivity(intent);
    }
    /*@Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.newChar)
        {
            newChar.setText("I should make a character");
        }
    }*/
}
