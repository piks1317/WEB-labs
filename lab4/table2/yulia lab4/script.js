
    function func() {

        let array = ['Item3'];
        var inner = array.map(el => '<li  class = "more">' + el + '<ul  id="' + el + '"></ul></li>').join('');
        document.getElementById('menu').innerHTML += inner;

        let arrayOfPages = ['Page1', 'Page2'];
        var inner = arrayOfPages.map(el => '<li><a href="' + el + '.html">' + el + '</a></li>').join('');
        array.map(el => document.getElementById(el).innerHTML += inner);
        (function () {
            var elm = document.querySelectorAll('.more');

            for (var i = 0; i < elm.length; i++) {
                elm[i].addEventListener('click', function () {
                    this.classList.toggle('open');
                }, false);
            }
        })();
    }