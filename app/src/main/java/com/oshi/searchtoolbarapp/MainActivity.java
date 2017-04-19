package com.oshi.searchtoolbarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button activityExampleButton;
    private Button activityWithFragmentExampleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityExampleButton = (Button) findViewById(R.id.activityExampleButton);
        activityExampleButton.setOnClickListener(MainActivity.this);
        activityWithFragmentExampleButton = (Button) findViewById(R.id.activityWithFragmentExampleButton);
        activityWithFragmentExampleButton.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {

        int viewId = v.getId();

        if (viewId == R.id.activityExampleButton) {
            startActivity(new Intent(MainActivity.this, ExampleActivity.class));
        } else if (viewId == R.id.activityWithFragmentExampleButton) {
            startActivity(new Intent(MainActivity.this, ExampleFragmentActivity.class));
        }

    }
}
