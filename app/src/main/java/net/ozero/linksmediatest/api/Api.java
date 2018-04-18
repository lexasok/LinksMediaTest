package net.ozero.linksmediatest.api;

import net.ozero.linksmediatest.Event;
import net.ozero.linksmediatest.Events;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("list.php?category={category}")
    Call<Events> events(@Path("category") String category);
}
