package jdbc_prueba;

import java.sql.*;

public class prueba_jdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StockMaster";
        String user = "root";
        String password = "ExtruDelFox1010";


        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement();


            String insertQuery = "INSERT INTO administrador (nombre,email) VALUES ('juan', 'juan499@hotmail.com')";
            int rowsInsted = stmt.executeUpdate(insertQuery);
            if (rowsInsted > 0)
            {
                System.out.println("InsercionExitosa");
            }

            ResultSet resultado = stmt.executeQuery("select * from administrador");
            while (resultado.next())
            {
                System.out.print(resultado.getString("nombre"));
                System.out.print(" ");
                System.out.println(resultado.getString("email"));

            }
            resultado.close();


            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
