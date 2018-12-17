package com.thesavorycake.thesavory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.time.Instant;

public class MainmenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        final Button btnmenu = (Button) findViewById(R.id.btnmenu);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainmenuActivity.this, btnmenu);

                popup.getMenuInflater().inflate(R.menu.popup_menu,popup.getMenu());

                popup.show();

            }
        });


    }

    public void MainMenuActivity(MenuItem item) {
        finish();
        Intent MainMenu = new Intent(MainmenuActivity.this, MainmenuActivity.class);
        startActivity(MainMenu);
    }


    public void ProductlistActivity(MenuItem item) {
        finish();
        Intent ProductList = new Intent(MainmenuActivity.this, ProductlistActivity.class);
        startActivity(ProductList);
    }
}
