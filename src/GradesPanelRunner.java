import java.io.*;
import java.util.*;

public class GradesPanelRunner {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        LoginInfo p = new LoginInfo();
        GradesPanel gp = new GradesPanel();
        Clear clear = new Clear();

        try {
            File f = new File("logininfo.txt");
            Scanner s = new Scanner(f);
            int line = 1;
            while (s.hasNextLine()) {
                String data = s.next();
                if (line == 1) {
                    p.setUsername(data);
                }
                if (line == 2) {
                    p.setPassword(data);
                }
                line++;
            }
            s.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Please create a new account below. ");
            System.out.print("Enter a username: ");
            Scanner in = new Scanner(System.in);
            String user = in.nextLine();
            System.out.print("Enter a password: ");
            String pass = in.nextLine();
            p.setUsername(user);
            p.setPassword(pass);
            p.save();
        }

        System.out.print("Please enter your username: ");
        String us = x.nextLine();
        System.out.print("Please enter your password: ");
        String pa = x.nextLine();
        p.verifyLogin(us, pa, "logininfo.txt");

        if (p.isCorrectLogin())
        {
            clear.clear();
            System.out.println("What would you like to do today?");
            System.out.println("Add (C)ourse");
            System.out.println("Add (S)tudent");
            System.out.println("(Q)uit");
            System.out.print("Enter your choice: ");
            String choice = x.nextLine();
            System.out.println();
            while (!choice.equalsIgnoreCase("Q"))
            {
                if (choice.equalsIgnoreCase("C"))
                {
                    System.out.print("Please enter a course name: ");
                    String courseName = x.nextLine();

                    if (gp.getCourses().size() == 0)
                    {
                        Courses toAdd = new Courses();
                        toAdd.setCourseName(courseName);
                        gp.addCourse(toAdd);
                        System.out.println("Course Successfully Added");
                    }
                    else
                    {

                        if (gp.getCoursesNames().contains(courseName))
                        {
                            System.out.println("ERROR: This course already exists");
                        }
                        else
                        {
                            Courses toAdd = new Courses();
                            toAdd.setCourseName(courseName);
                            gp.addCourse(toAdd);
                            System.out.println("Course Successfully Added");
                        }
                    }
                }
                else if (choice.equalsIgnoreCase("S"))
                {
                    System.out.print("Please enter the student's name: ");
                    String name = x.nextLine();
                    System.out.print("Which course would you like to add this student to?: ");
                    String courseName = x.nextLine();

                    if (!gp.getCoursesNames().contains(courseName))
                    {
                        System.out.println("ERROR: This course does not exist");
                    }
                    else
                    {
                        boolean done = false;
                        ArrayList<Double> gs = new ArrayList<Double>();
                        while (!done)
                        {
                            System.out.print("Please add a grade for this student: ");
                            double grade = Double.parseDouble(x.nextLine());
                            gs.add(grade);
                            System.out.print("Would you like to add more grades? (y or n): ");
                            if (x.nextLine().equalsIgnoreCase("n"))
                            {
                                done  = true;
                            }
                        }
                        Student s = new Student(name, gs);
                        gp.addStudent(s, courseName);
                        System.out.println("Student Successfully Added.");
                    }
                }
                else
                {
                    System.out.println("ERROR: Invalid choice. ");
                }
                System.out.println();
                clear.clear();
                System.out.println("Add (C)ourse");
                System.out.println("Add (S)tudent");
                System.out.println("(Q)uit");
                System.out.print("Enter your choice: ");
                choice = x.nextLine();
                System.out.println();
            }
            gp.saveInfo();
        }
    }
}
