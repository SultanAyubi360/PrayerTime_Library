package com.sultanayubi.prayertimeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sultanayubi.prayertimeapp.Models.PrayerModel;

import java.util.List;

public class PrayerAdapter extends RecyclerView.Adapter<PrayerAdapter.myviewholder>{


    List<PrayerModel> prayerModels;
    Context context;

    public PrayerAdapter(List<PrayerModel> prayerModels, Context context) {
        this.prayerModels = prayerModels;
        this.context = context;
    }

    @NonNull
    @Override
    public PrayerAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_tv_item,parent,false);
        return new PrayerAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrayerAdapter.myviewholder holder, int position) {
        PrayerModel prayerModel = prayerModels.get(position);

        String imgUrl = prayerModel.getImgurl();
        if (imgUrl == null || imgUrl.isEmpty()) {
            holder.image.setAlpha(0f); // Make the ImageView transparent
        } else {
            holder.image.setAlpha(1f); // Make the ImageView opaque
            Glide.with(holder.itemView.getContext()).load(prayerModel.getImgurl()).into(holder.image);
        }

        holder.title.setText(prayerModel.getPrayerName());
        holder.time.setText(prayerModel.getPrayerTime());

        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.item_animation_fall_down));
    }

    @Override
    public int getItemCount() {
        return prayerModels.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title,time;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.app_logo);
            title = itemView.findViewById(R.id.app_title);
            time = itemView.findViewById(R.id.time);
        }
    }

}
