package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SendMessageActivity extends AppCompatActivity {
    
    private Button sendMessage;
    private EditText editTestMessage;

    public static final String EXTRA_SENT_MESSAGE = "the message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        wireWidgets();

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text from edit text
                String message = editTestMessage.getText().toString();
                //create an intent
                //the arguments are where you are coming from (this)
                //and where you are going (TargetActivity.class)
                Intent intentSendMessage = new Intent(SendMessageActivity.this, RecieveMessageActivity.class);
                //package the text into the intent
                intentSendMessage.putExtra("themessage", message);
                //start the activity
                startActivity(intentSendMessage);
            }
        });
    }

    private void wireWidgets() {
        sendMessage.findViewById(R.id.button_sendmessage_send);
        editTestMessage.findViewById(R.id.edittext_sendmessage_send);
    }
}
