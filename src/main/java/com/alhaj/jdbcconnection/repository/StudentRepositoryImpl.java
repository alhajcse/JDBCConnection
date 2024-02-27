package com.alhaj.jdbcconnection.repository;

import com.alhaj.jdbcconnection.DBConnection;
import com.alhaj.jdbcconnection.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{
    private DBConnection dbConnection=new DBConnection();

    @Override
    public void save(Student student) {

        var sql= String.format(" INSERT INTO student_info.student (name, " +
        "institute, "+
        "roll, "+
        "class_name, "+
        "version, "+ "date_created)"+
                "VALUES ( '%s', '%s', '%s', '%s','%s', '%s')",
                student.getName(),
                student.getInstitute(),
                student.getRoll(),
                student.getClass_name(),
                student.getVersion(),
                student.getDate_created());

        Connection connection=null;
        Statement statement=null;
        try {
            connection= dbConnection.tryConnection();
            statement=connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                }catch (SQLException e){
                    throw new RuntimeException("");
                }

            }

            if(connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    throw new RuntimeException("");
                }

            }
        }

    }

    @Override
    public List<Student> findAll() {
        var sql="SELECT * FROM student";
        List<Student> list=new ArrayList<>();
        try(var connection= dbConnection.tryConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                var student=new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setInstitute(resultSet.getString("institute"));
                student.setRoll(resultSet.getString("roll"));
                student.setClass_name(resultSet.getString("class_name"));
                student.setVersion(resultSet.getLong("version"));
                student.setDate_created(resultSet.getString("date_created"));
                list.add(student);
            }

        }catch (Exception e){
            throw new RuntimeException("");
        }

        return list;
    }



}
