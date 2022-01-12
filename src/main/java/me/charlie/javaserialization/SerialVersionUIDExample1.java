package me.charlie.javaserialization;

import java.io.*;

public class SerialVersionUIDExample1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "objectfile.ser";

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fis);
        User4 user = (User4) in.readObject();
        System.out.println(user);
    }
}

class User4 implements Serializable {
    static final long serialVersionUID = 3518731767529258119L;

    private final String name;
    private final int age;
    // 직렬화 후 추가된 필드
    private final String nickName;

    public User4(String name, int age, String nickName) {
        this.name = name;
        this.age = age;
        this.nickName = nickName;
    }
}