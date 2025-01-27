import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;

public class FeedbackGenerator extends PdfPageEventHelper {

    private static String studentName; // Static variable to store the student name
    private Font footerFont;

    public FeedbackGenerator() {
        this.footerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC);
    }

    public static void generateFeedback(String studentFolder, int labNum, String feedback, int totalScore) {
        try {
             String[] folderParts = studentFolder.split("_");
            if (folderParts.length < 3) {
                throw new IllegalArgumentException("Invalid studentFolder format. Expected format: '<timestamp>_<studentName>_<labId>'.");
            }
            studentName = folderParts[1]; // Extract the second part as the name
            // Generate PDF file path
            String pdfPath = studentFolder + "_lab" + labNum + "Feedback.pdf";

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            FeedbackGenerator footerEvent = new FeedbackGenerator();
            writer.setPageEvent(footerEvent);
            document.open();

            // Add logo
            String logoPath = "logo.png";
            if (new File(logoPath).exists()) {
                Image logo = Image.getInstance(logoPath);
                logo.setAlignment(Element.ALIGN_CENTER);
                logo.scaleToFit(100, 100);
                document.add(logo);
            }

            // Add centered title
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph title = new Paragraph("OBJECT ORIENTED PROGRAMMING 1 \nLab " + labNum + " Feedback Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Add centered student details
            Font detailsFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            Paragraph studentDetails = new Paragraph("Student: " + studentName, detailsFont);
            studentDetails.setAlignment(Element.ALIGN_CENTER);
            document.add(studentDetails);
            document.add(new Paragraph("\n")); // Add space after details

            // Add section headings and feedback
            Font sectionFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font feedbackFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

            String[] sections = feedback.split("Lab \\d Part \\d tests:");
            for (int i = 1; i < sections.length; i++) {
                String sectionHeader = "Lab " + labNum + " Part " + i + " tests:";
                Paragraph sectionTitle = new Paragraph(sectionHeader, sectionFont);
                sectionTitle.setSpacingBefore(10);
                sectionTitle.setSpacingAfter(5);
                document.add(sectionTitle);

                String sectionFeedback = sections[i].trim();
                String[] lines = sectionFeedback.split("\n");

                for (String line : lines) {
                    if (line.contains("\u2705")) { // ✅ Emoji
                        line = line.replace("\u2705", "").trim();
                        document.add(createParagraphWithEmoji("check.png", line));
                    } else if (line.contains("\u274C")) { // ❌ Emoji
                        line = line.replace("\u274C", "").trim();
                        document.add(createParagraphWithEmoji("cross.png", line));
                    } else {
                        document.add(new Paragraph(line, feedbackFont)); // Regular line
                    }
                }

                document.add(new Paragraph("\n")); // Add spacing between sections
            }

            document.close();
            System.out.println("Feedback generated: " + pdfPath);
        } catch (Exception e) {
            System.err.println("Error generating feedback PDF: " + e.getMessage());
        }
    }

    private static Paragraph createParagraphWithEmoji(String imagePath, String text) throws Exception {
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            throw new Exception("Image file not found: " + imagePath);
        }

        Image emojiImage = Image.getInstance(imageFile.getAbsolutePath());
        emojiImage.scaleAbsolute(12, 12);

        Chunk imageChunk = new Chunk(emojiImage, 0, 0, true);
        Chunk textChunk = new Chunk(" " + text);

        Paragraph paragraph = new Paragraph();
        paragraph.add(imageChunk);
        paragraph.add(textChunk);

        return paragraph;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte canvas = writer.getDirectContent();
        Phrase footer = new Phrase("Object Oriented Programming I (2024/2025) - Department of Computing and Information Technology", footerFont);
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, footer,
                (document.left() + document.right()) / 2, document.bottom() - 20, 0);
    }

    // Static method to get the student name
    public static String getStudentName() {
        return studentName;
    }
}
