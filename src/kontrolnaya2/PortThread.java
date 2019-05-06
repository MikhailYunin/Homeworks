package kontrolnaya2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.*;

public class PortThread {

    // переделать
    static Semaphore logFileSemaphore = new Semaphore(1);

    public static void main(String[] args) {
        int countOfShip = 10; // количество судов

        Semaphore prichal1 = new Semaphore(1);
        Semaphore prichal2 = new Semaphore(1);
        Semaphore prichal3 = new Semaphore(1);
        Semaphore prichal4 = new Semaphore(1);
//        Semaphore logFileSemaphore = new Semaphore(1);

        ExecutorService pool = Executors.newFixedThreadPool(4);

        // не ясно, почему при основном количесвте потоков "1" - задача становится однопоточной
//        ExecutorService pool = new ThreadPoolExecutor(
//                1, // основное количество потоков
//                countOfShip, // максимальное количество потоков
//                2, TimeUnit.MINUTES, //как долго могут потоки простаивать
//                new ArrayBlockingQueue<>(countOfShip) // очередб для задач, которую будут выполнять эти потоки
//        );

        // i - порядковый номер судна
        for (int i = 1; i <= countOfShip; i++) {
            pool.execute(new Dispetcher(prichal1, prichal2, prichal3, prichal4, i));

        }
        pool.shutdown();
    }


}


class Dispetcher extends Thread {

    Semaphore prichal1;
    Semaphore prichal2;
    Semaphore prichal3;
    Semaphore prichal4;
//    Semaphore logFileSemaphore;

    int id; // порядкаовый номер судна

    int min = 1000;
    int max = 10000;
    int diff = max - min;
    Random random = new Random();


    public Dispetcher(Semaphore prichal1, Semaphore prichal2, Semaphore prichal3, Semaphore prichal4, int id) {
        this.prichal1 = prichal1;
        this.prichal2 = prichal2;
        this.prichal3 = prichal3;
        this.prichal4 = prichal4;
        this.id = id;
//        this.logFileSemaphore = lofFileSemaphore;
    }

    @Override
    public void run() {

        System.out.println("Заходит в порт Судно " + id);

        if (prichal1.tryAcquire()) {
            ship(1);
            prichal1.release();
        } else if (prichal2.tryAcquire()) {
            ship(2);
            prichal2.release();
        } else if (prichal3.tryAcquire()) {
            ship(3);
            prichal3.release();
        } else if (prichal4.tryAcquire()) {
            ship(4);
            prichal4.release();
        }


    }

    public void ship(int numPrichal) {

        try {

            String text = "Судно " + id + " подходит к " + numPrichal + " причалу";
            System.out.println(text);
            if (PortThread.logFileSemaphore.tryAcquire()) {
                writeToFile(text);
                PortThread.logFileSemaphore.release();
            }

            sleep(700);

            text ="Судно " + id + " разгружается/загружается";

            System.out.println(text);
            if (PortThread.logFileSemaphore.tryAcquire()) {
                writeToFile(text);
                PortThread.logFileSemaphore.release();
            }

            int i = random.nextInt(diff) + min;// случайное время разгрузки от 1 сек до 10 сек
            sleep(i);


            text= "Судно " + id + " закончило погрузку";

            System.out.println(text);
            if (PortThread.logFileSemaphore.tryAcquire()) {
                writeToFile(text);
                PortThread.logFileSemaphore.release();
            }

            sleep(700);

            text = "Судно " + id + " покинуло порт";
            System.out.println(text);
            if (PortThread.logFileSemaphore.tryAcquire()) {
                writeToFile(text);
                PortThread.logFileSemaphore.release();
            }


            text = "Причал " + numPrichal + " свободен";

            System.out.println(text);
            if (PortThread.logFileSemaphore.tryAcquire()) {
                writeToFile(text);
                PortThread.logFileSemaphore.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFile(String textLog) throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream("src/kontrolnaya2/fileLog.txt", true))
        {


            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("kk.mm");
            StringBuilder sb = new StringBuilder();
            sb.append(textLog).append(" ")
                    .append(date.format(formatter)).append(" ")
                    .append(time.format(formatter2))
                    .append("\n");

            byte[] bytes = sb.toString().getBytes(Charset.forName("UTF-8"));
            outputStream.write(bytes);
        }



    }

}