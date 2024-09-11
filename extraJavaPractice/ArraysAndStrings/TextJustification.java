class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        List<List<String>> intermediate = new ArrayList<>();
        //separate words array into intermediate list
        int currWidth = words[0].length();
        List<String> temp = new ArrayList<>();
        temp.add(words[0]);
        for (int i = 1; i < words.length; i++)
        {
            if (currWidth + 1 + words[i].length() <= maxWidth)
            {
                temp.add(words[i]);
                currWidth+= 1 + words[i].length();
            }
            else {
                intermediate.add(new ArrayList<>(temp));
                temp.clear();
                temp.add(words[i]);
                currWidth = words[i].length();
            }
        }
        if (temp.size() > 0)//add the last word
        {
            intermediate.add(temp);//don't need copy of because it's the last one
        }

        for (int i = 0; i < intermediate.size(); i++)
        {
            for (int j = 0; j < intermediate.get(i).size(); j++)
            {
                System.out.print(intermediate.get(i).get(j) + "");
            }
            System.out.print("=\n");
        }

        int spacesToAdd = maxWidth;
        //add spaces until complete (except for last line)
        for (int i = 0; i < intermediate.size(); i++)//for each row
        {
            spacesToAdd = maxWidth;
            if (intermediate.get(i).size() == 1)//handle single word lines
            {
                spacesToAdd = maxWidth-intermediate.get(i).get(0).length();
                if (spacesToAdd > 0)
                intermediate.get(i).set(0,  intermediate.get(i).get(0) + String.format("%" + spacesToAdd + "s", ""));
                continue;
            }
            if (i == intermediate.size()-1)//handle last line
            {
                for (int j = 0; j < intermediate.get(i).size(); j++)//find number of spaces to add
                {
                    spacesToAdd-= (intermediate.get(i).get(j).length() + 1);//remove the word and a space worth
                    if (j != intermediate.get(i).size()-1) 
                        intermediate.get(i).set(j, intermediate.get(i).get(j) + " ");//also append a spcae to the end of each word
                }
                //account for the last word's space not being added
                spacesToAdd++;
                //add the spaces
                if (spacesToAdd > 0)
                intermediate.get(i).set(intermediate.get(i).size()-1,  intermediate.get(i).get(intermediate.get(i).size()-1) + String.format("%" + spacesToAdd + "s", ""));
                continue;
            }
            //handle normal case
            //find spaces to add
            for (int j = 0; j < intermediate.get(i).size(); j++)//find number of spaces to add
            {
                spacesToAdd -= (intermediate.get(i).get(j).length());//remove the word's worth of spaces
            }
            //add each needed space in one at a time for fun
            for (int j = 0; j < spacesToAdd; j++)//for each needed space
            {
                int index = j % (intermediate.get(i).size()-1);
                intermediate.get(i).set(index, intermediate.get(i).get(index) + " ");
            }
        }
        for (int i = 0; i < intermediate.size(); i++)
        {
            for (int j = 0; j < intermediate.get(i).size(); j++)
            {
                System.out.print(intermediate.get(i).get(j) + "");
            }
            System.out.print("=\n");
        }
        //convert intermediate into output by joining strings
        String line = "";
        for (int i = 0; i < intermediate.size(); i++)
        {
            line = String.join("", intermediate.get(i));
            output.add(line);            
        }
/*
        for (int i = 0; i < intermediate.size(); i++)
        {
            for (int j = 0; j < intermediate.get(i).size(); j++)
            {
                System.out.print(intermediate.get(i).get(j) + "");
            }
            System.out.print("=\n");
        }//*/
        return output;
    }
}