<html lang="en">
<head>
  <link rel="stylesheet" href="/books.css" type="text/css">
</head>
<body>
<div class="container">
    <h2>BOOKS</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">ID</div>
            <div class="col col-2">NAME</div>
            <div class="col col-3">GENRE</div>
        </li>
        <#assign sortedBooks = books?sort_by("id")>
        <#list sortedBooks as book>
            <li class="table-row">
                <div class="col col-1">${book.id}</div>
                <div class="col col-2">${book.name}</div>
                <div class="col col-3">${book.genre}</div>
            </li>g
        </#list>
    </ul>
</div>
</body>
</html>