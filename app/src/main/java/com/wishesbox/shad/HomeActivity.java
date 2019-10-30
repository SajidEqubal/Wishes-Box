package com.wishesbox.shad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    String From;
    String To;
    String Message;
    ConstraintLayout home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView imageView2=findViewById(R.id.imageView2);
        home=findViewById(R.id.home);
        From    = getIntent().getExtras().getString("FROM");
        To      = getIntent().getExtras().getString("TO");
        Message = getIntent().getExtras().getString("MESSAGE");


        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("IMG");

        Bitmap bmp = null;
        if (byteArray != null) {
            bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        // ImageView image = (ImageView) findViewById(R.id.imageView1);


        imageView2.setImageBitmap(bmp);




        TextView textView = (TextView)findViewById(R.id.from);
        textView.setText("FROM:"+" "+From);

        TextView textView3 = (TextView)findViewById(R.id.to);
        textView3.setText("TO:"+" "+To);



        TextView textView2 = (TextView)findViewById(R.id.to);
        textView2.setText("MESSAGE:"+" "+Message);

    }
    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0,
                    encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}