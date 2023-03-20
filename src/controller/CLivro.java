/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import livrariapoo.LivrariaPOO;
import model.Livro;




public class CLivro {
  

    ArrayList<Livro> livros = new ArrayList<>();
    int idLivro = 1;

    

    public int geraID() {
        return this.idLivro++;
    }

    
    public void addLivro(Livro l) {
        this.livros.add(l);
    }

    
    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    
    public void removeLivro(Livro l) {
        this.livros.remove(l);
    }

    
    public void mockLivros() {
        Livro l1 = new Livro();
        l1.setIdLivro(this.geraID());
        l1.setTítulo("Alice");
        l1.setIsbn("12387945836");
        l1.setAutor("R.B");
        l1.setEstoque(20);
        l1.setAssunto("Aventura");
        l1.setPreco(40);
        l1.setIdEditora(LivrariaPOO.cadEditora.getEditoraCNPJ ("98742369847521"));
        this.addLivro(l1);
    }

   
    public Livro getLivroISBN(String isbn) {
        Livro l = null;
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)){
                l = livro;
                break;
            }
        
        }
        return l;
    }

}// fim da classe controller


