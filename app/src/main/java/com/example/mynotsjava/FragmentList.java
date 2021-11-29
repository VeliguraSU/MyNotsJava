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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class FragmentList extends Fragment {



    private RecyclerView recyclerView;
    private Object NotsObject;


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

//делаем время и дату создания новости возможно что-то нужно будет переделать
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Date currentDate = new Date();
// Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
// Форматирование времени как "часы:минуты:секунды"
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String timeText = timeFormat.format(currentDate);

        List<NotsObject> notsObjectList = Arrays.asList(
                new NotsObject(getString(R.string.title1), getString(R.string.text1),dateText+" "+timeText),
                new NotsObject(getString(R.string.title2), getString(R.string.text2),dateText+" "+timeText),
                new NotsObject(getString(R.string.title3), getString(R.string.text3),dateText+" "+timeText),
                new NotsObject(getString(R.string.title4), getString(R.string.text4),dateText+" "+timeText),
                new NotsObject(getString(R.string.title5), getString(R.string.text5),dateText+" "+timeText),
                new NotsObject(getString(R.string.title6), getString(R.string.text6),dateText+" "+timeText),
                new NotsObject(getString(R.string.title7), getString(R.string.text7),dateText+" "+timeText),
                new NotsObject(getString(R.string.title8), getString(R.string.text8),dateText+" "+timeText),
                new NotsObject(getString(R.string.title9), getString(R.string.text9),dateText+" "+timeText)

        );
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        NotObjectAdapter adapter = new NotObjectAdapter(notsObjectList);
        adapter.setClickListner(new NotObjectAdapter.OnNotesClickListner() {
                                    @Override
                                    public void OnNoteClick(View view, int position) {
showNotes(notsObjectList.get(position));
                                    }
                                });

                recyclerView.setAdapter(adapter);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }




//       initView(view);
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




    // тут мы получаем в какой фрагмент отобразится наша новость
    private void showNotes(NotsObject notsObject) {

        if (!isLand()) {
            showNotesPort(notsObject);
        } else {
            showNotesLand(notsObject);
        }
    }
// для портретной ориентации
    private void showNotesPort(NotsObject notsObject) {
        FragmentNots fragment = FragmentNots.newInstance(notsObject);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();

    }
// для ландшафтной ориентации
    private void showNotesLand(NotsObject notsObject) {
        FragmentNots fragment = FragmentNots.newInstance(notsObject);
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


