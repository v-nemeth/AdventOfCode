import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> data = file_to_string_array("Day5/src/lines.txt");
        ArrayList<Line> lines = new ArrayList<Line>();

        int[][] map = new int[1000][1000];

        int overlap = 0;

        for (String string:data) {
            lines.add(new Line(string));
        }

        for (Line line:lines) {
            for (Point point:line.getPoints()) {
                map[point.x][point.y] += 1;
            }
        }

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                //System.out.print(map[y][x]);
                if(map[x][y] > 1) overlap += 1;
            }
            //System.out.println(" ");
        }
        System.out.println(overlap);
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
