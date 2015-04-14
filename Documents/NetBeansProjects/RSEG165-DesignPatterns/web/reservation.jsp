<%@include file="includes/header.jsp" %>
<section>
    <h1>Make a Reservation</h1>
    <form action="reservation" method="post">
        <input type="hidden" name="action" value="doCheckout"/>
        <label>First Name:</label>
        <input type="text" name="firstName"
               value="${reservation.firstName}" required/><br>
        <label>Last Name:</label>
        <input type="text" name="lastName"
               value="${reservation.lastName}" required/><br>
        <label>Location:</label>
        <input type="text" name="location"
               value="${reservation.location}" required/><br>
        <label>Number of Players:</label>
        <input type="text" name="numberOfPlayers" class="title"
               value="${reservation.numOfPlayers}" required/><br>
        <label>&nbsp;</label>
        <input type="submit" value="Make Reservation"/><br>
    </form>
</section>
</body>
</html>
