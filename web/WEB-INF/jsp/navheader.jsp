<%-- 
    Document   : navheaderadmin
    Created on : 18 juin 2023, 21:16:53
    Author     : P14A_77_Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
if (${param.nom} == null){
    response.sendRedirect("michael");
}
        
        
<c:if test="${empty param.nom}">
     <p>Le paramètre "nom" est null ou vide</p>
    <script>window.location.href = "/UpdateEvaluationMay/";</script>
</c:if>
--%>
<!DOCTYPE html>
<nav class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme">
    <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
        <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
            <i class="bx bx-menu bx-sm"></i>
        </a>
    </div>

    <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
        <!-- Search -->
        <div class="navbar-nav align-items-center">
            <div class="nav-item d-flex align-items-center">


                <i class="bx bx-search fs-4 lh-0"></i>

                <input
                    type="text"
                    class="form-control border-0 shadow-none"
                    placeholder="recherche...."
                    aria-label="Filtre ou recherche..."
                    />


            </div>
        </div>

        <ul class="navbar-nav flex-row align-items-center ms-auto">

            <li class="nav-item navbar-dropdown dropdown-user dropdown">
                <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);" data-bs-toggle="dropdown">
                    <div class="avatar avatar-online">
                        <img src="${pageContext.request.contextPath}/source/assets/michael/img/avatars/${param.photo}" alt class="w-px-40 h-auto rounded-circle" />
                    </div>
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li>
                        <a class="dropdown-item" href="#">
                            <div class="d-flex">
                                <div class="flex-shrink-0 me-3">
                                    <div class="avatar avatar-online">
                                        <img src="${pageContext.request.contextPath}/source/assets/michael/img/avatars/${param.photo}" alt class="w-px-40 h-auto rounded-circle" />
                                    </div>
                                </div>
                                <div class="flex-grow-1">
                                    <span class="fw-semibold d-block">${param.nom}</span>
                                    <small class="text-muted">${param.id}</small>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <div class="dropdown-divider"></div>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">
                            <i class="bx bx-user me-2"></i>
                            <span class="align-middle">Mon Profil</span>
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">
                            <span class="d-flex align-items-center align-middle">
                                <i class="flex-shrink-0 bx bx-credit-card me-2"></i>
                                <span class="flex-grow-1 align-middle">Notification</span>
                                <span class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20">99</span>
                            </span>
                        </a>
                    </li>
                    <li>
                        <div class="dropdown-divider"></div>
                    </li>

                    <li>
                        <a class="dropdown-item" href="<%=request.getContextPath()%>/deconexion">
                            <i class="bx bx-power-off me-2"></i>
                            <span class="align-middle">Deconnecter</span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

