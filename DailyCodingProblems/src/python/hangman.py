import random

def hangman():
    words_list = ["Christmas", "Software", "Presents", "Rolex"]
    rand_num = random.randint(0,3)

    word = words_list[rand_num].lower()

    wrong_guesses = 0
    stages = ["", "________      ", "|      |      ", "|      0      ", "|     /|\     ", "|     / \     ", "|"]

    remaining_letters = list(word)
    letter_board = ["_"] * len(word)

    win = False
    print("Welcome to Kurt's Hangman!")

    while wrong_guesses < len(stages) - 1:
        print("\n")
        guess = input("Guess letter: ")
        if guess in remaining_letters:
            print("\nCorrect guess!")
            charIndex = remaining_letters.index(guess)
            letter_board[charIndex] = guess
            remaining_letters[charIndex] = '$'
        else:
            wrong_guesses+=1
            if wrong_guesses >= len(stages) -1:
                break
            print("\nWrong guess, guesses left: {}".format(len(stages)-1-wrong_guesses))

        print(''.join(letter_board))
        print('\n'.join(stages[0:wrong_guesses+1]))

        if '_' not in letter_board:
            print("\nYou won!")
            print("The word was " + ''.join(letter_board))
            win = True
            break
    
    if not win:
        print('\n'.join(stages[0:wrong_guesses]))
        print("\nYou lost! The word was {}".format(word))
        print('\n')


hangman()