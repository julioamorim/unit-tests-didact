package io.github.julioamorim.servicos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import io.github.julioamorim.wcaquino.entidades.Filme;
import io.github.julioamorim.wcaquino.entidades.Locacao;
import io.github.julioamorim.wcaquino.entidades.Usuario;
import io.github.julioamorim.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@Test
	public void verifica_filme_alugado() {
		// definiçao de de cenario pra testes

		LocacaoService service = new LocacaoService();

		Usuario usuario = new Usuario("Júlio Amorim");

		Filme homemDeFerro = new Filme();
		homemDeFerro.setEstoque(1);
		homemDeFerro.setNome("Homem de Ferro");
		homemDeFerro.setPrecoLocacao(15.00);

		// Ação do cenario de teste
		Locacao filmeAlugado = service.alugarFilme(usuario, homemDeFerro);

		// Validação do cenário de Teste

		Assert.assertTrue(filmeAlugado.getValor() == 15.00);
		Assert.assertTrue(DataUtils.isMesmaData(filmeAlugado.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(filmeAlugado.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
}
