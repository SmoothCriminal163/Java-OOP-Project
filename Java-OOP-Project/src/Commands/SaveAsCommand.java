package Commands;
import Editor.Editor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SaveAsCommand implements Command {
    private Path filePath;
    private List<String> content;

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Usage: saveas <filepath>");
        }
        Path newFilePath = Paths.get(args[1]);
        try {
            Editor.saveAs(newFilePath);
            //Files.write(newFilePath, content);
            //this.filePath = newFilePath;
            //System.out.println("Successfully saved as " + filePath.getFileName());
        } catch (IOException e) {
            System.out.println("Error saving as " + newFilePath.getFileName() + ": " + e.getMessage());
            throw new RuntimeException("Could not save file", e);
        }
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}