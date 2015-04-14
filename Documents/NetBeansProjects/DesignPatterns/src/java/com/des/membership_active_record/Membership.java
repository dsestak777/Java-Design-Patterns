package com.des.membership_active_record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

public class Membership {
	
	private int memberID;
	private String firstName;
	private String lastName;
	private int age;
	private Date expireDate;
	private boolean hasPool;
	private boolean hasGym;
	private boolean hasAllCourts;
	private boolean hasEquipment;
	private boolean has24Hours;
	private boolean hasFamily;
	String memberType = "unknown membership type";
	
	private static Connection con;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static double cost;
	
	
	public Membership() {	}
	
	public Membership(int memberID, String firstName, String lastName, int age, Date expireDate, boolean hasPool, boolean hasGym,
    		boolean hasAllCourts, boolean hasEquipment, boolean has24Hours, boolean hasFamily) {
    
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.expireDate = expireDate;
		this.hasPool = hasPool;
		this.hasGym = hasGym;
		this.hasAllCourts = hasAllCourts;
		this.hasEquipment = hasEquipment;
		this.has24Hours = has24Hours;
		this.hasFamily = hasFamily;
				
	}
	
	 //method to check if a member already exists in the database
    public static boolean doesMemberExist(String firstName, String lastName) {
        
        //set user found to false
        boolean memberFound = false;
        
        //SQL string to check if user name exists
        String doesUserExist = "SELECT * FROM members WHERE firstName = ? AND lastName = ?";
        
        //try to query database for user name
        try {
            
            checkConnect();
            pstmt = con.prepareStatement(doesUserExist);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            rs = pstmt.executeQuery();
                  
            //if name found set to true
            if (rs.next()) { memberFound = true;
                
            System.out.println("Member Found!!");
            
            //if not found set to false    
            } else { memberFound = false; 
            
            System.out.println("Member Not Found!!");
            
            }
            
        } 
        catch (SQLException e ) {
            
            System.out.println("execute query error!");
            System.out.print(e);
            
        }
        
        //return results of query
        return memberFound;
    }
    
    
    //method used to add new member
    public static void addMember(String firstName, String lastName, Integer age, java.sql.Date expireDate, boolean hasPool, boolean hasGym,
    		boolean hasAllCourts, boolean hasEquipment, boolean has24Hours, boolean hasFamily) {
        
        //SQL string to add new user into users database (also checks for duplicates)
        String addUserString = "INSERT INTO members (firstName, lastName, age, expireDate, hasPool, hasGym, " +
        		"hasAllCourts, hasEquipment, has24Hours, hasFamily) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        //try to add new user to database
        try {
            
            checkConnect();
            pstmt = con.prepareStatement(addUserString);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, age);
            pstmt.setDate(4, expireDate);
            pstmt.setBoolean(5, hasPool);
            pstmt.setBoolean(6, hasGym);
            pstmt.setBoolean(7, hasAllCourts);
            pstmt.setBoolean(8, hasEquipment);
            pstmt.setBoolean(9, has24Hours);
            pstmt.setBoolean(10, hasFamily);
            pstmt.executeUpdate();
            
            System.out.println("New Member added!");
            
        } catch (SQLException e) {
            
            System.out.println("execute update error!");
            System.out.print(e);
        }
        
        
    } 
    
  //method used to edit a Member the database
    public static void editMember (String firstName, String lastName, int age, java.sql.Date expireDate, boolean hasPool, boolean hasGym,
    		boolean hasAllCourts, boolean hasEquipment, boolean has24Hours, boolean hasFamily, int id) {
    	
            try { 
            
                //SQL string to add new post to postindex
                String memberEdit = "UPDATE members SET firstName=?, lastName=?, age=?, expireDate=?, hasPool=?," +
                		"hasGym=?, hasAllCourts=?, hasEquipment=?, has24Hours=?, hasFamily=? WHERE memberID=?";
        
                checkConnect();
                pstmt = con.prepareStatement(memberEdit);
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setInt(3, age);
                pstmt.setDate(4, expireDate);
                pstmt.setBoolean(5, hasPool);
                pstmt.setBoolean(6, hasGym);
                pstmt.setBoolean(7, hasAllCourts);
                pstmt.setBoolean(8, hasEquipment);
                pstmt.setBoolean(9, has24Hours);
                pstmt.setBoolean(10, hasFamily);
                pstmt.setInt(11, id);
               
                pstmt.executeUpdate();
                
                System.out.println("Member Edit Success!");
                
            }
            catch (SQLException e ) {
                
                System.out.println("execute update error!");
                System.out.print(e);
                
            }
    }
    
    
    //method used to delete a message post 
    public static void deleteMember (String firstName, String lastName ) {
    
        //SQL string to delete topic from postindex
        String deleteIndex = "DELETE FROM members WHERE firstName = ? AND lastName = ?";
        
        //try to delete the member from database
        try {
          
            checkConnect();
            pstmt = con.prepareStatement(deleteIndex);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.executeUpdate();
            
        }
        catch (SQLException e ) {
                
                System.out.println("execute delete index update error!");
                System.out.print(e);
         }  
    }	
    
   
	// method to view all members
	public static ArrayList<Membership> viewAllMembers() {

		// initialize arraylist to hold topics
		ArrayList<Membership> members = new ArrayList<>();

		// SQL string to get all members from members table
		String viewUser = "SELECT * FROM members";

		// try to query databased
		try {

			checkConnect();
			pstmt = con.prepareStatement(viewUser);
		//	pstmt.setString(1, user);
			rs = pstmt.executeQuery();

			// while we have results get data from each line
			while (rs.next()) {

				int memberID = rs.getInt("memberID");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				int age = rs.getInt("age");
				Date expireDate = rs.getDate("expireDate");
				boolean hasPool = rs.getBoolean("hasPool");
				boolean hasGym = rs.getBoolean("hasGym");
				boolean hasAllCourts = rs.getBoolean("hasAllCourts");
				boolean hasEquipment = rs.getBoolean("hasEquipment");
				boolean has24Hours = rs.getBoolean("has24Hours");
				boolean hasFamily = rs.getBoolean("hasFamily");
				

				// Date date = rs.getObject("postDate",
				// Date.valueOf(LocalDate.MIN));

				// create a member object
				Membership member = new Membership(memberID, firstName, lastName, age, expireDate, hasPool, hasGym,
			    		hasAllCourts, hasEquipment, has24Hours, hasFamily); 
				    
				// add new object to arraylist
				members.add(member);

			}

		} catch (SQLException e) {

			System.out.println("execute view by user query error!");
			System.out.print(e);

		}
		// return arraylist of members
		return members;
	}

	
	// method to view all members
	public static Membership viewMember(String first, String last) {
			Membership member = new Membership();
		
			// SQL string to get a member from members table
			String viewUser = "SELECT * FROM members WHERE firstName = ? AND lastName = ?";

			// try to query database
			try {

				checkConnect();
				pstmt = con.prepareStatement(viewUser);
				pstmt.setString(1, first);
				pstmt.setString(2, last);
				rs = pstmt.executeQuery();

				// while we have results get data from each line
				if (rs.next()) {
				
					int memberID = rs.getInt("memberID");
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					int age = rs.getInt("age");
					Date expireDate = rs.getDate("expireDate");
					boolean hasPool = rs.getBoolean("hasPool");
					boolean hasGym = rs.getBoolean("hasGym");
					boolean hasAllCourts = rs.getBoolean("hasAllCourts");
					boolean hasEquipment = rs.getBoolean("hasEquipment");
					boolean has24Hours = rs.getBoolean("has24Hours");
					boolean hasFamily = rs.getBoolean("hasFamily");
					
					// create a member object
					member = new Membership(memberID, firstName, lastName, age, expireDate, hasPool, hasGym,
				    		hasAllCourts, hasEquipment, has24Hours, hasFamily); 
                                } else {
                                    
                                    System.out.println("User not found!");
                                    
                                }
                                
				
			} catch (SQLException e) {

				System.out.println("execute view by user query error!");
				System.out.print(e);

			}
			// return 
			return member;
		}

	
	// method used to get SQL format date
	public static java.sql.Date getCurrentJavaSqlDate() {
		java.util.Date today = new java.util.Date();

		return new java.sql.Date(today.getTime());
	}

        //check if connection to database exists
    public static void checkConnect() {
        
		// if connection does not exist create one
                if (con==null) {
                    
			con=createConnection();
		}
                //if statement does not exist create one 
		if(stmt==null) {
			try {
				stmt = con.createStatement();
			} catch (SQLException e){
				System.out.println("SQL Error: Cannot create the statement.");
			}					
		}
	}
    
    //close connection to database
    public static void closeConnection() {
		if( con != null ) {
			try { 
				con.close();
				stmt.close();
			} catch( SQLException e ) {
				e.printStackTrace();
				System.out.println("SQL Exception occurred when closing the connection.");
			}
		}
	}
    
    public static Connection createConnection() {
        
        //user name and password
        String user = "itp246";
        String pass = "itp246";
        
        
		try {	
		//	System.out.println("What is the username for the database?");
		//	String user = scan.nextLine();
		//	System.out.println("What is the password?");
		//	String pass = scan.nextLine();
			con=  JDBCConnection.connect(JDBCConnection.MYSQLLOCAL,user,pass);
		} catch (IllegalStateException e) {
        	// Scanner is closed. Open a new one.
        //	scan = new Scanner(System.in);
        } catch (NoSuchElementException e) {
        	// If the person enters CTRL-Z this exception occurs.
        //	WorldSeriesDriver.writeRecoveryFilesAndShutDown();
		}
		return con;
	}

     

	public String toString() {return firstName + " " + lastName + " " + age + " "+ expireDate + " ";}
	
	public static double membershipCost(Membership member) {
		
		cost = 100.00;
		
		if (member.hasPool) {cost = cost +10.00;} 
		if (member.hasGym) {cost = cost + 20.00;} 
		if (member.hasAllCourts)  {cost = cost + 25.00;} 
		if (member.hasEquipment) {cost = cost + 15.00;} 
		if (member.has24Hours) {cost = cost + 30.00;} 
		if (member.hasFamily) {cost = cost + 40.00;} 
	
		return cost;		
	}
	
	public String getFirstName() {return firstName;}
	//public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public String getLastName() {return lastName;}
	//public void setLastName(String lastName) {this.lastName = lastName;}
	
	public int getAge() {return age;}
	//public void setAge(int age) {this.age = age;}
	
	public Date getExpireDate() {return expireDate;}
	//public void setExpireDate(Date expireDate) {this.expireDate = expireDate;	}
	
	public boolean isHasPool() {return hasPool;}
	//public void setHasPool(boolean hasPool) {this.hasPool = hasPool;}

	public boolean isHasGym() {return hasGym;}
	//public void setHasGym(boolean hasGym) {this.hasGym = hasGym;}

	public boolean isHasAllCourts() {return hasAllCourts;}
	//public void setHasAllCourts(boolean hasAllCourts) {this.hasAllCourts = hasAllCourts;}

	public boolean isHasEquipment() {return hasEquipment;}
	//public void setHasEquipment(boolean hasEquipment) {this.hasEquipment = hasEquipment;}

	public boolean isHas24Hours() {return has24Hours;}
	//public void setHas24Hours(boolean has24Hours) {this.has24Hours = has24Hours;}

	public boolean isHasFamily() {return hasFamily;}
	//public void setHasFamily(boolean hasFamily) {this.hasFamily = hasFamily;}
	
	
}
