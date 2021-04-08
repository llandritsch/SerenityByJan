<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>
<body class="bg-dark">
    <div class="jumbotron">
        <h1>Office Character Reference Service</h1>
        <small>By Team <i>Serenity by Jan</i></small>
    </div>

    <div class="mt-3 p-3 text-light">
        <div style="margin-left: auto; margin-right: auto;">
            <h2><b>How to use</b></h2>
            <p>Supported Verbs: GET, POST, PUT</p>
        </div>
        <p>To get all characters: http://localhost:8080/SerenityByJan_war/characters/</p>
        <p>To get a character by character name:
            http://localhost:8080/SerenityByJan_war/characters/name/{characterName}</p>
        <p>To get a character by actor name:
            http://localhost:8080/SerenityByJan_war/characters/actor/{actorName}</p>
        <p>To get a character by id: http://localhost:8080/SerenityByJan_war/characters/{id}</p>
        <p>To create a new character: http://localhost:8080/SerenityByJan_war/characters/ Then add characterName, actorName, and memorable quote via JSON</p>
        <p>To update an existing character: http://localhost:8080/SerenityByJan_war/characters/{id of character to update} Then pick and choose to update characterName, actorName, and memorableQuote </p>
    </div>

    <div class="mt-4 p-3 text-light">
        <p>Test out some GET requests here</p>
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

        <div class="output mt-3 bg-light" id="output" style="width: 50%; margin-left: auto; margin-right: auto;">

        </div>
    </div>


</body>
<%@include file="footer.jsp"%>