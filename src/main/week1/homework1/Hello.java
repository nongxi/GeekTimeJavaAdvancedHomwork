
import java.util.logging.Logger;
// Homework
public class Hello {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Hello.calss");

        int a = 1;
        double b = 12;
        double sum = 0;

        if (a < b) {
            for (; a < b; a++) {
                if (a < b) {
                    b = b - a;
                    sum = (sum + b / 2) * b;
                    System.out.println("a is less than b,the sum is :" + sum);
                }
            }
        }
    }

}
