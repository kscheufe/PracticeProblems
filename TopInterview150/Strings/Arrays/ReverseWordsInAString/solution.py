class Solution(object):
    def reverseWords(self, s):
        s = s.split(' ')
        result = []
        for x in s:
            result.append(x)
        result.reverse()
        result = ' '.join(result).strip()
        return ' '.join(result.split())


""" works, slower and is more fine grained than what python provides advantages for
class Solution(object):
    def reverseWords(self, s):
        "1""
        :type s: str
        :rtype: str
        "1""
        word = ""
        sentence = ""
        for x in range(len(s)):
            if s[x] == ' ' and word == "":
                continue
            elif s[x] == ' ':
                sentence = word + " " + sentence
                word = ""
            else:
                word += s[x]
        if word != "":
            sentence = word + " " + sentence
        return sentence[:-1]
"""