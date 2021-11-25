import java.util.Arrays;
import java.util.Random;

public class Array {
    //--- 二次元配列と列、行番号の表示 ---//
    static void getArray(String array[][], String str) {
        System.out.println(" " + str);
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + Arrays.toString(array[i])); 
        }
    }

    //--- 二次元配列をシャッフル ---//
    static void shuffle(String array[][]) {
        Random rand = new Random();
        int random_h;
        int random_w;
        String value;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                random_h = rand.nextInt(array.length);
                random_w = rand.nextInt(array[i].length);
                value = array[i][j];
                array[i][j] = array[random_h][random_w];
                array[random_h][random_w] = value;
            }
        }
    }
}
