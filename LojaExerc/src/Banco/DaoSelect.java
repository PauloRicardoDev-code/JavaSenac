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

public class DaoSelect {

    private Conexao conexao;
    private Statement stm;
    private Connection con;
    private ResultSet rs;

    public boolean conect() {
        try {
            conexao = new Conexao();
            con = conexao.getConection();
            stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void desconect() {
        try {
            stm.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ResultSet selectVendas() {
        try {
            return stm.executeQuery("Select * FROM VENDAS");
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    

    /* Inserir cliente ao banco*/
    public void insertCliente(Cliente d) {
        try {
            String sql = "INSERT INTO VENDAS (DATA, NOME_CLIENTE, PRODUTO_ID, VALOR, PENDENCIA, QUANTIDADE) VALUES "
                    + "('" + d.getData() + "', '" + d.getNomeCliente() + "', " + d.getProdutoID() + ", "
                    + d.getValor() + ", '" + d.getValorPendencia() + "', " + d.getQuantidade() + ")";

            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    
    
    /* Inserir Fornecedor ao banco*/
    public void insertFornecedor(Fornecedor d) {
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
    public void insertProduto(Produtos d) {
        try {
            String sql = "INSERT INTO PRODUTOS (PRODUTO, VALOR_VENDA) VALUES "
                    + "('" + d.getNomeProduto() + "'," + d.getValorVenda() + ")";

            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    
    
    /* Listar no Aplicativo  */
    
    public List<Produtos> exibirProdutos() {

        List<Produtos> produtos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM PRODUTOS";
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Produtos produto = new Produtos();

                produto.setNomeProduto(rs.getString("produto"));
                produto.setId(rs.getInt("id"));
                produto.setValorVenda(rs.getDouble("Valor_Venda"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return produtos;

    }
    
    
    
    
    /* Listar no Aplicativo Vendas */
    
    public List<Cliente> exibirCliente() {

        List<Cliente> vendas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM vendas";
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setData(rs.getString("data"));
                cliente.setNomeCliente(rs.getString("Nome_cliente"));
                cliente.setProdutoID(rs.getInt("produto_id"));
                cliente.setValor(rs.getDouble("valor"));
                cliente.setQuantidade(rs.getInt("Quantidade"));
                vendas.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return vendas;

    }
    
    
    public List<Fornecedor> exibirFornecedores() {

        List<Fornecedor> fornecedor = new ArrayList<>();

        try {
            String sql = "SELECT * FROM fornecedores";
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Fornecedor fornec = new Fornecedor();

                fornec.setFornecedor(rs.getString("Fornecedor"));
                fornec.setProdutoID(rs.getInt("produto_id"));
                fornec.setValor(rs.getDouble("valor"));
                fornecedor.add(fornec);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return fornecedor;


    }

}
