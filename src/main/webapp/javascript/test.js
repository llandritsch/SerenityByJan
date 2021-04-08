const init = () => {
    let p = document.createElement("p");
    p.innerHTML = "Here is some text from javascript!";
    document.body.appendChild(p);
}

window.onload = init;