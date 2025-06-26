//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

void main(){
    var inputReader = new Scanner(System.in);
    System.out.println("What File do you want to count words in?");
    System.out.println("Short.txt or warpeace.txt");
    var userInput = inputReader.nextLine();
    var wordCount = countWords(userInput);
//    System.out.println(wordCount);
}

HashMap<String, Integer> countWords(String filename){
    var wordCount = new HashMap<String, Integer>();

    try {
        var fileLines = Files.readAllLines(Paths.get(filename));
    } catch (IOException e) {
        System.out.println("File not found" + e.getMessage());
    }

}