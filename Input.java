import java.util.Scanner;
public class Input {
    //--- 列行入力 ---//
    static int input(Scanner sc, int maxnum) {
        int num = sc.nextInt();
        if (num == 99) {    // 99が入力されたらプログラムを終了
            System.out.println("終了します");
            System.exit(0);
        } else if (num < 1 || maxnum < num) {
            System.out.println("1～" + maxnum + "で入力してください : ");
            return input(sc, maxnum);
        }
        return num;
    }
}
