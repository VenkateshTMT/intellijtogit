import UserDaoImplPkg.UserDaoImpl;
import UserDaoPackage.UserDao;
import UserModel.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static UserDao dObject= new UserDaoImpl();
    public static Scanner input =new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("initial Data in user table");
        accessSelectAll();
        System.out.println("Enter operation(GetUser,InsertUser,UpdateUser,DeleteUser,SelectUser) to perform:");
        String operation=input.next();

        switch(operation){
            case "GetUser":
                accessGetUser();
                break;
            case "InsertUser":
                accessInsertUser();
                break;
            case "UpdateUser":
                accessUpdate();
                break;
            case "DeleteUser":
                accessDelete();
                break;
            case "SelectUser":
                accessSelectAll();
                break;
            default:
                System.out.println("enter correct operation");
        }
    }


    public static void accessGetUser(){
        System.out.println("Enter user Id");
        User user=dObject.getUser(input.nextInt());
        System.out.println(user);
    }

    public static void accessInsertUser(){
        System.out.println("Enter user details");
        System.out.println("");
        System.out.println("Enter id:");
        int id=input.nextInt();
        System.out.println("Enter username:");
        String username=input.next();
        System.out.println("Enter password:");
        String  password=input.next();
        System.out.println("Enter email:");
        String email=input.next();
        System.out.println("Enter address:");
        String address=input.next();
        System.out.println("Enter role like customer,resturantAdmin,deliveryAgent:");
        String role=input.next();
        User user=new User(id,username,password,email,address,role,null,null);
        dObject.addUser(user);
        System.out.println("operation is success for this input"+user);
        System.out.println("After insertion");
        accessSelectAll();

    }

    public static void accessSelectAll() {
        List<User> myUserList= dObject.getAllUsers();
        for(User user:myUserList){
            System.out.println(user);
        }
    }

    public static void accessDelete() {
        System.out.println("Enter the id of the user to delete");
        dObject.deleteUser(input.nextInt());
        System.out.println("After deletion");
        accessSelectAll();
    }

    public static void accessUpdate() {
        System.out.println("this is the update method");

        System.out.println("Enter username:");
        String username=input.next();
        System.out.println("Enter password:");
        String  password=input.next();
        System.out.println("Enter email:");
        String email=input.next();
        System.out.println("Enter address:");
        String address=input.next();
        System.out.println("Enter role like customer,resturantAdmin,deliveryAgent:");
        String role=input.next();
        System.out.println("Enter id:");
        int id=input.nextInt();
        User user =new User(id,username,password,email,address,role,null,null);
        dObject.updateUser(user);
        System.out.println("After update");
        accessSelectAll();
    }
}