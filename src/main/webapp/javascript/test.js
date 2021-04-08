const init = () => {
    let p = document.createElement("p");
    p.innerHTML = "Here is some text from javascript!";
    document.body.appendChild(p);
}

const requestGET = async () => {
    const response = await fetch('http://localhost:8080/SerenityByJan_war/characters/');
    const json = await response.json(); //extract JSON from the http response
    document.getElementById('requestOutput').innerHTML = json;
}

window.onload = init;