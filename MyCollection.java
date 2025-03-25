import java.util.*;
import java.util.stream.Collectors;

public class MyCollection {
    List<Audience> myList = new ArrayList<>();
    
    public MyCollection(Audience[] arr) {
        this.myList.addAll(new HashSet<Audience>(Arrays.asList(arr)));
    }

    public void show() {
        this.myList.stream().forEach(a -> System.out.println(a));
    }

    public Audience findItem(int expectedValue) {
        return this.myList.stream().filter(item -> item.getNumberOfCabinet() == expectedValue)
        .findFirst()
        .orElse(null);
    }

    public void sortWithAnonimClass() {
        Collections.sort(this.myList, new Comparator<Audience>() {
            public int compare(Audience e1, Audience e2) {
                return e1.getNumberOfCabinet()-(e2.getNumberOfCabinet());
            }
        });
    }

    public void sortWithLyambda() {
        myList.sort((a, b) -> Integer.compare(a.numberOfCabinet, b.numberOfCabinet));
    }

    public void sortWithMethod() {
        myList.sort(Comparator.comparingInt(Audience::getNumberOfCabinet));
    }

    public void getAverageNumber() {
        List<Integer> l = this.myList.stream()
            .map(Audience::getNumberOfSeats)
            .collect(Collectors.toList());
        
        int sum = l.stream().reduce(0, (a, b) -> a+b);
        System.out.println("The arithmetic mean of number of seats is " + sum/this.myList.size());
    }
}