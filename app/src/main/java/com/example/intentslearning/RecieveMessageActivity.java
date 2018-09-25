package com.example.intentslearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecieveMessageActivity extends AppCompatActivity {

    private TextView textViewDisplayMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_message);

        wireWidgets();
    }

    private void wireWidgets() {
        textViewDisplayMessage.findViewById(R.id.textview_recieve_displaymsg);
        textViewDisplayMessage.setText(getIntent().getStringExtra(SendMessageActivity.EXTRA_SENT_MESSAGE));
    }
}
