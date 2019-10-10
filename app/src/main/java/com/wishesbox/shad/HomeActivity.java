package com.wishesbox.shad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    String From;
    String To;
    String Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        From    = getIntent().getExtras().getString("FROM");
        To      = getIntent().getExtras().getString("TO");
        Message = getIntent().getExtras().getString("MESSAGE");




        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("FROM:"+" "+From+'\n'+"TO:"+" "+To+'\n'+"MESSAGE:"+" "+Message);

    }
}