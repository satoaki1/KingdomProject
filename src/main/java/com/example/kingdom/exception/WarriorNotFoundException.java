package com.example.kingdom.exception;

public class WarriorNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public WarriorNotFoundException(String name) {
        super("Warrior " + name + " is not found.");
    }
}
