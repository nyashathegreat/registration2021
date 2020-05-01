import java.util.*;
import java.sql.*;

public class StudentFeePayment{
	
    public void StudentAdmission()throws Exception {

        try {
            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/registration","xxxx","xxxx" );
            Statement stmt = conn.createStatement();

            Scanner input = new Scanner(System.in);
            
            // user inputs details
            System.out.println("Please enter your full name: ");
            String NAME = input.nextLine().toUpperCase();

            System.out.println(" Please enter your student ID: ");
            String idNumber = input.nextLine();
                    
            System.out.println("Please enter the amount you would love to pay : ");
            double amount = input.nextInt();
            
            Stats students = new Stats (idNumber);
            
            //student paying fees
            students.fees(amount);
                
            if (students.getFees() >= 15000){
                System.out.println(" "+ NAME+ " has been successfully registered for classes!!!\n");
                System.out.println("\n"
                        + "|**======================= *** ===========================**|\n"
                        + "|    *** WELCOME TO THE GREAT UNIVERSITY 2025 CLASS ***     |\n"
                        + "|     *** PLEASE CHECK YOUR EMAIL FOR MORE DETAILS ***      |\n"
                        + "|**======================= *** ===========================**|\n");
                
                System.out.println("\n Please note your tution balance is R" + students.getBalance());
                
                //updating feesPaid in database 
                String feePaid = "UPDATE studentData set feesPaid  = "+ amount +
                                " WHERE id = " +idNumber; 
                int z = stmt.executeUpdate( feePaid); 
                        
                if (z > 0)             
                    System.out.println(" fee payment is successfully Updated");             
                else            
                    System.out.println("fee payment not updated");
                


            }
            else if (students.getFees() < 15000) {
                System.out.println("\n"
                + "|**======================= *** ===========================**|\n"
                + "            THANK YOU FOR YOUR TIME, PLEASE NOTE"
                + "\n         YOU ARE REQUIRED TO PAY AT LEAST 15000."
                + "\n      YOU MAY ALSO CONSIDER APPLYING FOR SCHOLARSHIP \n"
                + "           ON OPTION [4] ON YOUR HOME PAGE...ENJOY\n"
                + "|**======================= *** ===========================**|\n");
            
        }
        
            
        } catch (Exception e) {
            System.out.println("Sorry the program stopped running");
        }
        
        


    }
    
}