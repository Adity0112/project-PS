import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "credentials.txt";

    public static void saveCredentials(List<Credential> creds) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Credential c : creds) {
                bw.write(c.getWebsite() + "," + c.getUsername() + "," + c.getPassword());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Credential> loadCredentials() {
        ArrayList<Credential> list = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    list.add(new Credential(parts[0], parts[1], Encryptor.decrypt(parts[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}