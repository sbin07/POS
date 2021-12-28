<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Card">

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Card" required>

        <div class="mx-auto text-center" style="width: 350px;">
            <div>
                <label for="name">Name :</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="" value="" required autofocus>
                <div class="invalid-feedback">
                    Introduceti un nume
                </div>
            </div>
            <div>
                <label for="cardNr">Card number :</label>
                <input type="text" class="form-control" id="cardNr" name="numar_card" placeholder="" value="" required autofocus  maxlength="16" minlength="16">
                <div class="invalid-feedback">
                    Introduceti numar de card (16 caractere)
                </div>
            </div>
            <div>
                <label for="CVV">CVV :</label>
                <input type="text" class="form-control" id="cvv" name="cvv" placeholder="" value="" required autofocus  maxlength="3" minlength="3">
                <div class="invalid-feedback">
                    Introduceti cvv-ul cardului (3 caractere)
                </div>
            </div>
            <button class="btn btn-secondary" value="${bonId}">Plateste</button>
        </div>
    </form>

    <script>// Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict'
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll('.needs-validation')
            // Loop over them and prevent submission
            Array.prototype.slice.call(forms)
                    .forEach(function (form) {
                        form.addEventListener('submit', function (event) {
                            if (!form.checkValidity()) {
                                event.preventDefault()
                                event.stopPropagation()
                            }
                            form.classList.add('was-validated')
                        }, false)
                    })
        })()
    </script>
</t:pageTemplate>
