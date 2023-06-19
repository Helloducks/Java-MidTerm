package com.georgiancollege.test1;
import java.sql.*;
import java.util.ArrayList;

public class DBUtilitity {
    private static String user = "Saarath200520281";
    private static String pass = "0OFlJEf-9Y";
    private static String connectionString = "jdbc:mysql://172.31.22.43:3306/" + user;

    public static ArrayList<Employee> retrieveEmplyoeeFromDB() {
        ArrayList<Employee> Employees = new ArrayList<>();
        String sql = "SELECT employee_id,first_name,last_name,address,city,province,phone\n" +
                "FROM midTermEmployee;";
        try (
                Connection conn = DriverManager.getConnection(connectionString, user, pass);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while(resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                String address = resultSet.getString("address");

                String city = resultSet.getString("city");
                String province = resultSet.getString("province");
                String phoneNo = resultSet.getString("phone");
                Employee newemployee = new Employee(id,firstName,lastName,address,city,province,phoneNo);
                Employees.add(newemployee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Employees;


    }

    public static ArrayList<String> retrieveAreaCodeFromDB(){
        ArrayList<String> areaCodes = new ArrayList<>();
        String sql = "SELECT DISTINCT SUBSTRING(phone, 1, 3) AS AreaCode\n" +
                "FROM midTermEmployee\n" +
                "Order by AreaCode;";
        try (
                Connection conn = DriverManager.getConnection(connectionString, user, pass);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while(resultSet.next()){
                String areaCode = resultSet.getString("AreaCode");
                areaCodes.add(areaCode);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return areaCodes;
    }
    public static ArrayList<Employee> retrieveDataWithComboxInput(String comboBoxInput){
        ArrayList<Employee> Employees = new ArrayList<>();
        String sql = "SELECT employee_id,first_name,last_name,address,city,province,phone\n" +
                "FROM midTermEmployee\n" +
                "WHERE SUBSTRING(phone, 1, 3) = " + comboBoxInput +";";
        try (
                Connection conn = DriverManager.getConnection(connectionString, user, pass);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while(resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                String address = resultSet.getString("address");

                String city = resultSet.getString("city");
                String province = resultSet.getString("province");
                String phoneNo = resultSet.getString("phone");
                Employee newemployee = new Employee(id,firstName,lastName,address,city,province,phoneNo);
                Employees.add(newemployee);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return Employees;

    }

}