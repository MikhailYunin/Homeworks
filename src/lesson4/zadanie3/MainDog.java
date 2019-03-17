package lesson4.zadanie3;

public class MainDog {
    public static void main(String[] args) {
        Dog dog1= new Dog();
        Dog dog2 = new Dog("Charlie");
        Dog dog3 = new Dog("Tom",7,3);
        Dog dog4 = new Dog("Baks",12);
        Dog dog5 = new Dog(13.4, "black");
        Dog dog6 = new Dog(17.3, "white", "Madyson ave");

        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(dog3);
        System.out.println(dog4);
        System.out.println(dog5);
        System.out.println(dog6);

    }

}
