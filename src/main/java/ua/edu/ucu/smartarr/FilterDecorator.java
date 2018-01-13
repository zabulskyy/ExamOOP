package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private SmartArray smartArray;
    private MyPredicate myPredicate;
    private Object[] array;


    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(apply(smartArray, myPredicate));
        this.smartArray = apply(smartArray, myPredicate);
        this.myPredicate = myPredicate;
        this.array = smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return null;
    }

    static private SmartArray apply(SmartArray smartArray, MyPredicate myPredicate) {
        ArrayList<Object> newArrayList = new ArrayList<>();
        for (Object object : smartArray.toArray()) {
            if (myPredicate.test(object)) {
                newArrayList.add(object);
            }
        }
        return new BaseArray(newArrayList.toArray());
    }
}
