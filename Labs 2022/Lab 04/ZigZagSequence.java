/* Дадена е низа од N природни броеви и еден број K. Нека броевите се означени од a0 до aN−1. Да ја дефинираме сумата од апсолутни разлики како abs(a1−a0)+abs(a2−a1)+…+abs(aN−1−aN−2). Да се изберат точно K броеви од низата, така што кога ќе се спојат во една низа, сумата од апсолутни разлики е максимална. Да се испечати оваа сума.

Влез: Во првата линија ви се дадени два броеви N (1≤N≤100) и K (1≤K≤100, K≤N). Во втората линија ви се дадени N позитивни природни броеви, секој од броевите е помал од 1,000.

Излез: Да се испечати бараната максималната сума од апсолутни разлики.

Забелешка: Броевите се земаат во оној редослед во кој што се дадени во првата низа. Не смее да се менува редоследот на броевите во новодобиената низа.

Име на класата (Java): SumOfAbsoluteDifferences.

Делумно решение: Задачата се смета за делумно решена доколку се поминати 5 тест примери. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        int najdolgaNiza = 0;

        int dolzinaNaZigZagNiza = 1;
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] < 0 && a[i+1] > 0){
                if(dolzinaNaZigZagNiza == 1){
                    dolzinaNaZigZagNiza = 2;
                }else{
                    dolzinaNaZigZagNiza++;
                }

            } else if (a[i] > 0 && a[i+1] < 0) {
                if(dolzinaNaZigZagNiza == 1){
                    dolzinaNaZigZagNiza = 2;
                }else{
                    dolzinaNaZigZagNiza++;
                }
            }else{
                if(najdolgaNiza < dolzinaNaZigZagNiza){
                    najdolgaNiza = dolzinaNaZigZagNiza;
                }
                dolzinaNaZigZagNiza = 1;
            }
        }

        if(najdolgaNiza < dolzinaNaZigZagNiza){
            najdolgaNiza = dolzinaNaZigZagNiza;
        }

        return najdolgaNiza;


    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
