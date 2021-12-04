import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) {
        BingoAdministrator ba = new BingoAdministrator("Day4/src/bingo.txt");

        boolean found_winner = false;

        for (int i:ba.num) {
            if(found_winner){
                break;
            }
            for (Bingo board:ba.boards) {
                board.drawNumber(i);
                if(board.checkWin()){
                    System.out.println(board.currentNumber*board.get_sum());
                    found_winner = true;
                    break;
                }
            }
        }
    }

}
