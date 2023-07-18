<!DOCTYPE html>

<%//@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

                            <div class="row">
                                <div class="col-lg-12 mb-4 order-0">
                                    <div class="card">
                                        <div class="d-flex align-items-end row">
                                            <div class="col-sm-12">
                                                <div class="card-body">
                                                    <strong>Exception: </strong><%=request.getAttribute("erreur")%>
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
    </body>

</html>

