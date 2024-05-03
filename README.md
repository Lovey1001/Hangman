#NOTE: This project was created for my CPSC 210 course. It is my first time creating a project from start to end. 

========================================================================================================================================

# Hangman Game!

This is going to be a fun, interactive game for all ages.
There will be a wordbank with arbitrary words that can be added by the user where a random word will be chosen 
and the user will have to guess it. The user will have to input a letter from the keyboard and will have 6 tries to guess the word.
The 6 tries will represent a drawing of a hangman (for the GUI portion). If the user guesses all the letters properly,
they will win. The guessed word will be added to a list of "words guessed". There will also be a tally
of how many wins and losses the player has had. Also, the user can save their progress, reset the game,
continue where they left off. They can also view the list of previous words guessed. 

# *User Stories:*
- As a user, I want to be able to start a new game.
- As a user, I want to be able to save the progress of the current game.
- As a user, I want to be able to reset the game.
- As a user, I want to be able to continue where we left off.
- As a user, I want to be able to input a letter.
- As a user, I want to be able to input a word.
- As a user, I want to be able to input the word in a list of words.
- As a user, I want to add the letter inputted to a list of letters used.
- As a user, I want to add the random word to a list of used words so it is not repeated.
- As a user, I want to be able to view the list of used words or used letters. 
- As a user, I want to be able to see a tally of wins and losses for words guessed.

# *Data Persistence* 
- As a user, at the end of the current game, I want to be reminded to save my game to file and have option to do it or not.
- As a user, I want the option to reload my current progress from the previous game from file when starting my game.

# *Instructions for Grader*

- You can generate the first required action related to the user story "adding multiple Xs to a Y" by
  typing a word in the box and clicking the "Add Word" button.
- You can generate the second required action of viewing the list of X's in Y by clicking the "View Words" button.
- You can locate my visual component when a player starts a new game by clicking "Start New Game" and guesses the 
correct word. It will display an image with seperate text letting player know they won!
- You can save the state of my application by clicking the "Save Game" button.
- You can reload the state of my application by clicking the "Load Game" button.

# *Phase 4: Task 2* 
The GUI has been closed now.

Fri Apr 05 16:09:06 PDT 2024 - Added word to list: Whatsup

Fri Apr 05 16:09:07 PDT 2024 - Viewed words in the list.

Fri Apr 05 16:09:12 PDT 2024 - Added word to list: CPSC

Fri Apr 05 16:09:13 PDT 2024 - Viewed words in the list.

Fri Apr 05 16:09:16 PDT 2024 - Saved game.

Fri Apr 05 16:09:17 PDT 2024 - Started new game.

Fri Apr 05 16:09:18 PDT 2024 - Started new game.

Fri Apr 05 16:09:19 PDT 2024 - Started new game.

Fri Apr 05 16:09:33 PDT 2024 - Added word to list: gameover

Fri Apr 05 16:09:35 PDT 2024 - Viewed words in the list.

Fri Apr 05 16:09:39 PDT 2024 - Saved game.

Fri Apr 05 16:09:42 PDT 2024 - Loaded game.

Events logged successfully. Thanks for playing!

# *Phase 4: Task 3* 

**What refactoring can be done to improve the game?**

For this project, there were quite a few adjustments that could have been made as revisions.
Firstly, we could make it more scalable. Secondly, I want to implement the OpenAI API to get a user favorite
user topic wordbank that can be generated. This way we don't have to think of words to type, they
can be automatically generated. Thirdly, I could have added more graphics to make it more visual for the 
user such as having the stick man for the game. This can be implemented in the game with the user guesses and 
with every wrong guess, it will draw a component of a figure. 
