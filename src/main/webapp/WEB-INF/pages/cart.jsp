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
  <link rel="stylesheet" href="<c:url value="/resources/css/cart.css"/>">


</head>
  <body>
<jsp:include page="hearder.jsp"/>
    <section class="banner_area1">
      <div class="container">
        <div class="banner_content d-md-flex justify-content-between align-items-center">
          <div class="mb-3 mb-md-0">
            <h2>Giỏ Hàng</h2>
            <p>${msg}</p>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================Cart Area =================-->
    <section class="cart_areas">
      <div class="container">
        <div class="cart_inner">
          <div class="table-responsive">
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">Sản Phẩm</th>
                  <th scope="col">Giá</th>
                  <th scope="col">Số Lượng</th>
                  <th scope="col">Tổng</th>
                </tr>
              </thead>
                  <tbody>
                      <c:forEach var="cartItem" items="${cartItem}" varStatus="index">
                        <tr>
                          <td>
                            <div class="media">
                              <div class="d-col col-lg-3">
                                <img  class="img-fluid" src="./getProductPhoto/<c:out value='${cartItem.product.id}'/>"/>
                              </div>
                              <div class="media-body">
                               <a href="product/${cartItem.product.id}">
                                <p>${cartItem.product.name}</p>
                               </a>
                              </div>
                            </div>

                          </td>
                          <td>
                            <h5><fmt:formatNumber value="${cartItem.product.price}" pattern="#,##0" /></h5>
                          </td>
                          <td>
                            <div class="product_count">
                              <input
                                type="text"
                                name="qty"
                                id="sst"
                                maxlength="4"
                                value="${cartItem.quantity}"
                                title="Quantity:"
                                class="input-text qty"
                                readonly
                              />

                              </button>
                            </div>
                          </td>
                          <td>
                            <h5><fmt:formatNumber value="${cartItem.product.price*cartItem.quantity}" pattern="#,##0" /></h2></h5>
                          </td>
                          <td>
                            <div class="cupon_text">
                                <a class="main_btn" href="delete/${cartItem.id}">Loại bỏ</a>
                            </div>
                          </td>
                        </tr>
                      </c:forEach>
                        <tr>
                          <td></td>
                          <td></td>
                          <td>
                            <h5>Tổng đơn</h5>
                          </td>
                          <td>
                            <h5><fmt:formatNumber value="${total}" pattern="#,##0" /> <u>đ</u></h2></h5>
                          </td>
                        </tr>
                        <tr class="out_button_area">
                          <td></td>
                          <td></td>
                          <td></td>
                          <td>
                            <div class="checkout_btn_inner">
                              <div class="continuer">
                                <a class="gray_btn" href="/project-final-main">Chọn Thêm Sản Phẩm Khác</a>
                              </div>
                              <div class="buy">
                                <a class="main_btn" href="checkout">Thanh Toán</a>
                              </div>
                            </div>
                          </td>
                        </tr>
                  </tbody>
            </table>
          </div>
        </div>
      </div>
    </section>
    <!--================End Cart Area =================-->


  </body>
</html>
