
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
    public Connection getConection() {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/EXERC_LOJA", "root", "Amanhecer123");
            return conexao;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return null;
    }
}
