//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

void main(){
    var inputReader = new Scanner(System.in);
    System.out.println("What File do you want to count words in?");
    System.out.println("Short.txt or warpeace.txt");
    var userInput = inputReader.nextLine();
    if (userInput.isEmpty()) {
        var newInput = inputReader.nextLine();
        userInput = newInput;
    }
    var wordCount = countWords(userInput);
    for(var entry: wordCount.entrySet()){
        System.out.println(entry.getKey() + " :\t " + entry.getValue());
    }

//    System.out.println(wordCount);
}

HashMap<String, Integer> countWords(String filename){
    var wordCountDict = new HashMap<String, Integer>();
    List<String> fileLines = null;
    try {
        fileLines = Files.readAllLines(Paths.get(filename));
    } catch (IOException e) {
        System.out.println("File not found" + e.getMessage());
        System.exit(1);
    }
    for(var line: fileLines){
        var cleanLine = line.replaceAll("\\p{Punct}", "");
        var words = line.split("\\W+");
        for(var word: words){
            if(wordCountDict.containsKey(word)){
                wordCountDict.put(word, wordCountDict.get(word) + 1);
            }else{
                wordCountDict.put(word, 1);
            }
        }
    }
    return wordCountDict;
}