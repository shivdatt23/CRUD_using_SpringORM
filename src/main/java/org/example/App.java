package org.example;

import org.example.dao.StudentDao;
import org.example.entity.Student;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


public class App 
{
    public static void main( String[] args ) {

        ApplicationContext context = new ClassPathXmlApplicationContext("configg.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student=new Student(111,"Shivdatt Bibhar", "Los Angles");
//        int r=studentDao.insert(student);
//        System.out.println("done "+r);


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while (go) {
            System.out.println("********************<<<<<WELCOME TO SPRING ORM PROJECT>>>>>********************");
            System.out.println("PRESS 1 for add new student");
            System.out.println("PRESS 2 for display all students");
            System.out.println("PRESS 3 for get details of single student");
            System.out.println("PRESS 4 for delete students");
            System.out.println("PRESS 5 for update students");
            System.out.println("PRESS 6 for exit");
            try {
                int input = Integer.parseInt(bufferedReader.readLine());
                switch (input) {
                    case 1:
                        //add new student
                        System.out.println("Enter student ID :  ");
                        int s_id=Integer.parseInt(bufferedReader.readLine());
                        System.out.println("Enter student name :  ");
                        String s_name=bufferedReader.readLine();
                        System.out.println("Enter student city :  ");
                        String s_city=bufferedReader.readLine();
                        Student student=new Student(s_id,s_name,s_city);
                        int r=studentDao.insert(student);
                        System.out.println("Added "+ r);
                        System.out.println("********************************");

                        break;
                    case 2:
                        //display all student
                        List<Student> ls=studentDao.getAllstudent();
                        for (Student element: ls ){
                            System.out.println(element.getStudentId()+" "+element.getStudentName()+" "+element.getStudentCity());
                            System.out.println("_____________________________");
                        }

                        break;
                    //get single student data
                        case 3:
                            System.out.println("ENTER THE STUDENT ID : ");
                            int gs=Integer.parseInt(bufferedReader.readLine());
                            Student student1=studentDao.getStudent(gs);
                            System.out.println(student1.getStudentId()+" "+student1.getStudentName()+" "+student1.getStudentCity());
                            System.out.println("_____________________________________");

                        break;
                    case 4:
                        //delete student
                        System.out.println("ENTER STUDENT ID :  ");
                        int ds=Integer.parseInt(bufferedReader.readLine());
                        studentDao.deleteStudent(ds);
                        System.out.println("DELETED ");
                        break;
                    case 5:
                        //update student data
                        System.out.println("ENTER ID :  ");
                        int u_id=Integer.parseInt(bufferedReader.readLine());
                        System.out.println("ENTER UPDATED NAME : ");
                        String u_name=bufferedReader.readLine();
                        System.out.println("ENTER UPDATED CITY :  ");
                        String u_city=bufferedReader.readLine();
                        studentDao.updateStudent(u_id,u_name,u_city);
                        System.out.println("UPDATED");
                        System.out.println("______________________________");

                        break;
                    case 6:
                        //exit the program
                        go = false;
                        break;
                }

            } catch (Exception e) {
                System.out.println("INVALID INPUT (try another one) ");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("********** <<<<THANK YOU FOR USING MY APPLICATION>>>>***********");
        System.out.println("SEE YOU SOON !!");
    }


    }

