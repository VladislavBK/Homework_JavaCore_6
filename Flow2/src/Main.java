import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File save1 = new File("E:\\JavaHomework\\Flow\\Games\\savegames", "save1.dat");
        File save2 = new File("E:\\JavaHomework\\Flow\\Games\\savegames", "save2.dat");
        File save3 = new File("E:\\JavaHomework\\Flow\\Games\\savegames", "save3.dat");

        File zip = new File("E:\\JavaHomework\\Flow\\Games\\savegames", "zip.zip");

        try {
            if(zip.createNewFile()) {
                System.out.println("Файл zip.zip был создан");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(save1.createNewFile()) {
                System.out.println("Файл save1.dat был создан");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(save2.createNewFile()) {
                System.out.println("Файл save2.dat был создан");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(save3.createNewFile()) {
                System.out.println("Файл save3.dat был создан");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameProgress progress1 = new GameProgress(80, 1, 12, 64.30);
        GameProgress progress2 = new GameProgress(60, 2, 15, 104.25);
        GameProgress progress3 = new GameProgress(100, 3, 24, 250.32);

        progress1.saveGame(save1, "save.dat");
        progress2.saveGame(save2, "save1.dat");
        progress3.saveGame(save3, "save2.dat");

        progress1.zipFiles(zip, "save.dat");
        progress2.zipFiles(zip, "save1.dat");
        progress3.zipFiles(zip, "save2.dat");
    }
}
