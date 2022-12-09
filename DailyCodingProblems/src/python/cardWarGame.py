from random import shuffle

class Card:
    suits = ("Hearts", "Spades", "Diamonds", "Clovers")
    values = ("none", "none", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace")

    def __init__(self, v, s):
        self.suit = s
        self.value = v
    
    def __lt__(self, c2):
        if self.value < c2.value:
            return True
        if self.value == c2.value:
            if self.suit < c2.suit:
                return True
            else:
                return False
        return False
    
    def __gt__(self, c2):
        if self.value > c2.value:
            return True
        if self.value == c2.value:
            if self.suit > c2.suit:
                return True
            else:
                return False
        return False
    
    def __repr__(self):
        suit = self.suits[self.suit]
        value = self.values[self.value]
        return "{} of {}".format(value, suit)

class Player:
    def __init__(self, name):
        self.wins = 0
        self.name = name
        
    
class Deck:
    def __init__(self):
        self.cards = []
        for i in range(2, 15):
            for j in range(4):
                self.cards.append(Card(i, j))
        
        shuffle(self.cards)

    def rm_card(self):
        if len(self.cards) == 0:
            return
        else:
            return self.cards.pop()

class Game:
    def __init__(self):
        name1 = input("Please enter player 1 name: ")
        name2 = input("Please enter player 2 name: ")
        self.p1 = Player(name1)
        self.p2 = Player(name2)
        self.deck = Deck()

    def wins(self, winner):
        print("{} wins this round\n".format(winner))
    
    def draw(self, p1n, p1c, p2n, p2c):
        print("{} drew {}, {} drew {}".format(p1n, p1c, p2n, p2c))
    
    def playGame(self):
        cards = self.deck.cards
        while len(cards) >= 2:
            p1c = self.deck.rm_card()
            p2c = self.deck.rm_card()
            p1n = self.p1.name
            p2n = self.p2.name
            self.draw(p1n, p1c, p2n, p2c)
            
            if p1c > p2c:
                self.p1.wins += 1
                self.wins(p1n)
            else:
                self.p2.wins += 1
                self.wins(p2n)

            input("Enter to continue\n ")
        
        print("\nWar is over!")
        self.winner()
    
    def winner(self):
        print("\n{} had {} wins, {} had {} wins".format(self.p1.name, self.p1.wins, \
                    self.p2.name, self.p2.wins))
        
        if self.p1.wins > self.p2.wins:
            print("{} wins the game!\n".format(self.p1.name))
        elif self.p1.wins < self.p2.wins:
            print("{} wins the game!\n".format(self.p2.name))
        else:
            print("The game was a draw!\n")

            
game = Game()
game.playGame()
