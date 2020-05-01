import java.util.*;
import java.sql.*;

public class Scholarship {

    Scanner input = new Scanner(System.in);

    public void scholarshipApplication() throws Exception{
        
       try {
            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/registration","xxxx","xxxx" );
            Statement stmt = conn.createStatement();

            //all data is stored in databases and ArrayLists stores only the names of the applicant
            
            Boolean apply;
            String scholarship = "";
            String status = "";

            //creating an ArrayList to store details or name of the applicant
            ArrayList<String> scholarshipApplicantForTheGreatCity = new ArrayList<String>();
            ArrayList<String> scholarshipApplicantForNAFOAPP   = new ArrayList<String>();
            ArrayList<String> scholarshipApplicantForMerit  = new ArrayList<String>();
            
            //user menu
            System.out.println("\n"
                    + " DEAR APPLICANT, PLEASE MAKE SURE YOU ENTER YOUR STUDENT ID CORRECTLY\n"
                    + " Enter 1. TO APPLY FOR THE GREAT CITY SCHOLARSHIP \n"
                    + " Enter 2. TO APPLY FOR NAFOAPP \n"
                    + " Enter 3. TO APPY FOR MERIT SCHOLARSHIP \n"
                    + "|** ======================== *** =================================== **|\n");
            
            //user input details
            System.out.println("Please enter your full name: ");
            String aname = input.nextLine().toUpperCase();

            System.out.println("Please enter your Student ID from your stage 2 of application: \n");
            String StudentId = input.nextLine();
            
            System.out.println("Enter your total points calculated from your stage 1 application:");
            int finalPoints = input.nextInt();
    
            System.out.println("You may enter your number choice for the scholarship you are applying for: ");
            int Choice = input.nextInt();
            
            // user chooses scholarship option 
            if(finalPoints >= 25 && Choice == 1) {

                scholarshipApplicantForTheGreatCity.add(aname);
                System.out.println("The applicant with name "+scholarshipApplicantForTheGreatCity+ " is successfully submitted for the Fall Family Scholarship");
                System.out.println("\n *** Please check your email or dashboard for further communication ***");
                
                apply = true;
                scholarship = "The Great City";
                status = "applied";
                
            }
            if(finalPoints >= 30 && Choice == 2) {

                scholarshipApplicantForNAFOAPP.add(aname);
                System.out.println("The applicant with name "+scholarshipApplicantForNAFOAPP  + " is successfully submitted for NASFAS student support. ");
                System.out.println("\n *** Please check your email or dashboard for further communication ***");
                apply = true;
                scholarship = "NAFOAPP";
                status = "applied";
                
                
            }
            if(finalPoints >= 40 && Choice == 3) {

                scholarshipApplicantForMerit .add(aname);
                System.out.println("The applicant with name "+scholarshipApplicantForMerit + " is successfully submitted for UCT Merit Scholarship");
                System.out.println("\n*** Please check your email or dashboard for further communication ***");
                apply = true;
                scholarship = "Merit Scholarship";
                status = "applied";
            }
            if(finalPoints <= 25 && Choice >= 4) {
                System.out.println("Sorry your application cannot be processed due to incorrect details");
                apply = false;
            }
            //insert to database
            if (apply = true){
                String toDataBase1 ="insert into studentData values('" +StudentId+ "','"+aname+ "','"+scholarship+ "','"+ status +"')";
                                
                            
                int l = stmt.executeUpdate(toDataBase1);
                
                if (l > 0) {
                    System.out.println("Applicant's details successfully added to database\n"); 
                }
                else            
                    System.out.println("Insert Failed\n");

            } 
        }catch (Exception e) {
            
            //TODO: handle exception
            System.out.println("Sorry the System stopped running");

         
       }

        
    }

    public void menu(){
        System.out.println("\n"
            + " WELCOME TO SCHOLARSHIP DATA MANAGEMENT\n"
            + " THIS PROGRAM ALLOWS YOU TO UPDATE & DELETE DATA\n\n"
            + " Enter 31. TO UPDATE DATA \n"
            + " Enter 32. TO DELETE DATA \n"
            +"|** ======================== *** =================================== **|\n");

    }

    public void ScholarshipManagement() throws Exception{

        try {

            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/","xxxx","xxxx" );
            Statement stmt = conn.createStatement();

            System.out.println("Please enter your choice:");
            int numberchoice =  input.nextInt();

            switch(numberchoice){

                case 31:
                    //update database
                    System.out.println("Please enter the student's application status: ");
                    String update = input.nextLine();

                    System.out.println("Please enter the student's id number: ");
                    String id = input.nextLine();

                    String updatedadminIn = "UPDATE scholarship set status  = "+ update +" WHERE id = " +id; 
                    int k = stmt.executeUpdate( updatedadminIn); 
                
                    if (k > 0) {            
                        System.out.println(" data successful updated");  
                                
                    }
                    else            
                        System.out.println("invalid input");
                    break;

                case 32:

                //delete data
                System.out.println("\nPlease enter student's id: ");
                String studentIn = input.nextLine();
                String  delete = ("DELETE from scholarship WHERE id =" + studentIn);
                    
                int deleteData = stmt.executeUpdate(delete);  
                
                if (deleteData> 0)             
                    System.out.println("Student scholarship's data successfully deleted\n");             
                else
                    System.out.println("Error occured\n ");




            }
                    


            
        } catch (Exception e) {
            System.out.println("Error occured");
        }
    }

}
