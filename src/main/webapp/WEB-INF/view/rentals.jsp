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
            <h3 class="page-title">Lista Noleggi</h3>
        </div>
        <table id="users" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Rental ID</th>
                <th>Vehicle ID</th>
                <th>User ID</th>
                <th>Start Date</th>
                <th>End Date</th>
            </tr>
            </thead>
            <tfoot>
            </tfoot>
            <tbody>
            <c:forEach items="${Rentals}" var="rent">
                <tr>
                    <td>${rent.rentalId}</td>
                    <td>${rent.vehicleId}</td>
                    <td>${rent.userId}</td>
                    <td>${rent.startDate}</td>
                    <td>${rent.endDate}</td>
                    <td>
                        <a href=" <spring:url value="/users/update/${rent.vehicleId}" /> " class="btn btn-primary">
                            <span class="oi oi-plus"/></span> Modifica
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>