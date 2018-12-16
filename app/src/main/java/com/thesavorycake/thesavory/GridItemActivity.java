package com.thesavorycake.thesavory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GridItemActivity extends AppCompatActivity {

    TextView name;
    ImageView image;
    TextView harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        name = findViewById(R.id.griddata);
        image = findViewById(R.id.imageView);
        harga = findViewById(R.id.gridharga);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        //image.setImageResource(intent.getIntExtra("image"));
    }
}
