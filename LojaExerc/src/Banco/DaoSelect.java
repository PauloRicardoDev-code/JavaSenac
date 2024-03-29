package Banco;

import Model.Cliente;
import Model.Fornecedor;
import Model.Produtos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DaoSelect 
{
    private Conexao conexao;
    private Statement stm;
    private Connection con;
    private ResultSet rs;

    public boolean conect() 
    {
        try {
            conexao = new Conexao();
            con = conexao.getConection();
            stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    

    public void desconect() 
    {
        try {
            stm.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    
    public ResultSet selectVendas() 
    {
        try {
            return stm.executeQuery("Select * FROM VENDAS");
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    
    
    /* Inserir cliente ao banco*/
    public void insertCliente(Cliente d) 
    {
        try {               
            String sql = "INSERT INTO VENDAS (DATA, CLIENTE_ID, NOME_CLIENTE, PRODUTO_ID, VALOR, PENDENCIA, QUANTIDADE) VALUES "
                + "('" + d.getData() + "', " + d.getClienteID() + ", '" + d.getNomeCliente() + "', " + d.getProdutoID() + ", "
                + d.getValor() + ", '" + d.getValorPendencia() + "', " + d.getQuantidade() + ")";
                
            
            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    
    /* Inserir Fornecedor ao banco*/
    public void insertFornecedor(Fornecedor d) 
    {
        try {
            String sql = "INSERT INTO Fornecedores (fornecedor, PRODUTO_ID, VALOR) VALUES "
           + "('" + d.getFornecedor() + "', " + d.getProdutoID() + ", " + d.getValor() + ")";
                
            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    
    /* Inserir Produto ao banco*/
    public void insertProduto(Produtos d) 
    {
        try {
            String sql = "INSERT INTO PRODUTOS (PRODUTO) VALUES "
                    + "('" + d.getNomeProduto() + "')";
                
            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    public List<Produtos> exibirProdutos() {
        
        List<Produtos> produtos = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM PRODUTOS";
            rs = stm.executeQuery(sql);

            
            while(rs.next()) 
            {
            Produtos produto = new Produtos();  
            
            produto.setNomeProduto(rs.getString("produto"));
            produto.setId(rs.getInt("id"));
            produtos.add(produto);
            }
            
            
        }  catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         return produtos;
            
        
    }
    
    
}
