import java.util.ArrayList;

public class ExtendedArrayList<T> extends ArrayList<T> {

    public ExtendedArrayList() {
        super();
    }

    public boolean compareInnerObjects(int firstIndex, int secondIndex) {
        if (firstIndex >= 0 && firstIndex < size() && secondIndex >= 0 && secondIndex < size()) {
            T firstObject = get(firstIndex);
            T secondObject = get(secondIndex);
            return firstObject.equals(secondObject);
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
}

