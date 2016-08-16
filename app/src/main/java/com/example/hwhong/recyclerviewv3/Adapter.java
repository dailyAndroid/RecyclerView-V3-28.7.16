package com.example.hwhong.recyclerviewv3;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hwhong on 7/28/16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private ArrayList<Information> data;
    private LayoutInflater inflator;

    int prevPosition = 0;

    public Adapter(Context applicationContext, ArrayList<Information> data) {
        this.context = applicationContext;
        this.data = data;
        inflator = LayoutInflater.from(applicationContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //called each time the row view is created
        holder.txtView.setText(data.get(position).title);
        holder.imgView.setImageResource(data.get(position).imageID);

        if (position > prevPosition) {
            Animation.animate(holder, true);
        } else {
            //scrolled upward
            Animation.animate(holder, false);
        }

        prevPosition = position;

        final int currPos = position;
        final Information item = data.get(position);

        holder.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(currPos, item);
            }
        });

        holder.imgView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(currPos, item);

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtView;
        ImageView imgView;

        public ViewHolder(View itemView) {
            super(itemView);

            txtView = (TextView) itemView.findViewById(R.id.txtView);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);
        }
    }

    //makes another itme on the recyclerview
    private void addItem(int position, Information info) {
        data.add(position, info);
        notifyItemInserted(position);
    }

    private void remove(int position, Information info) {
        int pos = data.indexOf(info);
        data.remove(pos);
        notifyItemRemoved(pos);
    }
}
