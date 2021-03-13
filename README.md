
<!-- SOBRE O PROJETO -->
## SOBRE O PROJETO

Crud utilizando Spring Boot e JPA, para aprendizado. 

Tecnologias utilizadas:
* Java
* JPA
* Hibernate
* Lombok
* MapStruct
* MySQL
* Junit

<!-- GETTING STARTED -->
## Instalação

### Pré requisitos

* Insomnia/Postman ( Para testar os endpoints ) 

  
* Alguma IDE que rode Java  como Eclipse, Intellij... 

* Mysql
  
* Docker  


### Instalação

1. Pegue o link do repositório https://github.com/Raeski/crud-place.git
2. Clone o repo
   ```sh
   git clone https://github.com/Raeski/crud-place.git
   ```
3. Abra em sua IDE de prefêrencia

4. No terminal execute docker-compose up

5. Na IDE execute o arquivo GamesApplication

6. No insomnia teste os endpoins no localhost:8080

```
    Exemplo de JSON :
    {
    "name": "Fifa 21",
    "producer": "EA",
    "releaseYear": 2020
    }
 ```

   ```JS
   POST /games - para criar um jogo
   
   GET /games - Retorna uma lista com todos os jogos
   
   GET /games/{id} - Retorna o Game que foi passado o id
   
   DELETE /games/{id} - Deleta o Game que foi passado o id
   
   PUT /games - Atualiza o Game, precisa passar o id do game dentro do JSON
   ```

<!-- CONTACT -->
## Contato


<p>Feito por <b>Gustavo Raeski</b>  :octocat: | - gustavoraeski@outlook.com

<a href="https://www.linkedin.com/in/gustavo-raeski/">Entre em contato</a></p>

