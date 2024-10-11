import java.io.*;

public class Connector {

    private File file;

    public File getFile() {
        return file;
    }

    public Connector(String filename) {
        this.file = new File(filename);
    }

    public Connector(File file) {
        this.file = file;
    }

    public void write(Client[] database) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(database.length);
            for (Client client : database) {
                oos.writeObject(client);
            }
            oos.flush();
        }
    }

    public Client[] read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        try (ObjectInputStream oin = new ObjectInputStream(fis)) {
            int length = oin.readInt();
            Client[] result = new Client[length];
            for (int i = 0; i < length; i++) {
                result[i] = (Client) oin.readObject();
            }
            return result;
        }
    }
}
