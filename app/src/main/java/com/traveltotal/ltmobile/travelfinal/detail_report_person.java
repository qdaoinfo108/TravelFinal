package com.traveltotal.ltmobile.travelfinal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class detail_report_person extends Activity {
    private TextView tvEmail, tvTitle, tvContent;
    private EditText etEmail, etTitle, etContent;
    private Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_report_person);

        errorEditText();

    }

    private void errorEditText() {
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvContent = (TextView) findViewById(R.id.tvContent);


        etEmail = (EditText) findViewById(R.id.etEmail);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etContent = (EditText) findViewById(R.id.etContent);

        final String title = etTitle.getText().toString().trim();
        final String content = etContent.getText().toString().trim();
        btSubmit = (Button) findViewById(R.id.btnSubmit);


        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendEmail(title,content);
            }
        });

    }
    protected void sendEmail(String sj, String content) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:qdao.cntt@gmail.com"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, sj);
        emailIntent.putExtra(Intent.EXTRA_TEXT, content);
        startActivity(Intent.createChooser(emailIntent,"Chọn ứng dụng gửi email"));


    }
}
