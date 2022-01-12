package me.charlie.javaserialization;

import java.io.*;

public class SerializableFailEx {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "objectfile.ser";

        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(new User2("찰리", 31, new Object()));

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fis);
        User2 user = (User2) in.readObject();
        System.out.println(user);
    }
}

class User2 implements Serializable {
    private final String name;
    private final int age;
    private final Object obj;

    public User2(String name, int age, Object obj) {
        this.name = name;
        this.age = age;
        this.obj = obj;
    }
}
