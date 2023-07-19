<%-- 
    Document   : listespectacle
    Created on : 19 juin 2023, 22:14:53
    Author     : P14A_77_Michael
--%>



<%@page import="model.model.Budget"%>
<%@page import="model.model.Patient"%>
<%@page import="util.Utilitaire"%>
<%@page import="java.util.ArrayList"%>


<%
    ArrayList<Budget> l = (ArrayList<Budget>) request.getAttribute("lb");
    String[] table = Utilitaire.get2(l.size());

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
                                <h5 class="card-header">Lieu
                                    <button type="button" class="btn rounded-pill btn-outline-secondary"  data-bs-toggle="modal" data-bs-target="#modalCenter">
                                        <span class="bx bx-plus"></span> ajouter
                                    </button>
                                </h5>   

                                <!-- Modal -->
                                <div class="modal fade" id="modalCenter" tabindex="-1" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="modalCenterTitle">Ajouter lieu</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">

                                                <form action="<%=request.getContextPath()%>/functionsetBudget" >
                                                    <div class="row g-2">
                                                        <div class="mb-3 row">
                                                            <label for="html5-text-input" class="col-md-3 col-form-label" >Nom budget</label>
                                                            <div class="col-md-9">
                                                                <input class="form-control" type="text" placeholder="nom" name="nom" id="html5-text-input" />
                                                            </div>
                                                        </div>
                                                        <div class="mb-3 row">
                                                            <label for="html5-text-input" class="col-md-3 col-form-label" >Prix annuel</label>
                                                            <div class="col-md-9">
                                                                <input class="form-control" type="number" placeholder="prix annuel" name="prix" id="html5-text-input" />
                                                            </div>
                                                        </div>
                                                        <div class="mb-3 row">
                                                            <label for="html5-text-input" class="col-md-3 col-form-label" >Code</label>
                                                            <div class="col-md-9">
                                                                <input class="form-control" type="text" placeholder="code avec 3 lettres" name="code" id="html5-text-input" />
                                                            </div>
                                                        </div>
                                                        <div class="form-floating mb-3">
                                                            <select name="type" class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                                                <option selected>Type budget</option>
                                                                <option value="0">ACTE</option>
                                                                <option value="1">DEPENSE</option>


                                                            </select>
                                                            <label for="floatingSelect">TYPE BUDGET :</label>
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
                                                <th scope="col">Nom</th>
                                                <th scope="col"  style="text-align: right;">Prix annuel</th>
                                                <th scope="col"  style="text-align: right;">Type budget</th>
                                                <th scope="col"  style="text-align: right;">Code</th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-border-bottom-0">
                                            <%for (int i = 0; i < l.size(); i++) {
                                            %>
                                            <tr class="table-<%out.println(table[i]);%>">
                                                <td><i class="fab fa-sketch fa-lg text-warning me-3"></i> <strong><%=l.get(i).getNom()%></strong></td>
                                                <td  style="text-align: right;"><%=Utilitaire.alignement(l.get(i).getPrix())%></td>
                                                <td  style="text-align: right;"><%if (l.get(i).getType() == 0) {%>
                                                    <span class="badge bg-label-success me-1"><strong>ACTE</strong></span> 
                                                    <%   } else { %>
                                                    <span class="badge bg-label-warning me-1"><strong>DEPENSE</strong></span> 
                                                    <% }%>
                                                </td>
                                                <td  style="text-align: right;"><%=l.get(i).getCode()%></td>

                                                <%-- <td><span class="badge bg-label-primary me-1">active</span></td> --%>

                                                <td>
                                                    <div class="dropdown">
                                                        <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                                            <i class="bx bx-dots-vertical-rounded"></i>
                                                        </button>
                                                        <div class="dropdown-menu">                                              
                                                            <a class="dropdown-item" href="<%=request.getContextPath()%>/functiondeleteBudget?id=<%=l.get(i).getId()%>"><i class="bx bx-trash me-1"></i> Supprimer</a>
                                                        </div>
                                                    </div>
                                                </td>
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
