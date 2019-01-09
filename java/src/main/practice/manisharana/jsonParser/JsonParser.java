package main.practice.manisharana.jsonParser;

import java.util.Scanner;

public class JsonParser {
    
    public static void main(String[] args) {
        System.out.println("Enter Json String:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();


        System.out.println(new SpaceParser().parse(input).toString());
        System.out.println(new CommaParser().parse(input).toString());
    }
}
