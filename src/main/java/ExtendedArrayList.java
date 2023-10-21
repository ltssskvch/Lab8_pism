import java.util.ArrayList;

public class ExtendedArrayList<String> extends WorkingWIthArrayList {

    public ExtendedArrayList(ArrayList<String> arrayList) {
        super(arrayList);
    }

    public boolean compareInnerObjects(int firstIndex, int secondIndex) {
        if (firstIndex >= 0 && firstIndex < size() && secondIndex >= 0 && secondIndex < size()) {
            String firstObject = (String) get(firstIndex);
            String secondObject = (String) get(secondIndex);
            return firstObject.equals(secondObject);
        } else {
            System.out.println("error");
            return false;
        }
    }
}

