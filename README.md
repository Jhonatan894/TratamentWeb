# TratamentWeb - Automação de Busca de Vagas no Indeed

Este projeto automatiza a busca de vagas de emprego no site **Indeed** usando o **Selenium WebDriver**. O programa solicita ao usuário informações sobre o tipo de vaga e a localização desejada e, em seguida, exibe as vagas correspondentes encontradas na plataforma.

## Funcionalidades

- **Entrada do usuário**: O programa solicita ao usuário que insira o tipo de vaga e a localização desejada.
- **Busca no Indeed**: A busca é realizada no site do Indeed com os critérios fornecidos pelo usuário.
- **Exibição dos resultados**: O programa exibe o título da vaga, o nome da empresa e o link para cada vaga encontrada que corresponde ao tipo de vaga procurado.
- **Automação de Navegação**: O programa usa o Selenium WebDriver para navegar no site, preencher os campos de pesquisa e coletar as informações sobre as vagas.

## Requisitos

- **Java 11 ou superior**
- **Selenium WebDriver**
- **Microsoft Edge WebDriver** (para quem utiliza o Microsoft Edge como navegador)

## Dependências

### Selenium WebDriver e EdgeDriver

1. **Baixar o Selenium**: Baixe a biblioteca Selenium para automação de navegação na web. Você pode obter os JARs no [site oficial do Selenium](https://www.selenium.dev/downloads/). O pacote `selenium-java` inclui todos os JARs necessários para o Selenium.

2. **Baixar o WebDriver**:
   - Para quem usa **Microsoft Edge**, baixe o [EdgeDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/) compatível com sua versão do Edge.
   - Caso queira usar outro navegador (como Chrome ou Firefox), baixe o WebDriver correspondente.

3. **Adicionar os JARs ao Classpath**:
   Coloque os JARs baixados em uma pasta, por exemplo, `libs/` dentro do seu projeto. A estrutura do projeto pode ficar assim:
   /seu-projeto /libs selenium-java-x.x.x.jar selenium-api-x.x.x.jar edge-driver-x.x.x.jar /src me/TratamentWeb.java


## Como Configurar o Projeto

1. **Configuração do WebDriver**:
- Certifique-se de definir o caminho correto para o **EdgeDriver** (ou outro WebDriver, dependendo do navegador que você está usando).
- No código, defina o caminho para o WebDriver como mostrado abaixo:

```java
System.setProperty("webdriver.edge.driver", "caminho/para/edgedriver");
WebDriver driver = new EdgeDriver();


Compilação e Execução: Após configurar os JARs corretamente no classpath, compile e execute o código manualmente com os seguintes comandos no terminal ou prompt de comando.

Para compilar o código:

bash
Copiar
javac -cp ".;libs/*" me/TratamentWeb.java
Para executar o código:

bash
Copiar
java -cp ".;libs/*" me.TratamentWeb
Em sistemas Linux/macOS, substitua ; por ::

Para compilar em Linux/macOS:

bash
Copiar
javac -cp ".:libs/*" me/TratamentWeb.java
Para executar em Linux/macOS:

bash
Copiar
java -cp ".:libs/*" me.TratamentWeb
Exemplo de Execução
makefile
Copiar
QUE TIPO DE VAGA ESTA PROCURANDO?: Analista de Sistemas
QUAL A LOCALIZAÇÃO: São Paulo

TÍTULO: Analista de Sistemas - TI
EMPRESA: Empresa XYZ - São Paulo, SP
LINK: https://www.indeed.com.br/viewjob?jk=1234567890abcdef
--------------------------
TÍTULO: Analista de Sistemas Pleno
EMPRESA: Empresa ABC - São Paulo, SP
LINK: https://www.indeed.com.br/viewjob?jk=abcdef1234567890
--------------------------
Como Funciona
O programa solicita ao usuário o tipo de vaga e a localização desejada.
Com essas informações, o programa abre o site do Indeed e preenche os campos de pesquisa.
Após realizar a pesquisa, o programa captura as vagas encontradas, extrai o título, a empresa e o link de cada vaga e exibe essas informações para o usuário.
O processo é repetido até que todas as vagas relevantes sejam processadas.
Tratamento de Erros
O programa inclui tratamento básico de erros para garantir que a execução continue mesmo em caso de falha ao processar uma vaga. Se um erro ocorrer ao tentar extrair dados de uma vaga, uma mensagem de erro será exibida, mas a execução continuará.
