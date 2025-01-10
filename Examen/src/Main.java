import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/examen";
        String user="root";
        String password="Leito_2015";
        String query="Select * from usuarios";
        try(Connection cone=DriverManager.getConnection(url,user,password)){
            PreparedStatement statement=cone.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            System.out.println("Conectado");
        }
        catch (Exception e){
            Exception e1= e;
            e1.printStackTrace();
        }
    }
}