import java.io.*;
import java.sql.*;

public class studentDatabaseControl{

    public void menu(){
        
        System.out.println(""
        + "|**=============================== *** ======================================**|\n"
        + "              |** WELCOME TO THE STUDENT DATABASE MANAGEMENT **|\n"
        + "               |** PLEASE FOLLOW THE FOLLOWING INSTRUCTIONS **|\n\n"
        + " Press 1: TO DELETE STUDENT DATA\n"
        + " Press 2: TO GET INFORMATION FROM THE DATABASE\n"
        + " Press 3: TO UPDATE STUDENT DATA\n"
        + "|**=============================== *** ======================================**|\n");

    }

    public void studentData() throws Exception{

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","xxxx","xxxx");
			Statement stmt = conn.createStatement();
			

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
            int dataChoice = Integer.parseInt(br.readLine());

            switch(dataChoice) {
                case 1 :
                            // deleting from the applcantData table
                            System.out.println("\nPlease enter the studentId of the data you want to delete: ");
                            String Idin = br.readLine();
                            String  deleteStudentData = ("DELETE from applicantData WHERE id =" +Idin);
                                
                            int y = stmt.executeUpdate(deleteStudentData);  
                            
                            if (y> 0)             
                                System.out.println("Student data successfully deleted\n");             
                            else
                                System.out.println("Error occured\n ");
                case 2:

                    // Selecting data from the system
					System.out.println("\nPlease enter the studentId of  data you need from the table: ");
                    String getData = br.readLine();
                    
					String data = ("SELECT * FROM  applicantData WHERE id ="+ getData); 
    
					ResultSet rs = stmt.executeQuery(data); 
			           if(rs.next()) 
			           { 
                           System.out.println("\n"
                           +"\nStudentId          : " + rs.getString("studentId")
                           +"\nFull name          : " + rs.getString("name")
                           +"\nEmail address      : " + rs.getString("email")
                           +"\nDate of birth      : " + rs.getString("DOB")
                           +"\nTotal Points       : " + rs.getString("totalPoints")
                           +"\nRace               : " + rs.getString("race")
                           +"\n Student's Program : " + rs.getString("program")
                           +"\nTotal fees paid    : " + rs.getString("feesPaid")); 
			              
			            }
			            else
                            System.out.println("Please enter a valid student identity number: "); 

                        
                case 3:
                    // Updating database
					System.out.println("\nPlease enter the name of data you need to update: ");
                    String quantity = br.readLine();
                    
                    System.out.println("Please enter the updated information: ");
                    String updated = br.readLine();

                    System.out.println("Please enter the student's id number");
                    String id = br.readLine();

					System.out.println( quantity+ " is being updated to " + updated +" where id is "+ id);
				    
		
		            String dataExecuted = "UPDATE applicantData set  '"+ quantity +" '= '"+ updated +
		                    "' WHERE id = '" +id ; 
		            int z = stmt.executeUpdate( dataExecuted); 
		              
		            if (z > 0)             
		                System.out.println(" data successful updated");             
		            else            
		                System.out.println("invalid input");

                            
        }
            
        } catch (Exception e) {

            System.out.println("Sorry something went wrong");
        }
        
    	
      
		 
		 

    }
}

