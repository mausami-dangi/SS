package com.example.mausami.mychat;

import android.os.Bundle;

import com.stfalcon.chatkit.messages.MessageHolders;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

public class MainActivity extends DemoMessagesActivity
        implements MessageInput.InputListener,
                   MessageInput.AttachmentsListener  {

    private MessagesList messagesList;
    private MessageInput messageInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagesList = (MessagesList)findViewById(R.id.messagesList);
        initAdapter();
        messageInput = (MessageInput) findViewById(R.id.input);
        messageInput.setInputListener(this);
        messageInput.setAttachmentsListener(this);
    }


    @Override
    public boolean onSubmit(CharSequence input) {
        messagesAdapter.addToStart(MessagesFixtures.getTextMessage(input.toString()), true);
        return true;
    }

    @Override
    public void onAddAttachments() {
        messagesAdapter.addToStart(MessagesFixtures.getImageMessage(), true);
    }

    private void initAdapter() {
        MessageHolders holdersConfig = new MessageHolders()
                .setIncomingTextLayout(R.layout.item_custom_incoming_text_message)
                .setOutcomingTextLayout(R.layout.item_custom_outcoming_text_message)
                .setIncomingImageLayout(R.layout.item_custom_incoming_image_message)
                .setOutcomingImageLayout(R.layout.item_custom_outcoming_image_message);

        super.messagesAdapter = new MessagesListAdapter<>(super.senderId, holdersConfig, super.imageLoader);
        messagesList.setAdapter(super.messagesAdapter);
    }
}
