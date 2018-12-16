package com.thesavorycake.thesavory.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.thesavorycake.thesavory.Model.Product;
import com.thesavorycake.thesavory.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by UnixMan on 16/12/2018.
 */

public class ProductlistActivityAdapter extends BaseAdapter{

    private List<Product> products;
    private Context context;

    public ProductlistActivityAdapter(Context context,List<Product> products){
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int pos) {
        return products.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(context).inflate(R.layout.activity_productlist,viewGroup,false);
        }

        TextView nameTxt = view.findViewById(R.id.titleproduk);
        ImageView spacecraftImageView = view.findViewById(R.id.images);

        final Product thisProducts = products.get(position);

        nameTxt.setText(thisProducts.getNama());


        if(thisProducts.getImage() != null && thisProducts.getImage().length()>0)
        {
           // Picasso.get().load(thisProducts.getImage()).placeholder(R.drawable.placeholder).into(spacecraftImageView);
        }else {
            Toast.makeText(context, "Empty Image URL", Toast.LENGTH_LONG).show();
            //Picasso.get().load(R.drawable.placeholder).into(spacecraftImageView);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, thisProducts.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
