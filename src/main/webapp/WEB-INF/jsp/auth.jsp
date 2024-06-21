<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="currentUrl" value="${pageContext.request.requestURL}" />
<!DOCTYPE html>
<html>
<head>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="../../assets/css/common.css"/>
    <title>spring app :p</title>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Kek app</a>
            <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarNav"
                    aria-controls="navbarNav"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item">
                        <a
                                class="nav-link disabled"
                                href="#"
                                tabindex="-1"
                                aria-disabled="true"
                        >Disabled</a
                        >
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</head>

<body>
<div class="container d-flex align-items-center justify-content-center">
    <div class="m-5 d-flex p-2 justify-content-md-center align-middle">
        <form action="${currentUrl}/register" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input
                        name="email"
                        type="email"
                        class="form-control"
                        id="exampleInputEmail1"
                        aria-describedby="emailHelp"
                        placeholder="Enter email"
                        required
                />
                <small id="emailHelp" class="form-text text-muted"
                >We'll never share your email with anyone else.</small
                >
            </div>
            <div class="form-group">
                <label for="inputLogin">Login</label>
                <input
                        name="login"
                        type="text"
                        class="form-control"
                        id="inputLogin"
                        placeholder="Enter Login"
                        minlength="4"
                        maxlength="10"
                        aria-describedby="loginHelp"
                        required
                />
                <small id="loginHelp" class="form-text text-muted"
                >login must be from 4 to 10 symbols</small
                >
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input
                        name="password"
                        type="password"
                        class="form-control"
                        id="exampleInputPassword1"
                        placeholder="Enter Password"
                        required
                />
            </div>
            <div class="form-check">
                <input
                        type="checkbox"
                        class="form-check-input"
                        id="exampleCheck1"
                />
                <label class="form-check-label" for="exampleCheck1"
                >Check me out</label
                >
            </div>
            <button type="submit" id="sign_up_btn" class="btn btn-primary">
                Sign Up
            </button>
        </form>
    </div>
</div>

<footer class="d-flex flex-wrap justify-content-center align-items-center py-3 my-5 border-top">
    <div class="col-md-4 d-flex align-items-center">
        <span class="mb-3 mb-md-0 text-muted">:PPPPP</span>
    </div>
</footer>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"
></script>
<script src="../../assets/js/main_page.js"></script>
</body>
</html>
