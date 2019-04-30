package app.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

    private String driver;
    private String url;
    private String username;
    private String password;

    Connection con = null;
    PreparedStatement preparedStatement = null;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void conInit() throws Exception {
        Class.forName(driver);
        con = DriverManager.getConnection(url,username,password);
        System.out.println("Connection Opened");
    }

    public void destroy() throws Exception {
        con.close();
        System.out.println("Connection Closed");
    }
    public void save(int roll, String name, String email){
        String sql = "insert into student1 values ('"+roll+"','"+name+"','"+email+"')";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
            System.out.println("record Inserted Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
