import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRoleDAO {
    private Connection connection;
    private String databaseName = "people";
    private  String tableName = "roles";
    private String user = "rootMK";
    private String password = "admin";

    public UserRoleDAO(){
        init();
    }

    private void init() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+databaseName+
                    "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<UserRole> getAllUserRoles() {
        List<UserRole> userRoles = new LinkedList<UserRole>();
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String roleName = resultSet.getString("role");

                userRoles.add(new UserRole(id, Role.valueOf(roleName)));
                statement.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userRoles;
    }

    public UserRole getRoleById(Integer id){
        Statement statement = null;
        try{
            String query = "select * from " + tableName + " where id = '" + id + "'";
            statement= connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                String role = resultSet.getString("role");
                Role userRole = Role.valueOf(role);
                return new UserRole(id, userRole);
            }
            }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Integer getRoleIdByName(String roleName){
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String query =  "select * from " + tableName + " where role = '" + roleName + "'";

            ResultSet resultSet =  statement.executeQuery(query);

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                return id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

}
