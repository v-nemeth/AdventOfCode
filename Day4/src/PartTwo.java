public class PartTwo {
    public static void main(String[] args) {
        BingoAdministrator ba = new BingoAdministrator("Day4/src/bingo.txt");

        for (int i:ba.num) {
            ba.drawNumber(i);
        }
        Bingo last_winner = ba.winnerboards.getLast();
        System.out.println(last_winner.get_sum()*last_winner.currentNumber);
    }
}
