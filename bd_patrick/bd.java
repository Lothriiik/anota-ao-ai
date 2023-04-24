import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class bd {
    public static void main(String[] args) {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/locadora", "root", "");

            Statement stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);

            

            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente;");

            while (rs.next()) {

            System.out.println("Login: " + rs.getString(1));
            System.out.println("Nome: " + rs.getString(2));
            System.out.println(" ");
            
            }
            
            stmt.close();
            con.close();
            
            } catch (ClassNotFoundException e) {
            
            System.out.println("Driver não encontrado!");
            
            } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro na execução do comando SQL!");
            
            }
            }
            }