package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray  {

    Object[] objects;

    public BaseArray(Object[] objects){
        this.objects = objects;
    }

    @Override
    public Object[] toArray() {
        return objects;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
