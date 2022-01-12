package me.charlie.javaserialization;

import java.io.*;

public class ParentChildSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "objectfile.ser";

        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(new ChildUser("찰리", 31, "초콜릿공장장"));

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fis);
        ChildUser user = (ChildUser) in.readObject();
        System.out.println(user);
    }
}

class ParentUser implements Serializable {
    private final String name;
    private final int age;

    public ParentUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class ChildUser extends ParentUser {
    private final String nickname;

    public ChildUser(String name, int age, String nickname) {
        super(name, age);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
