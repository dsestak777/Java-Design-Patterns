/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.business;

import reservation.data.ReservationDB;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author dsestak
 */
 
        
public class ReservationTest {
    static ReservationDB db;
    //create list to hold reservation
    static List<Reservation> reservations = new ArrayList<>(); 
   
    public static void main (String[] blargs) {
   
    Reservation reservation1 = new Reservation();
    reservation1.setFirstName("Jim");
    reservation1.setLastName("Smith");
    reservation1.setLocation("Tennis Court");
    //reservation1.setReservationDate(null);
    reservation1.setNumOfPlayers(1);
    
    db.makeReservation(reservation1);
    
    Reservation reservation2 = new Reservation();
    reservation2.setFirstName("Sarah");
    reservation2.setLastName("Jane");
    reservation2.setLocation("Basketball Court");
   // reservation2.setReservationDate(null);
    reservation2.setNumOfPlayers(1);
    
    db.makeReservation(reservation2);
    
    reservations = db.viewReservation();
    for (Reservation reservation: reservations) {
        
        System.out.println(reservation.toString());
        }
    }
}
