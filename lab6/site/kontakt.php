<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">

    <style>
        .form-group {
            margin-top: 20px;
        }
    </style>
    
    <title>Зворотній зв'язок</title>
</head>
<body style="background-color: rgb(252, 251, 210);">
    
<header class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-dark bg-warning">
            <div class="container">
                <a class="navbar-brand" href="#">
                    <div class="site-logo">Libra</div>
                </a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="index.php">Головна</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Магазин</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                Статті
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Зворотній зв'язок</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
</header>


    <div style="margin-top: 50px;" class="container">
        
        <div class="col-md-4">
            <h4>Форма зворотнього зв'язку</h4>
            <form action="mail.php" method="POST" name="form">
                <div class="form-group">
                    <label for="name">Ваше имя:</label>
                    <input name="name" type="name"  class="form-control" id="name" placeholder="Name">
                </div>
                <div class="form-group">
                    <label for="email">E-mail:</label>
                    <input name="email" type="email"  class="form-control" id="email" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="phone">Тема:</label>
                    <input name="phone" type="phone"  class="form-control" id="phone" placeholder="Phone">
                </div>
                <div class="form-group">
                    <label for="message">Сообщение:</label>
                    <textarea name="message" class="form-control"  id="message" rows="3"></textarea>
                </div>
                <input type="submit" class="btn btn-warning" style="margin-top: 20px;" value="Send">
            </form>
        </div>
    </div>


    

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>