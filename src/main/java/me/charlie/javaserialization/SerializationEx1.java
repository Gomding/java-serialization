package me.charlie.javaserialization;

import java.io.*;

public class SerializationEx1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "objectfile.ser";

        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(new User("찰리", 31));

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fis);
        User user = (User) in.readObject();
        System.out.println(user);
    }
}
