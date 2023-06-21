package sdf;

public class Dogeat {
    public static void main(String[] args) {
        Dog dog = new Dog();

        //매개값으로 Apple 객체를 제공하고 dog() 메소드를 호출하세요.
        Apple apple = new Apple();
        dog.eat(apple);

        //매개값으로 Banana 객체를 제공하고 dog() 메소드를 호출하세요.
        Banana banana = new Banana();
        dog.eat(banana);
    }
}
