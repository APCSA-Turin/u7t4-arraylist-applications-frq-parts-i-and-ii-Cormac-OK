package com.example.project.WordScramble;
import java.util.ArrayList;
import java.util.Arrays;
public class WordScramble {
  /** Scrambles a given word.
   *
   *  @param word  the word to be scrambled
   *  @return  the scrambled word (possibly equal to word)
   *
   *  Precondition: word is either an empty string or contains only uppercase letters.
   *  Postcondition: the string returned was created from word as follows:
   *  - the word was scrambled, beginning at the first letter and continuing from left to right
   *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
   *  - letters were swapped at most once
   */
  public static String scrambleWord(String word) {
    char[] wordArray = new char[word.length()];
    for (int i = 0; i < word.length(); i ++){
      wordArray[i] = word.charAt(i);
    }

    for (int i = 0; i < wordArray.length-1; i ++){
      if(wordArray[i] == 'A' && wordArray[i+1] != 'A'){
        char temp = wordArray[i];
        wordArray[i] = wordArray[i+1];
        wordArray[i+1] = temp;
        i++;
      }
    }

    String scrambledWord = "";
    for(char letter: wordArray){
      scrambledWord += letter;
    }

    return scrambledWord;
  }

  /** Modifies wordList by replacing each word with its scrambled
   *  version, removing any words that are unchanged as a result of scrambling.
   *
   *  @param wordList the list of words
   *
   *  Precondition: wordList contains only non-null objects
   *  Postcondition:
   *  - all words unchanged by scrambling have been removed from wordList
   *  - each of the remaining words has been replaced by its scrambled version
   *  - the relative ordering of the entries in wordList is the same as it was
   *    before the method was called
   */
  public static ArrayList<String> scrambleOrRemove(ArrayList<String> wordList) {
    ArrayList<String> original = new ArrayList<String>();
    for (String str: wordList){
      original.add(str);
    }

    for(int i = 0; i < wordList.size(); i ++){
      wordList.set(i, scrambleWord(wordList.get(i)));
    }
    for(int i = 0; i < wordList.size(); i ++){
      if(wordList.get(i).equals(original.get(i))){
        wordList.remove(i);
        original.remove(i);
        i--;
      }
    }

    return wordList;
    
  }
}
