package net.ozero.linksmediatest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

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


}
