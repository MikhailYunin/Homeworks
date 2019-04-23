package lesson22_04;

import java.util.ArrayList;
import java.util.Random;

public class Library {
    public static void main(String[] args) {
        // библиотека не доделана
        Random random = new Random();
        ArrayList<String> booklist = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            booklist.add("Book " + i);
        }

        for (int i = 1; i < 15; i++) {
            int book = random.nextInt(10 + 1);//случайная книга
            new ReaderThread("Book " + book, booklist, i+100).start();

        }

    }
}


class ReaderThread extends Thread {

    String bookRequest; //запрашиваемая книга
    ArrayList<String> booklist; //библиотека
    int num; // номер читательского билета


    int min = 1000; // минимальное время чтения
    int max = 10000; // максиальное время чтения
    int diff = max - min;
    Random random = new Random();

    public ReaderThread(String bookRequest, ArrayList<String> booklist, int num) {
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