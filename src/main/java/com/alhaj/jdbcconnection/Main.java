package com.alhaj.jdbcconnection;

import com.alhaj.jdbcconnection.model.Student;
import com.alhaj.jdbcconnection.repository.StudentRepositoryImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // to see how IntelliJ IDEA suggests fixing it.

        DBConnection dbConnection=new DBConnection();
        try {
          var connection= dbConnection.tryConnection();
          if(connection.isValid(2)) {
              System.out.printf("SUCCESS!");

              var createDB = new CreateDatabase();
              createDB.createDatabase(connection, "student_info");

              var createTable = new CreateTable();
              createTable.createTable(connection, "student");

              var student=new Student();
              student.setName("Alhaj");
              student.setInstitute("Modina School");
              student.setRoll("123456");
              student.setClass_name("xii");
              student.setVersion(0L);
              //Convert time format
              SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              student.setDate_created(simpleDate.format(new Date()));
              //Call repo
              var studentRepo=new StudentRepositoryImpl();

             // studentRepo.save(student);

              studentRepo.findAll();

              System.out.printf(studentRepo.findAll().get(0).getName());
          }else System.out.printf("FAILED!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}