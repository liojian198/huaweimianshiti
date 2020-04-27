import java.util.HashMap;
import java.util.Scanner;

public class Test {

    private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        //init map
        for(int i = 12; i < 20; i ++) {
            map.put(i, 0);
        }

        Scanner in = new Scanner(System.in);
        int num = 0;
        while (in.hasNext() && num < 100) {
            String[] chars = in.next().split(",");
            int come = Integer.valueOf(chars[0]);
            int leave = Integer.valueOf(chars[1]);

            if(come >= leave) {
                System.out.println("come time is larger than leave time");
                continue;
            }

            if(-1 == come && -1 == leave) {
                break;
            }
            if((come < 12)|| (come >= 20) || (leave <= 12)|| (leave > 20)) {
                System.out.println("error time" +"[ " + come + " : "+ leave +" ]");
                continue;
            }
            counts(come, leave);
            num++;

        }
        if(100 == num ) {
            System.out.println("customer has been 100");
        }
        for(int i = 12; i < 20; i ++) {
            System.out.println("[" + i + "," + (i+1)+"):" +map.get(i));
        }

    }

    public static void counts (int come, int leave) {
        for (int i = come; i < leave; i ++) {
            map.put(i, map.get(i) + 1);
        }
    }
}
