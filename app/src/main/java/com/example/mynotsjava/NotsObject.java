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

    NotsObject notsObject1 = new NotsObject("новость1", "текст новости1", "времия создания новости1");
    NotsObject notsObject2 = new NotsObject("новость2", "текст новости2", "времия создания новости2");
    NotsObject notsObject3 = new NotsObject("новость3", "текст новости3", "времия создания новости3");
}
