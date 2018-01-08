/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    private ArrayList<String> wordList = new ArrayList<String>();
    private HashSet <String> wordSet = new HashSet<String>();
    private HashMap <String, ArrayList> lettersToWord = new HashMap<String, ArrayList>();

    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordList.add(word);
            wordSet.add(word);
        }
    }

    public boolean isGoodWord(String word, String base) {
        return true;
    }

    public List<String> getAnagrams(String targetWord) {
        String sortedTarget = sortedLetters(targetWord);

        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i< wordList.size(); i++){
            String swatch = sortedLetters(wordList.get(i));
            if (swatch.length()==sortedTarget.length() && swatch.equals(sortedTarget)){
                result.add(wordList.get(i));
            }
        }

        return result;
    }



    public String sortedLetters(String input){
        char[] charArr = input.toCharArray();
        Arrays.sort(charArr);
        String sorted = "";
        for (int i =0; i<charArr.length; i++){
            sorted+=charArr[i];
        }
        return sorted;
    }

    public List<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public String pickGoodStarterWord() {
        return "post";
    }
}
