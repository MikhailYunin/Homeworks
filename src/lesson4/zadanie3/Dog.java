package lesson4.zadanie3;

public class Dog {
    private String name = "noname";
    private double weight = 10.5;
    private int age = 5;
    private String color = "not determined";
    private String addres = "homeless";



    public Dog () {

    }

    public Dog(String name) {
        this.name = name;

    }

    public Dog(String name, double weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;


    }

    public Dog(double weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Dog(double weight, String color, String addres) {
        this.weight = weight;
        this.color = color;
        this.addres = addres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", addres='" + addres + '\'' +
                '}';
    }
}
