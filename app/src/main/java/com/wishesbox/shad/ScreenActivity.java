package com.wishesbox.shad;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ScreenActivity extends AppCompatActivity {


    EditText From;
    EditText To;
    EditText Message;
    ImageView imageView;
    Bitmap  bitmap;
    InputStream inputStream;
    byte[] byteArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        imageView = findViewById(R.id.imageView);

        Button button = findViewById(R.id.pickup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");

                startActivityForResult(Intent.createChooser(intent, "Pick An Image"), 1);
            }
        });


        From = (EditText) findViewById(R.id.frmEditText);
        To = (EditText) findViewById(R.id.toEditText);
        Message = (EditText) findViewById(R.id.msgEditText);

        Button makebtn = (Button) findViewById(R.id.makebtn);
        makebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String frmEditText = From.getText().toString();
                String toEditText = To.getText().toString();
                String msgEditText = Message.getText().toString();



                Intent intent = new Intent(ScreenActivity.this, HomeActivity.class);
                intent.putExtra("FROM", frmEditText);
                intent.putExtra("TO", toEditText);
                intent.putExtra("MESSAGE", msgEditText);
                intent.putExtra("IMG",byteArray);
                startActivity(intent);


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {

            try {
                inputStream = getContentResolver().openInputStream(data.getData());

                bitmap = BitmapFactory.decodeStream(inputStream);

                // Bitmap bmp = BitmapFactory.decodeStream(inputStream);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byteArray = stream.toByteArray();


                imageView.setImageBitmap(bitmap);



            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
}