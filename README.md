# Portfolio Project: 20 Questions
This repository is part of the portfolio uses for SFU MDM application only.

This project is a homework from the computer programming course I took during my undergraduate study. All codes are completed in Java.


## Project Description
This program, focusing on binary trees and recursion, is a simple version of the famous “Akinator”, which works as a game that the computer would guess an item within 20 yes/no questions answered by users. 

The users begin with QuestionMain.java for a text-based interface and VaderMain.java for a graphical interface. Select "recall our previous game" to load an existing question database. Whenever the computer can't guess the right answer, the users can add new answers and their questions. If the users do not want to continue a previous game, they can also create and save their own question database as a text file, starting with the initial question, "Would you object happen to be computer?"


## Work Done
I completed QuestionNode.java and QuestionTree.java files. The other files were provided by course instructor.



## File Description
**QuestionNode:** a class that implements a single node of the question tree. 

**QuestionTree:** a class that implements a question tree that stores yes/no questions and answers for the game. 

**UserInterface:** an interface program. 

**QuestionMain:** a program that can start the game with a text user interface. 

**VaderMain:** a program that can start the game with a graphical user interface.

**question1 & question2 & animals:** sample question databases that can be load to the game. 

**Other media files:** media resources used for graphical interface. 



## Outcome
While running either of the main program, the computer will start with the question “Shall I recall our previous games?”. If the answer is yes, the user can load an existing question data file and play with these questions and answers. If the answer is no, the user can start with a new question database with only one question “Would your object happen to be computer?”. 

The computer will ask several yes/no questions from the question data file and proceed to an answer. If the computer happens to guess correctly, it wins the game. If the computer fails to guess the item, it will ask the user for the correct answer and a question that distinguish this answer to the wrong guess. After the user choose to not continue challenge the computer, a game summary will appear and the computer will ask if the game should be saved. The user can then choose to output all questions and answers within the game play to a text file as a new question database or discard them. 


