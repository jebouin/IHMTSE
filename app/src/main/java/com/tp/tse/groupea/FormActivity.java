package com.tp.tse.groupea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {
    private Button buttonSave;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        buttonSave = findViewById(R.id.activity_form_button_submit);
        editTextName = findViewById(R.id.activity_form_editText_name);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void save() {
        String name = editTextName.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("USERNAME", name);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
