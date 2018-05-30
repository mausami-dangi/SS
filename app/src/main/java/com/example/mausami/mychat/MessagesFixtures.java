package com.example.mausami.mychat;

import com.example.mausami.mychat.model.Message;
import com.example.mausami.mychat.model.User;

public final class MessagesFixtures {

    public static Message getTextMessage(String text) {
        return new Message("RECEIVE-001", getUser(), text);
    }

    public static Message getImageMessage() {
        Message message = new Message("SEND1-001", getUser(), null);
        message.setImage(new Message.Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9byx82rwMnNhiVhmEYWWvef5XRFnRssceqHMKrk1Lxk9HUdAc"));
        return message;
    }

    private static User getUser() {
        return new User("SEND-001","Mausami Dangi","http://i.imgur.com/pv1tBmT.png",true);
    }

}
