package com.des.coachingclasses.business;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CoachClassTest {

    private static final String PERSISTENCE_UNIT_NAME = "rseg165Project2PU";
    private static EntityManager entitymanager;

    public static void main(String[] blargs) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        entitymanager = factory.createEntityManager();
        CoachClassTest test = new CoachClassTest();

        test.createParticipants();
        test.getCoachDetails();
        test.getPlayerDetails();
    }

    
 public void createParticipants() {
        if (null != entitymanager) {
            // First user
            Coach coach = new Coach("Coach One");
            Player player = new Player("Player 1", "Tennis");
            Player player1 = new Player("Player 2", "Tennis");
            coach.addToPlayerList(player);
            coach.addToPlayerList(player1);
            // Second user
            Coach coach1 = new Coach("Coach Two");
            Player player2 = new Player("Player 3", "Swimming");
            Player player3 = new Player("Player 4", "Swimming");
            coach1.addToPlayerList(player2);
            coach1.addToPlayerList(player3);
            EntityTransaction transaction = entitymanager.getTransaction();
            transaction.begin();
            entitymanager.persist(coach);
            entitymanager.persist(coach1);
            transaction.commit();
            System.out.println("Done..");

        }
    }
    public void getCoachDetails() {
        if (null != entitymanager) {
            EntityTransaction readTransaction = entitymanager.getTransaction();
            readTransaction.begin();
            Query query = entitymanager
                    .createQuery("select coach FROM Coach coach");
            List list = query.getResultList();
            Iterator iterator = list.iterator();
            System.out.println("Coach Details fetched from database : ");
            while (iterator.hasNext()) {
                Coach coach = (Coach) iterator.next();
                System.out.println(coach);
            }

            readTransaction.commit();
            System.out.println("\n");
        }
    }

    public void getPlayerDetails() {
        if (null != entitymanager) {
            EntityTransaction readTransaction = entitymanager.getTransaction();
            readTransaction.begin();
            Query query = entitymanager
                    .createQuery("select player FROM Player player");
            List list = query.getResultList();
            Iterator iterator = list.iterator();
            System.out.println("Player Details fetched from database : ");
            while (iterator.hasNext()) {
                Player player = (Player) iterator.next();
                System.out.println(player);
            }

            readTransaction.commit();
            
        }
    }
}
