import java.util.*;
import java.util.function.Function;

public class MyCollection <T> {
    List<T> myList = new ArrayList<>();
    
    public MyCollection(T[] arr) {
        // this.myList.addAll(Arrays.asList(arr));
        this.myList.addAll(new HashSet<T>(Arrays.asList(arr)));
    }

    public void show() {
        this.myList.stream().forEach(a -> System.out.println(a));
    }

    public <R> T findItem(Function<T, R> fieldGetter, R expectedValue) {
        return this.myList.stream().filter(item -> fieldGetter.apply(item).equals(expectedValue))
        .findFirst()
        .orElse(null);
    }

    public void sort(Comparator<T> comparator) {
        Collections.sort(this.myList, comparator);
    }
}