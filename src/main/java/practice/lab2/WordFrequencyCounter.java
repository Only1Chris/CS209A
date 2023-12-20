package practice.lab2;

import java.io.File;
        import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequencyCounter {
//    public static class Counter{
//        private String word;
//        private int freq;
//        public Counter(String word,int freq){
//            this.word=word;
//            this.freq=freq;
//        }
//    }


    public static void main(String[] args) {
        String fileName = "alice.txt"; // Replace with your input file name

        // Create a HashMap to store the word-frequency pairs
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try {
            // Read the file
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            // Process each word in the file
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();

                // Remove any non-alphabetic characters from the word
                word = word.replaceAll("[^a-zA-Z]", "");

                // Update the word frequency in the map
                if (wordFrequencyMap.containsKey(word)) {
                    wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
                } else {
                    wordFrequencyMap.put(word, 1);
                }
            }

            // Close the scanner
            scanner.close();

            // Create a list from the entries of the HashMap
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordFrequencyMap.entrySet());

            // Sort the list using a custom comparator
            Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                    return entry2.getValue().compareTo(entry1.getValue());
                }
            });

            // Print the sorted list
//            for (Map.Entry<String, Integer> entry : entryList) {
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            }
            for (int i = 0; i < 5; i++) {
                System.out.println(entryList.get(i));
            }
            // Print the words with their frequencies
//            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
