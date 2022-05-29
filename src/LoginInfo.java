import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;


public class LoginInfo {
    private String username;
    private String password;
    private Scanner s;
    private boolean correctLogin;

    public LoginInfo()
    {
        username = "";
        password = "";
    }

    public LoginInfo(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean isCorrectLogin() {
        return correctLogin;
    }

    public void verifyLogin(String username, String password, String filepath)
    {
        boolean found = false;
        String tempUser = "";
        String tempPass = "";

        try
        {
            s = new Scanner(new File(filepath));
            s.useDelimiter("[\n]");

            while (s.hasNextLine() && !found)
            {
                tempUser = s.next();
                tempPass = s.next();

                if(tempUser.trim().equals(username.trim()) && tempPass.trim().equals(password.trim()))
                {
                    found = true;
                    correctLogin = true;
                }
            }
            s.close();

            if (!found)
            {
                System.out.println("Incorrect Login Info.");
                correctLogin = false;
            }
            else
            {
                System.out.println();
                System.out.println("Welcome " + username + "!");
            }
        }
        catch (Exception e)
        {
            System.out.println("Incorrect Login");
        }
    }

    public void save() {
        try {
            File f = new File("src/logininfo.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter("src/logininfo.txt");
            fw.write(username + "\n");
            fw.write(password);
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}
