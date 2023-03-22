/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 311101245
 */
public class Livro {
    private int idLivro;
    private String título;
    private String autor;
    private String assunto;
    private String isbn;
    private int estoque;
    private float preco;
    private Editora idEditora;

    public Livro() {
    }

    public Livro(int idLivro, String titulo, String autor, String assunto, String bn, int estoque, float preco, Editora idEditora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Editora getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Editora idEditora) {
        this.idEditora = idEditora;
    }

    @Override
    public String toString() {
        return "Livro{" + "idLivro=" + idLivro + ", t\u00edtulo=" + título + ", autor=" + autor + ", assunto=" + assunto + ", isbn=" + isbn + ", estoque=" + estoque + ", preco=" + preco + ", idEditora=" + idEditora + '}';
    }

    public void setIdEditora(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
