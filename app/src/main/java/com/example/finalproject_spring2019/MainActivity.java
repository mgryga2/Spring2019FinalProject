package com.example.finalproject_spring2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create button instance to bring about new window which contains initial game settings
        button = (Button) findViewById(R.id.Enter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPanel();
            }
        });
    }
    /**
     * Opens the settings panel in order to set values.
     */
    public void openSettingsPanel() {
        Intent intent = new Intent(this, SettingsPanel.class);
        startActivity(intent);
    }
}
