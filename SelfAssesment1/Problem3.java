package SelfAssesment1;
public class Problem3 {
    public static void main(String[] args)
    {
        String text = "To be or not to be, that is the question;"
                + "Whether `tis nobler in the mind to suffer"
                + " the slings and arrows of outrageous fortune,"
                + " or to take arms against a sea of troubles,"
                + " and by opposing end them?";
        int spaces = 0;
        int vowels = 0;
        int letters = 0;
        //YOUR CODE HERE
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                letters++;
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                }
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            }
        }
        System.out.println("The text contained vowels: " + vowels + "\n"
                + " consonants " + (letters - vowels) + "\n" + " spaces: " + spaces);
    }

    /* Output is:
    The text contained vowels: 60
    consonants 93
    spaces: 37 
    */
}
