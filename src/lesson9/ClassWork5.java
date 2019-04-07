package lesson9;

//Написать программу, которая должна:
//        Считывать с клавиатуры 10 слов в список строк.
//        Определять, является ли список упорядоченным по возрастанию длины строки.
//        В случае отрицательного ответа выводить на экран номер первого элемента, нарушающего такую упорядоченность.

import java.util.ArrayList;
import java.util.Scanner;

public class ClassWork5 {
    ArrayList<String> list;

    public static void main(String[] args) {
        ClassWork5 classWork5 = new ClassWork5();

        classWork5.input(10);
        classWork5.printList(classWork5.list);
        classWork5.compare();
    }

    private ArrayList<String> input(int qty){
        list = new ArrayList<String>();
        Scanner in = new Scanner(System.in).useDelimiter(",| ");
        for (int i=0; i<qty-1; i++){
            list.add(in.next());
        }
        return list;
    }

    public void printList (ArrayList<String> list){
        System.out.println(list.toString());
    }

    private void compare(){
        boolean bool=false;
        for (int i=1; i<list.size(); i++){
            if (list.get(i-1).length()<=list.get(i).length()){
                bool=true;
            } else {
                System.out.println("сприсок не упорядочен по длине");
                System.out.println("Первый элемент нарушающий упорядоченность - "+list.get(i));
                break;
            }

        }
        if (bool) {System.out.println("Список упорядочен по возрастанию длины строки");}
    }

}
