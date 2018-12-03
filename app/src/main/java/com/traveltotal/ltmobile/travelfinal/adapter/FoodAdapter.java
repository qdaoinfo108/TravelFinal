package com.traveltotal.ltmobile.travelfinal.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.traveltotal.ltmobile.travelfinal.R;
import com.traveltotal.ltmobile.travelfinal.model.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private ArrayList<Food> dataList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvCity,tvPrice,tvContent,tvAdress;
        ImageView imgImage;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.f_title);
            this.tvCity = (TextView) itemView.findViewById(R.id.f_city);
            this.tvPrice = (TextView) itemView.findViewById(R.id.f_price);
            this.tvContent = (TextView) itemView.findViewById(R.id.f_content);
            this.tvAdress = (TextView) itemView.findViewById(R.id.f_adress);
            this.imgImage = (ImageView) itemView.findViewById(R.id.f_image);


        }
    }

    public FoodAdapter(Context context,ArrayList<Food> data) {
        this.dataList = data;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_food, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodAdapter.ViewHolder viewHolder,final int i) {
        viewHolder.tvTitle.setText(dataList.get(i).getfTitle());
        viewHolder.tvCity.setText(dataList.get(i).getfCity());
        viewHolder.tvPrice.setText(dataList.get(i).getfPrice()+"");
        viewHolder.tvContent.setText(dataList.get(i).getfContent());
        viewHolder.tvAdress.setText(dataList.get(i).getfAdress());
        Picasso.with(context).load(dataList.get(i).getfImage()).into(viewHolder.imgImage);


    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }




}
