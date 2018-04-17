package net.ozero.linksmediatest;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    ArrayList<Event> events;

    RecyclerViewAdapter(ArrayList<Event> events) {
        this.events = events;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(events.get(position).title);
        holder.coefficient.setText(events.get(position).coefficient);
        holder.time.setText(events.get(position).time);
        holder.place.setText(events.get(position).place);
        holder.preview.setText(events.get(position).preview);
        holder.article.setText(events.get(position).article);

        holder.cardContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView coefficient;
        TextView time;
        TextView place;
        TextView preview;
        TextView article;
        CardView cardContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            coefficient = itemView.findViewById(R.id.coefficient);
            time = itemView.findViewById(R.id.time);
            place = itemView.findViewById(R.id.place);
            preview = itemView.findViewById(R.id.preview);
            article = itemView.findViewById(R.id.article);

            cardContainer = itemView.findViewById(R.id.cardContainer);
        }
    }
}
