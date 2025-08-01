<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kamadhenu Dairy - Dashboard</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.tailwindcss.com"></script>

    <style>
        /* Base styles for the body, background image and overlay, consistent with other pages */
        body {
            background-image: url('https://source.unsplash.com/1600x900/?dairy,farm,dashboard');
            background-size: cover;
            background-attachment: fixed;
            background-position: center;
            font-family: 'Arial', sans-serif;
            color: #333;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            padding-top: 80px; /* IMPORTANT: Space for the fixed navbar to prevent content overlap */
        }
        /* Semi-transparent white overlay for better readability */
        body::before {
            content: '';
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(255, 255, 255, 0.7);
            z-index: -1;
        }

        /* Dashboard content container styles, similar to form-container */
        .dashboard-container {
            max-width: 90%; /* Increased max-width for better table display */
            margin: 0 auto;
            background-color: white;
            padding: 2.5rem;
            border-radius: 1rem;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
            flex-grow: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 2rem;
        }

        /* Profile section specific styling */
        .profile-table-card {
            background-color: #f9f9f9;
            padding: 2rem;
            border-radius: 0.75rem;
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
            width: 100%; /* Take full width of parent container */
        }

        /* Table specific styles for the profile data - HORIZONTAL FORMAT */
        .profile-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 1rem;
            border: 1px solid #cbd5e0; /* Overall table border */
        }

        .profile-table th,
        .profile-table td {
            padding: 0.75rem 1rem; /* Consistent padding */
            border: 1px solid #cbd5e0; /* Border for each cell */
            vertical-align: middle; /* Vertically align content in cells */
            text-align: center; /* Center align content in horizontal table cells */
        }

        .profile-table th {
            font-weight: 600; /* Semi-bold for labels */
            color: #555;
            background-color: #f0f4f8; /* Slightly different background for headers */
        }

        .profile-table td {
            color: #333;
            word-wrap: break-word; /* Ensure long words break */
        }

        .profile-table .icon-label {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
        }

        .profile-table .icon-label i {
            color: #28a745; /* Green icon */
            font-size: 1.25rem;
            line-height: 1;
        }

        /* Profile picture styling */
        .profile-picture {
            width: 120px;
            height: 120px;
            border-radius: 50%;
            object-fit: cover;
            border: 4px solid #28a745; /* Green border */
            margin-bottom: 1.5rem;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        /* Edit Photo button within table */
        .edit-photo-btn {
            background-color: #007bff; /* Bootstrap primary blue */
            color: white;
            padding: 0.4rem 0.8rem;
            border-radius: 0.3rem;
            font-size: 0.875rem;
            transition: background-color 0.2s;
            cursor: pointer;
            border: none;
            display: inline-flex;
            align-items: center;
            gap: 0.5rem;
        }
        .edit-photo-btn:hover {
            background-color: #0056b3;
        }


        /* --- Navbar Styling --- */
        .navbar {
            background-color: #28a745; /* Green for dairy theme */
            color: white;
            padding: 1rem 0;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1); /* Subtle shadow for depth */
        }

        .navbar-brand, .nav-link {
            color: white !important; /* !important to override Bootstrap's default */
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .navbar-brand {
            font-size: 1.8rem;
            text-shadow: 1px 1px 2px rgba(0,0,0,0.3);
            display: flex;
            align-items: center;
        }

        .navbar-brand img {
            height: 40px;
            margin-right: 10px;
            border-radius: 50%;
            border: 2px solid white;
        }

        .nav-link:hover {
            color: #ffc107 !important; /* Yellow on hover */
        }

        /* Style for buttons in Navbar */
        .navbar .btn-outline-light-custom {
            color: white;
            border-color: white;
            padding: 0.5rem 1rem;
            font-size: 0.9rem;
            border-radius: 25px; /* Pill shape */
            transition: all 0.3s ease;
            margin-left: 10px; /* Space between buttons */
        }

        .navbar .btn-outline-light-custom:hover {
            background-color: white;
            color: #28a745; /* Green text on hover */
        }

        /* Responsive Adjustments for Navbar */
        @media (max-width: 991.98px) {
             .navbar-brand {
                margin-right: auto;
            }
            .navbar-collapse {
                flex-grow: 1;
            }
        }

        @media (max-width: 576px) {
            .navbar-toggler {
                border-color: rgba(255,255,255,.5);
            }
            .navbar-toggler-icon {
                background-image: url("data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 30 30' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(255,255,255,.5)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E");
            }
        }

        /* --- Footer Styling --- */
        .footer {
            background-color: #343a40;
            color: white;
            padding: 40px 0;
            margin-top: auto;
            box-shadow: 0 -2px 5px rgba(0,0,0,0.1);
        }
        .footer h5 {
            color: #ffc107;
            margin-bottom: 20px;
        }
        .footer p, .footer li {
            font-size: 0.9rem;
            line-height: 1.6;
        }
        .footer a {
            color: #ffc107;
            text-decoration: none;
            transition: color 0.3s ease;
        }
        .footer a:hover {
            color: #e0a800;
        }
        .footer-logo-name {
            display: flex;
            align-items: center;
            justify-content: flex-start;
            margin-bottom: 1rem;
        }
        .footer-logo-name img {
            height: 50px;
            margin-right: 10px;
            border-radius: 50%; /* Rounded for consistency */
            border: 2px solid white; /* White border for logo */
            object-fit: cover;
        }
        .footer-logo-name h5 {
            margin-bottom: 0;
            font-size: 1.5rem;
            color: white;
            text-shadow: 1px 1px 2px rgba(0,0,0,0.3);
        }
        .footer-current-time {
            text-align: right;
            font-size: 0.9rem;
            color: #ffc107;
            font-family: 'Courier New', Courier, monospace;
        }
        .footer-nav-links {
            padding: 0;
            margin: 0;
            list-style: none;
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 25px;
            margin-bottom: 20px;
            font-size: 1.1rem;
        }
        .footer-nav-links li a {
            color: white;
            font-weight: bold;
        }
        .footer-nav-links li a:hover {
            color: #ffc107;
        }
        .footer .social-icons {
            margin-top: 15px;
            margin-bottom: 20px;
            display: flex;
            justify-content: center;
            gap: 20px;
        }
        .footer .social-icons a {
            font-size: 1.8rem;
            color: white;
            transition: color 0.3s ease, transform 0.3s ease;
        }
        .footer .social-icons a:hover {
            color: #ffc107;
            transform: scale(1.1);
        }
        .footer-copyright {
            width: 100%;
            text-align: center;
            margin-top: 20px;
            padding-top: 15px;
            border-top: 1px solid #495057;
            color: #adb5bd;
            font-size: 0.8rem;
        }

        /* Responsive adjustments */
        @media (max-width: 991.98px) {
             .navbar-brand { margin-right: auto; }
            .navbar-collapse { flex-grow: 1; }
        }
        @media (max-width: 768px) {
            .navbar-brand { font-size: 1.5rem; }
            .footer .row > div { margin-bottom: 20px; text-align: center; }
            .footer-logo-name { justify-content: center; }
            .footer-current-time { text-align: center; }
            .footer-nav-links { gap: 15px; font-size: 1rem; }
            .dashboard-container { padding: 1.5rem; }
        }
        @media (max-width: 576px) {
            .navbar-toggler { border-color: rgba(255,255,255,.5); }
            .navbar-toggler-icon { background-image: url("data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 30 30' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(255,255,255,.5)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E"); }
            .dashboard-container { margin-top: 1rem; }
            .profile-table th, .profile-table td {
                padding: 0.5rem 0.75rem;
            }
        }
        /* Custom button styling for dashboard actions */
        .dashboard-action-btn {
            background-color: #28a745; /* Green */
            color: white;
            padding: 12px 25px;
            border-radius: 50px;
            font-size: 1.1rem;
            font-weight: bold;
            transition: background-color 0.3s ease, transform 0.3s ease, box-shadow 0.3s ease;
            text-decoration: none;
            display: inline-block; /* Allows side-by-side display */
            margin: 10px; /* Space between buttons */
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        .dashboard-action-btn:hover {
            background-color: #218838; /* Darker green */
            transform: translateY(-3px);
            box-shadow: 0 6px 15px rgba(0,0,0,0.2);
            color: white; /* Ensure text remains white on hover */
            text-decoration: none; /* Keep text decoration off on hover */
        }
    </style>
</head>
<body class="text-gray-800">
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/'/>">
                <img src="https://play-lh.googleusercontent.com/UMwijH7tYOrEl-UV2xAhPTH4X6C8KRV8hSWdnQRytzTXl64DkIvHIZCirKhZrA38iMo" alt="Kamadhenu Dairy Logo">
                Kamadhenu Dairy
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <%-- Navbar buttons for Admin Dashboard --%>
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-light-custom" href="<c:url value='/redirectToHome'/>">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-light-custom" href="<c:url value='/redirectToRegisterUser'/>">Register User</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-light-custom" href="<c:url value='/redirectToViewUsers'/>">View Users</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-light-custom" href="<c:url value='/logout'/>">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container mx-auto py-10">
        <h2 class="text-4xl font-bold text-green-600 mb-10 text-center">Admin Dashboard</h2>
        <div class="dashboard-container">
            <h3 class="text-3xl font-bold text-gray-800 mb-8">My Profile</h3>

            <img id="adminProfilePicture" src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?q=80&w=2670&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                 alt="Admin Profile Picture"
                 class="profile-picture">

            <div class="profile-table-card">
                <table class="profile-table">
                    <thead>
                        <tr>
                            <th><div class="icon-label"><i class="fas fa-user"></i>Name:</div></th>
                            <th><div class="icon-label"><i class="fas fa-envelope"></i>Email:</div></th>
                            <th><div class="icon-label"><i class="fas fa-phone"></i>Phone:</div></th>
                            <th><div class="icon-label"><i class="fas fa-calendar-alt"></i>Date of Birth:</div></th>
                            <th><div class="icon-label"><i class="fas fa-id-card"></i>Admin ID:</div></th>
                            <th>Edit Profile Picture</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Bhargavi Raj</td>
                            <td>puttin2002@gmail.com</td>
                            <td>8296434761</td>
                            <td>12-05-2002</td>
                            <td>AD12345</td>
                            <td>
                                <button class="edit-photo-btn" onclick="document.getElementById('profilePictureInput').click();">
                                    <i class="fas fa-camera"></i> Edit Photo
                                </button>
                                <input type="file" id="profilePictureInput" accept="image/*" style="display: none;" onchange="handleProfilePictureChange(event);">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="mt-8 d-flex justify-content-center flex-wrap">
                <a href="<c:url value='/manageProducts'/>" class="dashboard-action-btn">
                    Manage Products
                </a>
                <a href="<c:url value='/redirectToRegisterUser'/>" class="dashboard-action-btn">
                    Register User
                </a>
                <a href="<c:url value='/redirectToViewUsers'/>" class="dashboard-action-btn">
                    View Users
                </a>
            </div>
        </div>
    </div>

    <footer class="footer">
        <div class="container">
            <div class="row align-items-start mb-4">
                <div class="col-md-6 col-sm-12 text-md-left text-center mb-md-0 mb-3">
                    <div class="footer-logo-name">
                        <img src="https://play-lh.googleusercontent.com/UMwijH7tYOrEl-UV2xAhPTH4X6C8KRV8hSWdnQRytzTXl64DkIvHIZCirKhZrA38iMo" alt="Kamadhenu Dairy Logo">
                        <h5>Kamadhenu Dairy</h5>
                    </div>
                </div>

                <div class="col-md-6 col-sm-12 text-md-right text-center mb-md-0 mb-3">
                    <h5 class="mb-3">Current Time (IST)</h5>
                    <p id="current-time" class="footer-current-time"></p>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-12 text-center">
                    <ul class="list-inline footer-nav-links">
                        <li class="list-inline-item"><a href="<c:url value='/'/>">Home</a></li>
                        <li class="list-inline-item"><a href="<c:url value='/#about'/>">About Us</a></li>
                        <li class="list-inline-item"><a href="<c:url value='/#products'/>">Our Products</a></li>
                        <li class="list-inline-item"><a href="<c:url value='/redirectToContact'/>">Contact Us</a></li>
                    </ul>
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-12 text-center">
                    <div class="social-icons">
                        <a href="#"><i class="fab fa-facebook-f"></i></a>
                        <a href="#"><i class="fab fa-twitter"></i></a>
                        <a href="#"><i class="fab fa-instagram"></i></a>
                        <a href="#"><i class="fab fa-youtube"></i></a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <p class="footer-copyright">© <span id="copyright-year"></span> Kamadhenu Dairy. All rights reserved.</p>
                </div>
            </div>
        </div>
    </footer>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            // --- Footer Time & Copyright ---
            function updateTime() {
                const now = new Date();
                const options = {
                    year: 'numeric', month: '2-digit', day: '2-digit',
                    hour: '2-digit', minute: '2-digit', second: '2-digit',
                    hour12: true, timeZone: 'Asia/Kolkata' // IST timezone for Bengaluru
                };
                document.getElementById('current-time').textContent = now.toLocaleString('en-IN', options);
            }
            setInterval(updateTime, 1000);
            updateTime();

            // --- Update Copyright Year for Footer ---
            document.getElementById('copyright-year').textContent = new Date().getFullYear();

            // --- Handle Profile Picture Change ---
            function handleProfilePictureChange(event) {
                const file = event.target.files[0];
                if (file) {
                    const reader = new FileReader();
                    reader.onload = function(e) {
                        // Update the displayed profile picture
                        document.getElementById('adminProfilePicture').src = e.target.result;
                        alert('New profile picture selected! In a real application, you would send this file to your server for storage.');
                        // IMPORTANT: In a real application, you would send 'file' to your server via AJAX/fetch here
                        /*
                        const formData = new FormData();
                        formData.append('profileImage', file);

                        fetch('/uploadProfilePicture', { // Replace with your actual server endpoint
                            method: 'POST',
                            body: formData
                        })
                        .then(response => response.json())
                        .then(data => {
                            if (data.success) {
                                console.log('Profile picture uploaded successfully:', data.imageUrl);
                                // Optionally, update the src with the URL returned by the server
                                // document.getElementById('adminProfilePicture').src = data.imageUrl;
                            } else {
                                console.error('Failed to upload picture:', data.message);
                            }
                        })
                        .catch(error => {
                            console.error('Error uploading profile picture:', error);
                        });
                        */
                    };
                    reader.readAsDataURL(file);
                }
            }

            // Make the handleProfilePictureChange function globally accessible
            window.handleProfilePictureChange = handleProfilePictureChange;
        });
    </script>
</body>
</html>