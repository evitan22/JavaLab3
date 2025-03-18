public class SheduleItem {
    String teachersName;
    String subjectName;
    String day;
    int numberOfLesson;
    Audience audience; //агрегування

    public SheduleItem(String teachersName, String subjectName, String day, int numberOfLesson, Audience audience) {
        this.teachersName = teachersName;
        this.subjectName = subjectName;
        this.day = day;
        this.numberOfLesson = numberOfLesson;
        this.audience = audience;
    }
}