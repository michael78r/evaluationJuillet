<%-- 
    Document   : listespectacle
    Created on : 19 juin 2023, 22:14:53
    Author     : P14A_77_Michael
--%>



<%@page import="model.view.V_devis_depense"%>
<%@page import="model.view.V_devis_acte"%>
<%@page import="model.model.Devis"%>
<%@page import="model.model.Budget"%>
<%@page import="model.model.Patient"%>
<%@page import="util.Utilitaire"%>
<%@page import="java.util.ArrayList"%>


<%
    ArrayList<V_devis_acte> lva = (ArrayList<V_devis_acte>) request.getAttribute("acte");
    ArrayList<V_devis_depense> lvd = (ArrayList<V_devis_depense>) request.getAttribute("depense");

    //String[] table1 = Utilitaire.get2(lva.size());
    //String[] table2 = Utilitaire.get2(lvd.size());

%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>


    <body class="fade-in">
        <div class="layout-wrapper layout-content-navbar">
            <div class="layout-container">
                <jsp:include page="asideadmin.jsp">
                    <jsp:param name="activeLink" value="<%=request.getAttribute("activeLink")%>"/>
                </jsp:include>
                <div class="layout-page"> 
                    <jsp:include page="navheader.jsp">
                        <jsp:param name="nom" value="<%=session.getAttribute("nom")%>"/>
                        <jsp:param name="id" value="<%=session.getAttribute("id")%>"/>
                        <jsp:param name="photo" value="<%=session.getAttribute("photo")%>"/>
                    </jsp:include>        

                    <div class="content-wrapper">
                        <div class="container-xxl flex-grow-1 container-p-y">
                            <br>
                            <%--<div class="row g-4">--%>
                            <div class="card">
                                <h5 class="card-header">Acte et Depense
                                    <button type="button" class="btn rounded-pill btn-outline-secondary"  data-bs-toggle="modal" data-bs-target="#modalCenter">
                                        <span class="bx bx-plus"></span> ajouter
                                    </button>
                                </h5>   

                                <!-- Modal -->
                                <div class="modal fade" id="modalCenter" tabindex="-1" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="modalCenterTitle">Ajouter acte et depense</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                       
                                        </div>
                                    </div>
                                </div>
                                <div class="table-responsive text-nowrap">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Mois</th>
                                                <th scope="col">Montant</th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-border-bottom-0">
                                            <%for (int i = 0; i < lva.size(); i++) {
                                            %>
                                            <tr class="table-secondary">
                                                <td> <%=Utilitaire.getMois(lva.get(i).getMois())%></td>
                                                <td> <%=lva.get(i).getPrix()%></td>
                                            <%}%>
                                        </tbody>

                                    </table>

                                </div>


                                <div class="table-responsive text-nowrap">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Mois</th>
                                                <th scope="col">Montant</th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-border-bottom-0">
                                            <%for (int i = 0; i < lvd.size(); i++) {
                                            %>
                                            <tr class="table-secondary">
                                                <td> <%=Utilitaire.getMois(lvd.get(i).getMois())%></td>
                                                <td> <%=lvd.get(i).getPrix()%></td>
                                            </tr>
                                            <%}%>
                                        </tbody>

                                    </table>

                                </div>
                            </div>
                        </div>
                        <%@include file="footer.jsp" %>
                        <div class="content-backdrop fade"></div>
                    </div>

                </div>
            </div>
        </div>

        <%@include file="footerscript.jsp" %>
    </body>


</html>
