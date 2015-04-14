/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.des.membership_active_record;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author dsestak
 */
public class DBUtilities {

	// list and initialize variables and arrays
	private static Connection con;
	private static Statement stmt;
	private static Scanner scan = new Scanner(System.in);
	private static String createDBString;
	private static String createMembersString;
	private static String dropTableMembers;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static CallableStatement ca;

	
      
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
        	scan = new Scanner(System.in);
        } catch (NoSuchElementException e) {
        	// If the person enters CTRL-Z this exception occurs.
        //	WorldSeriesDriver.writeRecoveryFilesAndShutDown();
		}
		return con;
	}

     
    //create database method
     public static void createDatabase() {
         
         con = null;
         stmt = null;
         
         createDBString = "CREATE DATABASE IF NOT EXISTS nesa";
         
         try { 
             
             checkConnect();
             stmt.executeUpdate(createDBString);
         }
         
         catch (SQLException e) {
                        
            //catch exception 
            System.out.println("The game table does not exist!");
        }
        
  
     }
     
     //create tables for database
     public static void createTables () {
        
        con = null;
        stmt = null;
       
        //SQL string to create users table
        createMembersString = "CREATE TABLE IF NOT EXISTS members "
                + "(memberID int(11) NOT NULL AUTO_INCREMENT,"
                + "firstName varchar(30) NOT NULL,"
                + "lastName varchar(30) NOT NULL,"
                + "age int(11) NOT NULL,"
                + "expireDate DATE NOT NULL," 
                + "hasPool boolean DEFAULT FALSE,"
                + "hasGym boolean DEFAULT FALSE,"
                + "hasAllCourts boolean DEFAULT FALSE,"
                + "hasEquipment boolean DEFAULT FALSE,"
                + "has24Hours boolean DEFAULT FALSE,"
                + "hasFamily boolean DEFAULT FALSE,"
                + "PRIMARY KEY (memberID))"
                + "ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1";
        
        //try creating tables
        try {
            
            checkConnect();
            // create the members table
            
            stmt.executeUpdate(createMembersString);
            System.out.println("Tables created!");
            
        }
        catch (SQLException e) {
            
            System.out.println("execute update error!");
            System.out.print(e);
            
        }
 
    }
    
    public static void deleteTables() { 
        
     con=null;
     stmt=null;
     
     dropTableMembers = "DROP TABLE IF EXISTS members"; 
     
        try {
         
         checkConnect();
         
         stmt.executeUpdate(dropTableMembers);
         System.out.println("tables deleted!");
         
        }
        catch (SQLException e) {
            
            System.out.println("table deletion error!");
            System.out.print(e);
            
        }
     
        
    }
     
	// method used to get SQL format date
	public static java.sql.Date getCurrentJavaSqlDate() {

		java.util.Date today = new java.util.Date();

		return new java.sql.Date(today.getTime());
	}

	
}
