package lesson9;

// написать генератор списка объектов класса Person
// Сортировать объекты Person по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании

import java.util.*;

class Person {
    String name;
    int age;
    int salary;
    String company;

    public Person(String name, int age, int salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                salary == person.salary &&
                Objects.equals(name, person.name) &&
                Objects.equals(company, person.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, company);
    }

    @Override
    public String toString() {
        return  '\n'+name +" "+ age +
                " " + salary +
                " " + company ;
    }
}

public class PersonTask {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<Person>();


        people.add(new Person("Иван   ",34, 37500, "Гранит"));
        people.add(new Person("Петр   ",42, 78000, "Заряд"));
        people.add(new Person("Ибрагим",33, 120000, "Алмаз"));
        people.add(new Person("Николя ",29, 200000, "Рубин"));
        people.add(new Person("Сергей ",28, 56000, "Малахит"));

        Collections.sort(people, new PersonComparator());
        System.out.println(people);

        Collections.sort(people, new PersonComparator().thenComparing(new SalaryComporator()));
        System.out.println(people);

        Collections.sort(people, new PersonComparator().thenComparing(new SalaryComporator()).thenComparing(new AgeComparator()).thenComparing(new CompanyComparator()));
        System.out.println(people);


    }

}


class PersonComparator implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SalaryComporator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}

class AgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class CompanyComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}