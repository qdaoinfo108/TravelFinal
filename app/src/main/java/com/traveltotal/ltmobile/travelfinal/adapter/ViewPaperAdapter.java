package com.traveltotal.ltmobile.travelfinal.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.traveltotal.ltmobile.travelfinal.R;

public class ViewPaperAdapter extends PagerAdapter {

    Activity activity;
    String[] image;
    LayoutInflater layoutInflater;

    public ViewPaperAdapter(Activity activity, String[] image) {
        this.activity = activity;
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemSlider = layoutInflater.inflate(R.layout.slider_items,container,false);

        ImageView imageView;
        imageView = (ImageView)itemSlider.findViewById(R.id.img_slider_items);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int weight= displayMetrics.widthPixels;
        imageView.setMaxHeight(height);
        imageView.setMaxWidth(weight);

        try {
            Picasso.with(activity.getApplicationContext())
                    .load(image[position])
                    .placeholder(R.mipmap.ic_launcher_foreground)
                    .error(R.mipmap.ic_launcher_foreground)
                    .into(imageView);
        } catch (Exception e){

        }

        container.addView(itemSlider);

        return itemSlider;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
