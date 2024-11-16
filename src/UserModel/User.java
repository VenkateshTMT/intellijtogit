package UserModel;
import java.util.*;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String address;
    private String role;
    private Date createDate;
    private Date lastLoginDate;

    public User() {
    }

    public User(int userId, String username, String password,String email ,String address, String role, Date createDate, Date lastLoginDate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email=email;
        this.address = address;
        this.role = role;
        this.createDate = createDate;
        this.lastLoginDate = lastLoginDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getEmail() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "id: "+userId+" name: "+username+" Password: "+password
                +"  email: "+email+" address:"+address+" Role: "+role+" CreateDate: "+createDate+" lastLoginDate: "+lastLoginDate;

    }
}
