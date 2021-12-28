<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Payment">

    <form <form class="needs-validation" novalidate method="GET" action="${pageContext.request.contextPath}/PaymentDone">

        <div class="mx-auto text-center overflow-auto " style="width: 1400px; height: 500px;">
             <label for="nrBon">Numarul bonului :</label> <label for="nrBon">${bonId}</label>
            <table id="cos" class="table table-striped table-hover table-condensed">
                <tr class="table-dark">
                    <th scope="col">Nume Produs</th>
                    <th scope="col">Pret</th>
                    <th scope="col">Cantitate</th>
                    <th scope="col">Valoare</th>
                </tr>
                <c:forEach var="produs" items="${produse}" varStatus="status">
                    <tr >
                        <th scope="col">${produs.denumire} </th>
                        <th scope="col">${produs.pret} RON</th>
                        <th scope="col">x1</th>
                        <th scope="col"></th>
                    </tr>
                </c:forEach>
                <tr >
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col">Ati platit :</th>
                    <th scope="col">${valoare} RON</th>
                </tr>

            </table>

        </div>

      
     

    </form>


</t:pageTemplate>
