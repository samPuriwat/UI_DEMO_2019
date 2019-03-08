import java.sql.*;

public class adminDAOImpl implements adminDAO {

    private static String driverName = "org.sqlite.JDBC";
    private static String url = "jdbc:sqlite:E:/company.sqlite";
    private static Connection conn = null;

    //Constant Operators
    private static final String AUTHEN = "select * from admin where username = ? and password = ?";


    private static adminDAOImpl instant = new adminDAOImpl();
    private adminDAOImpl(){
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Load Driver successfully.");
    }

    public static adminDAOImpl getInstance(){
        return instant;
    }


    public Admin authentication(String usn, String pwd) {
        Admin ad= null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url);
            ps = conn.prepareStatement(AUTHEN);
            ps.setString(1,usn);
            ps.setString(2,pwd);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);

                ad = new Admin(name);

                rs.close();
                ps.close();
                conn.close();

            }else {
                System.out.println("Username or Password is invalid.");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ad;
    }
}
