public class Main {
    public static void main(String[] args) {
        Audience[] audiences = {
            new Audience(200, 250, 34),
            new Audience(120, 103, 18),
            new Audience(60, 40, 99),
            new Audience(100, 67, 3),
            new Audience(135, 100, 182)
        };

        // System.out.println(audiences[0].bookAnAudience("Prihodko", "High Math", 100));
        // System.out.println(audiences[1].bookAnAudience("Mayer", "Programming"));
        // System.out.println(audiences[2].bookAnAudience("Gavrilenko", "English", 70));

        // System.out.println(audiences[0].getTypeOfLesson());
        // audiences[0].setTypeOfLesson("exam");
        // System.out.println(audiences[0].getTypeOfLesson());

        // System.out.println(Audience.getCountOfAudiences());

        SheduleItem[] items = {
            new SheduleItem("Prihodko", "English", "Friday", 4, audiences[0]),
            new SheduleItem("Mayer", "Programming", "Monday", 1, audiences[1]),
            new SheduleItem("Gavrilenko", "History", "Tuesday", 4, audiences[2])
        };
        Shedule mass = new Shedule(items);
        mass.addSheduleItem(new SheduleItem("Kovalchuk", "High Math", "Wednesday", 3, audiences[0]));
        mass.addSheduleItem(new SheduleItem("Tytynuk", "Astronomy", "Tuesday", 3, audiences[0]));
        mass.show();
        mass.removeSheduleItem("English", "Monday");
        mass.removeSheduleItem("Programming", "Monday");
        mass.show();
        mass.showSheduleForDay("Tuesday");
        mass.findFreeAudience(2, "Tuesday", audiences);

        Laboratory lab = new Laboratory(200, 2, 3, "Chemistry");
        Laboratory.Board board1 = lab.new Board("white", "wood");
        lab.setBoard(board1);
        System.out.println(lab.bookAnAudience("teachersName", "ectName", 392));
    }
}