package com.example.mynotsjava;

public class NotsObject {

    private static String noteTitle = "название новости";
    private static String noteDescription = "описание новости";
    private static String time = "время заполнения";

    NotsObject(String noteTitle, String noteDescription) {
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
    }




    public  String getNoteTitle() {
        return noteTitle;
    }


    public static String getNoteDescription() {
        return noteDescription;
    }

    public static String getTime() {
        return time;
    }
}
