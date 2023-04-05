<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <link rel="icon" href="img/fev.png" type="image/png"/>
  <title>Home</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="<c:url value="/resources/css/css/bootstrap.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/vendors/liner/style.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/css/font-awesome.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/css/them-icons.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/css/flat.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/vendors/owl-carousel/owl.carousel.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/vendors/lightbox/simpleLightbox.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/vendors/nice-select/css/nice-select.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/vendors/animate-css/animate.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/vendors/jquery-ui/jquery-ui.css"/>">
  <!-- main css -->
  <link rel="stylesheet" href="<c:url value="/resources/css/css/style.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/resources/css/css/responsive.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/resources/css/font-free-6.1.2-web/css/solid.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/banking.css"/>">


</head>
<body>
    <form:form action="addBankingCart" method="POST" modelAttribute="accountBanking">
        <div class="form-group">
                    <label class="control-label">Full Name (*)</label>
                    <input name="fullName" type="text" class="form-control"
                        placeholder="cardNumber" />
                </div>
        <div class="form-group">
            <label class="control-label">Full Name (*)</label>
            <input name="cardNumber" type="text" class="form-control"
                placeholder="cardNumber" />
        </div>
        <div class="form-group">
            <label class="control-label">cardNumber (*)</label>
            <input name="balance" type="number" class="form-control"
                placeholder="balance" required="true" />
        </div>
        <div class="form-group">
            <label class="control-label">expired_date (*)</label>
            <form:input path="expired_date" type="date" id="myDate" class="form-control"
                />
        </div>
        <div class="form-group">
            <label class="control-label">cvc (*)</label>
            <input name="cvc" type="number" id="myDate" class="form-control"
                />
        </div>
        <br>
        <div class="footer" style="display:flex; justify-content: center;">
            <button class="btn btn-primary" type="submit" style="width: 100%">Submit</button>
        </div>
    </form:form>

</body>
</html>