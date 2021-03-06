import java.util.*;
import java.io.*;

public class GradesPanel  {
    private ArrayList <Courses> courses = new ArrayList<Courses>();

    public GradesPanel () {}

    public void addCourse(Courses c)
    {
        courses.add(c);
    }

    public ArrayList<Courses> getCourses()
    {
        return courses;
    }

    public ArrayList<String> getCoursesNames()
    {
        ArrayList<String> n = new ArrayList<String>();
        for (int i = 0; i < courses.size(); i++)
        {
            n.add(courses.get(i).getCourseName());
        }
        return n;
    }

    public void addStudent(Student s, String courseName)
    {
        for (int i = 0; i < courses.size(); i++)
        {
            if(courses.get(i).getCourseName().equals(courseName))
            {
                courses.get(i).addStudents(s);
            }
        }
    }

    public void saveInfo()
    {
        try {
            File f = new File("info.data");
            f.createNewFile();
            FileWriter fw = new FileWriter("info.data");

            for (int i = 0; i < courses.size(); i++)
            {
                fw.write(courses.get(i).getCourseName() + "\n");
                for (int z = 0; z < courses.get(i).getStudents().size(); z++)
                {
                    fw.write(courses.get(i).getStudents().get(z).getName() + " - " + courses.get(i).getStudents().get(z).getAverage() + "\n");
                }
                fw.write("\n");
            }

            fw.close();
        }
        catch (IOException e)
        {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }




}
