package com.classy.class_2021a_and_4;

public class Record {

    private String name;
    private long date;
    private int score;

    public Record() { }

    public Record(String name, long date, int score) {
        this.name = name;
        this.date = date;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Record setName(String name) {
        this.name = name;
        return this;
    }

    public long getDate() {
        return date;
    }

    public Record setDate(long date) {
        this.date = date;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Record setScore(int score) {
        this.score = score;
        return this;
    }
}
