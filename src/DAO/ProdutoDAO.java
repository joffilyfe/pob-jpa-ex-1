package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelos.Produto;
import java.util.List;


public class ProdutoDAO {
    private Produto produto;
    protected static EntityManager manager;


    public ProdutoDAO() {
        EntityManagerFactory banco = Persistence.createEntityManagerFactory("loja");
        manager = banco.createEntityManager();
    }

    public void add(String nome, double preco) {
        this.produto = new Produto(nome, preco);
        save();
    }

    public Produto get(int id) {
        manager.getTransaction().begin();
        Produto p = manager.find(Produto.class, id);
        manager.getTransaction().commit();

        return p;
    }

    public void delete(int id) {

        Produto p = get(id);

        if (p == null) return;

        manager.getTransaction().begin();
        manager.remove(p);
        manager.getTransaction().commit();
    }

    public List<Produto> all() {
        Query q = manager.createQuery("select p from Produto p");
        List<Produto> list = (List<Produto>)q.getResultList();
        return list;
    }

    public void doublePrice(int id) {
        Produto p = get(id);
        if (p == null) return;

        p.setPreco(p.getPreco() * 2);
        manager.getTransaction().begin();
        manager.merge(p);
        manager.getTransaction().commit();
    }

    public void updatePricePercent(double percent) {
        List<Produto> produtos = all();

        manager.getTransaction().begin();
        for (Produto p : produtos) {
            p.setPreco(p.getPreco() + ( p.getPreco() * (percent/100)));
            manager.merge(p);
        }
        manager.getTransaction().commit();
    }

    public void save() {
        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();

    }
}
