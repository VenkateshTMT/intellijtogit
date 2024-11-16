package UserDaoImplPkg;

import UserDaoPackage.UserDao;
import UserModel.User;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class UserDaoImpl implements UserDao {

    static final String SELECT_USER="select * from `user` where `userId`=?";

    static final String INSERT_QUERY="insert into `user`(`userId`,`username`,`password`,`email`,`address`,`role`) values(?,?,?,?,?,?)";

    static final String UPDATE_QUERY="update user set `username`=?,`password`=?,`email`=?,address=?,`role`=? where `userId`=?";


    static final String DELETE_USER="delete `user` where `userId`=?";

    static final String SELECT_ALL_USERS="select * from user";

    private Connection connection;

    public UserDaoImpl(){
        String url="jdbc:mysql://localhost:3306/food_delevery";
        String username="root";
        String password="@Venkat46";

        try{
            connection = DriverManager.getConnection(url,username,password);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) {
        PreparedStatement pstmt=null;
        try{
            pstmt=connection.prepareStatement(INSERT_QUERY);
            pstmt.setInt(1,user.getUserId());
            pstmt.setString(2,user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4,user.getEmail());
            pstmt.setString(5, user.getAddress());
            pstmt.setString(6,user.getRole());

             pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public User getUser(int userId) {
        PreparedStatement pstmt=null;
        ResultSet res=null;
        User user=null;
        try{
            pstmt=connection.prepareStatement(SELECT_USER);
            pstmt.setInt(1,userId);
            res=pstmt.executeQuery();

            if(res.next()){
                String username=res.getString("username");
                String password=res.getString("password");
                String email=res.getString("email");
                String address=res.getString("address");
                String role=res.getString("role");
                Date createDate=res.getDate("createDate");
                Date lastLoginDate=res.getDate("lastLoginDate");

                user=new User(userId,username,password,email,address,role,createDate,lastLoginDate);
            }
            return user;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        PreparedStatement pstmt=null;
        try {
            pstmt = connection.prepareStatement(UPDATE_QUERY);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3,user.getEmail());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5,user.getRole());
            pstmt.setInt(6,user.getUserId());
            pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(int userId) {
        PreparedStatement pstmt=null;
        try{
            pstmt=connection.prepareStatement(DELETE_USER);
            pstmt.setInt(1,userId);
            pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Statement stmt=null;
        ResultSet res=null;
        ArrayList<User> userList=new ArrayList<>();
        try{
            stmt=connection.createStatement();
            res= stmt.executeQuery(SELECT_ALL_USERS);

            while(res.next()){
                int userId=res.getInt("userId");
                String username=res.getString("username");
                String password=res.getString("password");
                String email=res.getString("email");
                String address=res.getString("address");
                String role=res.getString("role");
                Date createDate=res.getDate("createDate");
                Date lastLoginDate=res.getDate("lastLoginDate");
                User user=new User(userId,username,password,email,address,role,createDate,lastLoginDate);
                userList.add(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

}
