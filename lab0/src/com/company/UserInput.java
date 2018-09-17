package com.company;

import java.util.HashMap;
import java.util.Map;

class UserInput {
    private Map<String,Integer> usersInputMapSI = new HashMap<>();
    private Map<Integer,Integer> usersInputMapII = new HashMap<>();

    void setNewKey(String key, int value){
        usersInputMapSI.put(key,value);
    }
    void setNewKey(int key, int value) {
        usersInputMapII.put(key,value);
    }
    int getValue(String key){
        return usersInputMapSI.get(key);
    }
    int getValue(int key){
        return usersInputMapII.get(key);
    }

}
