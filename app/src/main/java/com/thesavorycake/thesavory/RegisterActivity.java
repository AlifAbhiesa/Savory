package com.thesavorycake.thesavory;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.thesavorycake.thesavory.Api.RegisterAPI;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterActivity extends AppCompatActivity {

    public static final String URL = "http://192.168.100.19/android/";

    EditText txtNama;
    EditText txtNik;
    EditText txtAlamat;
    EditText txtEmail;
    EditText txtNoHp;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtNama = (EditText)findViewById(R.id.nama);
        txtNik = (EditText)findViewById(R.id.nik);
        txtAlamat = (EditText)findViewById(R.id.alamat);
        txtEmail = (EditText)findViewById(R.id.email);
        txtNoHp = (EditText)findViewById(R.id.nohp);
        txtPassword = (EditText)findViewById(R.id.password);

    }

    public void register(View view) {

      final ProgressDialog progress;

      String nik = txtNik.getText().toString();
      String nama = txtNama.getText().toString();
      String alamat = txtAlamat.getText().toString();
      String email = txtEmail.getText().toString();
      String nohp = txtNoHp.getText().toString();
      String password = txtPassword.getText().toString();

      if(nik.isEmpty() || nama.isEmpty() || alamat.isEmpty() ||
              email.isEmpty() || nohp.isEmpty() || password.isEmpty()){
          Toast.makeText(RegisterActivity.this, "Anda harus mengisi semua field !", Toast.LENGTH_LONG).show();
      }else{
          progress  = new ProgressDialog(this);
          progress.setCancelable(false);
          progress.setMessage("Loading ...");
          progress.show();
          Retrofit retrofit = new Retrofit.Builder()
                  .baseUrl(URL)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
          RegisterAPI api = retrofit.create(RegisterAPI.class);
          Call<Value> call = api.daftar(nik, nama, alamat, email, nohp, password);

          call.enqueue(new Callback<Value>() {
              @Override
              public void onResponse(Call<Value> call, Response<Value> response) {
                  String value = response.body().getValue();
                  String message = response.body().getMessage();
                  progress.dismiss();
                  if (value.equals("200")) {
                      Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                      finish();
                  } else {
                      Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                  }
              }
              @Override
              public void onFailure(Call<Value> call, Throwable t) {
                  progress.dismiss();
                  Toast.makeText(RegisterActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
              }
          });
      }

    }
}
