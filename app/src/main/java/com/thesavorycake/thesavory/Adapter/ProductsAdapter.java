package com.thesavorycake.thesavory.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thesavorycake.thesavory.Model.Product;
import com.thesavorycake.thesavory.R;

import java.util.List;

/**
 * Created by UnixMan on 15/12/2018.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    private Context mContext;
    private List<Product> productList;

    public ProductsAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.activity_produk, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        Glide.with(mContext)
                .load(product.getImage())
                .into(holder.imageView);

        holder.textViewTitle.setText(product.getNama());
        holder.textViewShortDesc.setText(product.getKeterangan());
       // holder.textViewRating.setText("Rating :"+String.valueOf(product.getProductrating()));
        //holder.textCategory.setText(String.valueOf(product.()));
        holder.textViewPrice.setText("Rs. "+String.valueOf(product.getHarga()));
       // holder.login.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textCategory, textViewPrice;
        ImageView imageView;
        Button regist, login;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textCategory = itemView.findViewById(R.id.textCategory);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
           // login = itemView.findViewById(R.id.btnlogin);

        }
    }
}
