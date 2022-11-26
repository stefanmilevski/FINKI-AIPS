//* На автобуската станица во ФинТаун имало N возрасни и M деца кои што сакале да патуваат заедно за соседниот град МинТаун. Цената на еден билет е 100 денари. Ако некој возрасен сака да патува со k деца, треба да плати еден билет за него и k-1 билети за децата (за едно дете не мора да плаќа билет). Исто така, возрасен може да се вози и сам, во тој случај ќе си плати еден билет за него. Дополнително знаеме дека децата не можат да се возат без да се придружени од некој возрасен.
//
//Во првиот ред од влезот е даден бројот N. Во вториот ред е даден бројот M. Потребно е да пресметате колкав е минималниот и максималниот број на денари што може да ги платат патниците за билети и да ги испечатите во две линии. Во автобусот ќе има најмалку еден возрасен. */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {


    public static int minPayment(int adults,int children){
        int minPayment = 0;
        while (adults > 1){
            minPayment += 100;
            adults--;
            children--;
        }
        if(adults > 0){
            minPayment += 100;
            for(int i = 1; i < children; i++){
                minPayment+=100;
            }
        }

        return minPayment;
    }

    public static int maxPayment(int adults,int children){
        int maxPayment = 0;
        while (adults > 1){
            maxPayment += 100;
            adults--;
        }
        if(adults > 0){
            maxPayment += 100;
            for(int i = 1; i < children; i++){
                maxPayment+=100;
            }
        }

        return maxPayment;
    }





    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        System.out.println(minPayment(N,M));
        System.out.println(maxPayment(N,M));
    }

}
