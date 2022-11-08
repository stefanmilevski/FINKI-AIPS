/*Дадено ни е со какви типови на различни монети (различни вредности) располагаме, како и одредена сума. Со тие информации, да се пресмета кој е минималниот број на монети со коишто можеме да ја формираме таа сума, користејќи greedy пристап.

Влез: Во првиот ред одделени со празно место се дадени различните вредности на монети со коишто располагаме. Во вториот ред е дадена бараната сума.

Излез: Минималниот број на монети со коишто може да се формира сумата.

*/

import java.util.Scanner;

public class GreedyCoins {

    public static int minNumCoins(int coins[], int sum) {
        for (int i = 0; i < coins.length - 1; i++) {
            for (int j = 0; j < coins.length - i - 1; j++) {
                if (coins[j] < coins[j + 1]) {
                    int temp = coins[j];
                    coins[j] = coins[j + 1];
                    coins[j + 1] = temp;

                }
            }
        }


        int minNumCoins = 0;
        int counter = 0;
        while (sum > 0) {
            if (sum / coins[counter] > 0) {
                minNumCoins += sum / coins[counter];
                sum = sum % coins[counter];
            }
            counter++;
        }
        return minNumCoins;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String coinsStringLine = input.nextLine();
        String coinsString[] = coinsStringLine.split(" ");
        int coins[] = new int[coinsString.length];
        for (int i = 0; i < coinsString.length; i++) {
            coins[i] = Integer.parseInt(coinsString[i]);
        }

        int sum = input.nextInt();

        System.out.println(minNumCoins(coins, sum));
    }
}
