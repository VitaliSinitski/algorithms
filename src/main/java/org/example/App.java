package org.example;

public class App {
    public static void main(String[] args) {
//        String name = "Jack";   // 2300927
//        System.out.println(name.hashCode());

        Person person1 = new Person();
        person1.setAge(22);
        person1.setName("Jack");
        Person person2 = new Person();
        person2.setAge(22);
        person2.setName("Jack");
        Person person3 = new Person();
        person3.setAge(22);
        person3.setName("Jack");
        System.out.println(person1.hashCode());  // 381259350   // 71329720
        System.out.println(person2.hashCode());  // 2129789493  // 71329720
        System.out.println(person3.hashCode());  // 668386784   // 71329720

        Dog dog1 = new Dog();
        dog1.setAge(22);
        dog1.setName("Jack");
        System.out.println(dog1.hashCode());

        System.out.println(person1.equals(dog1));
    }


}
