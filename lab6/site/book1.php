<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript"
        src="//cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/fluidbox/2.0.5/js/jquery.fluidbox.min.js"
        integrity="sha512-0kQqdmb3fpKtRwrbCZDlmiwuZgDyPAOLDOu/HyAt4py7lAVDXKknqtqS6dFNV8U8JrHZymQxlO9SFPZ2u8dhMw=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fluidbox/2.0.5/css/fluidbox.min.css"
        integrity="sha512-1gVXQF5Q9gL1HvHBLK0y3IAWCorLY9EU+JMTsLBlXgWfgf6EIS/8B27R/nUq1joeKz2N7ZHCNnLCjc+PuqDqDA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

    <title>Document</title>
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
                            <a class="nav-link" aria-current="page" href="#">Головна</a>
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

    <section style="padding-top: 35px; padding-bottom: 35px; width: 98.5%; background-color: rgb(236, 236, 178);"
        class="container-fluid">
        <div class="container">
            <form class="row">
                <div class="col-md-3">
                    <input type="text" class="form-control" placeholder="Назва Книги">
                </div>
                <div class="col-md-3">
                    <select style="background-color: rgb(252, 251, 210);" class="form-select">
                        <option selected>Жанр Книги</option>
                        <option>...</option>
                    </select>
                </div>
                <div class="col-md-3">
                    <input type="text" class="form-control" placeholder="Автор Книги">
                </div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-warning float-end"><img src="images/search.svg">&nbsp; Знайти
                        Книгу</button>
                </div>
            </form>
        </div>
    </section>

    <section class="container main">
        <a id="book" href="images/big_book1.png">
            <img src="images/book1.png" alt="">
        </a>
    </section>
    <!-- https://images.ua.prom.st/2297858651_w640_h640_lyudina-rozumna-istoriya.jpg -->
    <script>
        $(function () {
            $('#book').fluidbox();
        });
    </script>

</body>

</html>