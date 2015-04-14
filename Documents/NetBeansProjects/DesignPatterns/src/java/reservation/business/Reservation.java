package reservation.business;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationNumber;
    private String firstName;
    private String lastName;
    private String location;
    private int numOfPlayers;
    
    @Temporal(TemporalType.DATE)
    private Date reservationDate;
    
    public Reservation() {
         
    reservationDate = new Date();
    
    // The following code sets a default due date 14 days in the future.
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(reservationDate);
        calendar.add(Calendar.DATE, 14);
        reservationDate.setTime(calendar.getTime().getTime());
    }
    
    public String toString() {return "name = " + firstName + " "+ lastName + " Location " + location + "Date: " + reservationDate;}

    public long getReservationNumber() {return reservationNumber;}
    public void setReservationNumber(long reservationNumber) {this.reservationNumber = reservationNumber;}
    
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public int getNumOfPlayers() {return numOfPlayers;}
    public void setNumOfPlayers(int numOfPlayers) {this.numOfPlayers = numOfPlayers;}

    public Date getReservationDate() {return reservationDate;}
    public void setReservationDate(Date reservationDate) {this.reservationDate = reservationDate;}
    
    public String getFormattedDate() {
        return new SimpleDateFormat("MM-dd-yyyy").format(reservationDate);
    }
}
