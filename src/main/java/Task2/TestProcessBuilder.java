package Task2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestProcessBuilder {


    private static List<Exception> exceptionsList = new ArrayList<>();

    static void createProcess(String command) throws IOException {
        Thread thread = new Thread(new ProcessThread(command, exceptionsList));
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        String commandLine;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n***** Welcome to the Java Command Shell *****");
        System.out.println("If you want to exit the shell, type END and press RETURN.\n");
    
        while (true) {
            System.out.print("jsh>");
            commandLine = scanner.nextLine();

            if (commandLine.equals("showerlog")){
                System.out.println("Here are all the errors of this session:");
                exceptionsList.stream().forEach(exception -> System.out.println(exception.getMessage()));
            }

            // if user entered a return, just loop again
            else if (commandLine.equals("")) {
                continue;
            }
            else if (commandLine.toLowerCase().equals("end")) { //User wants to end shell
                System.out.println("\n***** Command Shell Terminated. See you next time. BYE for now. *****\n");
                scanner.close();
                System.exit(0);
            }
            else {
                createProcess(commandLine);
            }
        }   
    }
   
}
