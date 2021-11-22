package com.example.mynotsjava;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;


public class FragmentList extends Fragment {

    String Time = "12:00";


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

        List<NotsObject> notsObjectList = Arrays.asList(
                new NotsObject(getString(R.string.title1), getString(R.string.text1), Time),
                new NotsObject(getString(R.string.title1), getString(R.string.text1), Time),
                new NotsObject(getString(R.string.title2), getString(R.string.text2), Time),
                new NotsObject(getString(R.string.title3), getString(R.string.text3), Time),
                new NotsObject(getString(R.string.title4), getString(R.string.text4), Time),
                new NotsObject(getString(R.string.title5), getString(R.string.text5), Time),
                new NotsObject(getString(R.string.title6), getString(R.string.text6), Time),
                new NotsObject(getString(R.string.title7), getString(R.string.text7), Time),
                new NotsObject(getString(R.string.title8), getString(R.string.text8), Time),
                new NotsObject(getString(R.string.title9), getString(R.string.text9), Time)

        );

        RecyclerView recyclerView = new RecyclerView(getContext());
        NotObgektAdapter adapter= new NotObgektAdapter(notsObjectList);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

//        initView(view);
//    }
//// создаем список новостей
//    private void initView(View view) {
//        LinearLayout linearLayout = (LinearLayout) view;
//        String[] notes = getResources().getStringArray(R.array.titleNotes);// получаем текст из ресурсов
//
//        for (int i = 0; i < notes.length; i++) {
//            TextView textView = new TextView(getContext());//создаем вьюшку
//            textView.setText(notes[i]);// вставляем текст из списка новостей
//            textView.setTextSize(30);
//            final int position = i;
//            textView.setOnClickListener(v -> {
//                // пишем тост(вылезет сообщенька)
//                Toast.makeText(getContext(),"Что-то приозошло черезвычайно важное,но повлиять на это ты не можешь. " +
//                        "Так, что всеравно",Toast.LENGTH_LONG).show();
//                showNotes(position);
//            });
//            linearLayout.addView(textView);
//
//        }
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


