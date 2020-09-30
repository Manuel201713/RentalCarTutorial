<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="jumbotron jumbotron-billboard">
    <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>${Titolo}</h2>
                <p>${Titolo2}</p>
            </div>
        </div>
    </div>
</div>
<section class="container">
    <div class="row">
        <div class = "col-md-6 col-sm-6">
            <h3 class="page-title">Lista Utenti</h3>
        </div>
        <table id="users" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Birth Date</th>
                <th>Fiscal Code</th>
                <th>E-mail</th>
                <th>Password</th>
                <th>Phone</th>
                <th>Admin</th>
            </tr>
            </thead>
            <tfoot>
            </tfoot>
            <tbody>
            <c:forEach items="${Users}" var="utente">
                <tr>
                    <td>${utente.userId}</td>
                    <td>${utente.firstName}</td>
                    <td>${utente.lastName}</td>
                    <td>${utente.birthDate}</td>
                    <td>${utente.fiscalCode}</td>
                    <td>${utente.email}</td>
                    <td>${utente.password}</td>
                    <td>${utente.phone}</td>
                    <td>${utente.admin}</td>
                    <td>
                        <a href=" <spring:url value="/users/update/${utente.userId}" /> " class="btn btn-primary">
                            <span class="oi oi-plus"/></span> Modifica
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>