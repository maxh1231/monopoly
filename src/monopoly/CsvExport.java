package monopoly;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvExport {

    public static void exportToCSV(String filename, int[] data, int[] data2, int[] data3, int[] data4) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("n = 1000,n = 10000,n = 100000,n = 1000000,\n");
            for (int i = 0; i < data.length; i++) {
                bw.write(data[i] + "," + data2[i] + "," + data3[i] + "," + data4[i] + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}