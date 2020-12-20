package com.learning.oops;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class ObjectCreation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException, IOException {
        // By using newInstance()
        Class st=Class.forName("com.learning.oops.Student");
        Student student=(Student)st.getDeclaredConstructor().newInstance();
        student.name="Nidish";
        student.age=29;
        System.out.println(student.name+ " "+ student.age);

        //Using Clone
        StudentClone s=new StudentClone();
        s.name="Naija";
        s.age=27;
        StudentClone sClone= (StudentClone) s.cloneTest();
        System.out.println(sClone.name+ " "+s.age);
        System.out.println(sClone.name+" "+sClone.age);
        
        //Using De-serializing
        
        // 1. Serializing
        FileOutputStream out=new FileOutputStream("text.txt");
        StudentSerializable stSer=new StudentSerializable();
        stSer.name="NaijaNidish";
        stSer.age=27;
        ObjectOutputStream ser=new ObjectOutputStream(out);
        ser.writeObject(stSer);
        
        //2. De -Serializing
        
        FileInputStream in=new FileInputStream("text.txt");
        ObjectInputStream inSer=new ObjectInputStream(in);
        StudentSerializable sDeser=(StudentSerializable) inSer.readObject();
        System.out.println("After De Serializing");
        System.out.println(sDeser.name+ " "+sDeser.age);
    }
}

class Student{
    String name;
    int age;
}

class StudentClone implements Cloneable{
    String name;
    int age;
    public Object cloneTest() throws CloneNotSupportedException {
        return super.clone();
    }
}

class StudentSerializable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6604692412976572527L;
	String name;
	int age;
}
