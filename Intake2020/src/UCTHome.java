import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.Date;

public class UCTHome {

	public static void main(String[] args) {
		try {
			
			//student database connection
			Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/registration","xxxx","xxxx" );
			Statement stmt = conn.createStatement();
					
			Scanner input = new Scanner(System.in);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			boolean loop = true;
			while(loop){
				System.out.println("\n\n\n"
					   + "|**========================= *** =============================**|\n\n"
			           + "             WELCOME TO THE GREAT UNIVERSITY \n"
			           + "               ADMINISTRATION DEPARTMENT\n"
			           + "                 FEBRUARY 2021 INTAKE \n"
			           + "      |** WE WISH ALL THE BEST IN YOUR APPLICATION **|\n"
					   + "   |** WE ARE SO LOOKING FORWARD TO WELCOME YOU ON CAMPUS! **|\n"  
			           + "|**========================= *** =============================**|\n\n");
			
			
				System.out.println("Please enter a number which matches the options below:\n\n"
					+ "   1:  Stage 1 of application if  you are an applicant applying to our Unvivesity.\n"
					+ "   2:  Stage 2 of application if you are an applicant proceeding to subject selection.\n"
					+ "   3:  Stage 3 of application if you would love to pay your fees.\n"
					+ "   4:  Stage 4 of application if you woul love to apply for scholarship.\n"
					+ "   0:  If you would love to exit.\n "
					+ " 12:   For an Administator \n");
			
			System.out.println("Please enter a number which indicates the area of your choice below: ");
			int numberChoice;
			
			numberChoice = input.nextInt();
			
				switch(numberChoice){
					case 1:
					
						System.out.println("\n"
								+ "                      |** DEAR APPLICANT **|\n"
								+ "           |** WELCOME TO STAGE 1 OF YOUR APPLICATION **|\n"
								+ "     |** PLEASE NOTE AT THIS STAGE ONLY YOUR RESULTS ARE EVALUATED **|\n"
								+ "       |** IF YOUR GRADES MEETS THE MINIMUM PROGRAMS REQUIREMENTS **|\n\n"
								+ "  |**============================ *** ==================================**|\n");
						
						System.out.println("\n"
								+"* PLEASE TAKE NOTE OF THE FOLLOWING NOTICE *\n\n"
								+"\nYour grades are evaluated as follows\n"
								+ "Grade 'A': is equivalent to 5 points.\n"
								+ "Grade 'B': is equivalent to 4 points.\n"
								+ "Grade 'C': is equivalent to 3 points.\n"
								+ "Grade 'D': is equivalent to 2 points.\n"
								+ "Grade 'E': is equivalent to 1 points.\n");
						
						//user input
						System.out.println("\nPlease enter the number of your matric subjects: ");
						int numberOfSubjects;			
						numberOfSubjects = input.nextInt();		
						
						int i;
						int totalPoints = 0;	
						int grade;
											
						System.out.println("\n"
				            +"Please note if you enter an invaid input it will not be recorded ***\n"
							+"Please enter your grade 3 TIMES; eg if your grade is 'A' and points = '5',\n"
				            +"Please enter as follows (enter your grade and press enter to go to the next line):\n"
							+ "5\n"
							+ "5\n"
							+ "5\n");
							for(i = 0; i < numberOfSubjects; i++){
								System.out.println("Please enter your number "+(i+1)+ " grade : ");
												
								if(input.nextInt() <6 && input.nextInt() >= 0){
												   
									grade = input.nextInt();
									totalPoints += grade;
													
								}
								else
									System.out.println("Sorry, You entered an invalid input and grade not recorded");
												
							}			 
							
							System.out.println("Your total  points is "+totalPoints + " ");
									
								//returns if student meets the minimum requirement
							if (totalPoints >= 40 ) {
								System.out.println(""
										+ "|**======================= SPECIAL NOTICE ===========================**|\n\n"
										+ "            You qualify to study any of our Programs!\n"
										+ "         You may proceed to stage two of your application!\n\n"
										+ "|**=======================       ***      ===========================**|\n");
									break;
							}
							if (totalPoints >= 30) {
								System.out.println("" 
								+ "|**======================= SPECIAL NOTICE ===========================**|\n\n"
				                + "          You qualify to study our Commmercial and Arts program!\n"
				                + "             You may proceed to stage two of your application!\n\n"
				                + "|**=======================       ***      ===========================**|\n");
								break;
							}
							if (totalPoints >= 25) {
									
								System.out.println(""
										+ "|**======================= SPECIAL NOTICE ===========================**|\n"
										+ "                 You qualify to study any of our Arts Program  \n"
										+ "                You may proceed to stage two of your application!\n\n"
										+ "|**=======================       ***      ===========================**|\n");
								break;
									}
								
								else {  
									System.out.println(""
										+ "|**========================= SPECIAL NOTICE =============================**|\n"
										+ "  Sorry, your grade do not meet the mimimun requirements to study with us\n"
										+ "|**=========================       ***      =============================**|\n");
									break;
									}
						
						

					case 2:

						System.out.println("\n"
								+ "          _|** WELL DONE ON MAKING IT TO STAGE 2! **|_\n" 
								+ "       |** PLEASE TAKE NOTE OF THE FOLLOWING NOTICE **| \n"
									+ "    |** AS YOU PROCEED TO STAGE TWO OF YOUR APPLICATION **|\n"
								+ " |**FOR YOUR PROGRAM SELECTION PRESS THE NUMBER INDICATED ON THE LEFT MARGIN  **|\n\n"
									+ " 1. For programs in medical Sciences and Engineering\n" 
									+ " 2. For programs in Accounting and Finance\n" 
									+ " 3. For programs in Law and Political Science. \n"
									+ "|**================================= *** ========================================**|\n");
						
						//initializing variables
						    Random random = new Random();
							String idcode = "TGU2025";
							Date dateOfBirth = null;
							String ApplicantName;
							String StudentID;
							String applicantEmail;
							String race;
							String program = "";
							int points;
							int applicantChoice;
							
							StudentID = (idcode +random.nextInt(100000));
						
							//user input details
							System.out.println("Please enter your full name: ");
							ApplicantName = br.readLine().toUpperCase(); 
							
							System.out.print("Please enter your email address: ");
							applicantEmail = br.readLine();
									
							System.out.println("Enter date of birth  (DD/MM/YYYY):");
							dateOfBirth = new SimpleDateFormat("ddMMyyyy").parse(br.readLine().replaceAll("/", ""));
							
							System.out.println("Please enter your race: ");
							race = br.readLine();
						
							System.out.println("Please enter your points calculated in stage 1: ");
							points = Integer.parseInt(br.readLine());
							
							System.out.println("Please enter the number of your program of choice as indicated above: ");
							applicantChoice = Integer.parseInt(br.readLine());
							
							boolean database;
						 
						if (applicantChoice == 1 && points >= 40) {
						
							System.out.println(""
									+"|**============================== *** ==================================**|\n"
									+"      Congratulations you are successful admitted into our Science Depart!\n"
									+"               You may procceed to third and  your Final Stage!\n"
									+"                   *** PLEASE NOTE THE FOLLOWING ***\n"
									+"               YOUR NEW STUDENT ID "+ ApplicantName+" is " +StudentID+"\n"
								    +"|**============================== *** ==================================**|\n");
							database = true;
							program = "Sciences";
						 
						}else if (points < 40 && applicantChoice == 1) {
						
							System.out.println("\n"
									+"|**=============================== *** ==================================**|\n\n"
									+"      Sorry " + ApplicantName+ ", you do not qualify for this program. \n\n"
									+"|**=============================== *** ==================================**|");
							database = false;
							
						}
						
						if (applicantChoice == 2 && points >= 30) {
						
							System.out.println(""
									+"|**================================= *** =====================================**|\n"
									+"     Congratulations you are successful admitted into our Commercial Depart!\n"
									+"                 You may procceed to third and  your Final Stage!\n"
									+"                   *** PLEASE NOTE THE FOLLOWING ***\n"
									+"                  YOUR NEW STUDENT ID "+ ApplicantName+" is " +StudentID+"\n"
								    +"|**================================= *** =====================================**|\n");
							database = true;
							program = "Commercials";
						 
						
						}else if (points <30  && applicantChoice == 2) {
						
							System.out.println("\n"
									+"|**=============================== *** ==================================**|\n\n"
									+"   Sorry " + ApplicantName+ ", you do not qualify for this program. \n\n"
									+"|**=============================== *** ==================================**|");
							database = false;
							
						}
						if (applicantChoice == 3 && points >= 25) {
						
							System.out.println(""
									+"|**=============================== *** ==================================**|\n"
									+"      Congratulations you are successful admitted into our Arts Depart!\n"
									+"               You may procceed to third and  your Final Stage!\n"
									+"                   *** PLEASE NOTE THE FOLLOWING ***\n"
									+"                  YOUR NEW STUDENT ID "+ ApplicantName+" is " +StudentID+"\n"
								    +"|**=============================== *** ==================================**|\n");
							database = true;
							program = "Arts";
						 	
						}
						
						else if (points < 25 &&  applicantChoice == 3 ) {
						
							System.out.println("\n"
									+"|**=============================== *** ==================================**|\n\n"
									+"       Sorry " + ApplicantName+ ", you do not qualify for this program. \n\n"
									+"|**=============================== *** ==================================**|");
							database = false;
						}
						
						else if (applicantChoice >= 3 || points <0) {
							System.out.println("\n"
									+"|**=============================== *** ==================================**|\n\n"
									+"    Sorry " + ApplicantName+ ", you have entered invalid details. \n\n"
									+"|**=============================== *** ==================================**|");
							
						
						}

						if (database = true) {
							String toDataBase ="insert into studentData values('" +StudentID+ "','"+ApplicantName+ "','"+applicantEmail+ "','"+ dateOfBirth +"','" +points+ "','"+ race+ "','" + program  +  "','" + 0  +"')";
							
						
						int x = stmt.executeUpdate(toDataBase);
						
						if (x > 0) {
							System.out.println("Applicant's details successfully added to database\n"); 
						}
						else            
							System.out.println("Insert Failed\n"); 
						}
						
						break;

						
					case 3:
						
						//student menu
						System.out.println("\n"
								   + "           |** WELL DONE ON MAKING IT TO STAGE 3! **|\n" 
								   + "         |** PLEASE TAKE NOTE OF THE FOLLOWING NOTICE **| \n"
								   + "    |** AS YOU ARE IN YOUR FINAL STAGE OF YOUR APPLICATION **|\n"
								   + "|** YOU CAN ONLY BE REGISTERED AFTER PAYING AT LEAST 50% OF YOUR TUITION **|\n"
								   + "     |** YOU MAY CHECK ALSO OUR SCHOLARSHIPS IF YOU ARE INTERESTED **|\n" 
								   + "|**=============================== *** ======================================**|\n");
								
						StudentFeePayment finalStage = new StudentFeePayment();
									
						//calling the public method
						finalStage.StudentAdmission();
								
						
						break;

					case 4:
						
						//student menu
						System.out.println("\n"
								   + "                  |** WELCOME TO THE GREAT UNIVERSITY  **|\n" 
								   + "         |** PLEASE NOTE THE SCHOLARSHIP OFFERED HERE ARE AS FOLLOWS: **|\n \n"
								   + " 1. THE GREAT CITY SCHOLARSHIP \n"
								   + " 2. NAFOAPP \n"
								   + " 3. MERIT SCHOLARSHIP \n"
								   + "|**=============================== *** ======================================**|\n");
									
						//calling the public method
						 Scholarship apply = new Scholarship();
						apply.scholarshipApplication();

						break;
					
					case 12:
					   //password to access database management
						final String AccessCode = "TheGreatUniversity";
						int attempts = 3;
						
					    String password = "";
					    while (attempts-- > 0 && !AccessCode.equals(password)) //compares and then decrements
					    {
					        System.out.print("Enter your password to Access Admin: ");
					        password = br.readLine();
					        if (password.equals(AccessCode)) {
								
								//to access database
								System.out.println("\n"
								+ "|**=============================== *** ======================================**|\n"
								+ "                  |** WELCOME TO THE GREAT UNIVERSITY  **|\n"
								+ "                      |** STUDENT DATA MANAGEMENT **|\n"
								+ "                    |*** PLEASE NOTE THE FOLLOWING ***|\n\n"
								+ "     Please enter ' toStudentData ' :  if you wish to manage the student data\n"
								+ "     Please enter '  toAdminData '  :  if you wish to manage the admin data \n"
								+"      Please enter ' toScholarship ' :  if you wish to manage scholarship data"
								+ "|**=============================== *** ======================================**|\n");
								
								String dataBaseChoice =  br.readLine();

								switch(dataBaseChoice){

									//to manage admin
									case  "toAdminData" :
										
										AdminIn lecture = new AdminIn();
										lecture.menu();
										lecture.studentManagement();
										break;

									//to manage student data
									case  "toStudentData" :
								
										studentDatabaseControl applicant = new studentDatabaseControl();
										applicant.menu();
										applicant.studentData();
										break;

									//to manage student scholarship data
									case "toScholarship" :

										Scholarship data = new Scholarship();
										data.menu();
										data.ScholarshipManagement();
								}
						            
					        }

					        else 
					            System.out.println("Incorrect password, " + attempts + " attempts remaining");        
					    }
						
						break;

					case 0:
						
						//exit program
						System.out.println("Exiting, Thank you!");
						
						break;

					default:
						System.out.println("Sorry; you have entered an invalid input, Please read the menu below carefully");
						break;

				}
				if (numberChoice == 0) {
					loop = false;
					
				}

			}
		} catch (Exception e) {
			System.out.println("\n"
			+"|**================================== *** =========================================**|\n"
			+" |** Sorry; The program stopped running, You may try again if you wish to Proceed **| "
			+"     |** And if the problem persist, please contact your engineer or Admin **| \n"
			+"|**================================== *** =========================================**|\n");
		}
		
		

	}

}
