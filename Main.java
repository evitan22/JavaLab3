public class Main {
    public static void main(String[] args) {
        Audience a1 =  new Audience(200, 250, 34);
        Audience[] audiences = {
            a1, a1,
            new Audience(120, 103, 18),
            new Audience(60, 40, 99),
            new Audience(100, 67, 3),
            new Audience(135, 100, 182)
        };

        SheduleItem[] items = {
            new SheduleItem("Prihodko", "English", "Friday", 2, audiences[0]),
            new SheduleItem("Mayer", "Programming", "Monday", 1, audiences[1]),
            new SheduleItem("Gavrilenko", "History", "Tuesday", 4, audiences[2])
        };
        
        MyCollection<Audience> collInstance = new MyCollection<>(audiences);
        MyCollection<SheduleItem> collInstance2 = new MyCollection<>(items);
        collInstance.show();
        System.out.println("-------------------------------------");
        collInstance2.show();
        System.out.println("-------------------------------------");
        System.out.println(collInstance.findItem(Audience::getNumberOfCabinet, 3));
        System.out.println("-------------------------------------");
        collInstance.sort(Audience.NUMBER_COMPARE);
        collInstance.show();
        System.out.println("-------------------------------------");
        System.out.println(collInstance2.findItem(SheduleItem::getSubjectName, "English"));
        System.out.println("-------------------------------------");
        collInstance2.sort(SheduleItem.NUMBER_OF_LESSON__COMPARATOR);
        collInstance2.show();
    }
}