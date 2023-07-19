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
    ArrayList<Patient> p = (ArrayList<Patient>) request.getAttribute("p");
    ArrayList<Budget> la = (ArrayList<Budget>) request.getAttribute("acte");
    ArrayList<Budget> ld = (ArrayList<Budget>) request.getAttribute("depense");
    ArrayList<V_devis_acte> lva = (ArrayList<V_devis_acte>) request.getAttribute("v_acte");
    ArrayList<V_devis_depense> lvd = (ArrayList<V_devis_depense>) request.getAttribute("v_depense");

    String[] table1 = Utilitaire.get2(lva.size());
    String[] table2 = Utilitaire.get2(lvd.size());

%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>


    <body class="fade-in">
        <div class="layout-wrapper layout-content-navbar">
            <div class="layout-container">
                <jsp:include page="asideutilisateur.jsp">
                    <jsp:param name="activeLink" value="<%=request.getAttribute("activeLink")%>"/>
                </jsp:include>
                <div class="layout-page"> 
                    <jsp:include page="navheader.jsp">
                        <jsp:param name="nom" value="<%=session.getAttribute("nomutilisateur")%>"/>
                        <jsp:param name="id" value="<%=session.getAttribute("idutilisateur")%>"/>
                        <jsp:param name="photo" value="<%=session.getAttribute("photoutilisateur")%>"/>
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
                                            <div class="modal-body">

                                                <form action="<%=request.getContextPath()%>/functionsetDevis" >
                                                    <div class="row g-2">
                                                        <div class="form-floating mb-3">
                                                            <select name="type"  class="form-select" id="categorie" aria-label="Floating label select example" onchange="select()">
                                                                <option value="0" selected>ACTE</option>    
                                                                <option value="1">DEPENSE</option>  
                                                            </select>
                                                            <label for="floatingSelect">veuillez inserer type budget :</label>
                                                        </div>


                                                    </div>
                                                    <%--acte--%>
                                                    <div class="row g-2" id="ac" style="">
                                                        <div class="col mb-0">
                                                            <div class="form-floating mb-3">
                                                                <select name="acte" class="form-select" id="floatingSelect" aria-label="Floating label select example"   >
                                                                    <%for (int i = 0; i < la.size(); i++) {
                                                                    %>
                                                                    <option value="<%out.print(la.get(i).getId());%>"><%out.print(la.get(i).getNom());%></option>
                                                                    <%}%>
                                                                </select>
                                                                <label for="floatingSelect">Acte :</label>
                                                            </div></div>
                                                        <div class="col mb-0">

                                                            <div class="form-floating mb-3">
                                                                <select name="idpatient" class="form-select" id="floatingSelect" aria-label="Floating label select example" >
                                                                    <%for (int i = 0; i < p.size(); i++) {
                                                                    %>
                                                                    <option value="<%out.print(p.get(i).getId());%>"><%out.print(p.get(i).getNom());%></option>
                                                                    <%}%>                                                                 
                                                                </select>
                                                                <label for="floatingSelect">Patient :</label>
                                                            </div>
                                                        </div>
                                                    </div>


                                                    <%--depense--%>
                                                    <div class="form-floating mb-3"  data-category="1" id="dep" style="display: none;">
                                                        <select name="depense" class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                                            <%for (int i = 0; i < ld.size(); i++) {
                                                            %>
                                                            <option value="<%out.print(ld.get(i).getId());%>"><%out.print(ld.get(i).getNom());%></option>
                                                            <%}%>                                                            
                                                        </select>
                                                        <label for="floatingSelect">Depense :</label>
                                                    </div>




                                                    <div class="row g-2">
                                                        <div class="mb-3 row">
                                                            <label for="html5-text-input" class="col-md-3 col-form-label" >Date devis</label>
                                                            <div class="col-md-9">
                                                                <input class="form-control" type="date" placeholder="inserer date" name="date" id="html5-text-input"/>
                                                            </div>
                                                        </div>
                                                        <div class="mb-3 row">
                                                            <label for="html5-text-input" class="col-md-3 col-form-label" >Prix devis</label>
                                                            <div class="col-md-9">
                                                                <input class="form-control" type="number" placeholder="prix" name="prix" id="html5-text-input" />
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <br><br><br> <small class="text-light fw-semibold">  Verifiez les données avant de terminer</small>   
                                                        <br><br><br> 
                                                        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                                                            Fermer
                                                        </button>
                                                        <button type="submit" class="btn btn-primary">Ajouter</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-responsive text-nowrap">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">NomBudget</th>

                                                <th scope="col">Date</th>
                                                <th style="text-align: right;" scope="col">Prix</th>
                                                <th style="text-align: right;" scope="col">NomPatient</th>
                                                <th style="text-align: right;" scope="col">TypeBudget</th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-border-bottom-0">
                                            <%for (int i = 0; i < lva.size(); i++) {
                                            %>
                                            <tr class="table-<%out.println(table1[i]);%>">
                                                <td><i class="fab fa-sketch fa-lg text-warning me-3"> </i><strong><%=lva.get(i).getNombudget()%></strong></td>
                                                <td> <%=Utilitaire.conversionDate(lva.get(i).getDate())%></td>
                                                <td style="text-align: right;"> <%=Utilitaire.alignement(lva.get(i).getPrix())%></td>
                                                <td style="text-align: right;"><i class="fab fa-sketch fa-lg text-warning me-3"><a href="<%= request.getContextPath()%>/benefice?idspectacle=<%= lva.get(i).getId()%>"> <%=lva.get(i).getNompatient()%></a></i></td>


                                                <td style="text-align: right;"><%if (lva.get(i).getType() == 0) {%>
                                                    <span class="badge bg-label-success me-1"><strong>ACTE</strong></span> 
                                                    <%   } else { %>
                                                    <span class="badge bg-label-warning me-1"><strong>DEPENSE</strong></span> 
                                                    <% }%>
                                                </td>

                                                <%-- <td><span class="badge bg-label-primary me-1">active</span></td> --%>

                                                <td>
                                                    <div class="dropdown">
                                                        <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                                            <i class="bx bx-dots-vertical-rounded"></i>
                                                        </button>
                                                        <div class="dropdown-menu">                                              
                                                            <a class="dropdown-item" href="<%=request.getContextPath()%>/functiondeleteDevis?id=<%=lva.get(i).getId()%>"><i class="bx bx-trash me-1"></i> Supprimer</a>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>

                                    </table>

                                </div>


                                <div class="table-responsive text-nowrap">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">NomBudget</th>

                                                <th scope="col">Date</th>
                                                <th scope="col"  style="text-align: right;">Prix</th>
                                                <th scope="col"  style="text-align: right;">TypeBudget</th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-border-bottom-0">
                                            <%for (int i = 0; i < lvd.size(); i++) {
                                            %>
                                            <tr class="table-<%out.println(table2[i]);%>">
                                                <td><i class="fab fa-sketch fa-lg text-warning me-3"> </i><strong><%=lvd.get(i).getNombudget()%></strong></td>
                                                <td> <%=Utilitaire.conversionDate(lvd.get(i).getDate())%></td>
                                                <td  style="text-align: right;"> <%=Utilitaire.alignement(lvd.get(i).getPrix())%></td>

                                                <td  style="text-align: right;"><%if (lvd.get(i).getType() == 0) {%>
                                                    <span class="badge bg-label-success me-1"><strong>ACTE</strong></span> 
                                                    <%   } else { %>
                                                    <span class="badge bg-label-warning me-1"><strong>DEPENSE</strong></span> 
                                                    <% }%>
                                                </td>

                                                <%-- <td><span class="badge bg-label-primary me-1">active</span></td> --%>

                                                <td>
                                                    <div class="dropdown">
                                                        <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                                            <i class="bx bx-dots-vertical-rounded"></i>
                                                        </button>
                                                        <div class="dropdown-menu">                                              
                                                            <a class="dropdown-item" href="<%=request.getContextPath()%>/functiondeleteDevis?id=<%=lvd.get(i).getId()%>"><i class="bx bx-trash me-1"></i> Supprimer</a>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>

                                    </table>

                                </div>

                                <div class="card">                                  
                                    <form action="<%=request.getContextPath()%>/functionImporterCsv" >
                                    <div class="card-body">
                                            <label for="formFileDisabled" class="form-label">Import csv</label>
                                            <input name="csvFile" class="form-control" type="file" id="formFileDisabled" required/>
                                        <button type="submit" class="btn btn-secondary m-2">import csv (insertion depense)</button>
                                    </div>                                   
                                    </form>
                                </div>
                            </div>
                        </div>
                        <%@include file="footer.jsp" %>
                        <script>
                            function select() {
                                if (document.getElementById('categorie').value == '0')
                                {
                                    document.getElementById('dep').style.display = 'none';
                                    document.getElementById('ac').style.display = '';
                                } else if (document.getElementById('categorie').value == '1')
                                {
                                    document.getElementById('ac').style.display = 'none';
                                    document.getElementById('dep').style.display = 'block';
                                }
                            }
                        </script>
                        <div class="content-backdrop fade"></div>
                    </div>

                </div>
            </div>
        </div>

        <%@include file="footerscript.jsp" %>
    </body>


</html>
