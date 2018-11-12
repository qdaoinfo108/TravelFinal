package com.traveltotal.ltmobile.travelfinal;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.traveltotal.ltmobile.travelfinal.adapter.LocationAdapter;
import com.traveltotal.ltmobile.travelfinal.model.Location;


/**
 * A simple {@link Fragment} subclass.
 */
public class Location_fragment extends Fragment {


    private static final String theURL = "http://192.168.1.78/test.php";


    private ListView recyclerView;
    //bạn dùng rycleviwr thì mình ko rõ chứ mình dùng view thôi nhe
   private View rootView;
    private LocationAdapter mLocationAdapter;
    private RequestQueue mRequestQueue;
    private ArrayList<Location> listItem;
    private Context context;
    private int dem = 0;

    public Location_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // tao doi tuong View => return view
        rootView = inflater.inflate(R.layout.fragment_location_fragment, container, false);
        AnhXa();


        listItem = new ArrayList<>();
        //cái này nó chạy cục bộ ,bỏ vô chạy cho khỏe
        mRequestQueue = Volley.newRequestQueue(getActivity());
        loadRecyclerViewData();

        return rootView;
    }
    private void AnhXa(){
        //treen fragmen nay co bao nhieu thu can phai anh xa ?
        recyclerView=rootView.findViewById(R.id.rcLocation);
    }
    private void loadRecyclerViewData() {

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Đợi xíu, tải dữ liệu đã...");
        progressDialog.show();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, theURL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressDialog.dismiss();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Location location;
                                location = new Location(jsonObject.getString("TITLE"),
                                        jsonObject.getString("HINHANH"),
                                        jsonObject.getString("DIACHI"));
                                listItem.add(location);
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        mLocationAdapter = new LocationAdapter(getActivity(), listItem);

                        // recyleview thì trên stackoverflow cũng có hướng dẫn set adapter cho riếng nó luôn nhé ,bạn run thử xem
                        recyclerView.setAdapter(mLocationAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }

        );

        mRequestQueue.add(request);


    }
}
