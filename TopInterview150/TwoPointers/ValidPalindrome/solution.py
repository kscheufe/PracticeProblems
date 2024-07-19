class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        p1 = 0
        p2 = len(s)-1
        while (p1 < p2):
            if not s[p1].isalnum():
                p1+=1
            elif not s[p2].isalnum():
                p2-=1
            elif s[p1].lower() == s[p2].lower():
                p1+=1
                p2-=1
            else:
                return False
        return True