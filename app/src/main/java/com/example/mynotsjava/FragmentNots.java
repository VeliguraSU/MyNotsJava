package com.example.mynotsjava;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;


public class FragmentNots extends Fragment {


    private static final String ARG_POSITION = "poz";
    private NotsObject notsObject;

    public FragmentNots() {
        // Required empty public constructor
    }

    // второй паттерн програмирования за день ФАБРИЧНЫЙ МЕТОД
    // тут мы передаем наш position во фрагмент(оч важно)
    public static FragmentNots newInstance(@NonNull NotsObject notsObject) {
        FragmentNots fragment = new FragmentNots();
        Bundle args = new Bundle();
        args.putParcelable(ARG_POSITION, notsObject);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            notsObject = getArguments().getParcelable(ARG_POSITION);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nots, container, false);

    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] title = getResources().getStringArray(R.array.titleNotes);
        String[] notes = getResources().getStringArray(R.array.textNotes);

        TextView tv = view.findViewById(R.id.Title);
        TextView tv1 = view.findViewById(R.id.Notes);
        TextView tv2 = view.findViewById(R.id.time);
if(notsObject!=null) {
    tv.setText(notsObject.getNoteTitle());
    tv1.setText(notsObject.getNoteDescription());
    tv2.setText(notsObject.getNoteTime());
}

    }


}
