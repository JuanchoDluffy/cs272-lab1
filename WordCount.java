import java.io.*;
import java.util.*;

public class WordCount {
    public static int lineCount(String fileName) throws IOException {
        // read text file and count the number of lines
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lines = 0;
        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();
        return lines;
    }// end of line count method

    public static void countWords(String inputString, String FILEname) throws IOException {
        // Split input string into words
        String[] words = inputString.split(",");
        // convert all words to lower case
        for (int l = 0; l < words.length; l++) {
            words[l] = words[l].toLowerCase();
        }
        // clean up duplicates from array words
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    words[j] = "";
                }
            }
        }
        // Create a map to store word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILEname))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Clean the line from special characters and convert it to lower case
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                for (String word : words) {
                    // convert line into array of words and count the occurrences of each word
                    int count = 0;
                    String[] lineList = line.split(" ");
                    for (int x = 0; x < lineList.length; x++) {
                        if (lineList[x].equals(word)) {
                            count++;
                        }
                    }
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + count);
                }
            }
        }
        // remove key for empty string to avoid priting count of ""
        wordCounts.remove("");
        // Write the word counts to the output file
        try (PrintWriter writer = new PrintWriter(new File("WordCount.csv"))) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }// end of count words method

    public static void main(String[] args) throws Exception {
        int num = lineCount("pg100.txt");
        System.out.println(num);
        countWords("the,,she,her,language,king,king's,he's,thus", "pg100.txt");
    }// end of main method
}// end of class