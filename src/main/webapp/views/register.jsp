<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup | MyApp</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea, #764ba2);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .signup-container {
            background: #fff;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            background-image: url("${pageContext.request.contextPath}/static/images/hinh-nen-dep-96-scaled.jpg");
        }
        .signup-container h3 {
            text-align: center;
            margin-bottom: 1.5rem;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="signup-container">
        <h3>Sign Up for MyApp</h3>
        <form id="signupForm" action="${pageContext.request.contextPath}/register" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Sign Up</button>
            <% String message = (String) request.getAttribute("ResponseMessage"); %>
			<% if (message != null) { %>
			    <p style="color: red;"><%= message %></p>
			<% } %>
        </form>
        <p class="text-center mt-3">Already have an account? <a href="signin.html">Login here</a></p>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>