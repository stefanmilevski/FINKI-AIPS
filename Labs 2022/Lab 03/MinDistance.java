/*Дадени се N точки (N>=2) во дводимензионален простор. Пресметајте кое е најмалото растојание помеѓу две точки.

Влез: Во првиот ред од влезот е даден бројот на точки (N). Потоа, во следните N редови влез, се дадени координатите на секоја точка.

Излез: На излез треба да се испечати минималното растојание помеѓу две точки. */

import java.util.Scanner;

public class MinDistance {

    public static float minimalDistance(float points[][]) {
        float mininmalDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                if (shortestDistance(points[i][0], points[i][1], points[j][0], points[j][1]) < mininmalDistance) {
                    mininmalDistance = shortestDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                }
            }
        }
        System.out.println(mininmalDistance);
        return mininmalDistance;
    }

    public static float shortestDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        float points[][] = new float[N][2];

        for (int i = 0; i < N; i++) {
            points[i][0] = input.nextFloat();
            points[i][1] = input.nextFloat();
        }

        System.out.printf("%.2f\n", minimalDistance(points));
    }
}
