document.getElementById('btn').onclick = function() {
    document.getElementById("namef").innerHTML = null;
    var x = document.getElementById("fname").value;
    if(x.length < 4 && x.indexOf(' ') > 0){
        document.getElementById("namef").innerHTML +=" SMALL SIZE and CONSIST SPACE";
        return false;
    } else if(x.length < 4){
        document.getElementById("namef").innerHTML +=" SMALL SIZE";
        return false;
    } else if (x.indexOf(' ') > 0) {
        document.getElementById("namef").innerHTML += " CONSIST SPACE";
        return false;
    }
};