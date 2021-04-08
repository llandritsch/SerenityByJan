const init = () => {
    let p = document.createElement("p");
    p.innerHTML = "Here is some text from javascript!";
    document.body.appendChild(p);
}

const requestGET = async () => {
    const response = await fetch('http://localhost:8080/SerenityByJan_war/characters/');
    console.log(response);
    document.getElementById('requestOutput').innerHTML = response;
}

window.onload = init;