package net.ozero.linksmediatest;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.ozero.linksmediatest.api.Api;

public class MainActivity extends AppCompatActivity {

    private static final int LOADER_EVENTS = 0;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private Api mApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        mApi =((App) getApplication()).api();
        
        loadEvents();

        //set data
//        recyclerView.setAdapter(new RecyclerViewAdapter(Event.createFakeEvents(), this));
    }

    private void loadEvents() {
        getLoaderManager().initLoader(LOADER_EVENTS, null, new LoaderManager.LoaderCallbacks<Events>() {
            @Override
            public Loader<Events> onCreateLoader(int id, Bundle args) {
                return null;
            }

            @Override
            public void onLoadFinished(Loader<Events> loader, Events data) {

            }

            @Override
            public void onLoaderReset(Loader<Events> loader) {

            }
        });
    }

}
