package com.thesavorycake.thesavory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductlistActivity extends AppCompatActivity {
GridView gridView;
    String[] caketNames = {"Crusty Fruits","Matcha Blueberry","Red Velvet","NYC Cheesecake","Classic Chocochip","Cinnamon Rolls","Sweet Confetti","Raisin Bread","Tutti Fruity Macarons","Nuttela Meringue"};
    int[] cakeImages = {R.drawable.cake1,R.drawable.cake2,R.drawable.cake6,R.drawable.cake7,R.drawable.cake3,R.drawable.cake4,R.drawable.cake8,R.drawable.cake9,R.drawable.cake11,R.drawable.cake13};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);

        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",caketNames[i]);
                intent.putExtra("image",cakeImages[i]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return cakeImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView name = view1.findViewById(R.id.titleproduk);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(caketNames[i]);
            image.setImageResource(cakeImages[i]);
            return view1;

        }
    }

    static class RetrofitClientInstance {

        private static Retrofit retrofit;
        private static final String BASE_URL = "https://192.168.100.19/";

        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }
}
