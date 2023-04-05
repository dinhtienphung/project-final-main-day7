<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
  <link rel="stylesheet" href="<c:url value="/resources/css/pageHome.css"/>">


</head>

<body>
<jsp:include page="hearder.jsp"/>

  <section class="feature-area section_gap_bottom_custom">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-6">
          <div class="single-feature">
            <a href="product-list/categoryid=${1}page1">
            <img width="54px" src="<c:url value='/resources/css/img/logoDT.PNG'/>"/>
              <h3>Điện Thoại</h3>
            </a>
          </div>
        </div>

        <div class="col-lg-3 col-md-6">
          <div class="single-feature">
            <a href="product-list/categoryid=${2}page1">
            <img src="<c:url value='/resources/css/img/logotablet3.PNG'/>"/>
              <h3>Tablet</h3>
            </a>
         </div>
        </div>

        <div class="col-lg-3 col-md-6">
          <div class="single-feature">
            <a href="product-list/categoryid=${3}page1">
            <img style="width: 82px;" src="<c:url value='/resources/css/img/logoLaptop.PNG'/>"/>
              <h3>LapTop&MAC</h3>
            </a>
          </div>
        </div>

        <div class="col-lg-3 col-md-6">
          <div class="single-feature">
            <a href="product-list/categoryid=${4}page1">
            <img style="width: 37px;" src="<c:url value='/resources/css/img/logodongho.PNG'/>"/>
              <h3>Đồng Hồ</h3>
            </a>
          </div>
        </div>
      </div>
    </div>
  </section>

  <section class="new_product_area section_gap_top section_gap_bottom_custom">
  <div class="row justify-content-center">
    <!--  <div class="col-lg-12">
        <div class="main_title">
            <div class="img-logohome1">
              <div class="img-logo1">
                <img src="<c:url value='/resources/css/img/logohome1920x600-060323-min.png'/>"/>
              </div>
            </div>
        </div>
      </div> -->
 </div>
    <div class="container">

        <div class="row">
          <c:forEach var="top1" items="${ListTop1}" varStatus="index">
            <div  class="col-lg-5">
              <div style="margin-top:-120px"; class="new_product">
                <h3 class="text-uppercase">${top1.name}</h3>
                <div class="product-img">
                    <a href="product/${top1.id}">
                      <img  class="img-fluid w-100"  src="getProductPhoto/<c:out value='${top1.id}'/>"/>
                    </a>
                </div>
                <h4><fmt:formatNumber value="${top1.price}" pattern="#,##0" /></h4>
                <a href="addToCart/${top1.id}" class="main_btn">Thêm Vào Giỏ</a>

              </div>
            </div>
          </c:forEach>
            <div class="col-lg-6 mt-5 mt-lg-0">

                  <div class="row">
                      <c:forEach var="top4" items="${ListTop4}" varStatus="index">
                        <div  class="col-lg-6">
                          <div class="single-product">
                            <div class="product-img">
                              <img class="img-fluid" w-100 h-100" src="getProductPhoto/<c:out value='${top4.id}'/>"/>
                              <div class="p_icon">
                                <a href="product/${top4.id}">
                                  <i class="ti-eye"></i>
                                </a>
                                <a href="addToCart/${top4.id}">
                                  <i class="ti-shopping-cart"></i>
                                </a>
                              </div>
                            </div>
                            <div class="product-btm">
                              <a href="product/${top4.id}" class="d-block">
                                <h4>${top4.name}</h4>
                              </a>
                              <div class="mt-3">
                                <span class="mr-4"><fmt:formatNumber value="${top4.price}" pattern="#,##0" /></span>
                              </div>
                            </div>
                          </div>
                        </div>
                      </c:forEach>
                  </div>
            </div>

      </div>
    </div>
  </section>

  <section class="inspired_product_area section_gap_bottom_custom">
    <div  class="main_title">
      <div class="img-logohome1">
        <div class="img-logo1">
          <img src="<c:url value='/resources/img/banner/banner1.webp'/>"/>
        </div>
      </div>
    </div>
    <div style="background-color: #ff685f; border-radius: 10px; padding-top: 20px; height: 75%"; class="container">
      <div class="row">
          <c:forEach var="product" items="${productListTopPhone}" varStatus="index">
            <div class="col-lg-3 col-md-6">
              <div  style="background-color: #ffff; padding: 10px 0px; border-radius: 10px"; class="single-product">
                <div class="product-img">
                <img class="img-fluid" w-100" src="getProductPhoto/<c:out value='${product.id}'/>"/>
                  <div class="p_icon">
                    <a href="product/${product.id}">
                      <i class="ti-eye"></i>
                    </a>
                    <a href="addToCart/${product.id}">
                      <i class="ti-shopping-cart"></i>
                    </a>
                  </div>
                </div>
                <div class="product-btm">
                  <a href="product/${product.id}" class="d-block">
                    <h4>${product.name}</h4>
                  </a>
                  <div class="mt-3">
                    <span class="mr-4"><fmt:formatNumber value="${product.price}" pattern="#,##0" /></span>
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>
      </div>
      <div class="main_titles">
             <a href="product-list/categoryid=${1}page1" class="d-block">Xem Tất Cả</a>
      </div>
    </div>
  </section>

  <section class="inspired_product_area section_gap_bottom_custom">
      <div  class="main_title">
        <div class="img-logohome1">
          <div class="img-logo1">
            <img style=" height: 33%"; src="<c:url value='/resources/img/banner/banner2.PNG'/>"/>
          </div>
        </div>
      </div>
      <div style="background-color: #fedd38; border-radius: 10px; padding-top: 20px; height: 75%"; class="container">
        <div class="row">
            <c:forEach var="product" items="${productListTopTablet}" varStatus="index">
              <div class="col-lg-3 col-md-6">
                <div  style="background-color: #ffff; padding: 10px 0px; border-radius: 10px"; class="single-product">
                  <div class="product-img">
                  <img class="img-fluid" w-100" src="getProductPhoto/<c:out value='${product.id}'/>"/>
                    <div class="p_icon">
                      <a href="product/${product.id}">
                        <i class="ti-eye"></i>
                      </a>
                      <a href="addToCart/${product.id}">
                        <i class="ti-shopping-cart"></i>
                      </a>
                    </div>
                  </div>
                  <div class="product-btm">
                    <a href="product/${product.id}" class="d-block">
                      <h4>${product.name}</h4>
                    </a>
                    <div class="mt-3">
                      <span class="mr-4"><fmt:formatNumber value="${product.price}" pattern="#,##0" /></span>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
        </div>
        <div class="main_titles">
             <a href="product-list/categoryid=${2}page1" class="d-block">Xem Thêm</a>
        </div>
      </div>
  </section>
   <section class="inspired_product_area section_gap_bottom_custom">
         <div  class="main_title">
           <div class="img-logohome1">
             <div class="img-logo1">
               <img style=" height: 33%"; src="<c:url value='/resources/img/banner/banner3.png'/>"/>
             </div>
           </div>
         </div>
         <div style="background-color: #c62301; border-radius: 10px; padding-top: 20px; height: 75%"; class="container">
           <div class="row">
               <c:forEach var="product" items="${productListTopLaptop}" varStatus="index">
                 <div class="col-lg-3 col-md-6">
                   <div  style="background-color: #ffff; padding: 10px 0px; border-radius: 10px"; class="single-product">
                     <div class="product-img">
                     <img class="img-fluid" w-100" src="getProductPhoto/<c:out value='${product.id}'/>"/>
                       <div class="p_icon">
                         <a href="product/${product.id}">
                           <i class="ti-eye"></i>
                         </a>
                         <a href="addToCart/${product.id}">
                           <i class="ti-shopping-cart"></i>
                         </a>
                       </div>
                     </div>
                     <div class="product-btm">
                       <a href="product/${product.id}" class="d-block">
                         <h4>${product.name}</h4>
                       </a>
                       <div class="mt-3">
                         <span class="mr-4"><fmt:formatNumber value="${product.price}" pattern="#,##0" /></span>
                       </div>
                     </div>
                   </div>
                 </div>
               </c:forEach>
           </div>
           <div class="main_titles">
                <a href="product-list/categoryid=${3}page1" class="d-block">Xem Thêm</a>
           </div>
         </div>
   </section>
   <section class="inspired_product_area section_gap_bottom_custom">
         <div  class="main_title">
           <div class="img-logohome1">
             <div class="img-logo1">
               <img style=" height: 33%"; src="<c:url value='/resources/img/banner/banner4.png'/>"/>
             </div>
           </div>
         </div>
         <div style="background-color: #092dc6; border-radius: 10px; padding-top: 20px; height: 75%"; class="container">
           <div class="row">
               <c:forEach var="product" items="${productListTopDH}" varStatus="index">
                 <div class="col-lg-3 col-md-6">
                   <div  style="background-color: #ffff; padding: 10px 0px; border-radius: 10px"; class="single-product">
                     <div class="product-img">
                     <img class="img-fluid" w-100" src="getProductPhoto/<c:out value='${product.id}'/>"/>
                       <div class="p_icon">
                         <a href="product/${product.id}">
                           <i class="ti-eye"></i>
                         </a>
                         <a href="addToCart/${product.id}">
                           <i class="ti-shopping-cart"></i>
                         </a>
                       </div>
                     </div>
                     <div class="product-btm">
                       <a href="product/${product.id}" class="d-block">
                         <h4>${product.name}</h4>
                       </a>
                       <div class="mt-3">
                         <span class="mr-4"><fmt:formatNumber value="${product.price}" pattern="#,##0" /></span>
                       </div>
                     </div>
                   </div>
                 </div>
               </c:forEach>
           </div>
           <div class="main_titles">
                <a href="product-list/categoryid=${4}page1" class="d-block">Xem Thêm</a>
           </div>
         </div>
   </section>

    <script src="<c:url value="/resources/css/js/jquery-3.2.1.min.js"/>"></script>
        <script src="<c:url value="/resources/css/js/popper.js"/>"></script>
        <script src="<c:url value="/resources/css/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/css/js/stellar.js"/>"></script>
        <script src="<c:url value="/resources/css/vendors/lightbox/simpleLightbox.min.js"/>"></script>
        <script src="<c:url value="/resources/css/vendors/nice-select/js/jquery.nice-select.min.js"/>"></script>
        <script src="<c:url value="/resources/css/vendors/isotope/imagesloaded.pkgd.min.js"/>"></script>
        <script src="<c:url value="/resources/css/vendors/isotope/isotope-min.js"/>"></script>
        <script src="<c:url value="/resources/css/vendors/owl-carousel/owl.carousel.min.js"/>"></script>
        <script src="<c:url value="/resources/css/js/jquery.ajaxchimp.min.js"/>"></script>
        <script src="<c:url value="/resources/css/js/mail-script.js"/>"></script>
        <script src="<c:url value="/resources/css/vendors/jquery-ui/jquery-ui.js"/>"></script>
        <script src="<c:url value="/resources/css/vendors/counter-up/jquery.waypoints.min.js"/>"></script>
        <script src="<c:url value="/resources/css/vendors/counter-up/jquery.counterup.js"/>"></script>
        <script src="<c:url value="/resources/css/js/theme.js"/>"></script>


</body>
</html>