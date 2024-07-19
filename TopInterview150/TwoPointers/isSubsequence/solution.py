class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) == 0:
            return True
        if len(t) == 0:
            return False
        p1 = 0
        p2 = 0
        while p2 < len(t):
            if (s[p1] == t[p2]):
                p1+=1
                if p1 == len(s):
                    return True
            p2+=1
        return False