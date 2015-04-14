
package reservation.data;

import reservation.business.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class ReservationDB {
    
    public static void makeReservation(Reservation reservation) {
        //code to check out a book.
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        //try database transaction
        try{
            trans.begin();
            em.persist(reservation);
            trans.commit();
            
            System.out.println("Reservation Successfully Made!!");
        }
        
        //rollback if there is a problem
        catch(Exception e ) {
            
            System.out.println("There was an Error in Making the Reservation!!");
            trans.rollback();
        }
        //close connection
        finally {
            
            em.close();
        }
        
    }
    
    public static List<Reservation> viewReservation() {
        //code to view all reservation.
        
        //create list to hold reservation
        List<Reservation> reservations = new ArrayList<>(); 
        
        //create entity manager instance
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        //database query string
        String qString = "SELECT c FROM Reservation c";
        
        //create a typed query
        TypedQuery<Reservation> q = em.createQuery(qString, Reservation.class);
        
        //create Rervation object
        Reservation reservation = null;
        
         //try database transaction
        try {
             
            reservations = q.getResultList();
            
            
        //rollback if there is a problem    
        }
        catch (Exception e) {
            
            System.out.print(e);
        }
        
         //close connection
        finally {
            em.close();
        
        }
            
        //return checkouts list
        return reservations;
    }
 
    public static void deleteReservation(long reservationNumber) {
        //code to delete a reservation.
        
        //create entity manager instance
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        //create query string 
        String qString = "DELETE FROM Reservation c WHERE c.reservationNumber = :reservationnumber";
        
        //create typed query
        TypedQuery<Reservation> q = em.createQuery(qString, Reservation.class);
        q.setParameter("reservationnumber", reservationNumber);
        
        //try database transaction
        try{
            trans.begin();
            q.executeUpdate();
            trans.commit();
            
            System.out.println("Reservation Deleted!!");
        }
         //rollback if there is a problem    
        catch(Exception e ) {
            
            trans.rollback();
        }
        
         //close connection
        finally {
            
            em.close();
        }
        
    }
}
