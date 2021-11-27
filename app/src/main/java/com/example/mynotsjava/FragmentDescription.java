package com.example.mynotsjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;


public class FragmentDescription extends Fragment {


    public FragmentDescription() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        TextView tv = view.findViewById(R.id.tv_description);
        tv.setText("Добрый день. Это моё учебное приложение. конкретно тут я учусь делать меню");
        //снекбар это плашка с сообщением. пока кнопку не нажмешь не исчезнет
        Snackbar bar = Snackbar.make(view, "купи слона!", Snackbar.LENGTH_INDEFINITE);
        bar.setAction("Ок", v1 -> bar.dismiss());
        bar.show();
    }
}