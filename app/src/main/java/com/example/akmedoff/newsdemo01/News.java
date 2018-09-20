package com.example.akmedoff.newsdemo01;

public class News {
    private int image;
    private String title;
    private String category;
    private String comment;

    public News(int image, String title, String category, String comment) {
        this.image = image;
        this.title = title;
        this.category = category;
        this.comment = comment;
    }

    public News() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
