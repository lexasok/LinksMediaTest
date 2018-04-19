package net.ozero.linksmediatest.api;

import net.ozero.linksmediatest.Event;
import net.ozero.linksmediatest.Events;
import net.ozero.linksmediatest.ItemArticle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("/list.php")
    Call<Events> events(@Query("category") String category);

    @GET("/post.php")
    Call<ItemArticle> itemArticle(@Query("article") String article);
}
