/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import livrariapoo.LivrariaPOO;
import model.Livro;
import model.VendaLivro;



/**
 *
 * @author 311101245
 */
public class CVendaLivro {
    

    ArrayList<VendaLivro> vendaLivros = new ArrayList<>();
    int idVendaLivro = 1;

    

    public int geraID() {
        return this.idVendaLivro++;
    }

    
    public void addVendaLivro(VendaLivro v) {
        this.vendaLivros.add(v);
    }

    
    public ArrayList<VendaLivro> getVendaLivros() {
        return this.vendaLivros;
    }

    
    public void removeVendaLivro(VendaLivro v) {
        this.vendaLivros.remove(v);
    }

    
    public void mockVendaLivros() {
        VendaLivro v1 = new VendaLivro();
        v1.setIdVendaLivro(this.geraID());
        v1.setIdCliente(LivrariaPOO.cadCliente.getClienteCPF ("12387945836"));
        v1.setDataVenda(LocalDate.parse("2023-03-14"));
        ArrayList<Livro>livros1 = new ArrayList<>();
        livros1.add(LivrariaPOO.cadLivro.getLivroISBN("12387945836"));
        v1.setLivros(livros1);
        v1.setSubTotal((float)100.00);
       
        
        
        this.addVendaLivro(v1);
    }

       
}
