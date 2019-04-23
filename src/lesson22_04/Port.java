package lesson22_04;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Port {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4); // количество причалов
        for (int i=1; i<11; i++) {
            new Ship(semaphore,i).start();
            
        }
    }


}


class Ship extends Thread{
    Semaphore semaphore;

    int id; // порядкаовый номер судна

    int min = 1000;
    int max = 10000;
    int diff = max - min;
    Random random = new Random();



    public Ship(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }


    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Судно "+id+" подходит к причалу");
            sleep(700);
            System.out.println("Судно "+id+" разгружается/загружается");
            int i = random.nextInt(diff + 1+min);// время разгрузки
            sleep(i);
            System.out.println("Судно "+id+" закончило погрузку");
            sleep(700);
            semaphore.release();
            System.out.println("Судно "+id+" покинуло порт");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}