import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class datafromexe {

    public static void main(String[] args) {
        try {
            String exePath = "/home/anshu/GolandProjects/awesomeProject/Arrays";
            String request = "request";
            ProcessBuilder processBuilder = new ProcessBuilder(exePath, request);
            Process process = processBuilder.start();

            // Read the output stream of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder responseBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();

            String response = responseBuilder.toString();
            System.out.println("Execution completed with exit code: " + exitCode);
            System.out.println("Response from the process:"+ request +"\n" +  response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}