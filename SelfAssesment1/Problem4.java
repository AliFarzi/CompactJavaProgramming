package SelfAssesment1;

import java.util.ArrayList;

public class Problem4 {
    public static void main(String[] args)
    {
        String text = "To be or not to be, that is the question;"
                + "Whether `tis nobler in the mind to suffer"
                + " the slings and arrows of outrageous fortune,"
                + " or to take arms against a sea of troubles,"
                + " and by opposing end them?";

        //Counting letters so we can filter out one-letter words
        int letters = 0;

        //Temporary storage for each word
        String word = "";

        //List of words with 2 or more letters
        ArrayList <String> words = new ArrayList<String>();

        //YOUR CODE HERE

        //Iterate through each character in the string
        for (int i = 0; i < text.length(); i++) {
            
            //Get the character at position i
            char ch = text.charAt(i);

            //If the character is a letter, add it to the current word
            if (Character.isLetter(ch)) {
                word += ch;
                letters++;

            //If the character is not a letter, we have reached the end of a word
            } else{
                
                //If the word has 2 or more letters, add it to the list
                if (!word.isEmpty() && letters >= 2) {
                    words.add(word);
                }

                //Reset the word and letter count for the next word
                word = "";
                letters = 0;
            }
        }  
        //Output the list of words
        System.out.println("Unsorted list of words: " + words);  

        //sorting the list of words in alphabetical order
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = 0; j < words.size() - 1 - i; j++) {
                if (words.get(j).compareToIgnoreCase(words.get(j+1)) > 0) {
                    //Swap words[i] and words[j]
                    String temp = words.get(j);
                    words.set(j, words.get(j+1));
                    words.set(j+1, temp);
                }
            }
        }
        //Output the sorted list of words
        System.out.println("Sorted list of words: " + words);
    }

    /* 
    Definition of word: A sequence of letters (A-Z, a-z) that is at least two letters long.
    Any non-letter character is a word separator.
    
    Output is:
    Unsorted list of words: [To, be, or, not, to, be, that, is, the, question, Whether, tis, nobler, in, the,
     mind, to, suffer, the, slings, and, arrows, of, outrageous, fortune, or, to, 
    take, arms, against, sea, of, troubles, and, by, opposing, end, them]

    Sorted list of words: [against, and, and, arms, arrows, be, be, by, end, fortune, in, is, mind, nobler,
     not, of, of, opposing, or, or, outrageous, question, sea, slings, suffer, take, that, the, the, the, 
     them, tis, To, to, to, 
    to, troubles, Whether]
    */
}
