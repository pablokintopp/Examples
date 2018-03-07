package com.company;

import java.util.*;

public class Main {

    public Set<String> keyWordsFound = new HashSet<>();
    public List<String> keyWordsJava = new ArrayList();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Main test = new Main();

        TimerJava timer = new TimerJava();

        test.keyWordsJava.add("public");
        test.keyWordsJava.add("private");
        test.keyWordsJava.add("static");
        String inputWord = "";




        do {

            System.out.println("Informe palavra: ");

            inputWord = scanner.nextLine();




            if (test.keyWordsJava.contains(inputWord.toLowerCase())) {
                test.keyWordsFound.add(inputWord);
            }

            int foundSize = test.keyWordsFound.size();
            int totalSize = test.keyWordsJava.size();

            if(foundSize == totalSize){
                System.out.println("Parabéns! Acabou o jogo em: ");
                inputWord = "0";

            }else{
                System.out.println("Found: " + foundSize + " of " + totalSize );

            }



            System.out.println();


        } while (!inputWord.equals("0"));





    }

    public static class TimerJava extends TimerTask{

        @Override
        public void run() {

        }
    }
}
