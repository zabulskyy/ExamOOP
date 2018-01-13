package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class  DistinctDecorator extends SmartArrayDecorator {


    SmartArray smartArray;
    private Object[] array;
    private Object object;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        this.smartArray = apply(smartArray);
        this.array = smartArray.toArray();
    }


    @Override
    public String operationDescription() {
        return null;
    }

    static private SmartArray apply(SmartArray smartArray) {
        ArrayList<Object> newArrayList = new ArrayList<>();
        for (Object object : smartArray.toArray()) {
            if (!newArrayList.contains(object)) {
                newArrayList.add(object);
            }
        }
        return new BaseArray(newArrayList.toArray());
    }
}
