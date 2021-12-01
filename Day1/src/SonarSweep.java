import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SonarSweep {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> data = file_to_array_int("Day1/src/data.txt");

        System.out.println(num_of_increase(data));

        System.out.println(num_of_increase(three_measure_sum(data)));
    }

    public static int num_of_increase(ArrayList<Integer> int_list) {
        int num = 0;
        int prev = 0;
        for (int i : int_list) {
            if (i > prev && prev != 0) {
                num += 1;
            }
            prev = i;
        }
        return num;
    }

    public static ArrayList<Integer> three_measure_sum(ArrayList<Integer> int_list) {
        ArrayList<Integer> new_list = new ArrayList<Integer>();

        for (int i = 0; i < int_list.size(); i++) {
            if(i+2 == int_list.size()){break;}

            int sum = int_list.get(i) + int_list.get(i + 1) + int_list.get(i + 2);
            new_list.add(sum);
        }
        return new_list;
    }

    public static ArrayList<Integer> file_to_array_int(String pathname) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        File file = new File(pathname);

        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            list.add(Integer.valueOf(reader.nextLine()));
        }
        return list;
    }
}


