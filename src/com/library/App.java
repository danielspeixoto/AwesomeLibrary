package com.library;

import com.library.creator.OperationCreator;

import java.util.Scanner;

public class App {

    public static String EXIT_CMD = "sai";

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    OperationCreator creator = OperationCreator.getInstance();
	    String command;
        command = scanner.nextLine();
	    while(!command.equals(EXIT_CMD)) {
            System.out.println(
                    creator.getOperation(command)
                            .execute()
            );
            command = scanner.nextLine();
        }
    }
}
