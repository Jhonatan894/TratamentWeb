package me;

    import org.openqa.selenium.*;
    import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import java.time.Duration;
    import java.util.List;
    import java.util.Scanner;

public class TratamentWeb {

    public static void main(String[] args) {
        // Configurando o WebDriver e a pesquisa no site do indeed
        Scanner sc = new Scanner(System.in);
        System.out.printf("QUE TIPO DE VAGA ESTA PROCURANDO?: ");
        String Search = sc.nextLine();

        System.out.println("QUAL A LOCALIZAÇÃO: ");
        String Location = sc.nextLine();

        sc.close();

        WebDriver EdgeDriver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(EdgeDriver, Duration.ofSeconds(3));

        try {
            // Navegando para o Indeed
            String url = "https://br.indeed.com/?from=mobRdr&utm_source=%2Fm%2F&utm_medium=redir&utm_campaign=dt";
            EdgeDriver.get(url);
            //pesquisando
            WebElement TextInput = EdgeDriver.findElement(By.id("text-input-what"));
            TextInput.sendKeys(Search);
            Thread.sleep(1000);

            WebElement TextInputLocation = EdgeDriver.findElement(By.id("text-input-where"));
            TextInputLocation.sendKeys(Location);


            //confirmando a pesquisa
            TextInput.sendKeys(Keys.ENTER);

            // Esperando a página carregar
            EdgeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            // Localizando os elementos das vagas através de XPath
            List<WebElement> vagas = EdgeDriver.findElements(By.xpath(".//div[contains(@class, 'job_seen_beacon')]"));

            // Iterando sobre cada vaga encontrada
            for (WebElement vaga : vagas) {
                try {
                    // Lista de títulos importantes

                    // Capturando o título da vaga via XPath (STRING ONDE CONTENHA JOBTITLE, COMPANYNAME)
                    String title = vaga.findElement(By.xpath(".//h2[contains(@class, 'jobTitle')]")).getText();

                    // Capturando o nome da empresa via XPath (STRING ONDE CONTENHA JOBTITLE, COMPANYNAME)
                    String company = vaga.findElement(By.xpath(".//*[contains(@class, 'company_location')]")).getText();

                    // Capturando o link da vaga via XPath
                    String link = vaga.findElement(By.xpath(".//a[@href]")).getAttribute("href");

                    EdgeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

                    //LOCALIZANDO COM BASE NA PESQUISA SEARCH
                    if (title.contains(Search)) {
                        System.out.println("TÍTULO: " + title);
                        System.out.println("EMPRESA: " + company);
                        System.out.println("LINK: " + link);
                        System.out.println("--------------------------");
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao processar uma vaga: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO GERAL: " + e.getMessage());
        } finally {
            // Finalizando o driver do Edge
            EdgeDriver.quit();
        }
    }
}
