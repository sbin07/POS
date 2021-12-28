<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Card">

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Cash" required>

        <div class="mx-auto text-center" style="width: 350px;">
            <div>
                <label>Valoare de plata :</label>
                <label>${total}</label>
            </div>
            <div>
                <label for="deIntrodus">Introduceti suma pe care o doriti :</label>
                <input type="text" class="form-control" id="deIntrodus" name="de_introdus" placeholder="" value="" required autofocus>
                <div class="invalid-feedback">
                    Introduceti suma corecta
                </div>
            </div>
<!--            <div>
                <label>Rest :</label>
                <label>${rest}</label>
            </div>-->
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
