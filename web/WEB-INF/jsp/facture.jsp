
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<%
    String nom = (String) request.getAttribute("n");
    
%>

    <html>
    <%@include file="header.jsp" %>

    <body class="fade-in">
        <div class="layout-wrapper layout-content-navbar">
            <div class="layout-container">
                <jsp:include page="asideutilisateur.jsp">
                    <jsp:param name="activeLink" value="<%=request.getAttribute("activeLink")%>"/>
                </jsp:include>

                <%-- <script src="${pageContext.request.contextPath}/source/assets/michael/js/transition.js"></script>  --%> 

                <div class="layout-page"> 
                    <jsp:include page="navheader.jsp">
                        <jsp:param name="nom" value="<%=session.getAttribute("nom")%>"/>
                        <jsp:param name="id" value="<%=session.getAttribute("id")%>"/>
                        <jsp:param name="photo" value="<%=session.getAttribute("photo")%>"/>
                    </jsp:include> 
                    <div class="content-wrapper">
                        <div class="container-xxl flex-grow-1 container-p-y">
                            <div id="accordionIcon" class="accordion mt-3 accordion-without-arrow">
                                <div class="card accordion-item">
                                    <h2 class="accordion-header" id="headingTwo">
                                        <button type="button" class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#accordionTwo" aria-expanded="false" aria-controls="accordionTwo" >
                                            <strong class="text fw-semibold"> Facture patient <%=nom%></strong>
                                        </button>
                                    </h2>
                                    <div id="accordionTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <div class="col-4">
                                                <form action="<%=request.getContextPath()%>/facture">
                                                    <div class="mb-0 row">
                                                        <div class="col-md-4">
                                                            <input name="nom" class="form-control" placeholder="Choisir patient à afficher" type="text">
                                                        </div>
                                                        <input value="filtrer"  type="submit" class="btn btn-secondary m-1" hidden>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <br>
                            <div class="row g-4">
                                <div class="col-12">

                                    <div class="card">

                                        <div class="table-responsive text-nowrap">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Annee</th>
                                                        <th scope="col">Vente</th>
                                                        <th scope="col">Achat</th>
                                                        <th scope="col">Commission</th>
                                                        <th scope="col">Perte</th>
                                                        <th scope="col">Benefice</th>
                                                        <th scope="col">TOTAL</th>
                                                    </tr>
                                                </thead>
                                                <%    for (int i = 1; i <= 12; i++) {
                                                %>
                                                <tbody class="table">
                                                    <tr class="table-secondary" 
                                                        data-bs-toggle="offcanvas"
                                                        data-bs-target="#offcanvasScroll"
                                                        aria-controls="offcanvasScroll">

                                                        <%}%>
                                                      
                                                    </tr>                                        
                                                </tbody>
                                            </table>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <br><hr><br>
                            <div class="row">
                                <div class="col-lg-12 mb-4 order-0">
                                    <div class="row">
                                        <div class="col-lg-12 grid-margin stretch-card">
                                            <div class="card">
                                                <div class="card-body">
                                                    <h6 class="card-title">Statistique sur le benefice par année depuis 2019</h6>
                                                    <canvas id="areaChart" style="height: 250px;"></canvas>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>


                        </div>

                        <%@include file="footer.jsp" %>


                    </div>

                </div>
            </div>
        </div>

        <%@include file="footerscript.jsp" %>

        <script src="${pageContext.request.contextPath}/source/assets/michael/vendor/chart.js/Chart.min.js"></script>
    </body>

</html>

