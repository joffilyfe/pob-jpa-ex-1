package fachada;

import DAO.ProdutoDAO;
import modelos.Produto;

public class Programa {

    public Programa() {
        ProdutoDAO pdao = new ProdutoDAO();

        // Inserindo 10 produtos
        pdao.add("Arroz", 50);
        pdao.add("Macarrão", 50);
        pdao.add("Maçã", 50);
        pdao.add("Tapioca", 50);
        pdao.add("Macaxeira", 50);
        pdao.add("Batata", 50);
        pdao.add("Biscoito", 50);
        pdao.add("Refrigerante", 50);
        pdao.add("Tempero", 50);
        pdao.add("Sabão", 50);

        // Dobrando o preço do item 5
        pdao.doublePrice(5);

        // Listando todos os produtos
        for (Produto p: pdao.all()) {
            System.out.println(p);
        }

        // Apagar o produto 10
        pdao.delete(10);

        // Aumentando o valor de todos os produtos em 10%
        pdao.updatePricePercent(10);

    }

    public static void main(String args[]) {
        new Programa();
    }
}