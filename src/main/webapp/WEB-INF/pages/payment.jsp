<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Payment">

    <form <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Payment">

        <div class="mx-auto text-center" style="width: 350px;">
            <label for="cod_produs">Introduceti codul produsului :</label>
            <input type="text" class="form-control" id="codProdus" name="cod_produs" placeholder="" value="" required="">
            <div class="invalid-feedback">
                Introduceti codul corect
            </div>
            <button class="btn btn-secondary btn-sm" type="submit" >Adauga</button>
        </div>
        <br>
        <div class="mx-auto text-center overflow-auto " style="width: 1400px; height: 500px;">
            <table id="cos" class="table table-striped table-hover table-condensed">
                <tr class="table-dark">
                    <th scope="col">Nume Produs</th>
                    <th scope="col">Pret</th>
                    <th scope="col">Cantitate</th>
                    <th scope="col">Valoare</th>
                </tr>
                <c:forEach var="produs" items="${items}" varStatus="status">
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
                    <th scope="col"></th>
                    <th scope="col">${valoare} RON</th>
                </tr>

            </table>

        </div>

        <div class="mx-auto text-center" style="width: 500px;">
            <label for="Valoare">Valoare :</label> <label for="valoare">${valoare} RON&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label for="TVA">TVA :</label> <label for="TVA_val">19%&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label for="discount">Discount :</label> <label for="discount_val">15%&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label for="total">Total :</label> <label for="total_val">${total} RON</label>
        </div>
        <div class="mx-auto text-center" style="width: 500px;">
            <label for="metoda_plata">Alege metoda de plata :</label>
            <a name="card" class="btn btn-secondary btn-sm" type="submit" href="${pageContext.request.contextPath}/Card">Card</a>
            <button name="cash" class="btn btn-secondary btn-sm" type="submit">Cash</button>
            <button name="pay" class="btn btn-secondary btn-sm" type="submit">Plateste</button>
        </div>

    </form>
<!--    <script>
        var Table = document.getElementById("cos");
        Table.innerHTML = "";
    </script>-->
</t:pageTemplate>
