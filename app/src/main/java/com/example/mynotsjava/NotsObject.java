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


    public NotsObject(String string, String string1) {
    }

    public static String getNoteTitle() {
        return noteTitle;
    }

    public static void setNoteTitle(String noteTitle) {
        NotsObject.noteTitle = noteTitle;
    }

    public static String getNoteDescription() {
        return noteDescription;
    }

    public static void setNoteDescription(String noteDescription) {
        NotsObject.noteDescription = noteDescription;
    }

    public static String getTime() {
        return time;
    }

    public static void setTime(String time) {
        NotsObject.time = time;
    }
}
