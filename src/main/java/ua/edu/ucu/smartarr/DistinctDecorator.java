package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {


    SmartArray smartArray;
    private Object[] array;
    private Object object;

    public DistinctDecorator(SmartArray smartArray) {
        super(apply(smartArray));
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
            if (!contains(newArrayList, object)) {
                newArrayList.add(object);
            }
        }
        return new BaseArray(newArrayList.toArray());
    }

    static private boolean contains(ArrayList<Object> arrayList, Object o) {
        for (Object anArrayList : arrayList) {
            if (o.toString().equals(anArrayList.toString())) {
                return true;
            }
        }
        return false;
    }

}
