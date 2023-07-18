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
    ArrayList<Budget> ld = (ArrayList<Budget>) request.getAttribute("depense");
    //ArrayList<Budget> l = (ArrayList<Budget>) request.getAttribute("lb");
    //String[] table = Utilitaire.get2(l.size());

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
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <h5 class="card-header">Pour faciliter la saisie des dépenses, créer le formulaire suivant qui permet de 
                                        saisir un type de dépense sur plusieurs mois
                                    </h5>
                                    <!-- Checkboxes and Radios -->
                                    <form action="<%=request.getContextPath()%>/functionsetdepense" >
                                        <div class="card-body">
                                            <div class="col mb-0">
                                                <div class="form-floating mb-3">
                                                    <select name="nom" class="form-select" id="floatingSelect" aria-label="Floating label select example"   >
                                                        <%for (int i = 0; i < ld.size(); i++) {
                                                        %>
                                                        <option value="<%out.print(ld.get(i).getId());%>"><%out.print(ld.get(i).getNom());%></option>
                                                        <%}%>
                                                    </select>
                                                    <label for="floatingSelect">Acte :</label>
                                                </div></div>
                                            <div class="mb-3 row">
                                                <label for="html5-text-input" class="col-md-3 col-form-label" >Jour</label>
                                                <div class="col-md-9">
                                                    <input class="form-control" type="number" placeholder="jour" name="jour" id="html5-text-input" />
                                                </div>
                                            </div>
                                            <div class="row gy-3">
                                                <div class="col-md">
                                                    <label for="html5-text-input" class="col-md-3 col-form-label" >Mois</label>
                                                    <% for (int i = 1; i <= 12; i++) {%>
                                                    <div class="form-check mt-3">
                                                        <input class="form-check-input" name = "mois" type="checkbox" value="<%=i%>" id="defaultCheck1" />
                                                        <label class="form-check-label" for="defaultCheck1"> <%=Utilitaire.getMois(i)%> </label>
                                                    </div>
                                                    <%  }%>

                                                </div>

                                            </div>
                                            <div class="mb-3 row">
                                                <label for="html5-text-input" class="col-md-3 col-form-label" >Annee</label>
                                                <div class="col-md-9">
                                                    <input class="form-control" type="text" placeholder="annee" name="annee" id="html5-text-input" />
                                                </div>
                                            </div>

                                            <div class="mb-3 row">
                                                <label for="html5-text-input" class="col-md-3 col-form-label" >Montant</label>
                                                <div class="col-md-9">
                                                    <input class="form-control" type="text" placeholder="montant" name="prix" id="html5-text-input" />
                                                </div>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-secondary m-2">Inserer</button>
                                    </form>
                                    <hr class="m-0" />
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
