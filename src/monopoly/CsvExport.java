package monopoly;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvExport {

    public static void exportToCSV(String filename, int[] data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("Square,Count\n");
            for (int i = 0; i < data.length; i++) {
                bw.write(i + "," + data[i] + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}