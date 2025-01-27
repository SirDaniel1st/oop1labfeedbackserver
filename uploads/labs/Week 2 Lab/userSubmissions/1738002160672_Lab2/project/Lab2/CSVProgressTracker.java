import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class CSVProgressTracker {
    private String filePath;

    public CSVProgressTracker(String filePath) {
        this.filePath = filePath;
    }

    // Initialize the CSV file with headers if it does not already exist
    public void initializeCSV(String[] headers) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(filePath)) {
                for (int i = 0; i < headers.length; i++) {
                    writer.append(headers[i]);
                    if (i < headers.length - 1) {
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }
        }
    }

    // Append student results to the CSV file
    public void appendStudentResults(String studentId, int[] results) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(studentId); // Add the student ID as the first column
            for (int i = 0; i < results.length; i++) {
                writer.append(",").append(String.valueOf(results[i]));
            }
            writer.append("\n");
        }
    }
}
