import java.util.*;
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

    public String getSubjectName() {
        return this.subjectName;
    }

    public String toString() {
        return "This instance of class SheduleItem with lesson " + this.numberOfLesson;
    }

    static final Comparator<SheduleItem> NUMBER_OF_LESSON__COMPARATOR = new Comparator<SheduleItem>() {
        public int compare(SheduleItem e1, SheduleItem e2) {
            return e1.numberOfLesson - e2.numberOfLesson;
        }
    };
}