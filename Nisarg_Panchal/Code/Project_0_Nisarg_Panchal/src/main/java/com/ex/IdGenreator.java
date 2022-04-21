package com.ex;

public class IdGenreator {
    private int initVal;

    public IdGenreator(int initVal) {
        this.initVal = initVal;
    }
    //This method is used to return the current ID value
    public int currentID(){
        return initVal;
    }
    //This method returns the value to next ID by incrementing this value.
    public int nextID(){
        return initVal=initVal+1;
    }
}
