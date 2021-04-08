const init = () => {
    let p = document.createElement("p");
    p.innerHTML = "Here is some text from javascript!";
    document.body.appendChild(p);

}

// const requestGET = async () => {
//     const response = await fetch('http://localhost:8080/SerenityByJan_war/characters/');
//     console.log(response);
//     document.getElementById('requestOutput').innerHTML = response;
// }

const requestGET = async () => {
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/SerenityByJan_war/characters/";

    xhr.open("get", url);

    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4) {

            let characters = xhr.responseText;
            // console.warn(xhr.responseText);
            console.log(characters);

            let pre = document.createElement("pre");
            pre.setAttribute("class", "pre-scrollable");
            pre.setAttribute("id", "requestOutput");


            pre.innerHTML = characters;
            document.getElementById("output").appendChild(pre);

        }
    }

    xhr.send(null);
}

window.onload = init;