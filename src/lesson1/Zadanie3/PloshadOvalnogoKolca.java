package lesson1.Zadanie3;

public class PloshadOvalnogoKolca {
    public static void main(String[] args) {
        System.out.println("Задача 3. Найдите площадь овального кольца, полученного из овала площадью 15 дм2 вырезанием овала площадью 600 см2.");
        int sOv1=15, sOv2=600;
        sOv1=sOv1*100;
        int sKolca=sOv1-sOv2;
        System.out.println("Ответ: площадь овального кольца - "+sKolca+" см2");
    }
}
