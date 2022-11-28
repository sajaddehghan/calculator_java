import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InterruptedException {

        calculator calcu = new calculator();
        System.out.println("wellcome :");

        Scanner input = new Scanner(System.in);

        String str = input.next();

        calcu.check(str);

    }
}
