import java.util.*;
import java.util.stream.Collectors;

public class MapStore {
    Map<String, List<SheduleItem>> store = new HashMap<>(); 

    public MapStore(SheduleItem[] items) {
        Shedule shedule = new Shedule(items);
        store.put("Monday", shedule.showSheduleForDay("Monday"));
        store.put("Tuesday", shedule.showSheduleForDay("Tuesday"));
        store.put("Wednesday", shedule.showSheduleForDay("Wednesday"));
        store.put("Thursday", shedule.showSheduleForDay("Thursday"));
        store.put("Friday", shedule.showSheduleForDay("Friday"));
        store.put("Saturday", shedule.showSheduleForDay("Saturday"));
    }

    static Map<String, Integer> sortedDays = Map.of(
        "Monday", 1,
        "Tuesday", 2,
        "Wednesday", 3,
        "Thursday", 4,
        "Friday", 5,
        "Saturday", 6
    );

    static final Comparator<String> DAYS__COMPARATOR = new Comparator<String>() {
        public int compare(String e1, String e2) {
            return sortedDays.get(e1)-sortedDays.get(e2);
        }
    };

    public void showMap() {
        Set<String> keys = store.keySet();
        List<String> list = new ArrayList<>(keys);
        list.sort(MapStore.DAYS__COMPARATOR);

        for (String key : list) {
            System.out.println("Key: " + key + " --> Value: " + store.get(key));
        }
    }

    public void sortWithAnonymousClass() {
        for (List<SheduleItem> list : this.store.values()) {
            Collections.sort(list, new Comparator<SheduleItem>() {
                public int compare(SheduleItem p1, SheduleItem p2) {
                    return p2.numberOfLesson-p1.numberOfLesson;
                }
            });
        }
    }

    public void sortWithLyambda() {
        for (List<SheduleItem> list : this.store.values()) {
            list.sort((p1, p2) -> p2.numberOfLesson-p1.numberOfLesson);
        }
    }

    public void sortWithMethod() {
        for (List<SheduleItem> list : this.store.values()) {
            list.sort(Comparator.comparingInt(SheduleItem::getNumberOfLesson).reversed());
        }
    }

    public void findItem(String expectedValue) {
        List<SheduleItem> allItems = this.store.values()
            .stream()
            .flatMap(List::stream)
            .filter(item -> item.subjectName.equals(expectedValue))
            .collect(Collectors.toList());
        for (SheduleItem i : allItems) {
            System.out.println(i);
        }
    }

    public void removeItems(String expectedValue) {
        Set<String> keys = store.keySet();

        for (String key : keys) {
            List<SheduleItem> cuttedList = store.get(key)
                .stream()
                .filter(i -> i.subjectName.equals(expectedValue))
                .collect(Collectors.toList());
            this.store.put(key, cuttedList);
        }
    }

    public void getSum() {
        List<Integer> allItems = this.store.values()
            .stream()
            .flatMap(List::stream)
            .map(i -> i.audience.numberOfSeats)
            .collect(Collectors.toList());

        int sum = allItems.stream()
            .reduce(0, (a, b) -> a+b);
        System.out.println(sum);
    }
}