package com.traveltotal.ltmobile.travelfinal.adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.traveltotal.ltmobile.travelfinal.R;
import com.traveltotal.ltmobile.travelfinal.model.Location;

import java.util.ArrayList;


public class LocationAdapter extends BaseAdapter {

    private Context mcontext;
    private ArrayList<Location> mlocations;

    public LocationAdapter(Context mcontext, ArrayList<Location> mlocations) {
        this.mcontext = mcontext;
        this.mlocations = mlocations;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mlocations.get(position);
    }

    @Override
    public int getCount() {
        return mlocations.size();
    }

    private class ViewHolder{
        TextView txt1,txt2,txt3,txt4;
        ImageView img1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder =new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) mcontext.getSystemService(mcontext.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_items_location,null);

            viewHolder.txt1=convertView.findViewById(R.id.l_title);
            viewHolder.txt2=convertView.findViewById(R.id.l_adress);
            viewHolder.txt3=convertView.findViewById(R.id.l_city);
            viewHolder.txt4=convertView.findViewById(R.id.l_content);

            viewHolder.img1=convertView.findViewById(R.id.l_image);

            convertView.setTag(viewHolder);

        }else
            viewHolder = (ViewHolder) convertView.getTag();
        Location lc=mlocations.get(position);
        viewHolder.txt1.setText(lc.getlTitle());
        viewHolder.txt3.setText(lc.getlThanhpho());
        viewHolder.txt4.setText(lc.getlContent());
        viewHolder.txt2.setText(lc.getlAdress());
        Picasso.with(mcontext).load(lc.getlImageMain()).into(viewHolder.img1);


        return convertView;
    }

}
