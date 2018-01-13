package com.library.repository;

import com.library.model.Id;

import java.util.ArrayList;
import java.util.List;

public class Repository<T extends Id> {

    protected List<T> data;

    public Repository(List<T> data) {
        this.data = data;
    }

    public T findById(int id) {
        for (T entry : data) {
            if(entry.getId() == id) {
                return entry;
            }
        }
        // Not found
        return null;
    }
}
