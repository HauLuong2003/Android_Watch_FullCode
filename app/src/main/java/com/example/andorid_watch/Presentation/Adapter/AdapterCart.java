package com.example.andorid_watch.Presentation.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andorid_watch.Domain.Models.Product;
import com.example.andorid_watch.Domain.Models.UserSQL;
import com.example.andorid_watch.Domain.services.Interface.ICartServices;
import com.example.andorid_watch.Domain.services.Interface.IUserServices;
import com.example.andorid_watch.Domain.services.Manager.UserManager;
import com.example.andorid_watch.Presentation.Activity.CartActivity;
import com.example.andorid_watch.Presentation.Controller.Command.CommandProcessor;
import com.example.andorid_watch.Presentation.Controller.Functions.ListCart;
import com.example.andorid_watch.Presentation.Controller.Functions.ListUser;
import com.example.andorid_watch.Presentation.Controller.Functions.UpdateCart;
import com.example.andorid_watch.R;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.CartViewHolder> {
    private TextView textViewName;

    private Context mContext;
    private List<Product> mProductList;
    private List<Integer> itemCountList;
    private CommandProcessor commandProcessor;
    private ICartServices cartServices;

    private IUserServices userServices;
    private String userName;
    private UserManager userManager;


    public AdapterCart(Context context) {
        mContext = context;
        this.itemCountList = new ArrayList<>();
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
        holder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Giảm số lượng sản phẩm khi nhấn nút trừ
                //lấy số lượng hiện tại
                int currentQuantity = Integer.parseInt(holder.unit.getText().toString());
                if (currentQuantity > 0) {
                    // số lượng lớn hơn 0 thì giảm đi
                    currentQuantity--;
                    holder.unit.setText(String.valueOf(currentQuantity));
                }



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
        TextView add, sub,unit;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.pic_cart);
            textViewName = itemView.findViewById(R.id.txt_name);
            textViewPrice = itemView.findViewById(R.id.txt_price);
            textViewPrice1 = itemView.findViewById(R.id.txt_price1);
            txt_Delete = itemView.findViewById((R.id.txt_Delete));
            sub = itemView.findViewById(R.id.sub);
            add = itemView.findViewById(R.id.add);
            unit = itemView.findViewById(R.id.unit);
        }
    }
    public boolean checkExitUser() {
        List<UserSQL> userSQLList = commandProcessor.getAllUser(new ListUser(userServices));

        if(userSQLList.size() != 0)
        {
            for (UserSQL userSQL: userSQLList){
                userName = userSQL.getUserName();
            }
            return true;
        }
        return false;
    }


}
