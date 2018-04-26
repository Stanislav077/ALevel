document.getElementById('btn').onclick = function() {
    if(localStorage.length > 0){
        localStorage.clear();
    }
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