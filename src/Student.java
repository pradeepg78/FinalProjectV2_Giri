import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Double> grades = new ArrayList<>();;

    public Student(String name, ArrayList<Double> grades)
    {
        this.grades = grades;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<Double> getGrades()
    {
        return grades;
    }

    public void setGrades(ArrayList<Double> grades)
    {
        this.grades = grades;
    }

    public void addGrades(double g)
    {
        grades.add(g);
    }

    public double getAverage()
    {
        double sum = 0;
        int total = 0;
        for (int i = 0; i < grades.size(); i++)
        {
            sum += grades.get(i);
            total++;
        }
        return  sum / total;
    }

}
