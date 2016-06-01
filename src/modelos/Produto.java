package modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nome;
    private double preco;
    private Date created_at = new Date();

    public Produto() {};
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() { return this.preco; }
    public String getNome() { return this.nome; }

    @Override
    public String toString() {
        return this.nome + ", R$: " + this.getPreco();
    }
}
