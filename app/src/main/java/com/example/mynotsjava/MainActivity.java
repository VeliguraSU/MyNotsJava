package com.example.mynotsjava;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {// стартовыый фрагмент
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentList fragmentList = new FragmentList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentList)
                .commit();

    }


    @Override
    public void onBackPressed() {// тут мы делаем стек обратново вызова
        if (getSupportFragmentManager().getFragments().size() > 1) {
            getSupportFragmentManager()
                    .popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_seting) { //кнопка настройки

            FragmentSetting fragment = new FragmentSetting();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;

        } else if (id == R.id.action_switch) {//кнопка смены темы

            FragmentSvitsh fragment = new FragmentSvitsh();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;

        } else if (id == R.id.action_description) {//кнопка "о приложении"

            FragmentDescription fragment = new FragmentDescription();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        } else if (id == R.id.action_list) {//кнопка перехода во фрагмент со сп иском

            FragmentList fragmentList = new FragmentList();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragmentList)
                    .addToBackStack(null)
                    .commit();
            return true;
        } else if (id == R.id.action_exit) { //кнопка выход иz приложения
            // а вот еще один паттекрн. билдер добавляет в конструктор параметры.
                new AlertDialog.Builder(this).setMessage("давай попробуем еще раз")
                        .setTitle("Выбор между жизнью и смертью")
                        .setPositiveButton("ok",(dialog, which) -> {
                            FragmentList fragmentList = new FragmentList();
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.container, fragmentList)
                                    .addToBackStack(null)
                                    .commit();
                        }).setNegativeButton("неа",(dialog, which) -> {
                    Toast.makeText(this,"эх",Toast.LENGTH_LONG).show();
                    finish();
                }).show();

                   }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
// хз как но хочу довить сообщение на выход
        new AlertDialog.Builder(this).setMessage("давай попробуем еще раз")
                .setTitle("Выбор между жизнью и смертью")
                .setPositiveButton("ok",(dialog, which) -> {
                    FragmentList fragmentList = new FragmentList();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, fragmentList)
                            .addToBackStack(null)
                            .commit();
                }).setNegativeButton("неа",(dialog, which) -> {
            Toast.makeText(this,"эх",Toast.LENGTH_LONG).show();
            finish();
        }).show();
    }
}






