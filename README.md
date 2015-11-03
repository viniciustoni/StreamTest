# StreamTest
Aplicação para efetuar um teste de tecnologia onde gera um serviço REST com springMVC e SprongBoot onde recebe um stream e retorna a primeira letra que nao se repete na stream.

# Developers
- Vinicius Antonio Gai - viniciustoni@gmail.com

# Tecnologias
As técnologias utilizadas para o desenvolvimento da aplicação foram:
- Maven 3
- Spring Framework
- Spring boot
- Swagger - Frameworks para API
- Java 7

# Como executar a aplicação?
Para rodar a aplicação é necessário conter o Maven 3 instalado e configurado na maquina.
Após isso basta executar no prompt, dentro da pasta da aplicação os seguintes comandos maven:
- Compilando a aplicação: mvn clean package
- Executando a aplicação: mvn spring-boot:run -Dserver.port=8080

# Como utilizar a aplicação?
Como a aplicação está executando o framework do Swagger, ao acessar a URL (http://localhost:8080/index.html) será redirecionado para uma pagina onde irá conter todos os serviços Rest da aplicação:
- /streamtest/stream/firstChar : Calcula o primeiro char unico na stream

## /streamtest/stream/firstChar
URL completa: http://localhost:8080/streamtest/stream/firstChar

- JSON Request
O Request, basta informar a stream:

* Exemplo de chamada Request
![executaStream](https://github.com/viniciustoni/StreamTest/blob/master/img_doc/Chamada_servico.png)

- JSON Response
O Response caso de sucesso retorna o char localizado
![retornoStream](https://github.com/viniciustoni/StreamTest/blob/master/img_doc/Resultado_servico.png)

#Arquitetura
A aplicação está divida em 2 camadas:
- Controller: Camada que está esposta para acesso externo, com os serviços REST.
- Core: Camada contendo o processamento da aplicação, ou seja, as regras de negócio.

##Classe de UniqueStreamImpl
A classe de UniqueStreamImpl é uma implementação da interface Stream, onde contém os seguintes métodos:
- hasNext: Caso haja mais itens para serem processados.
- getNext: Carrega o proximo char UNICO para processamento, ou seja, esse método retorna todos os chars unicamente, sem repetição, exemplo: AaAbb:
  - 1 Chamada: A
  - 2 Chamada: a
  - 3 Chamada: b
- isUnique: Esse método valida se um determinado char é unico dentro da stream.
