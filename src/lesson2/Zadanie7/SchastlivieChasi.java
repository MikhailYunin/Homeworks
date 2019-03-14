package lesson2.Zadanie7;

public class SchastlivieChasi {
    public static void main(String[] args) {
        System.out.println("Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать сколько раз за сутки случается так, что слева от двоеточия показывается симметричная комбинация для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51)");
        int result = 0;
        for (int chi = 0; chi < 3; chi++) {
            for (int chj = 0; chj < 10; chj++) {
                for (int mi = 0; mi < 6; mi++) {
                    for (int mj = 0; mj < 10; mj++) {
                        if (chi == mj) {
                            if (chj == mi) {
                                result++;
                                System.out.println(chi+chj+":"+mi+ mj);
                            }
                        }

                    }
                }

            }
        }
        System.out.println("Количество таких раз " + result);

    }
}
