package ua.edu.ucu.smartarr;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator  {

    public MapDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public String operationDescription() {
        return null;
    }

}
