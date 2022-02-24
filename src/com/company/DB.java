package com.company;

public abstract class DB {
    // DB connection method
    public abstract void connect();
    public abstract void remove(int id);
    public abstract void showTable();
}