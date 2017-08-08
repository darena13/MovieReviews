package darena13.moviereviews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.util.List;

import darena13.moviereviews.Model.Response;
import darena13.moviereviews.Model.Result;


/**
 * Created by darena13 on 08.08.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Result> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView title;
        public TextView tags;
        public TextView date;
        public TextView headline;
        public TextView summary;
        public Button readMore;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture);
            title = (TextView) itemView.findViewById(R.id.title);
            tags = (TextView) itemView.findViewById(R.id.tags);
            date = (TextView) itemView.findViewById(R.id.date);
            headline = (TextView) itemView.findViewById(R.id.headline);
            summary = (TextView) itemView.findViewById(R.id.summary);
            readMore = (Button) itemView.findViewById(R.id.read_more);;
        }
    }

    public MyAdapter(List<Result> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        TextView v = (TextView) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.recycler_card, parent, false);
//
//        ViewHolder vh = new ViewHolder(v);
//        return vh;

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recycler_card, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.picture.
        holder.title.setText(mDataset.get(position).getDisplayTitle());
        holder.tags.setText(mDataset.get(position).getMpaaRating());
        holder.date.setText(mDataset.get(position).getPublicationDate());
        holder.headline.setText(mDataset.get(position).getHeadline());
        holder.summary.setText(mDataset.get(position).getSummaryShort());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public Uri getUri (int position) {
        return Uri.parse(mDataset.get(position).getLink().getUrl());
    }
}
