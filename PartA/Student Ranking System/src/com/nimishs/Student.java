package com.nimishs;

/**
 * Created by NMSH on 03-04-2016.
 */
public class Student implements Comparable<Student> {

    String Name;
    String Roll;
    int[] Marks;
    int total;


    public Student(String name,String roll, int[] marks)
    {
        this.Name=name;
        this.Roll=roll;
        this.Marks=marks;
        this.total=0;

        for(int i=0;i<5;i++)
            this.total+=marks[i];
    }

    public int hashCode()
    {
        return Roll.hashCode();
    }

    public boolean equals(Object obj)
    {
        Student stu=(Student) obj;

        return getRoll().equals(stu.getRoll());
    }


    public String getName()
    {
        return this.Name;
    }

    public String getRoll()
    {
        return  this.Roll;
    }

    public int getMaths()
    {
        return this.Marks[0];
    }

    public int getScience()
    {
        return  this.Marks[1];
    }

    public int getLanguage1()
    {
        return  this.Marks[3];
    }

    public int getLanguage2()
    {
        return  this.Marks[4];
    }

    public int getES()
    {
        return this.Marks[2];
    }

    public int getTotal()
    {
        return  this.total;
    }

    public int[] getMarks()
    {
        return this.Marks;

    }

    public String toString()
    {
        return this.Roll+" - "+this.Name;
    }

    public int compareTo(Student stu)
    {
        if(total!=stu.getTotal())
            return stu.getTotal()-getTotal();
        else
         {
             int[] stuMarks=stu.getMarks();

             for(int i=0;i<5;i++)
                 if(Marks[i]!=stuMarks[i])
                     return stuMarks[i]-Marks[i];
         }

        return Name.compareTo(stu.getName());
    }
}
