package com.learning.oops;

import java.lang.reflect.InvocationTargetException;

public class ObjectCreation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException {
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
