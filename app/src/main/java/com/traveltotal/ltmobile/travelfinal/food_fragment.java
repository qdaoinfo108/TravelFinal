package com.traveltotal.ltmobile.travelfinal;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.slider.library.SliderLayout;
import com.traveltotal.ltmobile.travelfinal.adapter.FoodAdapter;
import com.traveltotal.ltmobile.travelfinal.adapter.ViewPaperAdapter;
import com.traveltotal.ltmobile.travelfinal.model.Food;
import com.traveltotal.ltmobile.travelfinal.model.Location;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class food_fragment extends Fragment {

    private static final String theURLEat = "https://traveltotal.000webhostapp.com/foodEat.php";
    private static final String theURLDrink = "https://traveltotal.000webhostapp.com/foodDrink.php";

    private RecyclerView eatRecyclerView, drinkRecyclerView;
    private FoodAdapter mFoodyAdapter;
    private RequestQueue mRequestQueue;
    private ArrayList<Food> listItem,listItem2;
    private Context context;
    private View rootView;
    private RecyclerView.Adapter adapter,adapter2;
    private DividerItemDecoration dividerItemDecoration,dividerItemDecoration2;
    private ViewPager viewPager;
    private ViewPaperAdapter viewPaperAdapter;
    private String[] imgSlider = {"https://s3-hd.hotdeal.vn/original/2018/10/1/5bbf16224c544-hd-bannercate-hotpot-story.jpg",
                                "http://www.goldenlion.vn/sites/default/files/pictures/Hue-Thuong-banner.jpg",
    "http://chacalavong2s.vn/wp-content/uploads/2017/11/GH-web-banner-1600x600.jpg"};


    public food_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_food_fragment, container, false);

        AnhXa();
        listItem = new ArrayList<Food>();
        listItem2 = new ArrayList<Food>();

        adapter = new FoodAdapter(getActivity(),listItem);
        adapter2 = new FoodAdapter(getActivity(),listItem2);

        //--------------------------------------------------------------------------------------------------
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, theURLEat, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Food food;
                                food = new Food(jsonObject.getString("TIEUDE"),
                                        jsonObject.getString("HINHANH"),
                                        jsonObject.getDouble("GIA"),
                                        jsonObject.getString("DIACHI"),
                                        jsonObject.getString("THANHPHO"),
                                        jsonObject.getString("SDT"),
                                        jsonObject.getString("NOIDUNG"),
                                        jsonObject.getInt("danhgia"));
                                listItem.add(food);
                            } catch (JSONException e) {
                                Toast.makeText(getActivity(), e.getMessage() + "", Toast.LENGTH_SHORT).show();
                            }
//                            Toast.makeText(getActivity(), listItem.toString() + "", Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();

                        }

                        // something
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        //--------------------------------------------------------------------------------------------------
        // DRINK
        //--------------------------------------------------------------------------------------------------
        JsonArrayRequest request2 = new JsonArrayRequest(Request.Method.GET, theURLDrink, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Food food;
                                String s = "";
                                food = new Food(jsonObject.getString("TIEUDE"),
                                        jsonObject.getString("HINHANH"),
                                        jsonObject.getDouble("GIA"),
                                        jsonObject.getString("DIACHI"),
                                        jsonObject.getString("THANHPHO"),
                                        jsonObject.getString("SDT"),
                                        jsonObject.getString("NOIDUNG"),
                                        jsonObject.getInt("danhgia"));
                                listItem2.add(food);
                            } catch (JSONException e) {
                                Toast.makeText(getActivity(), e.getMessage() + "", Toast.LENGTH_SHORT).show();
                            }
//                            Toast.makeText(getActivity(), listItem.toString() + "", Toast.LENGTH_SHORT).show();
                            adapter2.notifyDataSetChanged();

                        }

                        // something
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        //--------------------------------------------------------------------------------------------------
        // END DRINK
        //cái này nó chạy cục bộ ,bỏ vô chạy cho khỏe
        mRequestQueue = Volley.newRequestQueue(getActivity());

        mRequestQueue.add(request);
        mRequestQueue.add(request2);

        eatRecyclerView.setAdapter(adapter);
        drinkRecyclerView.setAdapter(adapter2);


        return rootView;

    }

    private void AnhXa() {
        // set EAT
        eatRecyclerView = (RecyclerView) rootView.findViewById(R.id.lvFoodEat);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        dividerItemDecoration = new DividerItemDecoration(eatRecyclerView.getContext(), layoutManager.getOrientation());

        eatRecyclerView.setHasFixedSize(true);
        eatRecyclerView.setLayoutManager(layoutManager);
        eatRecyclerView.addItemDecoration(dividerItemDecoration);
        eatRecyclerView.setAdapter(adapter);
        eatRecyclerView.setLayoutManager(layoutManager);

        //set DRINK
        drinkRecyclerView = (RecyclerView) rootView.findViewById(R.id.lvFoodDrink);
        final LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        dividerItemDecoration2 = new DividerItemDecoration(drinkRecyclerView.getContext(), layoutManager2.getOrientation());

        drinkRecyclerView.setHasFixedSize(true);
        drinkRecyclerView.setLayoutManager(layoutManager2);
        drinkRecyclerView.addItemDecoration(dividerItemDecoration2);
        drinkRecyclerView.setAdapter(adapter2);
        drinkRecyclerView.setLayoutManager(layoutManager2);

        // set Slider
        viewPager = rootView.findViewById(R.id.foodslider);
        viewPaperAdapter =  new ViewPaperAdapter(getActivity(),imgSlider);
        viewPager.setAdapter(viewPaperAdapter);
    }

    public void setSider(){

    }
}



