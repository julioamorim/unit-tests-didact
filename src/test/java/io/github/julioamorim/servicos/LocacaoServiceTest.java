package io.github.julioamorim.servicos;

import io.github.julioamorim.wcaquino.entidades.Filme;
import io.github.julioamorim.wcaquino.entidades.Locacao;
import io.github.julioamorim.wcaquino.entidades.Usuario;
import io.github.julioamorim.wcaquino.utils.DataUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class LocacaoServiceTest {

    @Rule
    public ErrorCollector erro = new ErrorCollector();

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

        //assert that woth corematchers by static import
        assertThat(filmeAlugado.getValor(), is(15.00));
        assertThat(filmeAlugado.getValor(), is(not(16.00)));

        assertTrue(DataUtils.isMesmaData(filmeAlugado.getDataLocacao(), new Date()));
        assertTrue(DataUtils.isMesmaData(filmeAlugado.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

        assertThat(DataUtils.isMesmaData(filmeAlugado.getDataLocacao(), new Date()), is(true));
        assertThat(DataUtils.isMesmaData(filmeAlugado.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));

        //With rules and checkThat, is possible view erros individually
        erro.checkThat(DataUtils.isMesmaData(filmeAlugado.getDataLocacao(), new Date()), is(true));
        erro.checkThat(DataUtils.isMesmaData(filmeAlugado.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
    }
}
