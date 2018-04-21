/**
 * Created by Ivan Isaev on 18.04.2018.
 */
var element = document.getElementById("img");
if(element){
    element.addEventListener('mouseover', function () {
        this.style.height = '110%';
        this.style.width = '110%';
    }, false);
    element.addEventListener('mouseout', function () {
        this.style.height = '100%';
        this.style.width = '100%';
    })
}

var signUp = document.getElementsByClassName("nav-link active");
[].forEach.call(signUp, function (e1) {
    e1.addEventListener('mouseover', function () {
        this.style.color = '#8B0000';
    }, false);
    e1.addEventListener('mouseout', function () {
        this.style.color = ""
    }, false);
});

document.getElementById('btn').onclick = function() {
    document.getElementById("namef").innerHTML = null;
    var x = document.getElementById("fname").value;
    if(x.length < 4 && x.indexOf(' ') > 0){
        document.getElementById("namef").innerHTML +=" SMALL SIZE and CONSIST SPACE";
    } else if(x.length < 4){
        document.getElementById("namef").innerHTML +=" SMALL SIZE";
        return false;
    } else if (x.indexOf(' ') > 0) {
        document.getElementById("namef").innerHTML += " CONSIST SPACE";
        return false;
    } else {
        window.location.href = "profile.html";
        return true;
    }
};

function hide(temp) {
    if(document.getElementById(temp).style.display == "none"){
        document.getElementById(temp).style.display = "block";
    } else{
        document.getElementById(temp).style.display ="none";
    }
}

