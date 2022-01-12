package me.charlie.javaserialization;

import java.io.*;

public class TransientEx1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "objectfile.ser";

        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(new User3("찰리", 31, new Object()));

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fis);
        User3 user = (User3) in.readObject();
        System.out.println(user);
    }
}

class User3 implements Serializable {
    private final String name;
    private final int age;
    private final transient Object obj;

    public User3(String name, int age, Object obj) {
        this.name = name;
        this.age = age;
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "User3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", obj=" + obj +
                '}';
    }
}
