package reservation.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    
    //create singleton instance of emf 
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("rseg165Project2PU");
    
    //return entity manager factory object singleton
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}