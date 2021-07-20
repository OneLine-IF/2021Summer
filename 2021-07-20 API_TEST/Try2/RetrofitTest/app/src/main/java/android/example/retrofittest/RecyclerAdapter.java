package android.example.retrofittest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    public RecyclerAdapter() {
        this.noticeArrayList = new ArrayList<>();
    }

    ArrayList<Notice> noticeArrayList;

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_notice, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Notice notice = noticeArrayList.get(position);
        holder.getTitleTextView().setText(notice.getTitle());
        holder.getContentTextView().setText(notice.getContent());
    }

    @Override
    public int getItemCount() {
        return noticeArrayList.size();
    }

    public void setNoticeArrayList(ArrayList<Notice> arrayList) {
        noticeArrayList = arrayList;
        notifyDataSetChanged();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleTextView;
        private final TextView contentTextView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title_textview);
            contentTextView = (TextView) itemView.findViewById(R.id.content_textview);
        }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public TextView getContentTextView() {
            return contentTextView;
        }
    }
}
