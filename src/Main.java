import UserDaoImplPkg.UserDaoImpl;
import UserDaoPackage.UserDao;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static UserDao dObject= new UserDaoImpl();
    public static Scanner input =new Scanner(System.in);

    public static void accessGetUser(){
        System.out.println("Enter user Id");
        dObject.getUser(input.nextInt());
    }


    public static void accessInsertUser(){

    }


    public static void main(String[] args) {
        System.out.println("Enter operation to perform:");
        String operation=input.next();

        switch(operation){
            case "GetUser":
                accessGetUser();
                break;
            case "InsertUser":
                accessInsertUser();
        }
    }
}