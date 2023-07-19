<%-- 
    Document   : listespectacle
    Created on : 19 juin 2023, 22:14:53
    Author     : P14A_77_Michael
--%>



<%@page import="java.math.BigDecimal"%>
<%@page import="model.view.V_recette_total"%>
<%@page import="model.view.V_depense_total"%>
<%@page import="model.view.V_depense"%>
<%@page import="model.view.V_recette"%>
<%@page import="model.view.V_devis_depense"%>
<%@page import="model.view.V_devis_acte"%>
<%@page import="model.model.Devis"%>
<%@page import="model.model.Budget"%>
<%@page import="model.model.Patient"%>
<%@page import="util.Utilitaire"%>
<%@page import="java.util.ArrayList"%>


<%
    ArrayList<V_recette> lva = (ArrayList<V_recette>) request.getAttribute("r");
    ArrayList<V_depense> lvd = (ArrayList<V_depense>) request.getAttribute("d");
    V_recette_total tr = (V_recette_total) request.getAttribute("tr");
    V_depense_total td = (V_depense_total) request.getAttribute("td");
    BigDecimal br = (BigDecimal) request.getAttribute("br");
    BigDecimal bb = (BigDecimal) request.getAttribute("bb");
    BigDecimal rea = (BigDecimal) request.getAttribute("rea");
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

                            <div id="accordionIcon" class="accordion mt-3 accordion-without-arrow">
                                <div class="card accordion-item">
                                    <h2 class="accordion-header" id="headingTwo">
                                        <button type="button" class="accordion-button collapsed" data-bs-toggle="collapse" data-bs-target="#accordionTwo" aria-expanded="false" aria-controls="accordionTwo" >
                                            <strong class="text fw-semibold"> Benefice</strong>
                                        </button>
                                    </h2>
                                    <div id="accordionTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <div class="col-4">
                                                <form action="<%=request.getContextPath()%>/tableaudebord">
                                                    <div class="mb-0 row">
                                                        <div class="mb-3 row">
                                                            <label for="html5-text-input" class="col-md-3 col-form-label" >Année</label>
                                                            <div class="col-md-9">
                                                                <input class="form-control" type="text" placeholder="filtrer annee" name="annee" id="html5-text-input" />
                                                            </div>
                                                            <label for="html5-text-input" class="col-md-3 col-form-label" >Mois</label>
                                                            <div class="col-md-9">
                                                                <input class="form-control" type="text" placeholder="filtrer mois" name="mois" id="html5-text-input" />
                                                            </div>
                                                            <button style="width:5px" type="submit" class="btn rounded-pill btn-outline-primary border-0"  data-bs-toggle="modal" data-bs-target="#modalCenter">
                                                                <span class="bx bx-search">Filtrer</span>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <br>
                            <%--<div class="row g-4">--%>
                            <div class="card">
                                <h5 class="card-header"><%if (lva.size() > 0) {
                                        out.println(Utilitaire.getMois(lva.get(0).getMois()) + " " + lva.get(0).getAnnee());
                                    } else {
                                        out.println("Benefice");
                                    }%>
                                </h5>  

                                <div class="table-responsive text-nowrap">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">NomBudget</th>
                                                <th style="text-align: right;">Reel</th>
                                                <th style="text-align: right;">Budget</th>                                              
                                                <th style="text-align: right;">Realisation</th>

                                            </tr>
                                        </thead>
                                        <tbody class="table-border-bottom-0">
                                            <%for (int i = 0; i < lva.size(); i++) {
                                            %>
                                            <tr class="table-secondary">
                                                <td> <%=lva.get(i).getNombudget()%></td>
                                                <td style="text-align: right;"> <%=Utilitaire.alignement(lva.get(i).getPrix())%></td>
                                                <td style="text-align: right;"> <%=Utilitaire.alignement(lva.get(i).getPrixannuel())%></td>                                       

                                                <td style="text-align: right;"> <%=lva.get(i).getRealisation()%></td>

                                                <%}%>
                                        </tbody>

                                    </table>

                                </div>


                                <div class="table-responsive text-nowrap">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">NomBudget</th>
                                                <th style="text-align: right;">Reel</th>
                                                <th style="text-align: right;">Budget</th>                                              
                                                <th style="text-align: right;">Realisation</th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-border-bottom-0">
                                            <%for (int i = 0; i < lvd.size(); i++) {
                                            %>
                                            <tr class="table-secondary">
                                                <td > <%=lvd.get(i).getNombudget()%></td>
                                                <td style="text-align: right;"> <%=Utilitaire.alignement(lvd.get(i).getPrix())%></td>
                                                <td style="text-align: right;"> <%=Utilitaire.alignement(lvd.get(i).getPrixannuel())%></td>
                                                <td style="text-align: right;"><%=lvd.get(i).getRealisation()%></td>
                                            </tr>
                                            <%}%>
                                        </tbody>

                                    </table>

                                </div>




                                <div class="table-responsive text-nowrap">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th style="text-align: right;">Reel</th>
                                                <th style="text-align: right;">Budget</th>                                              
                                                <th style="text-align: right;">Realisation</th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-border-bottom-0">
                                            <tr class="table-secondary">
                                                <td>Recette</td>
                                                <td style="text-align: right;"> <%= Utilitaire.alignement(tr.getSprix())%></td>
                                                <td style="text-align: right;"> <%= Utilitaire.alignement(tr.getSprixannuel())%></td>
                                                <td style="text-align: right;"> <%= tr.getSr()%></td>
                                            </tr>
                                            <tr class="table-secondary">
                                                <td>Depense</td>
                                                <td style="text-align: right;"> <%= Utilitaire.alignement(td.getSprix())%></td>
                                                <td style="text-align: right;"> <%= Utilitaire.alignement(td.getSprixannuel())%></td>
                                                <td style="text-align: right;"> <%= td.getSr()%></td>
                                            </tr>
                                            <tr class="table-secondary">
                                                <td><strong>TOTAL </strong></td>
                                                <td style="text-align: right;"> <%= Utilitaire.alignement(br)%></td>
                                                <td style="text-align: right;"> <%= Utilitaire.alignement(bb)%></td>
                                                <td style="text-align: right;"><%= rea%></td>
                                            </tr>
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
