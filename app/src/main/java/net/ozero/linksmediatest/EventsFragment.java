package net.ozero.linksmediatest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.ozero.linksmediatest.api.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsFragment extends Fragment {

    private static final String DATA_LOADING_ERROR = "Data loading error";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Event> events;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Api mApi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.events_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        events = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(events, getContext());
        recyclerView.setAdapter(recyclerViewAdapter);


        mApi = ((App) getActivity().getApplication()).api();


        //set data

        loadEvents();
    }

    private void loadEvents() {


        mApi.events(getArguments().getString(App.EXTRA_CATEGORY)).enqueue(new Callback<Events>() {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response) {
                Events events1 = response.body();
                if (events1 != null) {
                    recyclerViewAdapter.setEvents(events1.getEvents());
                }
            }

            @Override
            public void onFailure(Call<Events> call, Throwable t) {
                Toast.makeText(getContext(), DATA_LOADING_ERROR, Toast.LENGTH_LONG).show();
            }
        });
    }
}
