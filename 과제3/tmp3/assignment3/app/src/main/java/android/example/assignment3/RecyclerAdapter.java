package android.example.assignment3;

import android.content.Context;
import android.example.assignment3.databinding.TimeItemBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<TimeInfo> arrayList;
    public RecyclerAdapter(ArrayList<TimeInfo> arrayList){
        this.arrayList=arrayList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TimeItemBinding binding = TimeItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.bind(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TimeItemBinding binding;

        public RecyclerViewHolder(TimeItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
        void bind(TimeInfo timeInfo){
            binding.setTimeInfo(timeInfo);
        }
    }
}
