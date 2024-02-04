package org.example.model;

public class StringAttribute {

    private int length;

    private String inputString;

    private int numberOfQueries;

    private int l;

    private int r;

    private int k;

    public StringAttribute() {
    }

    public StringAttribute(int length, String inputString, int numberOfQueries, int l, int r, int k) {
        this.length = length;
        this.inputString = inputString;
        this.numberOfQueries = numberOfQueries;
        this.l = l;
        this.r = r;
        this.k = k;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public int getNumberOfQueries() {
        return numberOfQueries;
    }

    public void setNumberOfQueries(int numberOfQueries) {
        this.numberOfQueries = numberOfQueries;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}
