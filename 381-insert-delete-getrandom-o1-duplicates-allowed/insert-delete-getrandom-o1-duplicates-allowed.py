import random
from collections import defaultdict

class RandomizedCollection(object):

    def __init__(self):
        # Stores all values
        self.arr = []
        
        # value -> set of indices in arr
        self.indices = defaultdict(set)

    def insert(self, val):
        """
        :type val: int
        :rtype: bool
        """
        exists = len(self.indices[val]) > 0
        
        self.arr.append(val)
        self.indices[val].add(len(self.arr) - 1)
        
        return not exists

    def remove(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if not self.indices[val]:
            return False

        # Take any index of val
        remove_idx = self.indices[val].pop()

        last_val = self.arr[-1]
        last_idx = len(self.arr) - 1

        # Move last element into remove_idx if needed
        if remove_idx != last_idx:
            self.arr[remove_idx] = last_val

            # Update indices set for last_val
            self.indices[last_val].remove(last_idx)
            self.indices[last_val].add(remove_idx)

        # Remove last element
        self.arr.pop()

        return True

    def getRandom(self):
        """
        :rtype: int
        """
        return random.choice(self.arr)