package br.com.spring.sistemagerenciamento;

import br.com.spring.sistemagerenciamento.modelo.Produto;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

// @SpringBootApplication
public class SistemagerenciamentoApplication {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException{
		// SpringApplication.run(SistemagerenciamentoApplication.class, args);

		HttpRequest request = HttpRequest.newBuilder()
		.uri(new URI("http://www.submarino.com.br/busca?conteudo=SIMPLE_PRODUCT"))
		.GET()
		.build();

		HttpResponse<String> response = HttpClient.newHttpClient()
		.send(request, HttpResponse.BodyHandlers.ofString());

		ObjectMapper objectMapper = new ObjectMapper();

		List<Produto> produtos = objectMapper.readValue(response.body(), new TypeReference<List<Produto>>(){});

		String relatorioProdutosFeitosEmCasa = Relatorio.getRelatorio(produtos);

		System.out.println(relatorioProdutosFeitosEmCasa);
	}

}
