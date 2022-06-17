import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Copy {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь к папке которую нужно скопировать");
        String source = sc.nextLine().trim();

        System.out.println("Введите путь к папке куда нужно скопировать");
        sc = new Scanner(System.in);
        String target = sc.nextLine().trim();
        sc.close();
        copy(source, target);

    }

    private static void copy(String sourceDirectory, String targetDirectory) throws IOException {
        Files.walk(Paths.get(sourceDirectory))
                .forEach(source -> {
                    Path target = Paths.get(targetDirectory, source.toString().substring(sourceDirectory.length()));
                    try {
                        Files.copy(source, target);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
