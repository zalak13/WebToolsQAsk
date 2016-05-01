<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login here</title>
    </head>
    <body bgcolor="#ffffff">
        <h1>Login Page</h1>

        <form method="POST" action="j_security_check">
            <table border="0">
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="j_username"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="j_password"></td>
                </tr>
            </table>
            <input type="submit" value="Login!">
            
        </form>
    </body>
</html>