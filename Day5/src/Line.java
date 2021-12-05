import java.util.ArrayList;
import java.util.Arrays;

public class Line {
    private ArrayList<Point> points = new ArrayList<Point>();

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Line(String coordinates){
        String[] c = coordinates.split(" -\\> ");

        String[] c0 = c[0].split(",");
        String[] c1 = c[1].split(",");

        x1 = Integer.valueOf(c0[0]); y1 = Integer.valueOf(c0[1]);
        x2 = Integer.valueOf(c1[0]); y2 = Integer.valueOf(c1[1]);

        makePoints();

    }

    public void makePoints(){
        if(x1 == x2){
            for (int i = 0; i <= Math.abs(y2-y1); i++) {
                if(y2>y1) points.add(new Point(x1,y1+i));
                else if (y1>y2) points.add(new Point(x1,y1-i));
                else points.add(new Point(x1,y1));
            }
        }

        if(y1 == y2){
            for (int i = 0; i <= Math.abs(x2-x1); i++) {
                if(x2>x1) points.add(new Point(x1+i,y1));
                else if (x1>x2) points.add(new Point(x1-i,y1));
            }
        }

        if(Math.abs(x2-x1) == Math.abs(y2-y1)){
            for (int i = 0; i <= Math.abs(x2-x1); i++) {
                System.out.println((y2-y1)/Math.abs(y2-y1));
                points.add(new Point(x1+(i*(x2-x1)/Math.abs(x2-x1)),y1+(i*(y2-y1)/Math.abs(y2-y1))));

            }
        }


    }
    public ArrayList<Point> getPoints(){
        return points;
    }

}
