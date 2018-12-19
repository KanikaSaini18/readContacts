package com.example.kanika.readcontacts;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sms extends AppCompatActivity {
    EditText sms;
    Button send;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        sms = findViewById(R.id.sms);
        send = findViewById(R.id.send);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getIntent().getStringExtra("name"));

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Uri smsUri = Uri.parse("tel:"+getIntent().getStringExtra("mobile"));
                Intent intent = new Intent(Intent.ACTION_VIEW, smsUri);
                intent.putExtra("sms_body", "sms text");
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);*/
                Toast.makeText(sms.this, sms.getText().toString(), Toast.LENGTH_SHORT).show();

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(getIntent().getStringExtra("mobile"),null,sms.getText().toString(),null,null);
            }
        });

    }

}
