package lesson22_04;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Library {
    public static void main(String[] args) {
        // библиотека не доделана

        int countOfReader = 15; // число читателей
        Random random = new Random();
        CopyOnWriteArrayList<String> booklist =  new CopyOnWriteArrayList<>();
        for (int i = 1; i < 10; i++) {
            booklist.add("Book " + i);
        }

        ExecutorService fixedPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i < countOfReader; i++) {
            int numBook = (random.nextInt(8)) + 1;//случайный номер книги
            String bookRequest = "Book " + numBook; // случайное название книги
            int numReader = i+100; // номер читательского билета

            fixedPool.execute(new ReaderThread(bookRequest, booklist, numReader));

        }

    }
}


class ReaderThread extends Thread {

    String bookRequest; //запрашиваемая книга
    CopyOnWriteArrayList<String> booklist; //библиотека
    int num; // номер читательского билета


    int min = 1000; // минимальное время чтения
    int max = 10000; // максиальное время чтения
    int diff = max - min;
    Random random = new Random();

    public ReaderThread(String bookRequest, CopyOnWriteArrayList<String> booklist, int num) {
        this.bookRequest = bookRequest;
        this.booklist = booklist;
        this.num = num;
    }

    @Override
    public void run() {
        while (!booklist.contains(bookRequest))
        {

            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Книга "+bookRequest+" сейчас в зале");
        }

        for (String string : booklist) {

            try {

                if (string.equals(bookRequest)) {
                    booklist.remove(string);
                    System.out.println("Читатель с билетом №" + num + " взял книгу " + bookRequest);
                    int i = random.nextInt(diff + 1 + min);// случайное время чтения книги
                    sleep(i);

                    booklist.add(string);
                    System.out.println("Читатель сдал книгу " + bookRequest);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}