<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Payment">
    <form >
        <div class="mx-auto text-center" style="width: 350px;">
            <label for="cod_produs">Introduceti codul produsului :</label>
            <input type="text" class="form-control" id="codProdus" name="cod_produs" placeholder="" value="" required="">
            <div class="invalid-feedback">
                Introduceti codul corect
            </div>
            <button class="btn btn-secondary btn-sm" method="POST" href="${pageContext.request.contextPath}/Payment" type="submit">Adauga</button>
        </div>
        <br>
        <div class="mx-auto text-center overflow-auto " style="width: 1400px; height: 500px;">



            <table class="table table-striped table-hover table-condensed">
                <thead class="table-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nume Produs</th>
                        <th scope="col">Pret</th>
                        <th scope="col">Cantitate</th>
                        <th scope="col">Valoare</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="produs" items="${produse}" varStatus="status">
                        <tr>
                            <th scope="row">1</th>
                            <td>${produs.denumire}</td>
                            <td>${produs.pret}</td>
                            <td>x1</td>
                            <td></td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>


        </div>
        <div class="mx-auto text-center" style="width: 500px;">
            <label for="valoare">Valoare :</label> <label for="valoare_val">0 RON&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label for="TVA">TVA :</label> <label for="TVA_val">0 RON&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label for="discount">Discount :</label> <label for="discount_val">0 RON&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <label for="total">Total :</label> <label for="total_val">0 RON</label>
        </div>
        <div class="mx-auto text-center" style="width: 500px;">
            <label for="metoda_plata">Alege metoda de plata :</label>
            <button name="card" class="btn btn-secondary btn-sm" type="submit">Card</button>
            <button name="cash" class="btn btn-secondary btn-sm" type="submit">Cash</button>
            <button name="pay" class="btn btn-secondary btn-sm" type="submit">Plateste</button>
        </div>
    </form>
</t:pageTemplate>
