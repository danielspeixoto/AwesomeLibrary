package com.library.model;

public class Teacher extends User {

    public Teacher(int code, String name) {
        super(code, name, Role.TEACHER);
    }
}
