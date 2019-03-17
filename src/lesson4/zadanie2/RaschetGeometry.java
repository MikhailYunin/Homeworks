package lesson4.zadanie2;

public class RaschetGeometry {
    public static void main(String[] args) {
        Circle circle1 = new Circle(0,0, 15,0);
        System.out.println(circle1);

        double s = circle1.getPloshad();
        double l = circle1.getDlinaOcruznosti();

        System.out.println("Площадь круга равна " + s);
        System.out.println("Длина окружности равно " + l+"\n");

        Rectangle rectangle1 = new Rectangle(0,0,5,5);
        System.out.println(rectangle1);

        System.out.println("Площадь прямоугольника равна " + rectangle1.getPloshad());
        System.out.println("Периметр прямоугольника равен " + rectangle1.getPerimetr()+"\n");

        Triangle triangle1 = new Triangle(0,0,5,5, 10,0);
        System.out.println(triangle1);

        System.out.println("Площадь треугольника равна " + triangle1.getPloshad());
        System.out.println("Периметр треугольника равен " + triangle1.getPerimetr()+"\n");

    }
}
