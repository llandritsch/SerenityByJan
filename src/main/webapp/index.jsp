<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>
<body class="bg-dark">
    <div class="jumbotron">
        <h1>Office Character Reference Service</h1>
        <small>By Team <i>Serenity by Jan</i></small>
    </div>

    <div class="mt-3 p-3 text-light">
        <h3>How to use</h3>
        <p>Supported Verbs: GET, POST, PUT</p>
        <p>To get all characters: http://localhost:8080/SerenityByJan_war/characters/</p>
        <p>To get a character by id: http://localhost:8080/SerenityByJan_war/characters/{id}</p>
        <p>To create a new character: http://localhost:8080/SerenityByJan_war/characters/ Then add characterName, actorName, and memorable quote via JSON</p>
        <p>To update an existing character: http://localhost:8080/SerenityByJan_war/characters/{id of character to update} Then pick and choose to update characterName, actorName, and memorableQuote </p>
    </div>

    <div class="mt-4 p-3 text-light">
        <p>Test out some GET requests here</p>
        <div class="input-group">
            <span class="input-group-addon">https://localhost:8080/SerenityByJan_war/characters/</span>
            <input type="text" class="form-control" placeholder="1">
            <span class="input-group-btn">
                <button>request</button>
            </span>
        </div>
    </div>


</body>
<%@include file="footer.jsp"%>