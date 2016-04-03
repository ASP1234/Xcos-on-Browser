package com.nimishs;
import java.util.*;

public class Main {

    TreeSet<Student> StudentSet=new TreeSet<>();
    Scanner reader=new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        new Main().go();
    }

    public void go()
    {
        getStudents();
    }

    public void getStudents()
    {

        int choice;

        do{
            System.out.println("1.ADD STUDENT\n2.DISPLAY RANKING\n3.EXIT");
            choice=reader.nextInt();

            switch(choice)
            {
                case 1: addStudent();break;
                case 2: displayRank();break;
            }
        }while(choice==1||choice==2);
    }

    public void addStudent()
    {

        System.out.println("Enter Roll Number");
        String roll=reader.nextLine();
        roll=reader.nextLine();
        System.out.println("Enter Name: ");
        String name=reader.nextLine();

        int[] marks=new int[5];

        System.out.println("Enter Language 1 Marks: ");
        marks[3]=reader.nextInt();
        System.out.println("Enter Language 2 Marks: ");
        marks[4]=reader.nextInt();
        System.out.println("Enter Maths Marks: ");
        marks[0]=reader.nextInt();
        System.out.println("Enter Science Marks: ");
        marks[1]=reader.nextInt();
        System.out.println("Enter Environmental Science Marks: ");
        marks[2]=reader.nextInt();

        Student stu=new Student(name,roll,marks);
        StudentSet.add(stu);

    }

    public void displayRank()
    {
        System.out.println(StudentSet);
    }
}
