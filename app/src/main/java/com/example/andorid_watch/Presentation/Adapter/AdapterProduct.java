package com.example.andorid_watch.Presentation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.services.Manager.ProductManager;
import com.example.andorid_watch.Presentation.Activity.DetailActivity;
import com.example.andorid_watch.R;
import com.squareup.picasso.Picasso; // You can use Picasso library for image loading

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductViewHolder> {

    private Context context;
    private List<Product> mProductList;
    private ProductManager productManager;

    public AdapterProduct(Context context, ProductManager productManager) {
        this.context = context;
        this.productManager = productManager;

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_pop, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = mProductList.get(position);

        holder.textViewName.setText(String.valueOf("Name: " + product.getName()));
        holder.textViewPrice.setText(String.valueOf("Price: $" + product.getPrice()));
        if (product.getImage() != null && !product.getImage().isEmpty()) {
            String imageUrl = product.getImage();
            Picasso.get().load(imageUrl).into(holder.imageViewProduct);
        } else {
            System.out.println("error");
        }

        holder.imageViewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dicrect_to_details(product);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mProductList == null ? 0 : mProductList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewProduct;
        TextView textViewName;
        TextView textViewPrice;
        ImageView image_add_cart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            image_add_cart = itemView.findViewById(R.id.add_cart);

            imageViewProduct = itemView.findViewById(R.id.image_product);
            textViewName = itemView.findViewById(R.id.name1);
            textViewPrice = itemView.findViewById(R.id.price);
        }

    }
    public void loadProduct()
    {
        productManager.getAllProduct(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mProductList = response.body();
                notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void searchProducts(String keyword) {
        List<Product> searchResult = new ArrayList<>();
        productManager.searchProducts(keyword, new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mProductList = response.body();
                notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    //Hiển thị product qua category
    public void loadProductByCategory(String categoryID)
    {
        productManager.getProductInCategory(categoryID, new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mProductList = response.body();
                notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void  dicrect_to_details(Product product)
    {
        //Tạo intent
        Intent intent = new Intent(context, DetailActivity.class);

        //Đính kèm dữ liệu cần gửi
        intent.putExtra("PRODUCT_ID",product.getId());
        intent.putExtra("PRODUCT_NAME",product.getName());
        intent.putExtra("PRODUCT_PRICE",product.getPrice());
        intent.putExtra("PRODUCT_DESCRIPTION",product.getDescription());
        intent.putExtra("PRODUCT_IMAGE",product.getImage());

        context.startActivity(intent);
    }
}

