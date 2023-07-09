

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class Students {
    private static String DB_URL = "jdbc:mysql://localhost:3306/sqleggweek4";
    private static String USER_NAME = "root";
    private static String PASSWORD = "namhoa652004";
 
    /**
     * main
     * 
     * @author viettuts.vn
     * @param args
     */
    public static void main(String args[]) {
        try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement st = conn.createStatement();
            Scanner scanner = new Scanner(System.in);
            int choice=0;
            String name;
            int age;
            int id;
            String major;
          
            while (choice!=5) 
    		{
    			choice = scanner.nextInt();
    			if (choice==1) 
    			{
    				// Select
    	            // get data from table 'student'
    	            ResultSet rs = st.executeQuery("select * from students");
    	            // show data
    	            while (rs.next()) {
    	                System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
    	                        + "  " + rs.getString(3)+ " " + rs.getInt(4));
    	            }
    			}
    			else if (choice==2) 
    			{
    				//Insert
    				System.out.println("Age: ?");
    				
    				age = scanner.nextInt();
    				scanner.nextLine();
    				System.out.println("name: ?");
    	            name = scanner.nextLine();
    	            System.out.println("major: ?");
    	            major = scanner.nextLine();
    	            System.out.println("id: ?");
    	            id = scanner.nextInt();
    	            scanner.nextLine();
    	            String sqlInsert = "INSERT INTO students(id, name, major, age) "
    	            + " VALUE(" +id + ", '"+name+"', '"+major+"',"+ age+ ");";
    	            int numberRowsAffected = st.executeUpdate(sqlInsert);
    	            System.out.println("Affected rows after inserted: " + numberRowsAffected);

    			}
    			else if (choice==3) 
    			{
    				// Update
    		         System.out.println("Update age?");
    	            age = scanner.nextInt();
    	            scanner.nextLine();
    	            System.out.println("Update name?");
    	            name = scanner.nextLine();
    	            System.out.println("Update major?");
    	            major = scanner.nextLine();
    	            System.out.println("Give me an id?");
    	            id = scanner.nextInt();
    	            scanner.nextLine();
    	            String sqlUpdate = "UPDATE students SET age= "+age+" ,name= '"+name+"', major= '"+major+"' WHERE id="+id;
    	            int numberRowsAffected = st.executeUpdate(sqlUpdate);
    	            System.out.println("Affected rows after updated: " + numberRowsAffected);

    			}
    			else if (choice==4) 
    			{
    				// Delete
    	            id = scanner.nextInt();
    	            scanner.nextLine();
    	            String sqlDelte = "DELETE FROM students WHERE id="+id;
    	            int numberRowsAffected = st.executeUpdate(sqlDelte);
    	            System.out.println("Affected rows after deleted: " + numberRowsAffected);
    	            
    			}
    			else if (choice==5) 
    			{
    				break;
    			}
    		}
            
         
   
           
           
         
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
 
    /**
     * create connection 
     * 
     * @author viettuts.vn
     * @param dbURL: database's url
     * @param userName: username is used to login
     * @param password: password is used to login
     * @return connection
     */
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}