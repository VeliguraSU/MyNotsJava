package com.example.mynotsjava;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class NotObjectAdapter extends RecyclerView.Adapter<NotObjectAdapter.NotViewHolder> {
    private List<NotsObject> notsObjectList;
    private OnNotesClickListner ClickListner;
    public NotObjectAdapter(List<NotsObject> notsObjectList) {
        this.notsObjectList = notsObjectList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public NotViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_layout, parent, false);
        return new NotViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull NotObjectAdapter.NotViewHolder holder, int position) {

        holder.bind(notsObjectList.get(position));


    }

    @Override
    public int getItemCount() {
        return notsObjectList.size();
    }

    public void setClickListner(OnNotesClickListner clickListner) {
        ClickListner = clickListner;
    }


    class NotViewHolder extends RecyclerView.ViewHolder {

        TextView textView = itemView.findViewById(R.id.ListTITLE);
//        TextView tv2 = itemView.findViewById(R.id.ListNOT);
        TextView tv3 = itemView.findViewById(R.id.ListTIME);

        public NotViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
        }

        void bind(NotsObject notsObject) {
            textView.setText(notsObject.getNoteTitle());
//            tv2.setText(notsObject.getNoteDescription());
            tv3.setText(notsObject.getNoteTime());
            textView.setOnClickListener(v -> {
                if(ClickListner!=null){
                    ClickListner.OnNoteClick(v,getAdapterPosition());
                }
            });
        }
    }

    interface OnNotesClickListner {
        default void OnNoteClick(View view, int position){

        }
    }
}
