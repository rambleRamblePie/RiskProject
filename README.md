# RiskProject  
[![Build Status](https://travis-ci.com/rambleRamblePie/RiskProject.svg?branch=master)](https://travis-ci.com/rambleRamblePie/RiskProject)  
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/8f4737f970a94fce9da7f63ebcd8745e)](https://app.codacy.com/app/AlexMilligan/RiskProject?utm_source=github.com&utm_medium=referral&utm_content=rambleRamblePie/RiskProject&utm_campaign=Badge_Grade_Settings)
[![Codecov Badge](https://codecov.io/gh/rambleRamblePie/RiskProject/branch/master/graph/badge.svg)](https://codecov.io/gh/rambleRamblePie/RiskProject)

This repository holds project 1 of **TeamHAL** from COSC 4353 Software Design

[doc of ideas](https://docs.google.com/document/d/1d5d2bB72MDlnfXZmAud7WaaHd31uRfvRchUe9y6lsEA/edit?usp=sharing)

[maven guide](https://spring.io/guides/gs/maven/)

**How to compile and run test cases**:  
`mvn test`

**How to run the program**:  
`java -cp target/risk-game-0.1.jar Main`  
_Version may be different as specified in pom.xml_

_Both require you to be in the root project directory._

---------
## Suggestions
For the undoable actions, maybe refactor that code into the command design pattern:  
* http://gameprogrammingpatterns.com/command.html
* https://matt.berther.io/2004/09/16/using-the-command-pattern-for-undo-functionality/

---------
## Updates

Todo: I am working on the Twitter API --Aaron
Todo: Add more Maven test cases  
Todo: The Deck and Hand classes need to be worked on  

10-04-2018: v0.3 Tagged. Everything working --Aaron  
09-23-2018: New Maven Dependencies have been added the the pom.xml file. Be sure to add them in IntelliJ --Aaron  
09-23-2018: Territories and Continents are now spawning correctly. The overall driver of the program is working --Aaron  
09-22-2018: Chaning the structure of the program slightly. Players are being spawned and accounted for correctly --Aaron  
08-06-2018: Territories and Continents will be stored in a Map<k,v>  
Twitter -
----------------
We have added Twitter functionality to our game. Follow us on Twitter, `Team HAL @hal_team` for status updates

Updates - 
-----------------
Todo: I am working on the Twitter API --Aaron

09-23-2018: New Maven Dependencies have been added the the pom.xml file. Be sure to add them in IntelliJ --Aaron
09-23-2018: Territories and Continents are now spawning correctly. The overall driver of the program is working --Aaron
09-22-2018: Chaning the structure of the program slightly. Players are being spawned and accounted for correctly --Aaron
08-06-2018: Territoires and Continents will be stored in a Map<k,v>
