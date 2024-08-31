package org.example;

import java.io.*;

public class Program {
    public static void main(String[] args){
        Person person = new Person("Ivan", 27);
        try (FileOutputStream fileOut = new FileOutputStream("text.bin");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            System.out.println("Сериализация завершена.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация объекта Person из файла "text.bin"
        Person person1 = null;
        try (FileInputStream fileIn = new FileInputStream("text.bin");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            person1 = (Person) in.readObject();
            System.out.println("Десериализация завершена.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(person1);

    }
}
