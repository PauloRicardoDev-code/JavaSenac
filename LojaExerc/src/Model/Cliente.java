package Model;

import java.time.LocalDate;

public class Cliente {

    private String nomeCliente, data;
    private int produtoID, clienteID, quantidade;
    private double valor;
    private double valorPendencia;

    
    
    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public double getValorPendencia() {
        return valorPendencia;
    }

    public void setValorPendencia(double valorPendencia) {
        this.valorPendencia = valorPendencia;
    }

    public Cliente(String data, String nomeCliente, int produtoID, double valor,int quantidade) {
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.produtoID = produtoID;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Cliente() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
