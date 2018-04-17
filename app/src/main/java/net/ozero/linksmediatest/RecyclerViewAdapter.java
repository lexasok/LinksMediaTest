package net.ozero.linksmediatest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView coefficient;
        TextView time;
        TextView place;
        TextView preview;
        TextView article;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            coefficient = itemView.findViewById(R.id.coefficient);
            time = itemView.findViewById(R.id.time);
            place = itemView.findViewById(R.id.place);
            preview = itemView.findViewById(R.id.preview);
            article = itemView.findViewById(R.id.article);
        }
    }
}
