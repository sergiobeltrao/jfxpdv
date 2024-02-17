import com.sergio.jfxpdv.telas.TelaDeLogin;
import com.sergio.jfxpdv.modelo.ConfiguracoesDoAplicativo;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class ConfiguracoesDoAplicativoTest extends ApplicationTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
        ApplicationTest.launch(TelaDeLogin.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }


    @Test
    public void testAvisoDePrimeiraConfiguracao() {
        ConfiguracoesDoAplicativo configuracoesDoAplicativo = new ConfiguracoesDoAplicativo();
        configuracoesDoAplicativo.avisosDeInicializacao(0);
    }
}
