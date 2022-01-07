package com.example.recyclerviewgridlayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.RecyclerViewHolder> {
    private JSONArray mlist ;//= new ArrayList<>();
    private Context mcontext;

    public myadapter(JSONArray mlist) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.gridlayoutactivity, parent, false);
        return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Bind the data from Viewholder
        // holder.images.setImageResource(courseDataArrayList.get(position).getImg1());
        try {
            JSONObject obj = mlist.getJSONObject(position);

            holder.t1.setText(obj.getString("courses"));
            holder.t2.setText(obj.getString("mentor"));
            holder.t3.setText(obj.getString("price"));
            Picasso.get().load(obj.getString("Url")).into(holder.images);

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    @Override
    public int getItemCount() {
        return mlist.length();
    }


    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView t1, t2, t3;
        private ImageView images;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);
            t3 = itemView.findViewById(R.id.text3);
            images = itemView.findViewById(R.id.img1);
        }

    }
}

