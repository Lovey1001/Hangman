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
