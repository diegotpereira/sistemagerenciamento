package br.com.spring.sistemagerenciamento;

import java.util.Comparator;
import java.util.List;

import br.com.spring.sistemagerenciamento.modelo.Produto;

public class Relatorio {
    
    public static String getRelatorio(List<Produto> produtoLista) {

        StringBuilder sb = new StringBuilder();
        sb.append("Mostre todos os produtos caseiros que o cliente deseja comprar: ");

        produtoLista.stream()
        .filter(produto -> produto 
        .getCaseiro()
        .equals(true))
        .sorted(Comparator.comparing(Produto::getPreco))
        .forEach(produto -> {
            sb.append("\n..." + produto.getNome());
            sb.append("\n " + descricaoDaDivisao(produto.getDescricao()));

            if(produto.getPreco() > 700) {
                sb.append("\nMuito caro, provavelmente não vale a pena.");
            } else {
                sb.append("\nPreço: " + produto.getPreco() + "R$");
            }
        });

        Double custoProdutoCaseiro = 0.0;
        Long contarProdutoFeitoEmCasa = 0L;

        custoProdutoCaseiro = produtoLista
        .stream()
        .filter(produto -> produto.getCaseiro()
        .equals(true))
        .mapToDouble(Produto::getPreco)
        .sum();

        contarProdutoFeitoEmCasa = produtoLista
        .stream()
        .filter(produto -> produto.getCaseiro()
        .equals(true))
        .count();

        sb.append("\nCaseiro custa: " + custoProdutoCaseiro + "R$");
        sb.append("\nContagem caseira: " + contarProdutoFeitoEmCasa);

        return sb.toString();
    }
    public static String descricaoDaDivisao(String descricao) {
        String descricaoDaDivisao;

        if (descricao.length() < 50) { 
            return descricao;
        }

        descricaoDaDivisao = descricao.substring(0, 50) + " etc.";

        return descricaoDaDivisao;
    }
}
