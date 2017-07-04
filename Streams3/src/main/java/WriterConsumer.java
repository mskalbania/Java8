import java.io.*;
import java.util.function.Consumer;

public class WriterConsumer implements Consumer<Integer> {

    private String path;

    public WriterConsumer(String path) {
        this.path = path;
    }

    @Override
    public void accept(Integer integer) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(integer + ",");
            bw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
