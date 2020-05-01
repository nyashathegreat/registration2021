import java.io.*;
import java.sql.*;


public class AdminIn {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void menu() {
		System.out.println("\n"
				   + "|**========================= *** =============================**|\n\n"
		           + "         |** WELCOME TO THE STUDENT DATA MANAGEMENT **|\n"
				   + "        |** PLEASE FOLLOW THE FOLLOWING INSTRUCTIONS **|\n\n"
				   + " Press 1: TO INSERT DATA\n"
				   + " Press 2: TO UPDATE DATA\n"
				   + " Press 3: TO DELETE DATA\n"
		           + "|**========================= *** =============================**|\n");
	}


	public void studentManagement() throws Exception {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","xxxx","xxxx");
			Statement stmt = conn.createStatement();

			System.out.println(" Please enter the value of your option below : ");
			int dataOption = Integer.parseInt(br.readLine());

			if (dataOption == 1){
				
				//insert data
				System.out.println(" Please Enter your adminCode: ");
				String adminCode = br.readLine().toUpperCase();

				System.out.println(" Please enter the student's full name: ");
				String studentName = br.readLine();

				System.out.println("Please enter the name of the lecturer: ");
				String  lecturer = br.readLine();

				System.out.println("Please enter the year of data entered : ");
				int year = Integer.parseInt(br.readLine());

				System.out.println("Please indicate the semester: ");
				int semester = Integer.parseInt(br.readLine());

				System.out.println(" Please enter the amount paid by the student: ");
				int fee = Integer.parseInt(br.readLine());

				System.out.println("Please enter the amount the student owes : ");
				int feeOwing = Integer.parseInt(br.readLine()); 

				System.out.println("Please indicate the student's scholarship status: ");
				String scholarship = br.readLine();


				String toAdminIn ="insert into adminData values('"+adminCode+ "','"+ studentName+"','"+ lecturer + "','"+ year+"','" + semester    + "','"+ fee+ "','"+ feeOwing+ "','"+ scholarship + "')";
				
				int x = stmt.executeUpdate(toAdminIn);
						
				if (x > 0) {
					System.out.println("details successfully added to database\n"); 
				}
				else            
					System.out.println("Insert Failed\n"); 
			
			}
			else if(dataOption == 2) {
				
				//update data
				System.out.println("\nPlease enter the name of data you need to update: ");
                String update = br.readLine();
                    
                System.out.println("Please enter the updated information: ");
                String updated = br.readLine();

                System.out.println("Please enter the student's id number");
                String adminCode = br.readLine();

				System.out.println( update+ " is being updated to " + updated +" where id is "+ adminCode);
				    
		        String updatedadminIn = "UPDATE adminData set  '"+ update +" '= '"+ updated +
		                    "' WHERE id = '" +adminCode ; 
		        int z = stmt.executeUpdate( updatedadminIn); 
		              
		    	if (z > 0)             
		            System.out.println(" data successful updated");             
		        else            
		            System.out.println("invalid input");

			}
			else if (dataOption == 3 ){

				 // deleting data
				 System.out.println("\nPlease enter your admin code: ");
				 String adminCodeIn = br.readLine();
				 String  deleteAdminData = ("DELETE from adminData WHERE id =" +adminCodeIn);
					 
				 int deleteData = stmt.executeUpdate(deleteAdminData);  
				 
				 if (deleteData> 0)             
					 System.out.println("Admin data successfully deleted\n");             
				 else
					 System.out.println("Error occured\n ");


			}

				            	
		} catch (Exception e) {
			System.out.println("Error occured");
		}
    }
	
}