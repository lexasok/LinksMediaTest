package net.ozero.linksmediatest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

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

        //data
        ItemArticle itemArticle = new ItemArticle(true);
        team1.setText(itemArticle.team1);
        team2.setText(itemArticle.team2);
        timeItemArticle.setText(itemArticle.time);
        tournament.setText(itemArticle.tournament);
        placeArticle.setText(itemArticle.place);
        prediction.setText(itemArticle.prediction);


        recyclerView = findViewById(R.id.articleRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(new ArticleAdapter(itemArticle.articles));
    }

}