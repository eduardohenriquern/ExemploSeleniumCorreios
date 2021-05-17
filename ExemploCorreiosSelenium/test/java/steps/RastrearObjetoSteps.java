package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class RastrearObjetoSteps {

    private WebDriver driver;
    private String codigo;

//    @After
//    public void closeBrowser() {
//    	new WebDriverWait(driver, 5);
//    	driver.quit();
//    }


    @Dado("^que acesso o sistema do correios$")
    public void acessarSistemaDoCorreios() {
        driver = new ChromeDriver();
        driver.get("https://www.correios.com.br/");
        driver.manage().window().maximize();
    }

    @Quando("^insiro o código \"([^\"]*)\"$")
    public void inserirCodigo(String codigo){
        driver.findElement(By.id("objetos")).sendKeys(codigo);
        this.codigo = codigo;
    }

    @E("^clico no botão Buscar$")
    public void clicarBuscar() {
        WebElement lupa = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.elementToBeClickable(
                        driver.findElement(By.xpath("//button[@type='submit']"))));
        lupa.click();
    }

    @Então("^é exibida a página com o status do objeto$")
    public void exibirPaginaDeStatus() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // obtém a aba de resultado da busca
        String resultado = driver.findElement(By.className("codSro")).getText();
        assertEquals(resultado, this.codigo);
    }

    @Então("^recebo a \"([^\"]*)\"$")
    public void receberMensagemDeErro(String mensagem){
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String resultado = driver.findElement(By.className("info")).getText();
        assertEquals(resultado, mensagem);
    }
}
