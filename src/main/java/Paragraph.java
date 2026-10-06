import java.util.List;

public class Paragraph {
    private List<String> words;

    public Paragraph(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return words;
    }

    @Override
    public String toString() {
        return String.join(" ", words);
    }
}
