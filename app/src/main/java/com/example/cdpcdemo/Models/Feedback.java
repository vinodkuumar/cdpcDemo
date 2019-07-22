package com.example.cdpcdemo.Models;

import com.google.firebase.database.ServerValue;

public class Feedback {
    private String description;
    private Object timestamp;
    public Feedback(String description){
        this.description = description;
        this.timestamp = ServerValue.TIMESTAMP;
    }

    public Feedback() {
    }


    public String getDescription() {
        return description;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimestamp(Object timestamp) {
        this.timestamp = timestamp;
    }
}
