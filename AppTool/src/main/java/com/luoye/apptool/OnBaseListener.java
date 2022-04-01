package com.luoye.apptool;


public abstract class OnBaseListener<T> {

    public void itemId(int itemId) { }

    public void itemDate(T data) { }

    public void itemBoolean(boolean b) { }

    public void itemDate(T data,boolean b) { }

    public void itemDataAndId(T data, int itemId) { }

    public void itemDataAndId(T data, int itemId,boolean b) { }
}
