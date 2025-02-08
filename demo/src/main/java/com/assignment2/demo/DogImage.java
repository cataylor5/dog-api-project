

package com.assignment2.demo;

import java.util.List;

public class DogImage {
    // Fields based on JSON response
    private List<Object> breeds;
    private String id;
    private String url;
    private int width;
    private int height;

    // Constructor
    public DogImage(List<Object> breeds, String id, String url, int width, int height) {
        this.breeds = breeds;
        this.id = id;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    // Getters and Setters
    public List<Object> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Object> breeds) {
        this.breeds = breeds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}


