/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1412147;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nthan
 */
public class Student implements java.io.Serializable {
    private int iD;
    private String name;
    private float point;
   // private Image img;
    private String address;
    private String note;
    // initalization 
    public Student(){};
    public Student(int _id, String _name, float _point, String address,
            String _note)
    {
        this.iD = _id;
        this.name = _name;
        this.point = _point;
        this.note = _note;
        this.address = address;
    }
    public Student(Student newStudent)
    {
        this.iD = newStudent.iD;
        this.name = newStudent.name;
        this.address = newStudent.address;
        this.note = newStudent.note;
        this.point = newStudent.point;
    }
    
    public int getID()
    {
        return this.iD;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public float getPoint()
    {
        return this.point;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    public String getNote()
    {
        return this.note;
    }
    
    public void setID(int _iD)
    {
        this.iD = _iD;
    }
    
    public void setName(String _name)
    {
        this.name = _name;
    }
    public void setPoint(float _point)
    {
        this.point = _point;
    }
    public void setAddress(String _address)
    {
        this.address = _address;
    }
    public void setNote(String _note)
    {
        this.note = _note;
    }
    /*
        INPUT:
        + ID (subsistence)
        + NAME
        + POINT
        + ADDRESS
        + NOTE
    */
    public Student inputStudent()
    {
        Scanner scan = new Scanner(System.in);
        Student temp = new Student();
        try
        {
            System.out.println("ID:" + (ListStudent.getIDMax()));
            temp.iD = (new ListStudent().getIDMax());
            System.out.print("Name:");
            temp.name = scan.nextLine();
            System.out.print("Point:");
            temp.point = scan.nextFloat();
            String c = scan.nextLine();
            System.out.print("Address:");
            temp.address = scan.nextLine();
            System.out.print("Note:");
            temp.note = scan.nextLine();
            
        }
        catch(Exception e)
        {
            System.out.println("Input error!!!");
        }
        return temp;
    }
    /*
        Edit data
    */
    public void editDataStudent()
    {
        Scanner scan = new Scanner(System.in);
        try
        {
            System.out.println("ID:" + this.iD);
            System.out.print("Name:");
            this.name = scan.nextLine();
            System.out.print("Point:");
            this.point = scan.nextFloat();
            String c = scan.nextLine();
            System.out.print("Address:");
            this.address = scan.nextLine();
            System.out.print("Note:");
            this.note = scan.nextLine();
            
        }
        catch(Exception e)
        {
            System.out.println("Input error!!!");
        }
    }

    
}