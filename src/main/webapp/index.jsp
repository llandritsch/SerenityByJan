<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>
<body class="bg-dark">
    <div class="jumbotron">
        <h1>Office Character Reference Service</h1>
        <small>By Team <i>Serenity by Jan</i></small>
    </div>

    <div class="mt-3 p-3 text-light">
        <div style="width: 40%; margin-left: auto; margin-right: auto; text-align: center; border:4px solid hotpink; border-radius: 5em; background-color: slategray; padding-top: .5em; margin-bottom: 1em">
            <h2><b>How to use</b></h2>
            <p>Supported Verbs: GET, POST, PUT</p>
        </div>
        <div style="width: 75%; margin-left: auto; margin-right: auto;">
            <p>Get all characters: http://localhost:8080/SerenityByJan_war/characters/</p>
            <p>Get character by name:
                http://localhost:8080/SerenityByJan_war/characters/name/{characterName}</p>
            <p>Get by actor name:
                http://localhost:8080/SerenityByJan_war/characters/actor/{actorName}</p>
            <p>Get by id: http://localhost:8080/SerenityByJan_war/characters/{id}</p>
            <p>Create new character: http://localhost:8080/SerenityByJan_war/characters/
                <br/><span class="font-italic">Then add characterName, actorName, and memorable quote via JSON</span></p>
            <p>Update existing character: http://localhost:8080/SerenityByJan_war/characters/{id of character to update}
                <br/><span class="font-italic">Then pick and choose to update characterName, actorName, and memorableQuote</span> </p>
        </div>
    </div>

    <div class="mt-3 p-3 text-light" style="width: 75%; margin-left: auto; margin-right: auto; border: 4px solid hotpink; background-color: slategray; border-radius: 3em">
        <div style="text-align: center">
            <h2>Test out some GET requests here</h2>
        </div>
        <div class="input-group">

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3">https://localhost:8080/SerenityByJan_war/characters/</span>
                </div>
                <input type="text" class="form-control" id="params" placeholder="1">
            </div>

            <span class="input-group-btn">
                <button class="btn btn-success" onclick="requestGET(); return false;">request</button>
            </span>
        </div>

        <div class="output mt-3 bg-light" id="output" style="width: 75%; margin-left: auto; margin-right: auto;">

        </div>
    </div>


</body>
<%@include file="footer.jsp"%>