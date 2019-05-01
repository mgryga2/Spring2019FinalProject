package com.example.finalproject_spring2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsPanel extends AppCompatActivity {
    private Button button;
    private boolean startGame = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_panel);
        //button proceeds to the next activity which contains the game
        button = (Button) findViewById(R.id.Game);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGamePanel();
            }
        });
    }
    public void newInputs(View view) {
        EditText lengthInput = findViewById(R.id.enterLength);
        EditText widthInput = findViewById(R.id.enterWidth);
        EditText urlInput = findViewById(R.id.URLIMPORT);
        int length = Integer.valueOf(lengthInput.getText().toString());
        TwoDimensional.LENGTH = length;
        int width = Integer.valueOf(widthInput.getText().toString());
        TwoDimensional.WIDTH = width;
        String url = urlInput.getText().toString();
        //url = ImportLifePattern;

    }
    //newInputs.get(width), newInputs.get(height);
    /**
     * Opens and runs the game.
     */
    public void openGamePanel() {
        Intent intent = new Intent(this, TwoDimensional.class);
        startActivity(intent);
    }
}
