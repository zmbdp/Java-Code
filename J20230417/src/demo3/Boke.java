package demo3;
import java.util.*;


class Animals {
    public void run() {
        System.out.println("Animal::run");
    }
}
class Dogs extends Animals{
    public void eat() {
        System.out.println("Dogs::eat");
    }
    public void run() {
        System.out.println("Dou::run");
    }
}
class Cat extends Animals {
    public void catchMice() {
        System.out.println("Cat::catchMice");
    }
    public void run() {
        System.out.println("Cat::run");
    }
}
public class Boke {
    public static void main(String[] args) {
        Animals animals = new Dogs();
        Dogs dogs = (Dogs)animals;
        dogs.eat();
        animals = new Cat();
        if (animals instanceof Cat) {
            Cat cat = (Cat)animals;
            cat.catchMice();
        }
        //Scanner sc = new Scanner(System.in);
    }
}
