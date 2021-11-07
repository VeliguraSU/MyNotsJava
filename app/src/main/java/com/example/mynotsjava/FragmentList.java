package com.example.mynotsjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentList extends Fragment {


    public FragmentList() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.TitleNotes);

        for (int i=0;i< notes.length;i++) {
            TextView textView = new TextView(getContext());
            textView.setText(notes[i]);
            textView.setTextSize(30);
            linearLayout.addView(textView);

        }
    }
}