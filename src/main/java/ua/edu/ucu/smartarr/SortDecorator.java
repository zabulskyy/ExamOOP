package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private SmartArray smartArray;
    private MyComparator myComparator;
    private Object[] array;

    public SortDecorator(SmartArray smartArray, MyComparator myComparator) {
        super(apply(smartArray, myComparator));
        this.smartArray = apply(smartArray, myComparator);
        this.myComparator = myComparator;
        this.array = smartArray.toArray();
    }


    @Override
    public String operationDescription() {
        return null;
    }

    static private SmartArray apply(SmartArray smartArray, MyComparator myComparator) {
        ArrayList<Object> newArrayList = new ArrayList<>(Arrays.asList(smartArray.toArray()));
        newArrayList.sort(myComparator);
        return new BaseArray(newArrayList.toArray());
    }
}
