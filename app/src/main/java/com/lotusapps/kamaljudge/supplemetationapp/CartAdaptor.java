package com.lotusapps.kamaljudge.supplemetationapp;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CartAdaptor extends RecyclerView.Adapter<CartAdaptor.ViewHolder> {

private List<String> mData , mData2;
private LayoutInflater mInflater;
private ItemClickListener mClickListener;

        // data is passed into the constructor
        CartAdaptor(Context context, List<String> data , List<String> data2) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mData2 = data2;
        }

// inflates the row layout from xml when needed
@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.mycartlist, parent, false);
        return new ViewHolder(view);
        }

// binds the data to the TextView in each row
@Override
public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);
        String animal2 = mData2.get(position);
        holder.myTextView2.setText(animal2);
        }

// total number of rows
@Override
public int getItemCount() {
        return mData.size();
        }


// stores and recycles views as they are scrolled off screen
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView myTextView , myTextView2;

    ViewHolder(View itemView) {
        super(itemView);
        myTextView = itemView.findViewById(R.id.itemName);
        myTextView2 = itemView.findViewById(R.id.itemprice);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
    }
}

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

// parent activity will implement this method to respond to click events
public interface ItemClickListener {
    void onItemClick(View view, int position);
}
}