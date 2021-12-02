import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dive {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(deepDive("Day2/src/directions.txt"));

    }

    public static int deepDive(String pathname) throws FileNotFoundException {
        int forward_sum = 0;
        int up_sum = 0;
        int down_sum = 0;

        File file = new File(pathname);

        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            switch(reader.next()){
                case "forward":
                    forward_sum += reader.nextInt();
                    break;
                case "up":
                    up_sum += reader.nextInt();
                    break;
                case "down":
                    down_sum += reader.nextInt();
                    break;
            }
        }
        reader.close();

        return forward_sum*(down_sum-up_sum);
    }
}
