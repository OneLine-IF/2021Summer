package android.example.assignment2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<BookInfo> list;
    Context context;


    public RecyclerAdapter(ArrayList<BookInfo> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.book_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, final int position) {
        holder.title_textView.setText(list.get(position).title);
        holder.writer_textView.setText(list.get(position).writer);

        holder.arrow_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BookInfoActivity.class);
                intent.putExtra("title", list.get(position).getTitle());
                intent.putExtra("writer", list.get(position).getWriter());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List list) {
        list = list;
    }


    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView title_textView, writer_textView;
        Button title_button, writer_button, arrow_button;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            title_textView = itemView.findViewById(R.id.title_textview);
            writer_textView = itemView.findViewById(R.id.writer_textview);


            arrow_button = itemView.findViewById(R.id.right_arrow_button);


        }
    }


}
