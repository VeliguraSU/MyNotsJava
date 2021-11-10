package com.example.mynotsjava;

public class NotsObject {

    private static String noteTitle = "название новости";
    private static String noteDescription = "описание новости";
    private static String time = "время заполнения";

    NotsObject(String noteTitle, String noteDescription, String time) {
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
        this.time = time;
    }


}
