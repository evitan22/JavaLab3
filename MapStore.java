import java.util.*;

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
}