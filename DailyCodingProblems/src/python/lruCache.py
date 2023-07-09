class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}
        self.order = []

    def get(self, key):
        if key not in self.cache:
            return -1

        self.order.remove(key)
        self.order.append(key)
        return self.cache[key]

    def put(self, key, value):
        if key in self.cache:
            self.order.remove(key)

        self.cache[key] = value
        self.order.append(key)

        if len(self.order) > self.capacity:
            oldest_key = self.order.pop(0)
            del self.cache[oldest_key]


def main():
    cache = LRUCache(3)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.put(3, 3)
    print(cache.get(1))
    cache.put(4, 4)
    print(cache.get(2))


if __name__ == "__main__":
    main()
