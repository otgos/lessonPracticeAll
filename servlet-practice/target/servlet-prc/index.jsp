<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>www.SpringMVC-PRC.com</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            min-height: 100vh;
            background-color: rgb(145, 216, 138);
        }
        .f01 {
            background-color: rgb(156, 145, 196);
            padding: 100px;
            text-align: right;
            margin: auto;
            display: table;
            border-radius: 20px;
        }
        .input {
            background-color: rgb(218, 132, 4);
        }
        .title {
            text-align: center;
            margin-top: 20vh;
        }
    </style>
</head>
<body>
    <div class="title">
        <h1 style=color:"red"; font-size: 50px>Welcome</h1>
        <div>
            <img src="images/tpe.png" alt="tpe" width="500" height="75">
        </div>
        <div class="f01">
            <form action="login" method="post">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                </table>
                <input class="input" type="submit" value="Login">
            </form>
        </div>
        <div class="title1">
            <h1 style="color: 'red'; font-size: 50px;">Otgo Web Page</h1>
            <div>
                <img src="images/tpe.png" alt="tpe" width="500" height="75">
            </div>
        </div>
    </div>
  </body>
</html>