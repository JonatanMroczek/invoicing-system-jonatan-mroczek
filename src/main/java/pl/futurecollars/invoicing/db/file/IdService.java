package pl.futurecollars.invoicing.db.file;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.futurecollars.invoicing.utils.FilesService;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IdService {

    private Path idFilePath;
    private FilesService filesService;

    private long nextID = 1L;

    public IdService(Path idFilePath, FilesService filesService) {
        this.idFilePath = idFilePath;
        this.filesService = filesService;

        try {
            List<String> lines = filesService.readAllLines(idFilePath);
            if (lines.isEmpty()) {
                filesService.writeToFile(idFilePath, "1");
            } else {
                nextID = Integer.parseInt(lines.get(0));
            }

        } catch (IOException ex) {
            throw new RuntimeException("Failed to initialize id database", ex);

        }
    }

    public long getNextIdAndIncrement() {
        try {
            filesService.writeToFile(idFilePath, String.valueOf(nextID + 1));
            return nextID++;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to read id file", ex);
        }
    }

}

