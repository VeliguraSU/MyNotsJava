package com.example.mynotsjava;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.DatePicker;

public class NotsObject implements Parcelable {

    private String noteTitle = "название новости";
    private String noteDescription = "описание новости";
    private String noteTime;

    NotsObject(String noteTitle, String noteDescription,String noteTime) {
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
        this.noteTime = noteTime;
    }


    protected NotsObject(Parcel in) {
        noteTitle = in.readString();
        noteDescription = in.readString();
        noteTime = in.readString();
    }

    public static final Creator<NotsObject> CREATOR = new Creator<NotsObject>() {
        @Override
        public NotsObject createFromParcel(Parcel in) {
            return new NotsObject(in);
        }

        @Override
        public NotsObject[] newArray(int size) {
            return new NotsObject[size];
        }
    };

    public  String getNoteTitle() {
        return noteTitle;
    }


    public  String getNoteDescription() {
        return noteDescription;
    }


    public String getNoteTime() {
        return noteTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteTitle);
        dest.writeString(noteDescription);
        dest.writeString(noteTime);
    }
}
