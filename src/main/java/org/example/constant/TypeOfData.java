package org.example.constant;

public enum TypeOfData {
    A('A'),B('B');

    private final char data;
    TypeOfData(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }
}
