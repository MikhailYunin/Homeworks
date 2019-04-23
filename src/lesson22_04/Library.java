package lesson22_04;

import java.util.ArrayList;
import java.util.Random;

public class Library {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> booklist = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            booklist.add("book " + i);
        }

        for (int i = 1; i < 15; i++) {
            int book = random.nextInt(10 + 1);//случайная книга
            new ReaderThread("Book " + book, booklist).start();

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

    public ReaderThread(String bookRequest, ArrayList<String> booklist) {
        this.bookRequest = bookRequest;
        this.booklist = booklist;
    }

    @Override
    public void run() {

        for (String string : booklist) {

            try {

                if (string.equals(bookRequest)) {
                    booklist.remove(string);
                    System.out.println("Читатель с билетом №" + num + " взял книгу " + bookRequest);
                    int i = random.nextInt(diff + 1 + min);// случайное время чтения книги
                    sleep(i);

                    booklist.add(string);
                    System.out.println("Читатель сдал книгу");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}