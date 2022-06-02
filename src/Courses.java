import java.util.*;

public class Courses {
    private String courseName;
    private ArrayList <Student> students = new ArrayList<Student>();;

    public Courses ()
    {
        courseName = "";
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }


    public ArrayList<Student> getStudents()
    {
        return students;
    }

    public void addStudents(Student s)
    {
        students.add(s);
    }

}
