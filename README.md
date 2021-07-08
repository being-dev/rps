# ROCK PAPER SCISSORS Game Application

Refer this link [About Game](https://en.wikipedia.org/wiki/Rock_paper_scissors)

This is simple spring-boot base java application which exposes REST Endpoint to play the game between user and system.

This game is __played between Human and Computer(Server) System__ where Human need to invoke below rest endpoint with define set of action using tool like Postman or similar with POST as method type.

**How to run the application?**

 - Download code from https://github.com/being-dev/rps.git
 - Open command window and go to rps directory
 - Now to run the application use either of these command:
   - If you have already installed apache-maven then use **mvn sprin-boot:run**
   - Otherwise use **java -jar target/rps-0.0.0-SNAPSHOT.jar**
 - Use POSTMAN or similar tool to invoke REST Endpoint Url. Below are the rest endpoint uri to access the application:
  - http://localhost:8080/api/v1/rps/[action] In [action] can value either of **rock,paper or scissors**
  - Or can use http://localhost:8080/api/v1/rps/start.do and pass **action=[rock|paper|scissors]** as request parameter.
  - Above both request are **POST** request
  
