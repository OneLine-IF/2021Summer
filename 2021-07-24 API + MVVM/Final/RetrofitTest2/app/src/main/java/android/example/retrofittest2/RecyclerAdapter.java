package android.example.retrofittest2;

import android.example.retrofittest2.databinding.RecyclerviewNoticeBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<Notice> noticeArrayList;

    public RecyclerAdapter(ArrayList<Notice> noticeArrayList) {
        this.noticeArrayList = noticeArrayList;
    }



    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewNoticeBinding binding = RecyclerviewNoticeBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bind(noticeArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return noticeArrayList.size();
    }

    /*public ArrayList<Notice> setNoticeArrayList(ArrayList<Notice> arrayList) {
        noticeArrayList = arrayList;
        notifyDataSetChanged();
        return noticeArrayList;
    }*/

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        RecyclerviewNoticeBinding binding;

        public RecyclerViewHolder(RecyclerviewNoticeBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        void bind(Notice notice){
            binding.setNotice(notice);
        }
    }
}
