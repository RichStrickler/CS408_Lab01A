package com.example.cs408lab1a;

public enum Weapon {

    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");
    private String message;

    Weapon(String msg) { message = msg; }

    @Override
    public String toString() {return message;}
}