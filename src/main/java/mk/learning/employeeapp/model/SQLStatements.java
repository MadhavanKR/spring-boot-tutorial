package mk.learning.employeeapp.model;

public class SQLStatements {
	public static String addEmpSql = "insert into employee values(?,?)"; 
	public static String deleteEmpSql = "delete from employee where name=?";
	public static String getEmpSql = "select name from employee";
}
