package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText etName, etNumber, etWebsite, etLocation;
    ImageView ivHappy, ivOkay, ivSad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);
        ivHappy = findViewById(R.id.ivHappy);
        ivOkay = findViewById(R.id.ivOkay);
        ivSad = findViewById(R.id.ivSad);

        ivHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() ||
                        etWebsite.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity2.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String name = etName.getText().toString().trim();
                    String number = etNumber.getText().toString().trim();
                    String website = etWebsite.getText().toString().trim();
                    String location = etLocation.getText().toString().trim();
                    String face = "happy";

                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("number", number);
                    intent.putExtra("website", website);
                    intent.putExtra("location", location);
                    intent.putExtra("face", face);
                    setResult(RESULT_OK, intent);
                    MainActivity2.this.finish();
                }

            }
        });

        ivOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() ||
                        etWebsite.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity2.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String name = etName.getText().toString().trim();
                    Integer number = Integer.parseInt(etNumber.getText().toString().trim());
                    String website = etWebsite.getText().toString().trim();
                    String location = etLocation.getText().toString().trim();
                    String face = "okay";

                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("number", number);
                    intent.putExtra("website", website);
                    intent.putExtra("location", location);
                    intent.putExtra("face", face);
                    setResult(RESULT_OK, intent);
                    MainActivity2.this.finish();
                }

            }
        });

        ivSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() ||
                        etWebsite.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity2.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String name = etName.getText().toString().trim();
                    Integer number = Integer.parseInt(etNumber.getText().toString().trim());
                    String website = etWebsite.getText().toString().trim();
                    String location = etLocation.getText().toString().trim();
                    String face = "sad";

                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("number", number);
                    intent.putExtra("website", website);
                    intent.putExtra("location", location);
                    intent.putExtra("face", face);
                    setResult(RESULT_OK, intent);
                    MainActivity2.this.finish();
                }

            }
        });


    }
}