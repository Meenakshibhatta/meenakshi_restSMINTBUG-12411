



import java.sql.*; 
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author meenakshi.d
 */


@Path("user")
public class libraryService {
    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloWorld(){
        return "hello world from meenakshi";
    }
    
    @GET
    @Path("allbook")
    @Produces(MediaType.APPLICATION_JSON)
    public String allBook(){
        ArrayList<testmodel> arr= new ArrayList();
        ArrayList<String> arr1= new ArrayList();
        String value=" ";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//`com.mysql.cj.jdbc.Driver  com.mysql.jdbc.Driver
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://34.94.57.115:3306/org_db?useSSL=false","dbuser","123456");
            //here sonoo is database name, root is username and password  
            String sql = null;
            sql = "select * from book";
            System.out.println("i am inside..");
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                testmodel ts= new testmodel();
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                ts.setBkid(rs.getInt("bkid"));
                ts.setName(rs.getString("name"));
                ts.setPublisher(rs.getString("publisher"));
                arr.add(ts);               
                arr1.add(ts.getName());             
            }
            value= String.join(",", arr1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return value;
    }
    
    @GET
    @Path("allUser")
    @Produces(MediaType.APPLICATION_JSON)
    public String allUser(){
        ArrayList<testUsermodel> arr= new ArrayList();
        ArrayList<String> arr1= new ArrayList();
        String value=" ";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//`com.mysql.cj.jdbc.Driver  com.mysql.jdbc.Driver
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://34.94.57.115:3306/org_db?useSSL=false","dbuser","123456");
            //here sonoo is database name, root is username and password  
            String sql = null;
            sql = "select * from user";
            System.out.println("i am inside User..");
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                testUsermodel ts= new testUsermodel();
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                ts.setUserid(rs.getInt("userid"));
                ts.setUsername(rs.getString("username"));
                ts.setRole(rs.getString("role"));
                ts.setBookid(rs.getInt("bookid"));
                arr.add(ts);               
                arr1.add(ts.getUsername());             
            }
            value= String.join(",", arr1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return value;
    }
    
}
        


