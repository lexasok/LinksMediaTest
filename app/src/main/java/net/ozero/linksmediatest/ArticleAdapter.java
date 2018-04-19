package net.ozero.linksmediatest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>{

    ArrayList<Article> articles;

    ArticleAdapter(ArrayList<Article> articles) {
        this.articles = articles;
    }


    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.header.setText(articles.get(position).header);
        holder.text.setText(articles.get(position).text);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder{
        TextView header;
        TextView text;


        public ArticleViewHolder(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.header);
            text = itemView.findViewById(R.id.textArticle);

        }
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles.addAll(articles);
        notifyDataSetChanged();
    }
}
