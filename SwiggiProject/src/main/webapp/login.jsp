<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Login - Swiggy Clone</title>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-image:
		url('https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=1950&q=80');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	min-height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
}

.login-container {
	background: rgba(255, 255, 255, 0.95);
	padding: 3rem 4rem;
	border-radius: 25px;
	box-shadow: 0 12px 35px rgba(252, 128, 25, 0.35);
	max-width: 650px; /* Increased from 500px */
	width: 100%;
	text-align: center;
	margin: 60px auto;
}

.login-container input[type="text"], .login-container input[type="password"],
	.login-container input[type="email"] {
	width: 100%;
	padding: 12px 15px;
	margin: 12px 0;
	border: 1px solid #ccc;
	border-radius: 8px;
	font-size: 16px;
	box-sizing: border-box;
	transition: border-color 0.3s ease;
}

.login-container input:focus {
	border-color: #fc8019;
	outline: none;
	box-shadow: 0 0 8px rgba(252, 128, 25, 0.3);
}

.login-nav {
	display: flex;
	justify-content: space-around;
	margin-bottom: 20px;
}

.login-nav a {
	text-decoration: none;
	color: #333;
	font-size: 13px;
	font-weight: 600;
	display: flex;
	flex-direction: column;
	align-items: center;
	gap: 4px;
}

.login-nav a:hover {
	color: #fc8019;
}

.login-nav img {
	width: 28px;
	height: 28px;
}

h1 {
	color: #fc8019;
	margin-bottom: 1.5rem;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px 15px;
	margin-bottom: 15px;
	border-radius: 25px;
	border: 2px solid #fc8019;
	font-size: 14px;
}

button {
	background-color: #fc8019;
	color: white;
	font-weight: bold;
	padding: 10px 20px;
	border-radius: 25px;
	border: none;
	cursor: pointer;
	font-size: 16px;
	margin-top: 10px;
	width: 100%;
}

button:hover {
	background-color: #e06f0f;
}

.register-link {
	margin-top: 1rem;
	font-size: 0.9rem;
}

.register-link a {
	color: #fc8019;
	text-decoration: none;
}

.register-link a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>

	<div class="login-container">
		<!-- Embedded Navbar in Card -->
		<div class="login-nav">
			<a href="first"> <img
				src="https://img.icons8.com/ios-filled/50/home.png" alt="Home" />
				Home
			</a> <a href="all-menus"> <img
				src="https://img.icons8.com/ios-filled/50/menu.png" alt="Menu" />
				Menu
			</a> <a href="cart?action=view"> <img
				src="https://img.icons8.com/ios-filled/50/shopping-cart.png"
				alt="Cart" /> Cart
			</a>
		</div>

		<h1>Login to Swiggy</h1>

		<form action="LoginServlet" method="post">
			<input type="text" name="usernameOrEmail"
				placeholder="Username or Email" required /> <input type="password"
				name="password" placeholder="Password" required />
			<button type="submit">Login</button>
		</form>

		<div class="register-link">
			Don't have an account? <a href="registration.jsp">Register</a>
		</div>
	</div>

</body>
</html>
