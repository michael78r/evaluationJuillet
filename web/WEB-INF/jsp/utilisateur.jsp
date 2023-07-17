<%-- 
    Document   : admin
    Created on : 18 juin 2023, 21:06:07
    Author     : P14A_77_Michael
--%>

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
                            <div class="card">
                                <div class="card-header-pills" style="margin-left: 10px; margin-top: 10px"> <h6>Evaluation Juillet</h6> 
                                </div>   
                            </div>


                        </div>

                        <%@include file="footer.jsp" %>


                    </div>

                </div>
            </div>
        </div>
        <%@include file="footerscript.jsp" %>

    </body>

</html>


