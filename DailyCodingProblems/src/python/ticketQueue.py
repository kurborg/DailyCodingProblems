import time
import random

class Queue:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def enqueue(self, item):
        self.items.insert(0, item)
    
    def dequeue(self):
        return self.items.pop()
    
    def size(self):
        return len(self.items)

    def simulate_line(self, tillShow, maxT):
        pq = Queue()
        tixSold = []

        for i in range(10):
            pq.enqueue("person"+str(i))

        time_end = time.time() + tillShow
        time_now = time.time() 

        while time_now < time_end and not pq.isEmpty():
            time_now = time.time()
            randTimeUnderMax = random.randint(0, maxT)
            time.sleep(randTimeUnderMax)
            person = pq.dequeue()
            print(person)
            tixSold.append(person)
        
        return tixSold

pq = Queue()
sold = pq.simulate_line(3, 2)
print(sold)

