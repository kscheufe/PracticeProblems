class RandomizedSet(object):
    
    def __init__(self):
        self.lst = []
        self.idxMap = {}
    def search(self, val):
        return val in self.idxMap
    
    def insert(self, val):
        """
        :type val: int
        :rtype: bool
        """
        """if already in the map, return false"""
        if self.search(val):
            return False
        """if not in the map, add it and return true"""
        self.lst.append(val)
        self.idxMap[val] = len(self.lst) - 1
        return True      

    def remove(self, val):
        """
        :type val: int
        :rtype: bool
        """
        """if not in the list, return false"""
        if not self.search(val):
            return False
        """if in the list, remove it and return true"""
        idx = self.idxMap[val]
        self.lst[idx] = self.lst[-1]
        self.idxMap[self.lst[-1]] = idx
        self.lst.pop()
        del self.idxMap[val]
        return True
        

    def getRandom(self):
        """
        :rtype: int
        """
        return random.choice(self.lst)
        

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()

"""
class RandomizedSet(object):
    
    def __init__(self):
        self.thisSet = set()
    def insert(self, val):
        ""
        :type val: int
        :rtype: bool
        ""
        if val in self.thisSet:
            return False
        self.thisSet.add(val)
        return True
        

    def remove(self, val):
        ""
        :type val: int
        :rtype: bool
        ""
        if val not in self.thisSet:
             return False
        self.thisSet.remove(val)
        return True
        
        

    def getRandom(self):
        ""
        :rtype: int
        ""
        return random.choice(list(self.thisSet))

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
"""