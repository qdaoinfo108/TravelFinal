package com.traveltotal.ltmobile.travelfinal;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class person_fragment extends Fragment {

    private ListView listView;
    private View v;
    private TextView tvAbout, tvSOS, tvBookmark, tvReport;

    public person_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_person_fragment, container, false);

        AnhXa();
        return v;
    }

    private void AnhXa(){

        tvAbout =(TextView) v.findViewById(R.id.textAbout);
        tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),detail_about_person.class );
                startActivity(intent);
            }
        });

        tvSOS =(TextView) v.findViewById(R.id.textSOS);
        tvSOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),detail_sos_person.class );
                startActivity(intent);
            }
        });

        tvBookmark =(TextView) v.findViewById(R.id.textbookmark);
        tvBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),detail_about_person.class );
                startActivity(intent);
            }
        });

        tvReport = (TextView)v.findViewById(R.id.textReport);
        tvReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),detail_report_person.class );
                startActivity(intent);
            }
        });

    }

}
