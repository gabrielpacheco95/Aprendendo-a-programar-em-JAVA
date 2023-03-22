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
import model.Editora;
import model.Livro;
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

    public static int leiaNumFloat() {
        Scanner leiaNum = new Scanner(System.in);
        int num = 99;
        try {
            num = leiaNumFloat();
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
        System.out.println(cadCliente.getClientes().toString());
        for (Cliente cli : cadCliente.getClientes()) {
            System.out.println("CPF: \t" + cli.getCpf());
            System.out.println("Nome: \t" + cli.getNomeCliente());
            System.out.println("Fone: \t" + cli.getTelefone());
        }
        System.out.println("4 - Deletar" + tpCad);
        deletarCliente();
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
        if (cadCliente.getClienteCPF(cpf) != null) {
            System.out.println("Cliente Já Cadastrado");
        } else {
            System.out.print("Informe o nome: ");
            nomeCliente = leia.nextLine();
            System.out.print("Informe o telefone: ");
            telefone = leia.nextLine();
            System.out.print("Informe o Endereço: ");
            endereco = leia.nextLine();
            idCliente = cadCliente.geraID();
            Cliente cli = new Cliente(idCliente, nomeCliente, cpf, cnpj, endereco, telefone);
            cadCliente.addCliente(cli);
            System.out.println("Cliente Cadastrado com sucesso");

        }
    }// Fim Do cadastrarCliente    

    public static void deletarCliente() {
        System.out.println("Deletar Cliente");
        System.out.print("Informe o cpf: ");
        String cpf = leia.next();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = cadCliente.getClienteCPF(cpf);
            if (cli != null) {
                cadCliente.removeCliente(cli);
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Cliente não consta na base de dados!");
            }
        } else {
            System.out.println("CPF INVÀLIDO!");

        }
    }// Fim do deletar Cliente

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
                case 3:
                    int opSM;
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        //switch
                        switch (opSM) {
                            case 1:
                                System.out.println(" -- Cadastrar -- ");
                                if (opM == 1) {
                                    cadastrarCliente();
                                } else if (opM == 2) {
                                    cadastrarEditora();
                                } else if (opM == 3) {
                                    cadastrarLivro();
                                }
                            case 2:
                                System.out.println("-- Editar --");
                                editarCliente();

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

    private static void editarCliente() {
        System.out.println("-- Editar Cliente --");
        System.out.print("Informe o CPF: ");
        String cpf = leia.nextLine();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = cadCliente.getClienteCPF(cpf);
            if (cli != null) {
                System.out.println("1 - Nome:\t" + cli.getNomeCliente());
                System.out.println("2 - Endereço:\t" + cli.getEndereco());
                System.out.println("3 - Fone:\t" + cli.getTelefone());
                System.out.println("4 - Todos os campos acima?");
                System.out.print("Qual campo deseja alterar?"
                        + "\nDigite aqui: ");
                int opEditar = leiaNumInt();
                //Sugestão Sérgio INF3M212
                if (opEditar == 1 || opEditar == 4) {// "||" pipe significa "ou"
                    System.out.print("Informe o nome: ");
                    cli.setNomeCliente(leia.nextLine());
                }
                if (opEditar == 2 || opEditar == 4) {
                    System.out.print("Informe o endereço: ");
                    cli.setEndereco(leia.nextLine());
                }
                if (opEditar == 3 || opEditar == 4) {
                    System.out.print("Informe o telefone: ");
                    cli.setTelefone(leia.nextLine());
                }
                if (opEditar < 1 || opEditar > 4) {
                    System.out.println("Opção inválida!");
                }
                /*
                switch (opEditar) {
                    case 1:
                        System.out.print("Informe o nome: ");
                        cli.setNomeCliente(leia.nextLine());
                        break;
                    case 2:
                        System.out.print("Informe o endereço: ");
                        cli.setEndereco(leia.nextLine());
                        break;
                    case 3:
                        System.out.print("Informe o telefone: ");
                        cli.setTelefone(leia.nextLine());
                        break;
                    case 4:
                        System.out.println("Informe todos os campos abaixo:");
                        System.out.print("Informe o nome: ");
                        cli.setNomeCliente(leia.nextLine());
                        System.out.print("Informe o endereço: ");
                        cli.setEndereco(leia.nextLine());
                        System.out.print("Informe o telefone: ");
                        cli.setTelefone(leia.nextLine());
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                 */
                System.out.println("Cliente:\n" + cli.toString());
            } else {
                System.out.println("Cliente não cadastrado!");
            }
        } else {
            System.out.println("CPF inválido!");
        }
    }

    public static void cadastrarEditora() {
        int idEditora;
        String nmEditora;
        String cnpj;
        String endereco;
        String telefone;
        String gerente;

        System.out.println("-- Cadastrar Editora --");
        System.out.print("Informe o CNPJ da Editora: ");
        boolean cnpjis;
        int opCNPJ;
        do {
            cnpj = leia.nextLine();
            cnpjis = Validadores.isCNPJ(cnpj);
            if (!cnpjis) {
                System.out.print("CNPJ Invalido!"
                        + "\nDeseja tentar novamente? 1 - Sim || 2 - Não: ");
                opCNPJ = leiaNumInt();
                if (opCNPJ == 1) {
                    System.out.print("Informe o CNPJ: ");
                } else if (opCNPJ == 2) {
                    System.out.println("Cadastro encerrado pelo usuario!");
                    break;
                }
            }

        } while (!cnpjis);

        if (cadEditora.getEditoraCNPJ(cnpj) != null) {
            System.out.println("Editora já cadastrada!");
        } else {
            System.out.print("Informe o nome da editora: ");
            nmEditora = leia.nextLine();
            System.out.print("Informe o telefone da editora: ");
            telefone = leia.nextLine();
            System.out.print("Informe o endereço da editora: ");
            endereco = leia.nextLine();
            System.out.print("Informe o nome do gerente: ");
            gerente = leia.nextLine();
            idEditora = cadEditora.geraID();

            Editora edi = new Editora(idEditora, nmEditora, cnpj, endereco, telefone, gerente);
            cadEditora.addEditora(edi);
            System.out.println("Editora cadastrada com sucesso!");
        }
    }//fim do cadastrarEditora

    private static void editarEditora() {
        System.out.println("-- Editar Editora --");
        System.out.print("Informe o CNPJ: ");
        String cnpj = leia.nextLine();
        if (Validadores.isCNPJ(cnpj)) {
            Editora edi = cadEditora.getEditoraCNPJ(cnpj);
            if (edi != null) {
                System.out.println("1 - Nome:\t" + edi.getNmEditora());
                System.out.println("2 - Endereço:\t" + edi.getEndereco());
                System.out.println("3 - Fone:\t" + edi.getTelefone());
                System.out.println("4 - Todas as opções acima");
                System.out.print("Qual das opções deseja alterar? 1 || 2 || 3 || 4\n Digite aqui: ");
                int opEditar = leiaNumInt();
                switch (opEditar) {
                    case 1:
                        System.out.print("Informe o nome: ");
                        edi.setNmEditora(leia.nextLine());
                        break;
                    case 2:
                        System.out.print("Informe o endereço: ");
                        edi.setEndereco(leia.nextLine());
                        break;
                    case 3:
                        System.out.println("Informe o fone: ");
                        edi.setTelefone(leia.nextLine());
                        break;
                    case 4:
                        System.out.println("Informe todos os campos abaixo:");
                        System.out.print("Informe o nome: ");
                        edi.setNmEditora(leia.nextLine());
                        System.out.print("Informe o endereço: ");
                        edi.setEndereco(leia.nextLine());
                        System.out.print("Informe o fone: ");
                        edi.setTelefone(leia.nextLine());
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                System.out.println("Editora:\n" + edi.toString());
            } else {
                System.out.println("Editora não cadastrado!");
            }
        } else {
            System.out.println("CNPJ inválido!");
        }
    }//fim do editarEditora

    public static void listarEditora() {

        for (Editora edi : cadEditora.getEditoras()) {
            System.out.println("----");
            System.out.println("CNPJ:\t" + edi.getCnpj());
            System.out.println("Nome:\t" + edi.getNmEditora());
            System.out.println("Fone:\t" + edi.getTelefone());
        }

    }//fim listarCliente

    public static void deletarEditora() {
        System.out.println("-- Deletar Editora --");
        System.out.print("Informe o CNPJ: ");
        String cnpj = leia.nextLine();

        if (Validadores.isCNPJ(cnpj)) {
            Editora edi = cadEditora.getEditoraCNPJ(cnpj);
            if (edi != null) {
                cadEditora.removeEditora(edi);
                System.out.println("Editora deletada com sucesso!");
            } else {
                System.out.println("Editora não consta na base de dados!");
            }
        } else {
            System.out.println("CNPJ inválido!");
        }
    }//fim deletarEditora

    private static void cadastrarLivro() {
        System.out.println("-- Cadastro de Livro --");
        System.out.print("Informe o ISBN: ");
        String isbn = leia.nextLine();
        if (cadLivro.getLivroISBN(isbn) != null) {
            System.out.println("Livro ja cadastrado");
        } else {
            int idLivro = cadLivro.geraID();
            System.out.print("Informe o Título do Livro: ");
            String titulo = leia.nextLine();
            System.out.print("Informe o Autor: ");
            String autor = leia.nextLine();
            System.out.print("Infome o assunto:");
            String assunto = leia.nextLine();
            System.out.print("Informe o estoque: ");
            int estoque = leiaNumInt();
            System.out.print("Informe o preço: ");
            float preco = leiaNumFloat();
            boolean isCNPJ = false;
            Editora idEditora = null;
            do {
                System.out.print("Informe o CNPJ da Editora: ");
                String cnpj = leia.nextLine();
                isCNPJ = Validadores.isCNPJ(cnpj);
                if (isCNPJ) {
                    idEditora = cadEditora.getEditoraCNPJ(cnpj);
                    if (idEditora == null) {
                        System.out.println("Editora não cadastrada!");
                        isCNPJ = false;
                    }
                } else {
                    System.out.println("CNPJ inválido!");
                }

            } while (!isCNPJ);
            Livro l = new Livro(idLivro, titulo, autor, assunto, isbn, estoque, preco, idEditora);
            cadLivro.addLivro(l);
            System.out.println("Livro Cadastrado com sucesso");
        }
    }

    private static void editarLivro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void listarLivro() {
        System.out.println("-- Lista de livros --");
        for (Livro livro : cadLivro.getLivros()) {
            System.out.println("ISBN: \t" + livro.getIsbn());
            System.out.println("Título:\t" + livro.getTítulo());
            System.out.println("Atutor: \t" + livro.getAutor());
            System.out.println("Estoque: \t" + livro.getEstoque());
            System.out.println("Assunto: \t" + livro.getAssunto());
        }
    }

    private static void deletarLivro() {
        System.out.println("-- Deletar Livro -- ");
        System.out.print("Informe o ISBN: ");
        String isbn = leia.nextLine();
        Livro li = cadLivro.getLivroISBN(isbn);
        if (li != null) {
            System.out.println("Livro" + li.getTítulo()+ "Será deletado!");
            cadLivro.removeLivro(li);
        } else {
            System.out.println("ISBN não encontrado!");
        }
    }

}
/*
                switch (opEditar) {
                    case 1:
                        System.out.print("Informe o Nome: ");
                        cli.setNomeCliente(leia.nextLine());
                        break;
                    case 2:
                        System.out.print("Informe o Endereco: ");
                        cli.setEndereco(leia.nextLine());
                        break;
                    case 3:
                        System.out.println("Informe o telefone:");
                        cli.setTelefone(leia.nextLine());
                        break;
                    case 4:
                        System.out.println("Informe todos os campos abaixo: ");
                        System.out.print("Informe o Nome: ");
                        cli.setNomeCliente(leia.nextLine());

                        System.out.print("Informe o Endereco: ");
                        cli.setEndereco(leia.nextLine());

                        System.out.println("Informe o telefone:");
                        cli.setTelefone(leia.nextLine());
                        break;

                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
                /*
                System.out.println("Cliente: \n" + cli.toString());

            } else {
                System.out.println("Cliente não cadastrado!");
            }
        } else {
            System.out.println("CPF inválido");
        }
    }

    private static void cadastrarEditora() {
        

    }

 */
