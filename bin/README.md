# liax-prova-java

A Prova consiste em um pequeno sistema de cadastro para livros e autores, esse sistema possui uma arquitetura básica em camadas utilizando padrões, como Repositories, BOs e Services para um CRUD, nele se encontram algumas funcionalidades com erros, outras feitas utilizando más práticas ou até mesmo funcionalidades que ainda não existem, ou seja, com seu desenvolvimento pendente.

As Questões da Prova estão na branch "develop", juntamente com o script do banco de dados e o projeto java, basicamente a prova requer que as funcionalidades com problemas sejam resolvidas, as más práticas de programação sejam refatoradas em códigos melhores e as funcionalidades pendentes sejam criadas.

Faça um fork do projeto para seu repositório e ao terminar, por favor, realize um Pull Request/Merge Request. Seja o mais verboso possível demonstrando o pensamento empregado para resolução da prova, pois isso vai auxiliar na análise e correção da mesma, uma vez que a correção é feita levando em consideração tudo que foi feito e não apenas funcionar ou não o sistema.

Para realizar a prova é necessário as seguintes ferramentas e tecnologias:

* Java 1.8
* MySQL Community Server 5.5 ou MariaDB 10.1.40

* IDE ou editor de texto de sua escolha (Recomendamos o Eclipse ou NetBeans)

* Uma ferramenta integrada de desenvolvimento para banco de dados (Recomendamos o MySQL Workbench ou SQL YOG)

* Maven 3.3.9 (Caso não esteja usando nenhum ferramentas que já o possui integrado, por exemplo o eclipse)


Para início da prova, execute os seguintes passos:

* Faça o fork desse projeto

* Faça um clone do seu projeto “forkeado” do principal

* Por padrão o branch master está apenas com esse arquivo README

* De um checkout para branch "develop" (git checkout develop)

* Nessa branch está o projeto em Java, o script do banco de dados e as questões

* Execute o script database.sql  

* A questões da Prova estão na raiz do projeto

* Abra o projeto no seu editor/IDE, certifique que as dependências do projeto estão OK

* Configure a classe de conexão (ConnectionSingleton.java) com o MySQL passando host, porta, suas credenciais (usuário e senha) e nome do banco.


<b>Atenção:</b> Execute a prova por completo para certificar que tudo está funcionando, atentando-se aos erros apontados no console.

Boa Prova!
