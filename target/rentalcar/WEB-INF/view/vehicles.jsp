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
            <h3 class="page-title">Lista Veicoli</h3>
        </div>
        <table id="users" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Vehicle ID</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Type</th>
                <th>License Plate</th>
                <th>Registration Year</th>
            </tr>
            </thead>
            <tfoot>
            </tfoot>
            <tbody>
            <c:forEach items="${Vehicles}" var="veicolo">
                <tr>
                    <td>${veicolo.vehicleId}</td>
                    <td>${veicolo.brand}</td>
                    <td>${veicolo.model}</td>
                    <td>${veicolo.type}</td>
                    <td>${veicolo.licensePlate}</td>
                    <td>${veicolo.registrationYear}</td>
                    <td>
                        <a href=" <spring:url value="/users/update/${veicolo.vehicleId}" /> " class="btn btn-primary">
                            <span class="oi oi-plus"/></span> Modifica
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>