package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Default task From GeekBrains
        Student stud = new Student("John",33,5.6);
        Serialize(stud);
        Student afterSerialize = DeSerialize();
        System.out.println(afterSerialize);
    }

    public static void Serialize(Object obj) {
        try(FileOutputStream fos = new FileOutputStream("serializeStudent.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(obj);
        }
        catch (IOException e){
            System.out.println("Something goes wrong");
            e.printStackTrace();
        }
    }

    public static Student DeSerialize(){
        Student student;
        try(FileInputStream inp = new FileInputStream("serializeStudent.bin");
            ObjectInputStream in = new ObjectInputStream(inp)){
            student = (Student) in.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

}