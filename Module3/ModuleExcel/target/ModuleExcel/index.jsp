<html>
<head>
    <meta charset="UTF-8">
    <title>Excel</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
    <form class="form-group"
          method="post"
          action="/createtable">
        <div>
            <input type="text" id="nametable1" name="nametablecreate" placeholder="Enter a name table">
            <input type="text" id="col" name="col" placeholder="Enter a number col">
            <input type="submit" value="Create table" class="btn btn-primary" id="btn-create-table">
        </div>
    </form>
    <form class="form-group"
          method="post"
          action="/getdata">
        <div>
            <div>
                <input type="text" id="nametable2" name="nametabledata" placeholder="Enter a name table">
            </div>
            <div id="variants">
                <div class="control-group" id="uzz">
                    <div class="controls">
                        <input type="text" placeholder="Enter a number row" name="row2">
                        <input type="text" placeholder="Enter a data" name="data">
                    </div>
                </div>
            </div>
            <div>
                <input type="submit" value="Save data" class="btn btn-primary" id="btn-save-data">
            </div>
        </div>
    </form>
</body>
</html>
