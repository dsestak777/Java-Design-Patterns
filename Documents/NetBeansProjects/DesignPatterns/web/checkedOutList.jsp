<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="includes/header.jsp" %>
<jsp:useBean id="now" class='java.util.Date'/>
<section class="checkedOut">
    <h1>Current Reservations</h1>
    <table>
        <tr>
            <th>Name </th>
            <th>Location </th>
            <th>Number of Players </th>
            <th>Reservation Date</th>
            <th></th>
        </tr>
        <c:forEach var="reservation" items="${sessionScope.checkedOutList}">
            <tr>
                <td>${reservation.firstName} ${reservation.lastName}</td>
                <td>${reservation.location}</td>
                <td>${reservation.numOfPlayers}</td>
                <td>${reservation.formattedDate}</td>
               
                <td>&nbsp;</td>
                <td>
                    <form action="goldenoaks" method="post">
                        <input type="hidden" name="action" value="doCheckin"/>
                        <input type="hidden" name="checkoutNumber"
                               value="${checkout.checkoutNumber}"/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="index.jsp">Return to front page</a></p>
</section>
</body>
</html>
