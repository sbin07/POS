<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Card">

    <form class="needs-validation" method="POST" action="${pageContext.request.contextPath}/Card">

        <div class="mx-auto text-center" style="width: 350px;">
            <label for="name">Name :</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="" value="" required="">
            <div class="invalid-feedback">
                Introduceti un nume
            </div>
            <label for="cardNr">Card number :</label>
            <input type="text" class="form-control" id="cardNr" name="numar_card" placeholder="" value="" required="">
            <div class="invalid-feedback">
                Introduceti numar de card
            </div>

            <label for="CVV">CVV :</label>
            <input type="text" class="form-control" id="cvv" name="cvv" placeholder="" value="" required="">
            <div class="invalid-feedback">
                Introduceti cvv-ul cardului 
            </div>
            <button class="btn btn-secondary" value="${bonId}">Plateste</button>
        </div>
        


    </t:pageTemplate>
