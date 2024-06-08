class RandomizedSet(object):
    
    def __init__(self):
        self.thisSet = set()
    def insert(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if val in self.thisSet:
            return False
        self.thisSet.add(val)
        return True
        

    def remove(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if val not in self.thisSet:
             return False
        self.thisSet.remove(val)
        return True
        
        

    def getRandom(self):
        """
        :rtype: int
        """
        return random.choice(list(self.thisSet))

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()