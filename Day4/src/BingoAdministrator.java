import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BingoAdministrator {
    private String numbers = "";

    public ArrayList<Integer> num;
    public ArrayList<Bingo> boards = new ArrayList<Bingo>();

    public BingoAdministrator(String filename){
        loadBingoBoards(filename);
        num = string_to_array(numbers);
    }


    public void loadBingoBoards(String filename){
        File file = new File(filename);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                numbers += reader.nextLine();
                ArrayList<Integer> board = new ArrayList<Integer>();
                for (int i = 0; i < 25; i++) {
                    board.add(reader.nextInt());
                }
                boards.add(new Bingo(board,5));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> string_to_array(String string){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(string.split("\\s*,\\s*")));
        ArrayList<Integer> l = new ArrayList<Integer>();

        for (String str:list) {
            l.add(Integer.valueOf(str));
        }
        return l;
    }

}
