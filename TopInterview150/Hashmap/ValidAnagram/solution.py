class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        count = {}
        for char in s:
            count[char] = count.setdefault(char, 0) + 1
        for char in t:
            count[char] = count.setdefault(char, 0) - 1
        for value in count.values():
            if value != 0:
                return False
        return True