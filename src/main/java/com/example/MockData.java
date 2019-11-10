package com.example;


import java.util.Stack;

public class MockData {
    public String[][] data;
    Stack cards = new Stack();

    public MockData(){
        data = new String[5][2];
        data[0] = new String[]{"What color hair does bobby have", "Black"};
        data[1] = new String[]{"How old is David", "Nineteen"};
        data[2] = new String[]{"Who's super cool","Henry"};
        data[3] = new String[]{"Hail who?","Hail google"};
        data[4] = new String[]{"What do we say to game freak?","Fuck you"};
        Cardstack();
    }

    public void Cardstack(){
        cards.push(data[0]);
        cards.push(data[1]);
        cards.push(data[2]);
        cards.push(data[3]);
        cards.push(data[4]);
    }



}

