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
            <h4>Requests that will work on both the website and Postman (or equivalent):</h4>
            <ul>
                <li><u>Get All Characters</u>: http://18.219.146.156:8080/OfficeCharacterAPI/characters/</li>
                <li><u>Get Character by id</u>: http://18.219.146.156:8080/OfficeCharacterAPI/characters/{id}</li>
                <li><u>Get Character by Character Name</u>:
                    http://18.219.146.156:8080/OfficeCharacterAPI/characters/name/{characterName}</li>
                <li><u>Get Character by Actor Name</u>:
                    http://18.219.146.156:8080/OfficeCharacterAPI/characters/actor/{actorName}</li>
            </ul>
            <h4>Requests that will work on Postman (or equivalent):</h4>
            <ul>
                <li><u>Create a New Character</u>: http://18.219.146.156:8080/OfficeCharacterAPI/characters/
                    <br/><span class="font-italic">Then add characterName, actorName, and memorable quote via JSON.  Example:</span>
                </li>
                <li><u>Update an Existing Character</u>: http://18.219.146.156:8080/OfficeCharacterAPI/characters/{id of character to update}
                    <br/><span class="font-italic">Then pick and choose to update the characterName, actorName, and/or memorableQuote.</span>
                </li>
            </ul>
            <h5><u>Note</u>: The base Application URL on AWS is: http://18.219.146.156:8080/OfficeCharacterAPI</h5>
        </div>
    </div>

    <div class="mt-3 p-3 text-light" style="width: 75%; margin-left: auto; margin-right: auto; border: 4px solid hotpink; background-color: slategray; border-radius: 3em">
        <div style="text-align: center">
            <h2>Test out some GET requests here</h2>
        </div>
        <div class="input-group">

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon3">http://18.219.146.156:8080/SerenityByJan/characters/</span>
                </div>
                <input type="text" class="form-control" id="params" placeholder="1">
            </div>

            <span class="input-group-btn">
                <button class="btn btn-success" onclick="requestGET(); return false;">Request</button>
            </span>
        </div>

        <div class="output mt-3 bg-light mb-5" id="output" style="width: 75%; margin-left: auto; margin-right: auto;">

        </div>
    </div>


</body>
<%@include file="footer.jsp"%>