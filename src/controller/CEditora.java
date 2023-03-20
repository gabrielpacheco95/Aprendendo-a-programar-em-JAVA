/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Editora;


public class CEditora {

    ArrayList<Editora> editoras = new ArrayList<>();
    int idEditoras = 1;

    public CEditora() {
    }

    public int geraID() {
        return this.idEditoras++;
    }

    
    public void addEditora(Editora e) {
        this.editoras.add(e);
    }

        public ArrayList<Editora> getEditoras() {
        return this.editoras;
    }

    public void mockEditoras() {
        Editora e1 = new Editora();
        e1.setIdEditora(this.geraID());
        e1.setCnpj("98742369847521");
        e1.setEndereco("Rua das Oliveiras");
        e1.setTelefone("51782547891");
        e1.setGerente("Arnaldo");
        this.addEditora(e1);
         }

    public Editora getEditoraCNPJ(String cnpj) {
        Editora c = null;
        for (Editora cliente : editoras) {
            if (cliente.getCnpj().equals(cnpj)){
                c = cliente;
                break;
            }
        
        }
        return c;
    }

}// fim da classe controller
