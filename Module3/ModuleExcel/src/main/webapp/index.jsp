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
        <label>Create a table with a specified number of columns</label>
        <div>
            <input type="text" id="nametable1" name="nametablecreate" placeholder="Enter a name table">
            <input type="text" id="col" name="col" placeholder="Enter a number col">
            <input type="submit" value="Create table" class="btn btn-primary" id="btn-create-table">
        </div>
    </form>
    <form class="form-group"
          method="post"
          action="/droptable">
        <label>Delete a table by number</label>
        <div>
            <input type="text" id="nametable4" name="nametabledrop" placeholder="Enter a name table">
            <input type="submit" value="Delete table" class="btn btn-primary" id="btn-drop-table">
        </div>
    </form>
    <form class="form-group"
          method="post"
          action="/deleterow">
        <div>
            <label>Delete row by number row</label>
            <div>
                <input type="text" id="nametable5" name="nametable5" placeholder="Enter a name table">
                <input type="text" placeholder="Enter a number row" name="row3">
                <input type="submit" value="Delete row" class="btn btn-primary" id="btn-delete-row">
            </div>
        </div>
    </form>
    <form class="form-group"
          method="post"
          action="/getdata">
        <div>
            <label>Add data to the table by number row (Ex. "data, row, magic")</label>
            <div>
                <input type="text" id="nametable2" name="nametabledata1" placeholder="Enter a name table">
            </div>
            <div id="variants1">
                <div class="control-group">
                    <div class="controls">
                        <input type="text" placeholder="Enter a number row" name="row2">
                        <input type="text" placeholder="Enter a data" name="data1">
                    </div>
                </div>
            </div>
            <div>
                <input type="submit" value="Save data" class="btn btn-primary" id="btn-save-data-by-row">
            </div>
        </div>
    </form>
    <form class="form-group"
          method="post"
          action="/getdatawithoutrow">
        <div>
            <label>Add data to the table without number row (Ex. "data, row, magic")</label>
            <div>
                <input type="text" id="nametable3" name="nametabledata2" placeholder="Enter a name table">
            </div>
            <div id="variants2">
                <div class="control-group">
                    <div class="controls">
                        <input type="text" placeholder="Enter a data" name="data2">
                    </div>
                </div>
            </div>
            <div>
                <input type="submit" value="Save data" class="btn btn-primary" id="btn-save-data">
            </div>
        </div>
    </form>
    <form class="form-group"
          method="post"
          action="/json">
        <div>
            <input type="text" placeholder="Enter a nametable" name="tablename7">
            <input type="submit" value="JSON" class="btn btn-primary" id="btn-get-json">
        </div>
    </form>
</body>
</html>
