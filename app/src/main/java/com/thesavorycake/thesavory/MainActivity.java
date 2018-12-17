package com.thesavorycake.thesavory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nama) EditText nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void RegisterPage(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void LoginPage(View view) {
        Intent intent = new Intent(MainActivity.this, MainmenuActivity.class);
        startActivity(intent);

    }
}
