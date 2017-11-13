/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1412147;

import java.util.Vector;
import java.util.Arrays;
import java.io.*;
/**
 *
 * @author nthan
 */
/*
    class list of student
    
*/
public class ListStudent implements java.io.Serializable
{
    public static Vector<Student> listStudent = new Vector<Student>();
    /*
        Add student to the list
        ID is spontaneous
    */
    public static void addStudent(Student newStudent)
    {
        listStudent.add(newStudent);
    }
    /*
        Update student to the list
        ID is not update
        ID like element
    */
    public static void updateStudent(int _iD)
    {
        listStudent.elementAt(_iD).editDataStudent();
    }
    /*
        Remove form list student
    */
    public static void removeStudent(int _iD)
    {
        listStudent.removeElementAt(_iD);
        // set ID 
        for(int i = _iD; i < listStudent.size(); i++)
        {
            listStudent.elementAt(i).setID(_iD);
        }
    }
    
    /*
        Show list student ID ascending
    */
    public static void showListStudentIDAscending()
    {
        for (int i = 0; i < listStudent.size(); i++ )
        {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("ID:" + listStudent.elementAt(i).getID());
            System.out.println("Name:" + listStudent.elementAt(i).getName());
            System.out.println("Point:" + listStudent.elementAt(i).getPoint());
            System.out.println("Address:" + listStudent.elementAt(i).getAddress());
            System.out.println("Note:" + listStudent.elementAt(i).getNote());
            System.out.println("--------------------------------------------");
        }
    }
    /*
        Show list student ID decrase
    */
    public static void showListStudentIDDecrase()
    {
        int j = 0;
        if(listStudent.size() == 0)
            return;
        for(int i = listStudent.size() - 1; i < 0; i--)
        {
            
            System.out.println("Student " + (j + 1) + ":");
            System.out.println("ID:" + listStudent.elementAt(i).getID());
            System.out.println("Name:" + listStudent.elementAt(i).getName());
            System.out.println("Point:" + listStudent.elementAt(i).getPoint());
            System.out.println("Address:" + listStudent.elementAt(i).getAddress());
            System.out.println("Note:" + listStudent.elementAt(i).getNote());
            System.out.println("--------------------------------------------");
            j++;
        }
    }
    /*
        Show list student Point asceding
    */
    public static void showListStudentPointAscending()
    {
        float[] sort = new float[listStudent.size()];
        for (int i = 0; i < listStudent.size(); i++)
        {
            sort[i] = listStudent.elementAt(i).getPoint();
        }
        Arrays.sort(sort);
        for(int i = 0; i< listStudent.size(); i++)
        {
            System.out.println("Student " + i + ":");
            for(int j = 0; j < listStudent.size(); j++)
            {
                if(sort[i] == listStudent.elementAt(j).getPoint())
                {
                    System.out.println("ID:" + listStudent.elementAt(j).getID());
                    System.out.println("Name:" + listStudent.elementAt(j).getName());
                    System.out.println("Point:" + listStudent.elementAt(j).getPoint());
                    System.out.println("Address:" + listStudent.elementAt(j).getAddress());
                    System.out.println("Note:" + listStudent.elementAt(j).getNote());
                    System.out.println("--------------------------------------------");
                }
            }
        }
    }
    /*
        Show list student Point decrase
    */
    public static void showListStudentPointDecrare()
    {
        float[] sort = new float[listStudent.size()];
        for (int i = 0; i < listStudent.size(); i++)
        {
            sort[i] = listStudent.elementAt(i).getPoint();
        }
        Arrays.sort(sort);
        for(int i = listStudent.size(); i < 0; i--)
        {
            System.out.println("Student " + i + ":");
            for(int j = 0; j < listStudent.size(); j++)
            {
                if(sort[i] == listStudent.elementAt(j).getPoint())
                {
                    System.out.println("ID:" + listStudent.elementAt(j).getID());
                    System.out.println("Name:" + listStudent.elementAt(j).getName());
                    System.out.println("Point:" + listStudent.elementAt(j).getPoint());
                    System.out.println("Address:" + listStudent.elementAt(j).getAddress());
                    System.out.println("Note:" + listStudent.elementAt(j).getNote());
                    System.out.println("--------------------------------------------");
                }
            }
        }
    }
    /*
        open file birany 
    */
    public static void openFileBinary(String nameFile)
    {
        ObjectInputStream in = null;
        listStudent.clear();
        
        try
        {
            in = new ObjectInputStream(new FileInputStream(nameFile + ".txt"));

        }
        catch(IOException e)
        {
            System.out.println("Notfound!!!");
        }
        
        try
        {
            int size = (int)in.readObject();
            for(int i = 0; i < size; i++ )
                listStudent.add((Student)in.readObject());
        }
        catch(Exception e)
        {
            System.out.println("ReadFile Error!!!");
            return;
        }
        
        finally
        {
            if(in != null)
            {
                try
                {
                    in.close();
                }
                catch(Exception e)
                {
                    System.out.println("CloseFile Error!!!");
                }
            }
        }
        System.out.println("OpenFile success!!!");
    }
    /*
        save file binary

    */
    public static void saveFileBinary(String nameFile)
    {
        ObjectOutputStream out = null;
        try
        {
           out = new ObjectOutputStream(new FileOutputStream(nameFile + ".txt"));
           out.writeObject(listStudent.size());
           for(int i = 0; i < listStudent.size(); i++)
           {
               out.writeObject(listStudent.elementAt(i));
           }
        }
        catch(IOException e)
        {
            System.out.println("SaveFile error!!!" + e.toString());
        }
        finally
        {   
            try{
            if(out != null)
            {
                out.close();
                System.out.println("SaveFile success");
            }

            }
            catch(Exception e)
            {
                System.out.println("CloseFile Error!!!");
            }
                    
        }
    } 
    
    /*
        Get ID max
    */
    public static int getIDMax()
    {
        return listStudent.size();
    }
    /*
        Check ID in List
        return TRUE OR FALSE
    */
    public static boolean checkIDInList(int _iD)
    {
        if(_iD < 0 || _iD > ListStudent.listStudent.size())
            return false;
        return true;
    }
    /*
        export file txt
    */
    public static void exportListStudent(String nameFile)
    {
        FileWriter fw;
        try
        {
            fw = new FileWriter(nameFile + ".txt");
        }
        catch(Exception e)
        {
            System.out.println("Create file error!!!");
            return;
        }
        for(int i = 0; i < listStudent.size(); i++)
        {
            try
            {
                String temp;
                fw.write("Student: " + (i + 1) + "\r\n");
                fw.write("ID: " + Integer.toString(listStudent.elementAt(i).getID()) + "\r\n");
                fw.write("Name: " + listStudent.elementAt(i).getName() + "\r\n");
                fw.write("Point: " + Float.toString(listStudent.elementAt(i).getPoint()) + "\r\n");
                fw.write("Address: " + listStudent.elementAt(i).getAddress() + "\r\n");
                fw.write("Note: " + listStudent.elementAt(i).getNote() + "\r\n");
                fw.write("---------------------------------------\r\n");
            }
            catch(IOException e)
            {
                System.out.println("Write file error!!!");
            }
        }
        System.out.println("Export file success!!!");
        try
        {
            fw.flush();
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println("Close file error!!!");
        }
    }
    /*
        Import File
    */
    public static void importFile(String nameFile)
    {
        listStudent.clear();
        FileInputStream in;
        try
        {
            in = new FileInputStream(new File(nameFile + ".txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            String[] edit = new String[2];
            int check = 0;
            int index = 0;
            Student newStudent;

            /*
                Student: 
                ID: 
                Name:
                Point:
                Address:
                Note:
                --------
            */
            int id = 0;
            String name = "";
            float point = 0;
            String address = "";
            String note= "";
            while ((line = br.readLine()) != null)
            {

                check++;
                try
                {
                    if (line != null && !line.isEmpty())
                    {
                        edit = line.split(":", 2);
                        switch (check)
                        {
                            case 1: //STT Student
                                break;
                            case 2://ID
                                String temp = edit[1].trim();
                                try
                                {
                                    id = Integer.parseInt(temp); 
                                }
                                catch(Exception e)
                                {
                                    System.out.println("ID error!!!");
                                    id = 0;
                                }

                                break;
                            case 3: // Name
                                name = edit[1].trim();
                                break;
                            case 4: // Point
                                temp = edit[1].trim();
                                try
                                {
                                    point = Float.parseFloat(temp);
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Point error!!!");
                                    point = 0;
                                }
                                break;
                            case 5:// Address
                               address = edit[1].trim();
                                break;
                            case 6:// note
                                note = edit[1].trim();
                                break;
                            case 7: //---------------
                                break;
                        }
                    }
                    if(check == 7)
                    {
                        newStudent = new Student(id, name, point, address,note);
                        listStudent.add(newStudent);
                        index++;
                        check = 0;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Data error!!!");
                }  
            }
            br.close(); 
        }
        catch(IOException e)
        {
            System.out.println("Notfound!!");
            return;
        }
        System.out.println("Import file success!!!");    
    } 
}


