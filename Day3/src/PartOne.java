import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> myList = file_to_string_array("Day3/src/report.txt");

        String gammaRate = gammaRate(myList);
        String epsilonRate = flip_binary(gammaRate);

        System.out.println(binary_to_decimal(gammaRate));  //Decimal number = 199
        System.out.println(binary_to_decimal(epsilonRate));  //Decimal number 2 = 3896

        System.out.println(199*3896);

    }

    public static String gammaRate(ArrayList<String> list) {
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

    public static String flip_binary(String binary){
        String newString = "";
        for (int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i)=='0'){
                newString += "1";
            }
            else{
                newString += "0";
            }
        }
        return newString;
    }

    public static int binary_to_decimal(String binary){
        int decimal = 0;
        for (int i = binary.length()-1; i >= 0; i--) {
            int power = binary.length()-i-1;
            int c = Character.getNumericValue(binary.charAt(i));

            decimal += c*Math.pow(2,power);

        }
        return decimal;
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
