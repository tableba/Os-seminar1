package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ProcessThread implements Runnable {

    private String commands;
    private List<Exception> exceptions;


    public ProcessThread(String commands, List<Exception> exceptions){
        this.commands = commands;

        this.exceptions = exceptions;
    }

    @Override
    public void run() {
        List<String> input = Arrays.asList(commands.split(" "));

        ProcessBuilder processBuilder = new ProcessBuilder(input);
        BufferedReader bufferReader = null;
        try {

            Process proc = processBuilder.start();
            InputStream inputStream = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            bufferReader = new BufferedReader(isr);

            String line;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line );
            }
            bufferReader.close();
        } catch (IOException ioe) {
            System.err.println("Error:");
            System.err.println(ioe);
            exceptions.add(ioe);


        } finally {
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
