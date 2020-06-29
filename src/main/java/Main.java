import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static UserRoleDAO userRoleDAO = new UserRoleDAO();
    static UserDAO userDAO = new UserDAO();

//
    public static void createUser() {
        String name, lastname, role;
        Integer age, id;

        System.out.println("Type id: ");
        id = scanner.nextInt();

        System.out.println("Type a name: ");
        name = scanner.next();

        System.out.println("Type a lastname: ");
        lastname = scanner.next();

        System.out.println("Type your age: ");
        age = scanner.nextInt();

        System.out.println("Type role: ");
        role = scanner.next();

        User user = new User(id, name, lastname, age, new UserRole(Role.valueOf(role)));
        userDAO.createUser(user);
        System.out.println("Utworzono Usera: " + user.toString());
    }
//
//
//    public static void calculate() {
//        Integer x, y;
//
//        System.out.println("Type first number: ");
//        x = scanner.nextInt();
//
//        System.out.println("Type second number: ");
//        y = scanner.nextInt();
//
//        System.out.println("Sum: " + Calculator.add(x, y));
//        System.out.println("Subtract: " + Calculator.subtract(x, y));
//        System.out.println("Multiply: " + Calculator.multiply(x, y));
//        System.out.println("Divide: " + Calculator.divide(x, y));
//    }

    

    public static void updateUserByID(){
        String name, lastname, role;
        Integer id, age;

        System.out.println("Type an id: ");
        id = scanner.nextInt();

        System.out.println("Type a name: ");
        name = scanner.next();

        System.out.println("Type a lastname: ");
        lastname = scanner.next();

        System.out.println("Type your age: ");
        age = scanner.nextInt();

        System.out.println("Type role: ");
        role = scanner.next();

        User user = new User(id, name, lastname, age, new UserRole(Role.valueOf(role)));
        userDAO.updateUser(user);
        System.out.println("Update usera: " + user);

    }

    public static void deleteUserByLastName(){
        String lastname;

        System.out.println("Type a lastname: ");
        lastname = scanner.next();


        userDAO.deleteUser(lastname);

    }

    public static void main(String[] args) {
//        createUser();
//        calculate();

        UserDAO userDAO = new UserDAO();
        User user = new User(1, "dir", "mk", 22, new UserRole(Role.valueOf("USER")));
        System.out.println(userDAO.getAllUsers());
//        updateUserByID();
        userDAO.createUser(user);
        deleteUserByLastName();
        System.out.println(userDAO.getAllUsers());


    }
}

