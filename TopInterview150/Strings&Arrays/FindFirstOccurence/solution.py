class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        for x in range(1+len(haystack)-len(needle)):
            if (haystack[x:x+len(needle)] == needle):
                return x
        return -1