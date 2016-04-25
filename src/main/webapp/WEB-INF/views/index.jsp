<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<h1>Welcome to Qask</h1>
<title>Sign-Up/Login Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js">
    </script>
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' style="text/css">

<link rel="stylesheet" href="resources/css/normalize.css">
<link rel="stylesheet" href="resources/css/style.css">

</head>

<body>

	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#login">Log In</a></li>
			<li class="tab"><a href="#signup">Sign Up</a></li>
		</ul>

		<div class="tab-content">
						<div id="login">
				<h1>Welcome Back!</h1>

				<form:form action="loginuser.htm" commandName="user" method="post">
					
					<div class="field-wrap">
					<label><h6>${requestScope.ErrorMsg}</h6></label>
						<label> Email Address<span class="req">*</span>
						</label>
						<form:input path="email" required="required" autocomplete="off"/>
					</div>

					<div class="field-wrap">
						<label> Password<span class="req">*</span>
						</label>
						<form:password path="password" required="required"
							autocomplete="off" />
					</div>

					<p class="forgot">
						<a href="#">Forgot Password?</a>
					</p>

					<button class="button button-block" />Log In</button>

				</form:form>

			</div>
			<div id="signup">
				<h1>Sign Up for Free</h1>
				<form:form action="adduser.htm" commandName="user" method="post">

					<div class="top-row">
						<div class="field-wrap">
							<label> First Name<span class="req">*</span>
							</label>
							<form:input path="firstName" required="required"
								autocomplete="off" />
						</div>

						<div class="field-wrap">
							<label> Last Name<span class="req">*</span>
							</label>
							<form:input path="lastName" required="required"
								autocomplete="off" />
						</div>
					</div>

					<div  class="field-wrap">
						<label id = "errorMsg"> Email Address<span class="req">*</span>
						</label>
						<form:input id="emailaddress" path="email" required="required" autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Set A Password<span class="req">*</span>
						</label>
						<form:password path="password" required="required"
							autocomplete="off" />
					</div>

					<button type="submit" class="button button-block" />Get Started</button>

				</form:form>

			</div>

			

		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="resources/js/index.js"></script>




</body>
</html>
