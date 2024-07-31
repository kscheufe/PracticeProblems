class Solution(object):
    def wordPattern(self, pattern, s):
        """
        :type pattern: str
        :type s: str
        :rtype: bool
        """
        ps = {}
        sp = {}
        words = s.split()
        if len(words) != len(pattern):
            return False
        for i in range(len(pattern)):
            word = words[i]
            char = pattern[i]
            if char not in ps:
                ps[char] = word
            elif ps[char] != word:
                return False
        for i in range(len(pattern)):
            word = words[i]
            char = pattern[i]
            if word not in sp:
                sp[word] = char
            elif sp[word] != char:
                return False
        return True
    """interestingly enough, keeping the two loops separate here runs at 13ms, but combining them into one runs at 19ms, even though it's more efficient generally"""