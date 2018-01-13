import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SmartArray;

public class Main {
    public static void main(String[] args) {

        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        SmartArray sa = new BaseArray(integers);
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };
        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        for (Object o :
                sa.toArray()) {
            System.out.println(o);
        }
    }
}
