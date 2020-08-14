package com.learninspringboot.ecofootprintapi.model;

import java.io.InputStream;

public class Photo {
    public String title;
    public InputStream stream;

    public Photo() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }
}