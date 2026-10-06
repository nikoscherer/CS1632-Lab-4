import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String file_name = "test_file_1.txt";
        List<Paragraph> paragraphs =
                readTextFileIntoParagraphs("data/" + file_name);

        for (Paragraph p : paragraphs) {
            System.out.println(p.toString());
            System.out.println("-------");
        }
    }

    public static List<Paragraph> readTextFileIntoParagraphs(String file_name) {
        ArrayList<Paragraph> paragraphs = new ArrayList<>();
        ArrayList<String> currentLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {
            while (br.ready()) {
                String line = br.readLine();

                if (!line.trim().isEmpty()) {
                    currentLines.add(line.trim());

                    if (!br.ready() && !currentLines.isEmpty()) {
                        paragraphs.add(createParagraphFromLines(currentLines));
                    }
                } else if (!currentLines.isEmpty()){
                    paragraphs.add(createParagraphFromLines(currentLines));
                    currentLines.clear();
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot read file!");
        }

        return paragraphs;
    }

    public static Paragraph createParagraphFromLines(List<String> lines) {
        String[] words = String.join(" ", lines).split("\\s+");

        return new Paragraph(Arrays.stream(words).toList());
    }
}