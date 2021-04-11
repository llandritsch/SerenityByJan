### Office Character Reference Service
### Team: Serentiy by Jan
#### Project Statement: 
Some people just love the Office so much that they may need to create an application to reference the characters.  This API will provide the following character information: 
* Character name
* Actor name
* Memorable quote

#### Technologies Utilized
* Java
* Maven
* IntelliJ
* JSPs
* Entities
* Persistence Classes (DAO and SessionFactory)
* JUnit
* Log4J2
* Jersey
* JAX-RS
* GitHub
* Slack

#### Planning and Preparation
* Assembled the team and came up with a project plan.
* Created a GitHub Repository and shared amongst the team.
* Determined which files to add to .gitignore for ease of access to each of our respective local databases (log4j2.properties, hibernate.cfg.xml, logs/, and database.properties)
* Created a database for The Office Characters, which had the following fields: id, character_name, actor_name, and memorable_quote.

#### Coding
* Created the Character Entity and Character DAO (with CRUD functionality).
* Implmented Log4J2 and created the JUnit tests.
* Tested the application to ensure connectivity to the database and that credentials were correct on all applicable files.
* Created the jsp page, which included head.jsp, index.jsp and footer.jsp.
* Created the files corresponding to the REST Application (see next page)(CharacterApplication and CharacterService).
* Optimized the site to include some javascript functionality for live updated GET requests similar to the SWAPI.

#### Building the Character Service Class
* Our application path was set as @ApplicationPath(“/“).
* Four GET Methods were created: getAllCharacters(), getByCharacterName(String name), getByActorName(String name), and getById(int id).
* A method was created to format the output into a JSON String called formatFoundCharacters (List<Character> character).
* A POST method was created for adding a new character, createCharacter(Character character).
* A PUT method was created for updating an existing character, updateCharacter(int id, Character characterData).

#### Code Walkthrough
![image](Code%20Walkthrough.png)

#### Demo Details
![image](Local%20Host%20Demo%20Details.png)

#### References
* How to Create a RESTful Web Service in Java: https://www.tutorialspoint.com/restful/restful_methods.htm
* How to Convert a Java Object to JSON with Jackson: https://mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/