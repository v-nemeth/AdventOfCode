import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Binary {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> myList = file_to_string_array("Day3/src/report.txt");
        System.out.println(Gammarate(myList));
        //Decimal number = 199
        //Decimal number 2 = 3896

        System.out.println(rating(myList,0,"O"));
        //509
        System.out.println(rating(myList,0,"CO2"));
        //2693

    }
    
    public static boolean most_of(ArrayList<String> list, int index,String rating){
        int most_of = 0;

        for (String string:list) {
            char c = string.charAt(index);
            if(c=='1') most_of += 1;
            else if(c=='0') most_of -=1;
        }

        //true = most ones
        //false = most zeros
        if(rating.equals("O"))
            return most_of>=0;
        if(rating.equals("CO2"))
            return most_of < 0;
        else{
            System.out.println("Wrong rating input");
            return false;
        }
    }

    public static ArrayList<String> rating(ArrayList<String> list, int index, String method){
        if(list.size()==1) return list;

        ArrayList<String> newList = new ArrayList<String>();

        char bit_criteria = (most_of(list,index,method)) ? '1' : '0';

        for (String string:list) {
            if(bit_criteria == string.charAt(index)){
                newList.add(string);
            }
        }

        if(index == 11 && list.size()>1){
            index = 0;
        }


        return rating(newList,index+1,method);
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
