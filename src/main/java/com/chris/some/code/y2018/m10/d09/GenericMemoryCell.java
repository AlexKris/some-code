package com.chris.some.code.y2018.m10.d09;

public class GenericMemoryCell<AnyType> {

    private AnyType storedValue;

    public AnyType read() {
        return storedValue;
    }

    public void write(AnyType x) {
        storedValue = x;
    }
}