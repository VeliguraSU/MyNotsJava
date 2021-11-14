package com.example.mynotsjava;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentList extends Fragment {




    public FragmentList() {

    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
// создаем список новостей
    private void initView(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.titleNotes);// получаем текст из ресурсов

        for (int i = 0; i < notes.length; i++) {
            TextView textView = new TextView(getContext());//создаем вьюшку
            textView.setText(notes[i]);// вставляем текст из списка новостей
            textView.setTextSize(30);
            final int position = i;
            textView.setOnClickListener(v -> {
                showNotes(position);
            });
            linearLayout.addView(textView);

        }
    }
// тут мы получаем в какой фрагмент отобразится наша новость
    private void showNotes(int position) {
        if (!isLand()) {
            showNotesPort(position);
        } else {
            showNotesLand(position);
        }
    }
// для портретной ориентации
    private void showNotesPort(int position) {
        FragmentNots fragment = FragmentNots.newInstance(position);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();

    }
// для ландшафтной ориентации
    private void showNotesLand(int position) {
        FragmentNots fragment = FragmentNots.newInstance(position);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container2, fragment)
                .addToBackStack(null)
                .commit();

    }
// определяем ориентацию
    private Boolean isLand() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }
}


