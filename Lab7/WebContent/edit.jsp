<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <style>
            span {
                width: 100px;
                display: inline-block;
            }
            input {
                display: block;
                margin: 3px 3px 3px 0;
            }
        </style>
    </head>
    <body>
        <h1>Edit phone</h1>
        <form method="post" action="/Store/edit">
        	<input type="hidden" name="id" value="${phone.getId()}">
            <div>
                <span>Manufacturer</span>
                <input type="text" name="manufacturer" value="${phone.getManufacturer()}">
            </div>
            <div>
                <span>Name</span>
                <input type="text" name="name" value="${phone.getName()}">
            </div>
            <div>

                <span>Ram</span>
                <input type="text" name="ram" value="${phone.getRam()}">
            </div>
            <div>

                <span>Storage</span>
                <input type="text" name="storage" value="${phone.getStorage()}">
            </div>
            <br>
            <input type="submit" value="save">
        </form>
    </body>
</html>