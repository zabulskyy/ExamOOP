package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {


    private SmartArray smartArray;
    private MyFunction myFunction;
    private Object[] array;

    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        super(apply(smartArray, myFunction));
        this.smartArray = apply(smartArray, myFunction);
        this.myFunction = myFunction;
        this.array = smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return null;
    }

    static private SmartArray apply(SmartArray smartArray, MyFunction myFunction) {
        ArrayList<Object> newArrayList = new ArrayList<>();
        for (Object object : smartArray.toArray()) {
            newArrayList.add(myFunction.apply(object));
        }
        return new BaseArray(newArrayList.toArray());
    }

}
