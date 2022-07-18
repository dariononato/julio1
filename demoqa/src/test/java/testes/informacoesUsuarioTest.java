package testes;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class informacoesUsuarioTest {
	private WebDriver robo;
	@SuppressWarnings({ "unused", "deprecation" })
	@Before
	public void inicio() {
		// Abrindo o navegador
		System.setProperty("webdriver.chrome.driver",
				"/home/dario/eclipse-workspace/petz/Navegadores/chromedriver 102/chromedriver");
		robo = new ChromeDriver();
		robo.manage().window().maximize();
		robo.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Abrir uma pagina

		robo.get("http://www.juliodelima.com.br/taskit");

	}

	@Test
	public void testAdicionarUmaInformacaoDoUsuario() {

		// Clicar no Link que possui o texto "Sign in"
		robo.findElement(By.linkText("Sign in")).click();

		// Validar que eu esteja na tela para inserir usuário e senha Sign in
		assertEquals("Sign in", "Sign in");

		// Clicar no campo com o name="login" que está dentro do formulário de id
		// "signinbox"
		WebElement formularioSigninbox = robo.findElement(By.id("signinbox"));

		// Digitar no campo com o name="login" que está dentro do formulário de id
		// "signinbox" o texto "dario0001"
		formularioSigninbox.findElement(By.name("login")).sendKeys("dario0001");

		// Digitar no campo com o name="password" que está dentro do formulário de id
		// "signinbox"
		formularioSigninbox.findElement(By.name("password")).sendKeys("123!@#");

		// Clicar no link com o texto Sign in
		robo.findElement(By.linkText("SIGN IN")).click();

		//Validar que dentro do elemento com class "me" está o texto "Hi, Dario"
		// assertEquals("Hi, Dario", "Hi, Dario"); //Esse Assert tbm deu certo
		WebElement me = robo.findElement(By.className("me"));
		String textoNoElementoMe = me.getText();// o textoNoElementoMe é um nome que eu dei para apelidar a Strin
		assertEquals("Hi, Dario", textoNoElementoMe);
		
		//Clicar em um link que possui uma class me (My tasks)
		robo.findElement(By.linkText("My tasks")).click();
		
		//CLicar no botão + Add a task
		robo.findElement(By.xpath("//button[@data-target=\"addtask\"]")).click();
		
		//preencher o campo What will are trying to procrastinate?
		robo.findElement(By.name("title")).sendKeys("Estudar");
		//escolher o  texto
		robo.findElement(By.name("text")).sendKeys("Vai COrinthians");
		
		//Sim ou Não
		Select selecionador = new Select(robo.findElement(By.name("done")));
		selecionador.selectByVisibleText("Yes"); 
		
		//inserir data
		robo.switchTo().frame(robo.findElement(By.className("picker__frame")));
		robo.findElement(By.xpath("//*[@id=\"P1337424177_table\"]/tbody/tr[4]/td[2]/div")).sendKeys("18 July, 2022");
		
		//Clicar em SAve
		robo.findElement(By.xpath("//*[@id=\"addtask\"]/div[2]/a")).click();
		

	}
	

	@After
	public void fim() {

		// Fechar o navegador
		robo.quit();

	}
}
