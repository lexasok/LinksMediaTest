package net.ozero.linksmediatest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import net.ozero.linksmediatest.api.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleActivity extends AppCompatActivity {

    Api mApi;

    ItemArticle itemArticle;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArticleAdapter articleAdapter;

    TextView team1;
    TextView team2;
    TextView timeItemArticle;
    TextView tournament;
    TextView placeArticle;
    TextView prediction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        team1 = findViewById(R.id.team1);
        team2 = findViewById(R.id.team2);
        timeItemArticle = findViewById(R.id.timeItemArticle);
        tournament = findViewById(R.id.tournament);
        placeArticle = findViewById(R.id.placeArticle);
        prediction = findViewById(R.id.prediction);


        recyclerView = findViewById(R.id.articleRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Article> articles = new ArrayList<>();
        articleAdapter = new ArticleAdapter(articles);

        recyclerView.setAdapter(articleAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mApi = ((App) getApplication()).api();
        mApi.itemArticle(getIntent().getStringExtra("article")).enqueue(new Callback<ItemArticle>() {
            @Override
            public void onResponse(Call<ItemArticle> call, Response<ItemArticle> response) {
                itemArticle = response.body();
                if (itemArticle != null) {
                    team1.setText(itemArticle.getTeam1());
                    team2.setText(itemArticle.getTeam2());
                    timeItemArticle.setText(itemArticle.getTime());
                    tournament.setText(itemArticle.getTournament());
                    placeArticle.setText(itemArticle.getPlace());
                    prediction.setText(itemArticle.getPrediction());

                    if (itemArticle.getArticle() != null && itemArticle.getArticle().size() > 0) {
                        articleAdapter.setArticles(itemArticle.getArticle());
                    }
                }
            }

            @Override
            public void onFailure(Call<ItemArticle> call, Throwable t) {
                Toast.makeText(ArticleActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}