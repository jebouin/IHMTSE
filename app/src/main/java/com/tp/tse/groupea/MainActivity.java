package com.tp.tse.groupea;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int PICK_NAME = 1;
    private static int PICK_AVATAR = 2;
    private TextView textViewName;
    private Button buttonNext;
    private Button buttonAvatar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.activity_main_textview_name);

        buttonNext = findViewById(R.id.activity_main_button_next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivityForResult(intent, PICK_NAME);
            }
        });

        buttonAvatar = findViewById(R.id.activity_main_button_avatar);
        buttonAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_AVATAR);
            }
        });

        imageView = findViewById(R.id.activity_main_image_avatar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_NAME) {
            if(resultCode == RESULT_OK && data.getExtras() != null) {
                String name = data.getStringExtra("USERNAME");
                textViewName.setText(name);
            }
        } else if(requestCode == PICK_AVATAR) {
            try {
                if(resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    imageView.setImageURI(uri);
                }
            } catch (Exception e) {
                Log.e("FileSelectorActivity", "File selection error", e);
            }
        }
    }
}
