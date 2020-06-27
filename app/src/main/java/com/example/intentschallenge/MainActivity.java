package com.example.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCreate;
    ImageView ivFace, ivPhone, ivWebsite, ivLocation;

    final int ACTIVITY2 = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);
        ivFace = findViewById(R.id.ivFace);
        ivPhone = findViewById(R.id.ivPhone);
        ivWebsite = findViewById(R.id.ivWebsite);
        ivLocation = findViewById(R.id.ivLocation);

        ivFace.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWebsite.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,
                        com.example.intentschallenge.MainActivity2.class);
                startActivityForResult(intent, ACTIVITY2);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY2)
        {
            if (resultCode == RESULT_OK)
            {
                String name = data.getStringExtra("name");
                final String number = data.getStringExtra("number");
                final String website = data.getStringExtra("website");
                final String location = data.getStringExtra("location");
                String face = data.getStringExtra("face");

                if (face.equals("happy"))
                {
                    ivFace.setImageResource(R.drawable.happy);
                }
                else if (face.equals("okay"))
                {
                    ivFace.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24);
                }
                else if (face.equals("sad"))
                {
                    ivFace.setImageResource(R.drawable.sad);
                }

                ////////// new ///////////
                ivPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                        startActivity(intent);

                    }
                });

                ivWebsite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                        startActivity(intent);

                    }
                });

                ivLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                        startActivity(intent);

                    }
                });

                ivFace.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivWebsite.setVisibility(View.VISIBLE);
                ivLocation.setVisibility(View.VISIBLE);
            }
            /////////// new ////////////

            if (resultCode == RESULT_CANCELED)
            {
                // do nothing if no data received
            }
        }

    }
}