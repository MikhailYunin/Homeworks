package lesson9;

//Задача 4
//        Ввести с клавиатуры 5 слов в список строк.
//        Удалить 3 - ий элемент списка, и вывести оставшиеся элементы в обратном порядке.


import java.util.ArrayList;
import java.util.Scanner;

public class ClassWork4 {
    ArrayList<String> list;
    ArrayList<String> listReverse;

    public static void main(String[] args) {
        ClassWork4 classWork4 = new ClassWork4();

        classWork4.input(5);
        classWork4.printList(classWork4.list);
        classWork4.list.remove(2);
        classWork4.reverse(classWork4.list);
        classWork4.printList(classWork4.listReverse);
    }

    private ArrayList<String> input(int qty){
        list = new ArrayList<String>();
        Scanner in = new Scanner(System.in).useDelimiter(",| ");
        for (int i=0; i<qty; i++){
            list.add(in.next());
        }
        return list;
    }

    public void printList (ArrayList<String> list){
        System.out.println(list.toString());
    }

    private  ArrayList<String> reverse(ArrayList<String> list){
        listReverse = new ArrayList<String>();
        for (int i=0; i<list.size(); i++){
            listReverse.add(list.get(list.size()-i-1));
        } return listReverse;

    }

}
