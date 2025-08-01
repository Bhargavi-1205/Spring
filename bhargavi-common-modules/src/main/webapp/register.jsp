<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        .error { color: red; }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/common-module/">
                <img src="https://www.x-workz.in/Logo.png" alt="xyz" height="50" class="d-inline-block align-text-top" />
            </a>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/common-module/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/bhargavi-common-modules/home/register">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/bhargavi-common-modules/login">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <h2 class="mb-4 text-center text-success">Register</h2>
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <form method="post" action="/bhargavi-common-modules/register/saveRegistration">
                    <div class="mb-3">
                        <label for="userName" class="form-label">Username</label>
                        <input type="text" class="form-control" id="userName" name="userName" required />
                    </div>
                    <div class="mb-3">
                        <label for="phoneNumber" class="form-label">Phone Number</label>
                        <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" pattern="[0-9]{10}"
                            onchange="CheckPhoneNumber()" required />
                        <span class="error" id="phoneNumberError"></span>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="email" name="email" required />
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password" required />
                    </div>
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required />
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary px-4">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script>
        function CheckPhoneNumber() {
            let pnum = document.getElementById("phoneNumber").value;
            console.log("CheckPhoneNumber", pnum);
            const req = new XMLHttpRequest();
           req.open("GET" ,"http://localhost:8080/bhargavi-common-modules/api/common/checkMobileNumber/"+pnum);
            req.send();
            req.onload = function() {
                document.getElementById("phoneNumberError").innerHTML = this.responseText;
            }
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>