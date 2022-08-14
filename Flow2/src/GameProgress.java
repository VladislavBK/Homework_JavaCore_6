import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    public void saveGame(File file, String progress) throws IOException {
        try (FileOutputStream fileStream = new FileOutputStream(file);
             ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
            objectStream.writeObject(progress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void zipFiles(File zip, String fileInZip) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zip));
            FileInputStream fileIn = new FileInputStream(fileInZip);)
        {
            ZipEntry entry = new ZipEntry(fileInZip);
            zipOut.putNextEntry(entry);
            byte[] buffer = new byte[fileIn.available()];
            fileIn.read(buffer);
            zipOut.write(buffer);
            zipOut.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}