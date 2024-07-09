class Solution(object):
    def lengthOfLastWord(self, s):
        words = s.split()
        
        if words:
            return len(words[-1])
        else:
            return 0


"""
class Solution(object):
    def lengthOfLastWord(self, s):
        "/""
        :type s: str
        :rtype: int
        "/""
        found = False
        num = 0
        for x in range(len(s)-1, -1, -1):
            if (s[x] != ' '):
                num+=1
                found = True
            elif found == True:
                return num
        return num
    """