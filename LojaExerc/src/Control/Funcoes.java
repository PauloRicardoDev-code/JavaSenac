package Control;

import Banco.DaoSelect;
import Model.Cliente;

public class Funcoes {

    public void inserePessoa() {
        DaoSelect daoSelect = new DaoSelect();
        daoSelect.conect();
        
        /*
        Cliente cliente = new Cliente();

        cliente.setNomeCliente(nomeCliente.getText());
        cliente.setData(data.getText());
        cliente.setValor(Double.parseDouble(txtValor.getText()));
        cliente.setValorPendencia(Double.parseDouble(valorPendencia.getText()));
        cliente.setProdutoID(Integer.parseInt(produtoID.getText()));
        cliente.setClienteID(Integer.parseInt(IDcliente.getText()));
        daoSelect.insertCliente(cliente);

        daoSelect.desconect();*/
    }
}
