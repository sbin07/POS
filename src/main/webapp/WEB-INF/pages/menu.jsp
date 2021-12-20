<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}">POS</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                    <li class="nav-item ${activePage eq 'Return' ? 'active' : ''}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Return">Return</a>
                    </li>
                </c:if>

                <c:if test="${pageContext.request.isUserInRole('ClientRole')}">
                    <li class="nav-item ${activePage eq 'Users' ? 'active' : ''}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Users">Users</a>
                    </li>
                </c:if>

            </ul>
            <ul class="navbar-nav mr-auto">

                <li class="nav-item ${activePage eq 'Payment' ? 'active' : ''}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Payment">Payment</a>
                </li>

            </ul>
            <ul class="navbar-nav d-flex">
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${pageContext.request.getRemoteUser() == null}">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
    </div>
</nav>
