import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Binary {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> myList = file_to_string_array("Day3/src/report.txt");
        System.out.println(Gammarate(myList));
        //Decimal number = 199
        //Decimal number 2 = 3896
    }


    public static String Gammarate(ArrayList<String> list) {
        //1 or 0
        int num_of_ones = 0;
        int num_of_zeros = 0;
        String finalString = "";

        for (int i = 0; i < 12; i++) {
            for (String string: list) {
                char c = string.charAt(i);
                if(c == '1'){
                    num_of_ones += 1;
                }
                else if (c == '0'){
                    num_of_zeros += 1;
                }
            }
            if(num_of_ones>num_of_zeros){
                finalString += "1";
            }else{
                finalString += "0";
            }
            num_of_ones = 0;
            num_of_zeros = 0;
        }
        return finalString;
    }


    public static ArrayList<String> file_to_string_array(String filename) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        File file = new File(filename);

        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            list.add(reader.nextLine());
        }
        return list;
    }

}
