Calculadora de IMC — API REST
Projeto de estudo em Java e Spring Boot para praticar o desenvolvimento de uma API REST, a organização do código por responsabilidades e a injeção de dependência.

Desenvolvido acompanhando aulas no YouTube, com implementação e compreensão do código passo a passo. As fórmulas e faixas de interpretação seguem o exercício apresentado nas aulas.
Funcionalidades
- Receber altura em metros e peso em quilogramas para calcular o IMC.
- Retornar a interpretação do IMC conforme as regras do exercício.
- Converter a altura para centímetros e calcular o peso ideal conforme a fórmula estudada.
- Guardar o último resultado em memória.
- Consultar o último resultado, retornando 200 OK quando ele existe ou 204 No Content quando ainda não há resultado salvo.
  Tecnologias e ferramentas
  Tecnologia	Aplicação no estudo
  Java	Linguagem utilizada no backend.
  Spring Boot	Inicialização e configuração da aplicação.
  Spring Web / Spring MVC	Recebimento de requisições HTTP e retorno de respostas em JSON.
  Maven	Gerenciamento de dependências e construção do projeto.


O estudo também aborda o uso do Postman para enviar requisições e de Dockerfile para empacotar a aplicação, incluindo a construção da imagem em duas etapas.
Organização do código
Pacote	Responsabilidade
controller	Definir as rotas HTTP e preparar as respostas da API.
dto	Representar os dados de entrada e saída.
service	Coordenar os cálculos e o acesso ao último resultado.
storage	Manter o último resultado em memória.
utils	Reunir os métodos utilitários de cálculo e interpretação do IMC.


A Controller recebe o Service pelo construtor, e o Service recebe o Storage. O Spring gerencia esses componentes por meio de anotações como @RestController, @Service e @Component.
Executar localmente
Utilize um JDK compatível com a versão Java definida no pom.xml.

No IntelliJ IDEA, importe o projeto Maven e execute o método main da classe ImcApplication.

Também é possível iniciar pela raiz do projeto com o Maven Wrapper.

Windows / PowerShell:
.\mvnw.cmd spring-boot:run
Linux / macOS:
./mvnw spring-boot:run
Com a aplicação iniciada na porta padrão, a URL base será http://localhost:8080/api/imc.

A execução local pelo IntelliJ ou pelo Maven Wrapper permite testar a API sem iniciar um container Docker.
Endpoints da versão atual
Método	Rota	Finalidade
POST	/api/imc/calcular	Calcular o IMC e salvar o último resultado em memória.
POST	/api/imc/ultimo-resultado	Consultar o último resultado salvo.


Calcular o IMC
No Postman, selecione o método POST, use a URL http://localhost:8080/api/imc/calcular e configure Body → raw → JSON.

Envie o cabeçalho Content-Type: application/json e o corpo:
{
"altura": 1.94,
"peso": 93
}
No fluxo de sucesso, a API retorna 200 OK com o IMC, sua interpretação, o peso ideal calculado e a altura em centímetros.
Consultar o último resultado
Envie uma requisição POST para http://localhost:8080/api/imc/ultimo-resultado, sem corpo.
Situação	Resposta
Existe resultado salvo	200 OK, com os dados no corpo da resposta.
Ainda não existe resultado salvo	204 No Content, sem corpo.


Escopo do estudo
O armazenamento utiliza um atributo em um componente gerenciado pelo Spring. O resultado é compartilhado entre as requisições da mesma instância da aplicação e substituído quando um novo cálculo é realizado.

Os dados são perdidos ao reiniciar a aplicação. Esta versão guarda apenas o último resultado, sem histórico ou separação por usuário.

A validação automática com Bean Validation e o tratamento global de exceções foram deixados para outros estudos, mantendo o foco no fluxo da requisição, nos DTOs, nos cálculos e na injeção de dependência.

O conteúdo de Docker estudado separa a geração do JAR da preparação da imagem final de execução. A versão Java utilizada na imagem deve ser compatível com a configuração do projeto.
Autor e contexto
José Pedro Merlo — estudante de Java e Spring Boot.

Projeto desenvolvido para aprendizado, acompanhando aulas no YouTube. O repositório registra a implementação do exercício e os conceitos praticados ao longo do estudo.