/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livrariapoo;

import controller.CCliente;
import controller.CEditora;
import controller.CLivro;
import controller.CVendaLivro;
import java.util.Scanner;
import model.Cliente;
import util.Validadores;

/**
 *
 * @author 311101245
 */
public class LivrariaPOO {

    public static CCliente cadCliente = new CCliente();
    public static CEditora cadEditora = new CEditora();
    public static CLivro cadLivro = new CLivro();
    public static CVendaLivro cadVendaLivro = new CVendaLivro();
    public static Scanner leia = new Scanner(System.in);

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        int num = 99;
        try {
            num = leiaNum.nextInt();
        } catch (Exception e) {
            System.out.println("Tente novamente");
            leiaNum.nextLine();
        }
        return num;
    }

    public static void menuP() {
        System.out.println("Livraria");
        System.out.println("1- Gerenciar Clientes");
        System.out.println("2- Gerenciar Editoras");
        System.out.println("3- Gerenciar Livros");
        System.out.println("4- Venda Livro");
        System.out.println("0- Sair");
        System.out.print("Escolha uma opcção: ");
    }

    public static void subMenu(int op) {
        String tpCad = null;
        switch (op) {
            case 1:
                tpCad = "Cliente";
                break;
            case 2:
                tpCad = "Editora";
                break;
            case 3:
                tpCad = "Livro";
                break;
        }
        System.out.println("-- Ger." + tpCad + " --");
        System.out.println("1 - Cadastrar" + tpCad); //CADASTRAR CLIENTE
        System.out.println("2 - Editar" + tpCad);
        System.out.println("3 - Listar" + tpCad + "s");
        System.out.println("4 - Deletar" + tpCad);
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarCliente() {
        int idCliente;
        String nomeCliente;
        String cpf;
        String cnpj = null;
        String endereco;
        String telefone;

        System.out.println("-- Cadastro de Cliente --");
        System.out.print("Informe o CPF: 1");
        boolean cpfIs;
        int opCPF;
        do {
            cpf = leia.nextLine();
            cpfIs = Validadores.isCPF(cpf);
            if (!cpfIs) {
                System.out.println("CPF Inválido" + "\nDeseja tenta novamente? 1-Sim 2-Não");
                opCPF = leiaNumInt();
                if (opCPF == 1) {
                    System.out.print("Informe o CPF: ");
                } else if (opCPF == 2) {
                    System.out.println("Cadastro Cancelado pelo usuário");
                    break;
                }
            }
        } while (!Validadores.isCPF(cpf));
        if (cadCliente.getClienteCPF(cpf) != null){
            System.out.println("Cliente Já Cadastrado");
        }else{
            System.out.print("Informe o nome: ");
            nomeCliente = leia.nextLine();
            System.out.print("Informe o telefone: ");
            telefone= leia.nextLine();
            System.out.print("Informe o Endereço: ");
            endereco= leia.nextLine();
            idCliente = cadCliente.geraID();
            Cliente cli = new Cliente(idCliente, nomeCliente, cpf, cnpj, endereco, telefone);
            cadCliente.addCliente(cli);
            System.out.println("Cliente Cadastrado com sucesso");
            
        }
    }// Fim Do cadastrarCliente    

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cadCliente.mockClientes();
        cadEditora.mockEditoras();
        cadLivro.mockLivros();
        cadVendaLivro.mockVendaLivros();

        int opM;

        do {
            menuP();
            opM = leiaNumInt();
            //colocar um switch
            switch (opM) {
                case 1:
                case 2:
                case 03:
                    int opSM;
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        //switch
                        switch (opSM) {
                            case 1:
                                System.out.println(" -- Cadastrar -- ");
                                cadastrarCliente();
                            case 2:
                                System.out.println("-- Editar --");

                            case 3:
                                System.out.println("-- Listar --");
                                System.out.println(cadCliente.getClientes().toString());

                            case 4:
                                System.out.println("-- Aplicação Encerrada -- ");
                                break;
                            case 0:
                                System.out.println("-- Menu Principal--");
                                break;
                            default:
                                System.out.println("Aplicação encerrada");
                                break;
                        }
                    } while (opSM != 0); //fim subMenu
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opM != 0); //Sistema

    }
}
