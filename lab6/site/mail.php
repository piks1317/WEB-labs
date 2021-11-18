
<meta http-equiv='refresh' content='10; url=index.php'>
<meta charset="UTF-8" />

<?php

$name = $_POST['name'];
$email = $_POST['email'];
$phone = $_POST['phone'];
$message = $_POST['message'];

$mes = "Имя: $name \nE-mail: $email \nТелефон: $phone \nТекст: $message";

$send = mail($email, "Круте повідомлення", $mes, "Content-type:text/plain; charset = UTF-8\r\nFrom:$email");

if ($send == 'true') {
    echo "Відправлено\r\n";
    echo date("Y-m-d H:i:s");
}

else {echo "Ой, что-то пошло не так";}
?>



















