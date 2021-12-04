import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) {
        BingoAdministrator ba = new BingoAdministrator("Day4/src/bingo.txt");

        for (int i:ba.num) {
            for (Bingo board:ba.boards) {
                board.drawNumber(i);
                if(board.checkWin()){
                    System.out.println(board.currentNumber*board.get_sum());
                    break;
                }
            }
        }
    }

}
