package lesson9;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassWork2 {
    private ArrayList<Integer> spisok;
    private ArrayList<Integer> spisokNa3;
    private ArrayList<Integer> spisokNa2;
    private ArrayList<Integer> spisokOstalnoy;
    Scanner in = new Scanner(System.in);


    public static void main(String[] args) {

        ClassWork2 main = new ClassWork2();
        main.input();
        main.sort();
        main.printList();
        main.printList(main.spisok);



    }
    private ArrayList<Integer> input(){
        spisok = new ArrayList<Integer>();
        for (int i=0; i<20; i++){
            System.out.println("ВВедите число");
            int num = in.nextInt();
            spisok.add(num);
        }
        return spisok;
    }
    private void sort (){
        spisokNa3 = new ArrayList<Integer>();
        spisokNa2 = new ArrayList<Integer>();
        spisokOstalnoy = new ArrayList<Integer>();

        for (int i=0; i<spisok.size(); i++){
            if (spisok.get(i)%3 == 0){
                spisokNa3.add(spisok.get(i));
            }
            if (spisok.get(i)%2 == 0){
                spisokNa2.add(spisok.get(i));
            }
            if (spisok.get(i)%2 != 0 & spisok.get(i)%3 != 0){
                spisokOstalnoy.add(spisok.get(i));
            }
        }
    }
    private void printList (ArrayList<Integer> list){

        System.out.println("Список \n" +list.toString());
    }

    private void printList (){

         System.out.println(spisokNa2.toString());
         System.out.println(spisokNa3.toString());
         System.out.println(spisokOstalnoy.toString());
    }

}

