const init = () => {

}

const requestGET = async () => {
    if (document.getElementById('requestOutput') != null || document.getElementById('requestOutput') != undefined) {
        let outputNode = document.getElementById('output');
        outputNode.children[0].remove();
    }

    let xhr = new XMLHttpRequest();

    let url = "http://localhost:8080/OfficeCharacterAPI/characters/";

    let params = document.getElementById("params");
    url = url += params.value;
    xhr.open("get", url);

    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4) {

            let characters = xhr.responseText;
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