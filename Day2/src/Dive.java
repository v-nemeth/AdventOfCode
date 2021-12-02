import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dive {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(deepDivePartOne("Day2/src/directions.txt"));
        System.out.println(deepDivePartTwo("Day2/src/directions.txt"));

    }

    public static int deepDivePartOne(String pathname) throws FileNotFoundException {
        int forward_sum = 0;
        int vertical_sum = 0;

        File file = new File(pathname);

        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            switch(reader.next()){
                case "forward":
                    forward_sum += reader.nextInt();
                    break;
                case "up":
                    vertical_sum -= reader.nextInt();
                    break;
                case "down":
                    vertical_sum += reader.nextInt();
                    break;
            }
        }
        reader.close();

        return forward_sum*vertical_sum;
    }

    public static int deepDivePartTwo(String pathname) throws FileNotFoundException {
        int forward_sum = 0;
        int depth = 0;
        int aim = 0;

        File file = new File(pathname);

        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            switch(reader.next()){
                case "forward":
                    int x = reader.nextInt();
                    forward_sum += x;
                    depth += x*aim;
                    break;
                case "up":
                    aim -= reader.nextInt();
                    break;
                case "down":
                    aim += reader.nextInt();
                    break;
            }
        }
        reader.close();

        return forward_sum*depth;
    }

}
