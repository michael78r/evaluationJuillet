
<%@page import="util.Utilitaire"%>
<%@page import="model.view.V_facture_devis"%>
<%@page import="model.model.Facture"%>
<%@page import="model.view.V_devis_acte"%>
<%@page import="model.model.Patient"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<%
    String nom = (String) request.getAttribute("nom");
    ArrayList<Patient> p = (ArrayList<Patient>) request.getAttribute("p");
     ArrayList<V_facture_devis> f = (ArrayList<V_facture_devis>) request.getAttribute("f");
    ArrayList<V_devis_acte> l = (ArrayList<V_devis_acte>) request.getAttribute("acte");
    Integer lastId = (Integer) request.getAttribute("lastID");
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
                        <jsp:param name="nom" value="<%=session.getAttribute("nomutilisateur")%>"/>
                        <jsp:param name="id" value="<%=session.getAttribute("idutilisateur")%>"/>
                        <jsp:param name="photo" value="<%=session.getAttribute("photoutilisateur")%>"/>
                    </jsp:include> 
                    <div class="content-wrapper">
                        <div class="container-xxl flex-grow-1 container-p-y">
                            <div id="accordionIcon" class="accordion mt-3 accordion-without-arrow">
                                <div class="card accordion-item">
                                    <h2 class="accordion-header" id="headingTwo">
                                        <button type="button" class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#accordionTwo" aria-expanded="false" aria-controls="accordionTwo" >
                                            <strong class="text fw-semibold"> Acte patient <%=nom%></strong>
                                        </button>
                                    </h2>
                                    <div id="accordionTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <div class="col-4">
                                                <form action="<%=request.getContextPath()%>/infopatient">
                                                    <div class="mb-0 row">
                                                        <div class="col-md-4">
                                                            <select name="nom" class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                                                <%for (int i = 0; i < p.size(); i++) {
                                                                %>
                                                                <option value="<%out.print(p.get(i).getId());%>"><%out.print(p.get(i).getNom());%></option>
                                                                <%}%>                                                            
                                                            </select>

                                                        </div>
                                                        <button style="width:5px" type="submit" class="btn rounded-pill btn-outline-primary border-0"  data-bs-toggle="modal" data-bs-target="#modalCenter">
                                                            <span class="bx bx-search"></span>
                                                        </button>
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
                                            <form action="<%=request.getContextPath()%>/facture">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">Nom Patient</th>
                                                            <th scope="col" style="text-align: right;">Date</th>
                                                            <th scope="col" style="text-align: right;">Prix</th>
                                                            <th scope="col" style="text-align: right;">Nom budget</th>

                                                        </tr>
                                                    </thead>
                                                    <%    for (int i = 0; i < l.size(); i++) {
                                                    %>
                                                    <tbody class="table">                                                
                                                        <tr class="table-info" >
                                                            <td> <%=l.get(i).getNompatient()%></td>
                                                            <td style="text-align: right;"> <%=Utilitaire.conversionDate(l.get(i).getDate())%></td>
                                                            <td style="text-align: right;"> <%=Utilitaire.alignement(l.get(i).getPrix())%></td>
                                                            <td style="text-align: right;"> <%=l.get(i).getNombudget()%></td>

                                                            <td> <input name="id" type="checkbox" value="<%=l.get(i).getId()%>"  />
                                                                <input name="nom" value="<%=l.get(i).getIdpatient()%>" hidden  />
                                                                <input name="num" value="<%=lastId%>" hidden /></td>

                                                            <%-- <td><a href="<%=request.getContextPath()%>/"><button type="button" class="btn rounded-pill btn-outline-secondary border-0" 
                                                                                                                 ><small class="text-light fw-semibold"> facturé</small></button></td> --%>

                                                            <%}%> 

                                                        </tr>                                        
                                                    </tbody>
                                                </table>
                                                <button type="submit" class="btn btn-secondary m-2">Export pdf (facturation)</button>
                                            </form>
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

                                                <div class="row g-4">
                                                    <div class="col-12">

                                                        <div class="card">

                                                            <div class="table-responsive text-nowrap">
                                                                <table class="table">
                                                                    <thead>
                                                                        <tr>
                                                                             <th scope="col">Date facturation</th>
                                                                            <th style="text-align: right;" scope="col">Nom Patient</th>
                                                                            <th style="text-align: right;" scope="col">Date</th>
                                                                            <th style="text-align: right;"  scope="col">Prix</th>
                                                                            <th  style="text-align: right;" scope="col">Nom budget</th>
                                                                            <th style="text-align: right;" scope="col">TOTAL</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <%    for (int i = 0; i < f.size(); i++) {
                                                                    %>
                                                                    <tbody class="table">
                                                                        <tr class="table-secondary" 
                                                                            data-bs-toggle="offcanvas"
                                                                            data-bs-target="#offcanvasScroll"
                                                                            aria-controls="offcanvasScroll">
                                                                            <td> <%=Utilitaire.conversionDate(f.get(i).getDatefacturation())%></td>
                                                                            <td style="text-align: right;"> <%=f.get(i).getNompatient()%></td>
                                                                            <td style="text-align: right;"> <%=Utilitaire.conversionDate(f.get(i).getDate())%></td>
                                                                            <td style="text-align: right;"> <%=Utilitaire.alignement(f.get(i).getPrix())%></td>
                                                                            <td style="text-align: right;"> <%=f.get(i).getNombudget()%></td>
                                                                            <td></td>
                                                                            <%}%>

                                                                        </tr>                                        
                                                                    </tbody>
                                                                </table>
                                                            </div>

                                                        </div>
                                                    </div>

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

