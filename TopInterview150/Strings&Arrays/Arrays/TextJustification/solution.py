class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        output = [""]
        rowIndex = 0
        """first iterate through and sort the words"""
        for word in words:
            if output[rowIndex] == "":
                output[rowIndex] = word
            elif len(output[rowIndex] + " " + word) <= maxWidth:
                output[rowIndex] += " " + word
            else:
                output.append("")
                rowIndex +=1
                output[rowIndex] = word
        """then for each line calculate the spaces to add and add them evenly, then handle remainder"""
        for j in range(len(output)):
            row = output[j]
            """add them evenly"""
            lineLength = len(row)
            spacesToAdd = maxWidth-lineLength
            wordBreaks = 0
            """find the number of existing spaces to add to"""
            for x in range(len(row)):
                if row[x] == " ":
                    wordBreaks+=1
            """if only one word or the last line"""
            if wordBreaks == 0 or j == len(output)-1:
                for x in range(lineLength, maxWidth, 1):
                    row = row + " "
                output[j] = row
                continue
            """else if the are word breaks, add even spaces"""
            equalSpaces = spacesToAdd / wordBreaks
            i = 0
            while i < len(row) and i < maxWidth:
                if row[i] == " ":
                    for x in range(0, equalSpaces):
                        row = row[:i] + " " + row[i:]
                        i+=1
                i+=1
            output[j] = row

            """then add remainder"""        
            spacesToAdd = spacesToAdd % wordBreaks
            print(spacesToAdd, " spaces")
            added = False
            x = 0
            while (spacesToAdd > 0):
                if added == False and row[x] == " ":
                    row = row[:x] + " " + row[x:]
                    added = True
                    x+=1
                    spacesToAdd-=1            
                elif row[x] != " ":
                    added = False
                x+=1
                print(row)
            output[j] = row
        return output