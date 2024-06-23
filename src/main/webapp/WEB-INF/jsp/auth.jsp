<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<c:set var="currentUrl" value="${pageContext.request.requestURL}"/>
<!DOCTYPE html>
<html>
<t:header pageTitle="spring app :p"/>
<body>
<div class="container d-flex align-items-center justify-content-center">
    <div class="m-5 d-flex p-2 justify-content-md-center align-middle">
        <form action="${currentUrl}/register" method="post" id="register_form">
            <div class="form-group">
                <label for="inputEmail">Email address</label>
                <input
                        name="email"
                        type="email"
                        class="form-control"
                        id="inputEmail"
                        aria-describedby="emailHelp"
                        placeholder="Enter email"
                        required
                />
                <small id="emailHelp" class="form-text text-muted"
                >We'll never share your email with anyone else.</small
                >
            </div>

            <div class="form-group">
                <label for="inputPassword">Password</label>
                <input
                        name="password"
                        type="password"
                        class="form-control"
                        id="inputPassword"
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
            <button type="button" id="sign_up_btn" class="btn btn-primary">
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
<script src="../../assets/js/auth_page.js"></script>
</body>
</html>
