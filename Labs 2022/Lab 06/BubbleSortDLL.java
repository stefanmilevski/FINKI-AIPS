/* Дадена е една двојно поврзана листa и со N јазли кои во себе содржат по еден природен број. Треба да се сортира листата со помош на сортирањето со меурчиња (bubble sort).

Во првиот ред од влезот е даден бројот на јазли во листата, а потоа во вториот ред се дадени јазлите од кои е составена. На излез треба да се испечатат јазлите на сортираната листа.



Име на класата: BubbleSortDLL



Забелешка: При реализација на задачата МОРА да се користи дадената структура, а не да користат помошни структури како низи и сл.

For example: */


package Lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return "<-" + element.toString() + "->";
    }
}

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            DLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        }
        // else throw Exception
        return null;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp + "<->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "<->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {

        return last;
    }

}


public class BubbleSortDLL {

    public static void BubbleSortLinkedList(DLL<Integer> l){

        DLLNode<Integer> currentNode = l.getFirst();
        int listSize = l.length();

        for(int i = 0; i < listSize;i++){
            DLLNode<Integer> currentNodeNested = l.getFirst();
            for(int j = 0; j < listSize - i -1; j++){

                if(currentNodeNested.element > currentNodeNested.succ.element){
                    int temp = currentNodeNested.element;
                    currentNodeNested.element = currentNodeNested.succ.element;
                    currentNodeNested.succ.element = temp;

                }
                currentNodeNested = currentNodeNested.succ;

            }

            currentNode = currentNode.succ;


        }
    }





    public static void printLinkedList(DLL<Integer> l){
        while (l.getFirst() !=null){
            System.out.print(l.deleteFirst());
            System.out.print(" ");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        DLL<Integer> lista = new DLL<>();
        for(int i = 0; i < n; i++){
            Integer nextNumber = scanner.nextInt();
            lista.insertLast(nextNumber);
        }
        BubbleSortLinkedList(lista);

        printLinkedList(lista);
    }

}