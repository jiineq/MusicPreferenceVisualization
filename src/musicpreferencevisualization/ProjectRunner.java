package musicpreferencevisualization;

import java.util.Random;
public class ProjectRunner {

    public static void main(String[] args) {
        LList<String> list = new LList<String>();
        Random r = new Random();
        for (int i = 100; i > 0; i --) {
            list.add(""+r.nextInt(500));
        }
        System.out.println(list.toString());
        list.sort();
        System.out.println(list.toString());
    }
}
