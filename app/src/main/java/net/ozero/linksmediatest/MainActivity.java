package net.ozero.linksmediatest;

import android.annotation.SuppressLint;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import net.ozero.linksmediatest.api.Api;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final int LOADER_EVENTS = 0;
    private static final String DATA_LOADING_ERROR = "Ошибка загрузки данных с сервера!";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    private Api mApi;

    private ArrayList<Event> events;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        events = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(events,this);
        recyclerView.setAdapter(recyclerViewAdapter);


        mApi = ((App) getApplication()).api();


        //set data

        loadEvents();

    }

    private void loadEvents() {

        try {
            Response response = mApi.events("football").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


        mApi.events("football").enqueue(new Callback<Events>() {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response) {
                if (response.body() != null) {
                    Events eve = response.body();
                    events.clear();
                    try {
                        assert eve != null;
                        events.addAll(eve.getEvents());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    recyclerViewAdapter.notifyDataSetChanged();

                } else events = new ArrayList<>();
            }

            @Override
            public void onFailure(Call<Events> call, Throwable t) {
                Toast.makeText(MainActivity.this, DATA_LOADING_ERROR, Toast.LENGTH_LONG).show();
            }
        });
    }

}
