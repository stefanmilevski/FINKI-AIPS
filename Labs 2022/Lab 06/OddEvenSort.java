import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n)
    {
        int[] temp = a.clone();
        int evenNumberCount = EvenNumberCount(a,n);
        int oddNumberCount = OddNumberCount(a,n);

        int index = 0;

        while(oddNumberCount > 0){
            a[index] = MinOddNumber(temp,temp.length);
            temp = removeTheElement(temp,MinOddNumberIndex(temp,temp.length));
            index++;
            oddNumberCount--;
        }


        while(evenNumberCount > 0){
            a[index] = MaxEvenNumber(temp,temp.length);
            temp = removeTheElement(temp,MaxEvenNumberIndex(temp,temp.length));
            index++;
            evenNumberCount--;
        }


    }

    static int EvenNumberCount(int a[], int n){
        int count = 0;
        for (int i = 0; i < n; i++){
            if(a[i] % 2 == 0){
                count++;
            }
        }
        return count;
    }

    static int OddNumberCount(int a[], int n){
        int count = 0;
        for (int i = 0; i < n; i++){
            if(a[i] % 2 != 0){
                count++;
            }
        }
        return count;
    }


    static int MaxEvenNumber(int a[], int n){
        int maxEven = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if(a[i] % 2 == 0 && a[i] > maxEven){
                maxEven = a[i];
            }
        }
        return maxEven;
    }

    static int MaxEvenNumberIndex(int a[], int n){
        int maxEvenIndex = Integer.MIN_VALUE;
        int maxEven = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if(a[i] % 2 == 0 && a[i] > maxEven){
                maxEven = a[i];
                maxEvenIndex = i;
            }
        }

        return maxEvenIndex;
    }



    static int MaxOddNumber(int a[], int n){
        int maxOdd = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if(a[i] % 2 != 0 && a[i] > maxOdd){
                maxOdd = a[i];
            }
        }
        return maxOdd;
    }

    static int MaxOddNumberIndex(int a[], int n){
        int maxOddIndex = Integer.MIN_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if(a[i] % 2 != 0 && a[i] > maxOdd){
                maxOddIndex = i;
                maxOdd = a[i];
            }
        }
        return maxOddIndex;
    }

    static int MinOddNumber(int a[], int n){
        int minOdd = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            if(a[i] % 2 != 0 && a[i] < minOdd){
                minOdd = a[i];
            }
        }
        return minOdd;
    }

    static int MinOddNumberIndex(int a[], int n){
        int minOddIndex = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            if(a[i] % 2 != 0 && a[i] < minOdd){
                minOddIndex = i;
                minOdd = a[i];
            }
        }
        return minOddIndex;
    }




    public static int[] removeTheElement(int[] arr, int index)
    {

        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        int[] anotherArray = new int[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }

            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }





    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}