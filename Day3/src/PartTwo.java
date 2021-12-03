import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> myList = PartOne.file_to_string_array("Day3/src/report.txt");

        String OxygenRating = rating(myList,0,"O").get(0);
        String CO2Rating = rating(myList,0,"CO2").get(0);

        System.out.println(PartOne.binary_to_decimal(OxygenRating)); //509
        System.out.println(PartOne.binary_to_decimal(CO2Rating)); //2693

        System.out.println(509*2693);

    }

    public static boolean most_of(ArrayList<String> list, int index, String rating){
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
}
