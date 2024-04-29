package com.example.andorid_watch.Presentation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.CartViewHolder> {

    private Context mContext;
    private List<Product> mProductList;
    private CartItemClickListener mListener;


    public AdapterCart(Context context, List<Product> product) {
        mContext = context;
        mProductList = product;
    }
    public void setCartItemClickListener(CartItemClickListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.viewholder_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Product product = mProductList.get(position);

        holder.textViewName.setText(String.valueOf("Name: " + product.getName()));
        holder.textViewPrice.setText(String.valueOf("$" + product.getPrice()));
        if (product.getImage() != null && !product.getImage().isEmpty()) {
            String imageUrl = product.getImage();
            Picasso.get().load(imageUrl).into(holder.imageViewProduct);
        } else {
            System.out.println("error");
        }
        holder.txt_Delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mListener.deleteproduct(product.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }


    public class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProduct;
        TextView textViewName;
        TextView textViewPrice;
        TextView textViewPrice1;
        ImageView txt_Delete;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.pic_cart);
            textViewName = itemView.findViewById(R.id.txt_name);
            textViewPrice = itemView.findViewById(R.id.txt_price);
            textViewPrice1 = itemView.findViewById(R.id.txt_price1);
            txt_Delete = itemView.findViewById((R.id.txt_Delete));
        }
    }
    public interface CartItemClickListener {
        void deleteproduct(int id);
    }
}
