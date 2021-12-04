import java.util.ArrayList;

public class Bingo {
    private ArrayList<Integer> board = new ArrayList<Integer>();
    private int size = 3;
    private boolean win = false;
    private ArrayList<Integer> marked_indexes = new ArrayList<Integer>();
    public int currentNumber = 0;

    public Bingo(ArrayList<Integer> board,int size) {
        this.board = board;
        this.size = size;

    }

    public boolean checkWin() {
        if(win)return false;
        int victory_count_row = 0;
        int victory_count_column = 0;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                for (int i = 0; i < marked_indexes.size(); i++) {
                    if (marked_indexes.get(i) == x + (y * size)) {victory_count_row += 1;}
                }
            }
            if (victory_count_row == size) {win = true;return true;}
            victory_count_row = 0;
        }

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (int i = 0; i < marked_indexes.size(); i++) {
                    if (marked_indexes.get(i) == x + (y * size)) {victory_count_column += 1;}
                }
            }
            if (victory_count_column == size) {win = true;return true;}
            victory_count_column = 0;
        }

        return false;
    }

    public void drawNumber(int num) {
        if(!win) currentNumber = num; else return;
        for (int i : board) {
            if (num == i) {
                marked_indexes.add(board.indexOf(i));
            }
        }
    }


    public void printboard() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                System.out.print(" "+board.get(x+(size*y)));
            }
            System.out.println(" ");
        }
    }
    public int get_sum(){
        int sum = 0;
        for (int i:board) {
            sum += i;
        }
        for (int i:marked_indexes) {
            sum -= board.get(i);
        }

        return sum;
    }
}
