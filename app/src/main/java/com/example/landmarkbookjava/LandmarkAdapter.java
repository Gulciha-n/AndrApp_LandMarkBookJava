package com.example.landmarkbookjava;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.landmarkbookjava.databinding.RecyclerRawBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {

    //ArrayList'i , constructer'da bir parametre olarak isteyerek verilere buradan ulaşalım
    ArrayList<Landmark> landmarkArrayList;
    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //XML baglama islemi

        RecyclerRawBinding recyclerRawBinding = RecyclerRawBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRawBinding);

    }
    //onCreateViewHolder() yöntemi, RecyclerView'a eklenecek her bir öğe için çağrılır

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) { //degerleri verme

        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position));
                //Singleton singleton = Singleton.getInstance();
                //singleton.getSentLandmark(landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { //kac tane eleman oldugunu gösterir

        return landmarkArrayList.size();
    }
    public class LandmarkHolder extends  RecyclerView.ViewHolder{ //yardımcı sınıf
        private RecyclerRawBinding binding;
        public LandmarkHolder(RecyclerRawBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
