import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testexe {


    public static void main(String[] args) {
        try {
            String exePath = "/home/anshu/GolandProjects/awesomeProject/Arrays";
            String request = "hii";

            ProcessBuilder processBuilder = new ProcessBuilder(exePath, request);
            Process process = processBuilder.start();

            // Wait for the process to complete

            int exitCode = process.waitFor();

            System.out.println("Execution completed with exit code: " + exitCode);
            System.out.println("Response from the process: " + request);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}