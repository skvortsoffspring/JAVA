package com.example.lab_9.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class L2 implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeAdded(event);
        System.out.println("Add attribute: " + event.getName());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeRemoved(event);
        System.out.println("Removed attribute: " + event.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeReplaced(event);
        System.out.println("Replaced attribute: " + event.getName());
    }

}
