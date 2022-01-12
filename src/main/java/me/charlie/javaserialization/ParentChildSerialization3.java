package me.charlie.javaserialization;

import java.io.*;

public class ParentChildSerialization3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "objectfile.ser";

        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(new ChildUser3("찰리", 31, "초콜릿공장장"));

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fis);
        ChildUser3 user = (ChildUser3) in.readObject();
        System.out.println(user);
    }
}

class ParentUser3 {
    protected String name;
    protected int age;

    public ParentUser3() {
    }

    public ParentUser3(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class ChildUser3 extends ParentUser3 implements Serializable {
    private String nickname;

    public ChildUser3(String nickname) {
        this(null, 0, nickname);
    }

    public ChildUser3(String name, int age, String nickname) {
        super(name, age);
        this.nickname = nickname;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject();
        age = in.readInt();
        in.defaultReadObject();
    }

    @Override
    public String toString() {
        return "ChildUser3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
