# RiskProject [![Build Status](https://travis-ci.com/rambleRamblePie/RiskProject.svg?branch=master)](https://travis-ci.com/rambleRamblePie/RiskProject)<br>
This repository holds project 1 of **TeamHAL** from COSC 4353 Software Design

https://docs.google.com/document/d/1d5d2bB72MDlnfXZmAud7WaaHd31uRfvRchUe9y6lsEA/edit?usp=sharing

maven guide: https://spring.io/guides/gs/maven/

How to compile and run test cases: `mvn test`
How to run the program: `java -cp target/risk-game-0.1.jar Main`
Both require you to be in the root directory.

http://gameprogrammingpatterns.com/command.html

Updates - 
-----------------

Todo: Add more Maven test cases

Todo: The Deck and Hand classes need to be worked on

09-23-2018: New Maven Dependencies have been added the the pom.xml file. Be sure to add them in IntelliJ --Aaron
09-23-2018: Territories and Continents are now spawning correctly. The overall driver of the program is working --Aaron
09-22-2018: Chaning the structure of the program slightly. Players are being spawned and accounted for correctly --Aaron
08-06-2018: Territories and Continents will be stored in a Map<k,v>
