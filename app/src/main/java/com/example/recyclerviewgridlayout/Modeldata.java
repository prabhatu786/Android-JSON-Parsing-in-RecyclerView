package com.example.recyclerviewgridlayout;

public class Modeldata {
    private String courses, Url, mentor,price;

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public Modeldata(){

    }

    public Modeldata(String courses, String url, String mentor, String price) {
        this.courses = courses;
        this.Url = url;
        this.mentor = mentor;
        this.price = price;
    }
}
