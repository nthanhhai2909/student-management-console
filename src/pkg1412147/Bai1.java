/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1412147;
import java.util.*;
import java.io.*;
/**
 *
 * @author nthan
 */
public class Bai1
{

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Scanner scan = new Scanner(System.in);
        int choose = 0;
        // Select func
        do
        {
            do
            {
                System.out.println("        STUDENT MANAGEMENT      ");
                System.out.println("CHOOSE");
                System.out.println("1. STUDENT LIST");
                /*
                    watch ListStudent code ascending
                    watch ListStudent code decrease
                    watch ListStudent point ascending
                    watch ListStudent point decrease
                */
                System.out.println("2. ADD STUDENT");
                System.out.println("3. UPDATE STUDENT");
                System.out.println("4. REMOVE STUDENT");
                System.out.println("5. EXPORT FILE");
                System.out.println("6. IMPORT FILE");
                System.out.println("7. SAVE FILE BINARY");
                System.out.println("8. OPEN FILE BINARY");                
                System.out.print("Please choose(enter):");
                try
                {
                    choose = scan.nextInt();
                    
                }
                catch(Exception e)
                {
                    System.out.println("Input error!!!");
                }
                if(choose <= 0 || choose > 8)
                {
                    System.out.println("Select error!!! Please reselect.");
                }
            }
            while(choose <= 0 || choose > 8);

            switch (choose)
            {
                /*
                    Show ID:
                        + CODE ascending
                        + CODE decrase
                        + POINT ascending
                        + POINT decrase
                */
                case 1: // Show list Student
                    System.out.println("1. View ID ascending");
                    System.out.println("2. View ID decrase");
                    System.out.println("3. View POINT ascending");
                    System.out.println("4. View POINT decrase");
                    System.out.print("choose:");
                    // select func
                    try
                    {
                        choose = scan.nextInt();  
                    }
                    catch(Exception e)
                    {
                        System.out.println("Input error!!!");
                    }
                    if(choose <= 0 || choose > 4)
                    {
                        System.out.println("Select error!!! Please reselect.");
                    }
                    else
                    {
                        switch (choose)
                        {
                            case 1:// ID ascending
                                ListStudent.showListStudentIDAscending();
                                break;
                            case 2: // ID decrase
                                ListStudent.showListStudentIDDecrase();
                                break;
                            case 3: // Point ascending
                                ListStudent.showListStudentPointAscending();
                                break;
                            case 4:
                                break;
                        }
                            
                    }
                    break;
                case 2: // Add student in list
                    Student temp = new Student();
                    ListStudent.addStudent(temp.inputStudent());
                    break;
                case 3: // update student
                    choose = -1;
                    System.out.print("ID need updating:");
                    try
                    {
                        choose = scan.nextInt();
                    }
                    catch(Exception e)
                    {
                        System.out.print("Input error");
                    }

                    if(!ListStudent.checkIDInList(choose))
                    {
                        System.out.println("Invalid ID!!!");
                    }
                    else
                    {
                        ListStudent.updateStudent(choose);
                    }
                    break;
                case 4: // remove student
                    choose = -1;
                    System.out.print("ID need remove:");
                    try
                    {
                        choose = scan.nextInt();
                    }
                    
                    catch(Exception e)
                    {
                        System.out.print("Input error");
                    }
                    ListStudent.removeStudent(choose);
                    break;
                case 5:
                    String nameFileEx = "";
                    String c = scan.nextLine();
                    System.out.println("File name: ");
                    try
                    {
                        nameFileEx = scan.nextLine();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Input error!!!");
                    }
                    ListStudent.exportListStudent(nameFileEx);
                    break;
                case 6:
                    String namefileIm="";
                    c = scan.nextLine();
                    System.out.println("File name: ");
                    try
                    {
                        namefileIm = scan.nextLine();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Input error!!!");
                    }
                    ListStudent.importFile(namefileIm);
                    break;
                case 7:
                    System.out.println("Name File: ");
                    String nameFileSave = "";
                    scan.nextLine();
                    try
                    {
                        nameFileSave = scan.nextLine();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Input error!!!");
                    }
                    ListStudent.saveFileBinary(nameFileSave);
                    break;
                case 8:
                    System.out.println("Name File: ");
                    String nameFileOpen = "";
                    scan.nextLine();
                    try
                    {
                        nameFileOpen = scan.nextLine();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Input error!!!");
                    }
                    ListStudent.openFileBinary(nameFileOpen);
                    break;
                default:
            }
            //  want to continue the program or not
            do
            {
                System.out.println("Do you want to continue?");
                System.out.println("1 - YES");
                System.out.println("2 - NO");
                System.out.print("Please choose:");
                try
                { 
                   choose = scan.nextInt();
                }
               
                catch(Exception e)
                {
                    System.out.println("Input error!!!");
                    System.out.println(e);
                }
                if(choose <= 0 || choose > 2)
                {
                    System.out.println("Select error!!! Please reselect.");
                }
            }
            while(choose <= 0 || choose > 2);
            switch(choose)
            {
                case 1:
                    break;
                case 2:
                    System.out.println("GOODBYE!!!");
                    return;
            }
            
        }
        while(true);
    }
}



