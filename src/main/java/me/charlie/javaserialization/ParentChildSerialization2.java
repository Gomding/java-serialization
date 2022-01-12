package me.charlie.javaserialization;

import java.io.*;

public class ParentChildSerialization2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "objectfile.ser";

        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(new ChildUser2("찰리", 31, "초콜릿공장장"));

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fis);
        ChildUser2 user = (ChildUser2) in.readObject();
        System.out.println(user);
    }
}

class ParentUser2 {
    protected String name;
    protected int age;

    public ParentUser2() {
    }

    public ParentUser2(String name, int age) {
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

class ChildUser2 extends ParentUser2 implements Serializable {
    private final String nickname;

    public ChildUser2(String nickname) {
        this(null, 0, nickname);
    }

    public ChildUser2(String name, int age, String nickname) {
        super(name, age);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "ChildUser2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}