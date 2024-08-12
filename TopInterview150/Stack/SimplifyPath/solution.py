class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        output = ""
        current = ""
        stack = []
        path += "/"

        for c in path:
            if c == '/':
                if current == "..":
                    if len(stack) > 0:
                        stack.pop()
                elif current != "." and current != "":
                    stack.append(current)
                    print(current)
                current = ""
            else:
                current += c
        
        while len(stack) > 0:
            output = "/" + stack.pop() + output

        if output == "":
            return "/"
        return output