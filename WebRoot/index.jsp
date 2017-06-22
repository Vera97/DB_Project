<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>DB</title>
    
    <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css">                
    <link rel="stylesheet" href="css/bootstrap.min.css">                                      
    <link rel="stylesheet" href="css/hero-slider-style.css">                              
    <link rel="stylesheet" href="css/magnific-popup.css">                                 
    <link rel="stylesheet" href="css/templatemo-style.css">                                   
   
  <body>
  <!-- Content -->
        <div class="cd-hero">

            <!-- Navigation -->        
            <div class="cd-slider-nav">
                <nav class="navbar">
                    <div class="tm-navbar-bg">
                        
                        <a class="navbar-brand text-uppercase" href="#"><i class="fa fa-home tm-brand-icon"></i>DB</a>

                        <button class="navbar-toggler hidden-lg-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
                            &#9776;
                        </button>
                        <div class="collapse navbar-toggleable-md text-xs-center text-uppercase tm-navbar" id="tmNavbar">
                            <ul class="nav navbar-nav">
                                <li class="nav-item active selected">
                                    <a class="nav-link" href="#0" data-no="1">Region<span class="sr-only">(current)</span></a>
                                </li>                                
                                <li class="nav-item">
                                    <a class="nav-link" href="#0" data-no="2">Nation</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#0" data-no="3">Part</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#0" data-no="4">Supplier</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#0" data-no="5">PartSupp</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#0" data-no="6">Customer</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#0" data-no="7">LineItem</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#0" data-no="8">Orders</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#0" data-no="9">ComplexQuery</a>
                                </li>
                            </ul>
                        </div>                        
                    </div>

                </nav>
            </div> 
            <ul class="cd-hero-slider">
                <!-- Page 1 Home -->
                <li class="selected">
                    <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content tm-page-width" data-page-no="1">
                          <%String result = (String) request.getAttribute("RegionQ"); %>
                          <form method="post" action="RegionQ">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Query for Region
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>RegionKey</td><td>Name</td><td>Comment</td><tr>
                                            <tr><td><input type="text" name="regionkey"></td><td><input type="text" name="name"></td><td><input type="text" name="commnet"></td><tr>
                                            </table>
                                            <textarea rows="5" cols="100"><%=result %></textarea>     
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                          </form>
                          <%String RegionA = (String) request.getAttribute("RegionA");%>
                          <form method="post" action="RegionA">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Insert for Region
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>RegionKey</td><td>Name</td><td>Comment</td><td>RESULT</td><tr>
                                            <tr><td><input type="text" name="regionkey"></td><td><input type="text" name="name"></td>
                                            <td><input type="text" name="comment"></td><td><input type="text" value="<%=RegionA %>"></td><tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </form>
                         <%String RegionD = (String) request.getAttribute("RegionD");%>
                          <form method="post" action="RegionD">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Delete for Region
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>RegionKey</td><td>Name</td><td>Comment</td><td>RESULT</td><tr>
                                            <tr><td><input type="text" name="regionkey"></td><td><input type="text" name="name"></td><td><input type="text" name="comment"></td>
                                            <td><input type="text" value="<%=RegionD %>"></td><tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </form>
                          <%String RegionU = (String) request.getAttribute("RegionU");%>
                          <form method="post" action="RegionU">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Update for Region
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>old information</td></tr>
                                            <tr><td>RegionKey</td><td>RESULT</td></tr>
                                            <tr><td><input type="text" name="regionkey"></td>
                                            <td><input type="text" value="<%=RegionU %>"></td><tr>
                                            </table>
                                            <table>
                                            <tr><td>new information</td></tr>
                                            <tr><td>RegionKey</td><td>Name</td><td>Comment</td><tr>
                                            <tr><td><input type="text" name="regionkey2"></td><td><input type="text2" name="name2"></td><td><input type="text" name="comment"></td><tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </form>
                        
                        </div>
                      </div>
                </li>
                <!-- Page 2 -->
                <li>
                <%String NationQ = (String) request.getAttribute("NationQ"); %>
                    <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content tm-page-width" data-page-no="2">
                          <form method="post" action="NationQ">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Query for Nation
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>NationName</td>
                                            <tr><td><input type="text" name="name"></td></tr>
                                            </table>
                                            <textarea rows="5" cols="100"><%=NationQ %></textarea>     
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </form>
                        </div>
                      </div>
                </li>
                <li>
                <%String PartQ = (String) request.getAttribute("PartQ"); %>
                    <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content tm-page-width" data-page-no="3">
                          <form method="post" action="PartQ">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Query for Part
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>PartName</td><tr>
                                            <tr><td><input type="text" name="partkey"></td><tr>
                                            </table>
                                            <textarea rows="5" cols="100"><%=PartQ %></textarea>     
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </form>
                        </div>
                      </div>
                </li>
                <li>
                <%String SupplierQ = (String) request.getAttribute("SupplierQ");%>
                    <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content tm-page-width" data-page-no="4">
                          <form method="post" action="SupplierQ">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Query for Supplier
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>SupplierName</td><tr>
                                            <tr><td><input type="text" name="name"></td><tr>
                                            </table>
                                            <textarea rows="5" cols="100"><%=SupplierQ %></textarea>     
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </form>
                        </div>
                      </div>
                  
                </li>
                <li>
                <%String PartSuppQ = (String) request.getAttribute("PartSuppQ");%>
                    <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content tm-page-width" data-page-no="5">
                          <form method="post" action="PartSuppQ">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Query for PartSupp
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>PartKey</td><tr>
                                            <tr><td><input type="text" name="partkey"></td><tr>
                                            </table>
                                            <textarea rows="5" cols="100"><%=PartSuppQ %></textarea>     
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </form>
                        </div>
                      </div>
                </li>
                <li>
                <%String CustomerQ = (String) request.getAttribute("CustomerQ"); %>
                    <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content tm-page-width" data-page-no="6">
                          <form method="post" action="CustomerQ">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Query for Customer
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>CustomerName</td><tr>
                                            <tr><td><input type="text" name="name"></td><tr>
                                            </table>
                                            <textarea rows="5" cols="100"><%=CustomerQ %></textarea>     
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </form>
                        </div>
                      </div>
                            
                </li>
                <li>
                    <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content tm-page-width" data-page-no="7">
                          <form method="post" action="RegionQ">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Query for LineItem
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>RegionKey</td><td>Name</td><td>Comment</td><tr>
                                            <tr><td><input type="text" name="regionkey"></td><td><input type="text" name="name"></td><td><input type="text" name="commnet"></td><tr>
                                            </table>
                                            <textarea rows="5" cols="100"><%=result %></textarea>     
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </form>
                        </div>
                      </div>
                </li>
                <li>
                    <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content tm-page-width" data-page-no="8">
                          <form method="post" action="RegionQ">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">Query for Orders
                                            <input type="submit"><br></h2>
                                            <table>
                                            <tr><td>RegionKey</td><td>Name</td><td>Comment</td><tr>
                                            <tr><td><input type="text" name="regionkey"></td><td><input type="text" name="name"></td><td><input type="text" name="commnet"></td><tr>
                                            </table>
                                            <textarea rows="5" cols="100"><%=result %></textarea>     
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </form>
                        </div>
                      </div>
                </li>
                
                <%String cp = (String) request.getAttribute("ComplexQ"); %>
                <li>
                    <div class="cd-full-width">
                        <div class="container-fluid js-tm-page-content tm-page-pad" data-page-no="9">
                            <div class="row">
                                    <div class="tm-4-col-container">                                        
                                            <div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 tm-4-col-textbox">
                                                <div class="text-xs-left tm-textbox tm-textbox-padding tm-bg-white-translucent tm-4-col-textbox-inner">
                                                    <h2 class="tm-text-title">Minimum Cost Supplier Query</h2>                                           
                                                    <p class="tm-text">It finds, in a given region, for each part of a certain type and size, the supplier who can supply it at minimum cost.</p>
                                                    <form action="MyServlet" method="post">
                                                    type: <input type="text" name="type"/>
                                                    size: <input type="text" name="size"/>
                                                    region: <input type="text" name="name"/>
                                                    <input type="submit">
                                                    </form>
                                                </div>
                                            </div>
                                            <div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 tm-4-col-textbox">
                                                <div class="text-xs-left tm-textbox tm-textbox-padding tm-bg-white-translucent tm-4-col-textbox-inner">
                                                    <h2 class="tm-text-title">Order Priority Checking Query</h2>
                                                    <p class="tm-text">It counts the number of orders ordered in a given quarter of a given year in which at least one lineitem was received by the customer later than its committed date.</p>
                                                    <form action="Q2" method="post">
                                                    date: <input type="text" name="date"/>
                                                    <input type="submit">
                                                    </form>
                                                </div>          
                                            </div>
                                            <div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 tm-4-col-textbox">
                                                <div class="text-xs-left tm-textbox tm-textbox-padding tm-bg-white-translucent tm-4-col-textbox-inner">
                                                    <h2 class="tm-text-title">Returned Item Reporting Query</h2>
                                                    <p class="tm-text">It finds the top 20 customers, in terms of their effect on lost revenue for a given quarter, who have returned parts.</p>
                                                    <form action="Q3" method="post">
                                                    date: <input type="text" name="date"/>
                                                    <input type="submit">
                                                    </form>
                                                </div>          
                                            </div>
                                            <div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 tm-4-col-textbox">
                                                <div class="text-xs-left tm-textbox tm-textbox-padding tm-bg-white-translucent tm-4-col-textbox-inner">
                                                    <h2 class="tm-text-title">Large Volume Customer Query</h2>
                                                    <p class="tm-text">It finds a list of the top 100 customers who have ever placed large quantity orders. </p>
                                                    <form action="Q4" method="post">
                                                    quantity: <input type="text" name="quantity"/>
                                                    <input type="submit">
                                                    </form>
                                                </div>          
                                            </div>                                        
                                   </div>
                            </div>
                            <hr>
                              <div class="row">
                                <div class="col-xs-12">
                                    <div class="tm-flex">
                                        <div class="tm-bg-white-translucent text-xs-left tm-textbox tm-textbox-padding tm-white-box-margin-b">
                                            <h2 class="tm-text-title">The Result</h2>
                                            
                                            <textarea rows="5" cols="100"><%=cp %></textarea>     
                                        </div>
                                    </div>
                                </div>
                            </div>
                          
                         </div>
                    </div>
                </li>
               </ul>
              
            <footer class="tm-footer">
                <p class="tm-copyright-text">Copyright &copy; 2017 10152510184 Wang
            </footer>
                    
        </div> <!-- .cd-hero -->
        <script src="js/jquery-1.11.3.min.js"></script>         <!-- jQuery (https://jquery.com/download/) -->
        <script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script> <!-- Tether for Bootstrap (http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h) --> 
        <script src="js/bootstrap.min.js"></script>             <!-- Bootstrap js (v4-alpha.getbootstrap.com/) -->
        <script src="js/hero-slider-main.js"></script>          <!-- Hero slider (https://codyhouse.co/gem/hero-slider/) -->
        <script src="js/jquery.magnific-popup.min.js"></script> <!-- Magnific popup (http://dimsemenov.com/plugins/magnific-popup/) -->
        
        <script>

            function adjustHeightOfPage(pageNo) {

                var offset = 80;
                var pageContentHeight = 0;

                var pageType = $('div[data-page-no="' + pageNo + '"]').data("page-type");

                if( pageType != undefined && pageType == "gallery") {
                    pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .tm-img-gallery-container").height();
                }
                else {
                    pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .js-tm-page-content").height();
                }

                if($(window).width() >= 992) { offset = 120; }
                else if($(window).width() < 480) { offset = 40; }
               
                // Get the page height
                var totalPageHeight = 15 + $('.cd-slider-nav').height()
                                        + pageContentHeight + offset
                                        + $('.tm-footer').height();

                // Adjust layout based on page height and window height
                if(totalPageHeight > $(window).height()) 
                {
                    $('.cd-hero-slider').addClass('small-screen');
                    $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", totalPageHeight + "px");
                }
                else 
                {
                    $('.cd-hero-slider').removeClass('small-screen');
                    $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", "100%");
                }
            }

            /*
                Everything is loaded including images.
            */
            $(window).load(function(){

                adjustHeightOfPage(1); // Adjust page height

                /* Gallery One pop up
                -----------------------------------------*/
                $('.gallery-one').magnificPopup({
                    delegate: 'a', // child items selector, by clicking on it popup will open
                    type: 'image',
                    gallery:{enabled:true}                
                });
				
				/* Gallery Two pop up
                -----------------------------------------*/
				$('.gallery-two').magnificPopup({
                    delegate: 'a',
                    type: 'image',
                    gallery:{enabled:true}                
                });

                /* Gallery Three pop up
                -----------------------------------------*/
                $('.gallery-three').magnificPopup({
                    delegate: 'a',
                    type: 'image',
                    gallery:{enabled:true}                
                });

                /* Collapse menu after click 
                -----------------------------------------*/
                $('#tmNavbar a').click(function(){
                    $('#tmNavbar').collapse('hide');

                    adjustHeightOfPage($(this).data("no")); // Adjust page height       
                });

                /* Browser resized 
                -----------------------------------------*/
                $( window ).resize(function() {
                    var currentPageNo = $(".cd-hero-slider li.selected .js-tm-page-content").data("page-no");
                    
                    // wait 3 seconds
                    setTimeout(function() {
                        adjustHeightOfPage( currentPageNo );
                    }, 1000);
                    
                });
        
                // Remove preloader (https://ihatetomatoes.net/create-custom-preloading-screen/)
                $('body').addClass('loaded');
                           
            });

            /* Google map
            ------------------------------------------------*/
            var map = '';
            var center;

            function initialize() {
                var mapOptions = {
                    zoom: 15,
                    center: new google.maps.LatLng(37.769725, -122.462154),
                    scrollwheel: false
                };
            
                map = new google.maps.Map(document.getElementById('google-map'),  mapOptions);

                google.maps.event.addDomListener(map, 'idle', function() {
                  calculateCenter();
                });
            
                google.maps.event.addDomListener(window, 'resize', function() {
                  map.setCenter(center);
                });
            }

            function calculateCenter() {
                center = map.getCenter();
            }

            function loadGoogleMap(){
                var script = document.createElement('script');
                script.type = 'text/javascript';
                script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&' + 'callback=initialize';
                document.body.appendChild(script);
            }
        
            // DOM is ready
            $(function() {                
                loadGoogleMap(); // Google Map
            });

        </script>            
        
  </body>
</html>
