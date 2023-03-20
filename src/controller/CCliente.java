/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author 311101245
 */
public class CCliente {

    ArrayList<Cliente> clientes = new ArrayList<>();
    int idCliente = 1;

    /**
     * geraID gerencia a geração de id
     *
     * @return
     */

    public int geraID() {
        return this.idCliente++;
    }

    /**
     * addCliente adiciona um cliente na lista
     *
     * @param c
     */
    public void addCliente(Cliente c) {
        this.clientes.add(c);
    }

    /**
     * getClientes retorna a lista de clientes
     *
     * @return
     */
    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * removeClente remove os clientes da lista de clientes
     *
     * @param c
     */
    public void removeCliente(Cliente c) {
        this.clientes.remove(c);
    }

    /**
     * mockClientes inicializa a aplicação com clientes
     */
    public void mockClientes() {
        Cliente c1 = new Cliente();
        c1.setIdCliente(this.geraID());
        c1.setNomeCliente("Juvenal das Candongas");
        c1.setCpf("12387945836");
        c1.setEndereco("Rua das Oliveiras");
        c1.setTelefone("51782547891");
        this.addCliente(c1);

        Cliente c2 = new Cliente();
        c2.setIdCliente(this.geraID());
        c2.setNomeCliente("joaquin");
        c2.setCpf("87423684959");
        c2.setEndereco("Rua das margaridas");
        c2.setTelefone("51987365478");
        this.addCliente(c2);
    }

    /**
     * getClienteCPF pesquisa cliente pelo CPF. Caso encontre, retorna o cliente
     * caso não encontre, retorna nulo, podendo cadastrar.
     * @param cpf
     * @return 
     */
    public Cliente getClienteCPF(String cpf) {
        Cliente c = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)){
                c = cliente;
                break;
            }
        
        }
        return c;
    }

}// fim da classe controller
