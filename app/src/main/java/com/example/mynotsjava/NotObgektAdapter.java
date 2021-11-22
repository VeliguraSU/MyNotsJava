package com.example.mynotsjava;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NotObgektAdapter extends RecyclerView.Adapter<NotObgektAdapter.CardsViewHolder> {
private List<NotsObject> notsObjectList;
public static final String TAG = "CardsAdapter";

    public NotObgektAdapter(List<NotsObject> notsObjectList) {
        this.notsObjectList=notsObjectList;
    }

    @NotNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.support_simple_spinner_dropdown_item,parent,false);
        Log.d(TAG, "onCreateViewHolder: ");
        return new CardsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotObgektAdapter.CardsViewHolder holder, int position) {
        holder.bandl(notsObjectList.get(position));
        Log.d(TAG,"onBindViewHolder");
    }



    @Override
    public int getItemCount() {
        return notsObjectList.size();
    }

    class CardsViewHolder extends RecyclerView.ViewHolder {


        TextView textView = itemView.findViewById(R.id.text_view);
        public CardsViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }

        void bandl(NotsObject notsObject){
            textView.setText(notsObject.getNoteTitle());
        }
    }

}
