package net.ozero.linksmediatest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Event {

    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("coefficient")
    @Expose
    String coefficient;

    @SerializedName("time")
    @Expose
    String time;

    @SerializedName("place")
    @Expose
    String place;

    @SerializedName("preview")
    @Expose
    String preview;

    @SerializedName("article")
    @Expose
    String article;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

}
