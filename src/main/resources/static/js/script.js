var invader_button = document.getElementById("invader-button"),
    map_button = document.getElementById("map-button"),
    search_button = document.getElementById("search-button"),
    send_button = document.getElementById("send-button");

var invaders,
    situation,
    result;

invader_button.onclick = getInvaders;
map_button.onclick = getMap;
search_button.onclick = searchInvaders;
send_button.onclick = sendResult;

function getInvaders() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            invaders = this.response;
            console.log(JSON.parse(invaders));
            showInvaders(JSON.parse(invaders));
        }
    };
    xhttp.open("GET", "http://radar.lafox.net/api/getInvaders", true);
    xhttp.send();
    map_button.disabled = false;
}

function getMap() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            situation = this.response;
            console.log(JSON.parse(situation));
            showMap(JSON.parse(situation).map);
        }
    };
    xhttp.open("GET", "http://radar.lafox.net/api/getMap", true);
    xhttp.send();
    search_button.disabled = false;
}

function searchInvaders() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/api/searchInvaders", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            document.getElementById("response").innerHTML = this.responseText;
            result = JSON.parse(this.response);
        }
    };
    var data = JSON.stringify({
        invaders: JSON.parse(invaders),
        situation: JSON.parse(situation)
    });
    xhttp.send(data);
    send_button.disabled = false;
}

function showInvaders(invaders) {
    document.getElementById("invader-hold").innerHTML = "";
    for (var key in invaders) {
        if (invaders.hasOwnProperty(key)) {
            var invader_hold = document.getElementById("invader-hold");
            var invader_container = document.createElement("div");
            var invader_content = document.createElement("pre");
            invader_hold.appendChild(invader_container).appendChild(invader_content);
            invader_content.innerHTML = invaders[key];
        }
    }
}

function showMap(map) {
    var map_container = document.getElementById("map-container").innerHTML = map;
}

function sendResult() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://radar.lafox.net/api/checkMyResult ", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            alert(this.response)
        }
    };
    xhttp.send(JSON.stringify(result));
}

