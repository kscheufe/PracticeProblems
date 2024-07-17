class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> output(1);//use .size() to get length
        output[0] = words[0];
        //sort words into rows
        int sortingIndex = 0;
        for (int i = 1; i < words.size(); i++)
        {
            //if it fits in the current row, add it
            if ((output[sortingIndex] + " " + words[i]).length() <= maxWidth)
            {
                output[sortingIndex] += " " + words[i];
            }
            else
            {
                output.push_back("" + words[i]);//could also use insert with an index
                sortingIndex++;
            }
        }
        //results in a text block with single spacing

        //add spacing
        int spacesToAdd;
        int insertionPoints;
        for (int i = 0; i < output.size(); i++)
        {
            //add uniform spaces
            //calculate spacesToAdd
            spacesToAdd = maxWidth - output[i].size();
            if (spacesToAdd == 0)
            { continue; }
            //find the number insertion points to put them into
            insertionPoints = 0;
            for (int j = 0; j < output[i].size(); j++)
            {
                if (output[i][j] == ' ')
                {
                    insertionPoints++;
                }
            }
            //if there are none or if it is the last line
            if (insertionPoints == 0 || i == output.size()-1)
            {
                for (int j = 0; j < spacesToAdd; j++)//add spaces to end
                {
                    output[i] += " ";
                }
                continue;
            }
            //iterate through and add uniformSpaces to each location
            for (int j = 0; j < output[i].size(); j++)
            {
                if (output[i][j] == ' ')
                {
                    for (int k = 0; k < spacesToAdd/insertionPoints; k++)
                    {
                        output[i] = output[i].substr(0, j) + " " + output[i].substr(j, output[i].size());
                        j++;
                    }
                }
            }
            //add remainder spaces
            spacesToAdd = spacesToAdd % insertionPoints;
            bool added = false;
            int index = 1;
            while(spacesToAdd > 0)
            {
                if (output[i][index] == ' ' && added == false)
                {
                    output[i] = output[i].substr(0, index) + " " + output[i].substr(index, output[i].size());
                    spacesToAdd--;
                    index++;
                    added = true;
                }
                if (output[i][index] != ' ')
                {
                    added = false;
                }
                index++;
            }
        }
        return output;
    }
};