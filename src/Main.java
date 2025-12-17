import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println(read());
    }

    public static int read() throws FileNotFoundException {

        File f = new File("dialCombination.txt");
        //File f = new File("test.txt");
        Scanner s = new Scanner(f);

        int dial = 50;
        int count = 0;

        while (s.hasNext()) {
            String step = s.next();
            int num = Integer.parseInt(step.substring(1));
            String sign = step.substring(0, 1);

            if (sign.equals("L")) {
                num *= -1;
            }

            boolean startZero = dial == 0;
            dial += num;

            while (dial > 99) {
                dial -= 100;
                count++;
            }

            while (dial < 0) {
                dial += 100;
                count++;
            }

            if (dial == 0) count++;
            if (startZero) count--;
        }
        return count;
    }
}
