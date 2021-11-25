import java.util.Arrays;
import java.util.Scanner;

public class MemoryGame {
    static String[][] front = {
        {"１", "２", "３", "４", "５", "６", "７", "８", "９", "10", "11", "12", "13"},
        {"１", "２", "３", "４", "５", "６", "７", "８", "９", "10", "11", "12", "13"},
        {"１", "２", "３", "４", "５", "６", "７", "８", "９", "10", "11", "12", "13"},
        {"１", "２", "３", "４", "５", "６", "７", "８", "９", "10", "11", "12", "13"},
    };
    static String[][] back = {
        {"＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊",},
        {"＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊",},
        {"＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊",},
        {"＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊", "＊",},
    };
    static String number = " １　２　３　４　５　６　７　８　９　10  11  12  13";
    static int height1;
    static int width1;
    static int height2;
    static int width2;
    static int count = 1;
    static int player_turn = 0;

    /* main */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("何人で遊びますか？");
        int player_num = sc.nextInt();
        System.out.println("神経衰弱スタート");
        System.out.println("途中終了する場合は'99'を入力してください");

        Array.shuffle(front);
        Array.getArray(back, number);

        do {
            System.out.println(player_turn % player_num + 1 + "番の人のターン");
            System.out.println("カードを二枚選んでください");
            do {
                System.out.print("[" + (count) + "枚目]左から : ");
                width1 = Input.input(sc, 13) - 1;
                System.out.print("[" + (count) + "枚目]右から : ");
                height1 = Input.input(sc, 4) - 1;
            } while (Flip().equals("true"));
            Array.getArray(back, number);
            
            do {
                while (true) {
                    System.out.print("[" + (count) + "枚目]左から : ");
                    width2 = Input.input(sc, 13) - 1;
                    System.out.print("[" + (count) + "枚目]右から : ");
                    height2 = Input.input(sc, 4) - 1;
                    if (height1 == height2 && width1 == width2) {
                        System.out.println("一枚目と違うカードを選択してください");
                    } else {
                        break;
                    }
                }
            } while (Flip().equals("true"));
            Array.getArray(back, number);
        } while (Judge().equals("true") || GameEnd().equals("false"));
    }    

    /* method */
    //--- カードをめくる ---//
    static String Flip() {
        String judge;
        if (count == 1) {
            if (back[height1][width1].equals("　")) {
                System.out.println("既に揃っているカードです");
                judge = "true";
            } else {
                back[height1][width1] = front[height1][width1];
                count = 2; 
                judge = "false";
            }
        } else {
            if (back[height2][width2].equals("　")) {
                System.out.println("既に揃っているカードです");
                judge = "true";
            } else {
                back[height2][width2] = front[height2][width2];
                count = 1;
                judge = "false";
            }
        }
        return judge;
    }

    //--- めくったカードが同じ数字か判定 ---//
    static String Judge() {
        String judge;
        if (back[height1][width1].equals(back[height2][width2])) {
            judge = "true";
            System.out.println("正解！もう一度");
            // カードを省く
            back[height1][width1] = "　";
            back[height2][width2] = "　";
        } else {
            judge = "false";
            System.out.println("残念");
            // カードを裏向ける
            back[height1][width1] = "＊";
            back[height2][width2] = "＊";
            player_turn++;
        }
        return judge;
    }

    //--- 全部そろってゲーム終了 ---//
    static String GameEnd() {
        String gameend;
        if (Arrays.equals(front, back)) {
            gameend = "ture";
        } else {
            gameend = "false";
        } 
        return gameend;
    }
}