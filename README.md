# RiskProject ![](https://travis-ci.com/AlexMilligan/RiskProject.svg?token=w9mHzsjxCWQjxg31ooki&branch=master)<br>
Todo: change url of the image above
This repository holds project 1 of **TeamHAL** from COSC 4353 Software Design

https://docs.google.com/document/d/1d5d2bB72MDlnfXZmAud7WaaHd31uRfvRchUe9y6lsEA/edit?usp=sharing

maven guide: https://spring.io/guides/gs/maven/

How to compile and run test cases: `mvn test`
How to run the program: `java -cp target/risk-game-0.1.jar Main`
Both require you to be in the root directory.

Updates - 
-----------------
Todo: Correct the TravisCI badge and figure out why Maven builds successfully, but TravisCI is not showing
09-23-2018: New Maven Dependencies have been added the the pom.xml file. Be sure to add them in IntelliJ --Aaron
09-23-2018: Territories and Continents are now spawning correctly. The overall driver of the program is working --Aaron
09-22-2018: Chaning the structure of the program slightly. Players are being spawned and accounted for correctly --Aaron
08-06-2018: Territoires and Continents will be stored in a Map<k,v> https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
