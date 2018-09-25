package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {

    private Button sendMessage;
    private Button shareButton;
    private EditText editTextMessage;

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
                String message = editTextMessage.getText().toString();
                //create an intent
                //the arguments are where you are coming from (this)
                //and where you are going (TargetActivity.class)
                Intent intentSendMessage = new Intent(SendMessageActivity.this, RecieveMessageActivity.class);
                //package the text into the intent
                intentSendMessage.putExtra(EXTRA_SENT_MESSAGE, message);
                //start the activity
                startActivity(intentSendMessage);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make an intent with the desired action
               Intent intentShare = new Intent(Intent.ACTION_SEND);
               //set the data type of the stuff we're packaging away
                //can look up that type you need on the internet
                intentShare.setType("text/plain");
                //put the extra with the message
                intentShare.putExtra(EXTRA_SENT_MESSAGE, editTextMessage.getText().toString());
                //launch the activity
                startActivity(intentShare);
            }
        });
    }

    private void wireWidgets() {
        sendMessage.findViewById(R.id.button_sendmessage_send);
        editTextMessage.findViewById(R.id.edittext_sendmessage_send);
        shareButton.findViewById(R.id.button_sendmessage_share);
    }
}
