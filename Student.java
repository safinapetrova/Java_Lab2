import java.util.Arrays;

public class Student {
    private String name;
    private int[] grades;

    public Student(String name, int... grades) {
        this.name = name;
        this.grades = grades != null ? grades : new int[0];
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int[] getGrades() { return grades; }
    public void setGrades(int[] grades) { this.grades = grades; }

    public double getAverage() {
        if (grades.length == 0) return 0;
        double sum = 0;
        for (int grade : grades) sum += grade;
        return sum / grades.length;
    }

    public boolean isExcellent() {
        if (grades.length == 0) return false;
        for (int grade : grades) {
            if (grade != 5) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}