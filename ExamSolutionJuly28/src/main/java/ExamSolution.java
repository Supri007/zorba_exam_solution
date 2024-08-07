import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class ExamSolution {
    public static void main(String[] args) {

        try{
            //Create object of properties
            Properties pr = new Properties();
            File inputFile = new File("C:\\IntelliJ\\ExamJuly28\\ExamJuly28Solution\\src\\main\\resources\\dbValue.properties");
            FileInputStream inputStream = new FileInputStream(inputFile);
            pr.load(inputStream);


            String urlDB = (String)pr.get("dbURL");
            String userName = (String)pr.get("userName");
            String password = (String)pr.get("password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(urlDB,userName,password);
            System.out.println("DB connection successful");

            //Get input from user input
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter passenger Name: ");
            String name = sc.nextLine();
            System.out.println("Please enter age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Please enter seat: ");
            String seat = sc.nextLine();
            System.out.println("Please enter reservation type: ");
            String type = sc.nextLine();
            sc.close();

            boolean isSeniorCitizen = false;
            int amountPaid = 0;

            if (age > 60){
                isSeniorCitizen = true;
                seat = "berth/seat";
            }
            if (type.equals("AC")){
                amountPaid = 100;
            }
            else{
                amountPaid = 60;
            }

            //Create table
            String query = "Create table practice_test.railway_reservation (passenger_name varchar(20), passenger_age int(3), " +
                    "choosen_seat varchar(10), reservation_type varchar(10), is_senior_citizen int(1), amount_paid int(5))";
            Statement stat = con.createStatement();
            stat.execute( query);

            //add data to railway_reservation table
            String insertDetails = "insert railway_reservation values(?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = con.prepareStatement(insertDetails);
            insertStatement.setString(1, name);
            insertStatement.setInt(2, age);
            insertStatement.setString(3, seat);
            insertStatement.setString(4,type);
            insertStatement.setInt(5, isSeniorCitizen ? 1: 0);
            insertStatement.setInt(6, amountPaid);
            int noOfDateInserted = insertStatement.executeUpdate();
            System.out.println("Number of Rows Added: " + noOfDateInserted);
            con.close();
        }
        catch (Exception ex){
            System.out.println("Input error. Please enter again.");

        }
    }
}
