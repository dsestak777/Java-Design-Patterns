package reservation.controllers;

import reservation.business.Reservation;
import reservation.data.ReservationDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReservationController extends HttpServlet {

    @Override
    //process get requests
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        //get request parameter for action 
        String action = request.getParameter("action");
        String url = "";
        
        //select web page url based upon action parameter
        switch (action) {
            case "reservation":
                url = "/reservation.jsp";
                break;
            case "manage":
                url = manage(request, response);
                break;
        }

        //request new web page url
        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    //process post requests
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
         //get request parameter for action 
        String action = request.getParameter("action");
        String url = "";
        
         //select web page url based upon action parameter
        switch (action) {
            case "doCheckout":
                url = doCheckout(request, response);
                break;
            case "doCheckin":
                url = doCheckin(request, response);
                break;
        }
        
        //request new web page url
        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    
    private String manage(HttpServletRequest request,
            HttpServletResponse response) {
        
        //create list to hold reservations
        List reservationList = ReservationDB.viewReservation();
        
        
        //make list a session attribute
        HttpSession session = request.getSession();
        session.setAttribute("checkedOutList", reservationList);
        
        return "/checkedOutList.jsp";
    }

    //method to create a reservation 
    private String doCheckout(HttpServletRequest request,
            HttpServletResponse response) {
        
        int test = Integer.parseInt(request.getParameter("numberOfPlayers"));
        
        //create checkout object and set pararmeters based upon request
        Reservation reservation = new Reservation();
        reservation.setFirstName(request.getParameter("firstName"));
        reservation.setLastName(request.getParameter("lastName"));
        reservation.setLocation(request.getParameter("location"));
        reservation.setNumOfPlayers(test);

        //add reservation to database  
        ReservationDB.makeReservation(reservation);
        
        //include reservation object as parameter
        request.setAttribute("reservation", reservation);
        
        //return new web url
        return "/thankyou.jsp";
    }

    //method to delete reservations
    private String doCheckin(HttpServletRequest request,
            HttpServletResponse response) {
        
        //get checkout number from request parameter
        long checkoutNumber =
                Long.parseLong(request.getParameter("checkoutNumber"));
        
        //delete reservation in database
    //    ReservationDb.deleterReservation(checkoutNumber);
        
        return manage(request, response);
    }
}
