### 📌 Sobre o Projeto

Este repositório foi criado para solidificar meus conhecimentos em Java com Spring Boot, explorando as capacidades do framework para desenvolvimento ágil e código limpo.

O sistema implementa um CRUD (Create, Read, Update, Delete) de produtos, demonstrando a separação de responsabilidades e o uso de Data Transfer Objects (DTOs) e classes de serviço para uma arquitetura bem estruturada.

### 🔗 Endpoints da API

| Método HTTP | Endpoint          | Descrição                                                |
|-------------|-------------------|------------------------------------------------------------|
| `POST`      | `/products`      | Cria um novo produto. Espera um `ProductDTORequest` no body. |
| `GET`       | `/products/{id}` | Retorna os dados de um produto específico pelo seu ID.     |
| `GET`       | `/products`      | Lista todos os produtos cadastrados.                       |
| `PUT`       | `/products/{id}` | Atualiza os dados de um produto existente pelo seu ID. Espera um `Product` no body. |
| `DELETE`    | `/products/{id}` | Remove um produto específico pelo seu ID.                |
| `DELETE`    | `/products`      | Remove **todos** os produtos.                             |

### 🛠 Tecnologias Utilizadas

* **Java:** Linguagem de programação principal.
* **Spring Boot:** Framework para desenvolvimento rápido de aplicações Java.
* **Spring Data JPA:** Simplifica a interação com bancos de dados relacionais.
* **Lombok:** Biblioteca para reduzir código boilerplate (getters, setters, construtores).
* **Jakarta Bean Validation:** Para definir e aplicar regras de validação nos dados.
* **Swagger UI:** Para documentação interativa da API e testes dos endpoints.

### ⚙️ Arquitetura

O projeto segue uma arquitetura com as seguintes camadas principais:

* **Controllers:** Responsáveis por receber as requisições HTTP e delegar o tratamento para a camada de serviço.
* **Services:** Contêm a lógica de negócios da aplicação, realizando as operações necessárias e utilizando os repositórios para acessar os dados.
* **Repositories:** Interfaces responsáveis pela comunicação com o banco de dados, utilizando o Spring Data JPA.
* **Entities:** Representam as tabelas do banco de dados e os dados da aplicação.
* **DTOs (Data Transfer Objects):** Objetos utilizados para transferir dados entre as camadas, especialmente entre a camada de apresentação (Controllers) e a camada de serviço. Eles ajudam a definir claramente os dados que são esperados em requisições e retornado em respostas, além de permitir a aplicação de validações específicas para cada cenário.

### 🚀 Funcionalidades Destacadas

✔️ Operações CRUD completas com validações definidas nos DTOs.
<br>✔️ Documentação automatizada via Swagger para teste fácil dos endpoints.
<br>✔️ Endpoints RESTful seguindo melhores práticas (verbos HTTP adequados, status codes).
<br>✔️ Separação clara de responsabilidades entre Controllers, Services e Repositories.
<br>✔️ Utilização de DTOs para uma comunicação estruturada e validada.
<br>✔️ Operações em massa (listar/remover todos os produtos).

### 💡 Por que este projeto?

* Prática com Spring Data JPA para persistência de dados.
* Experiência com padrões REST e tratamento de exceções.
* Uso do Swagger como ferramenta essencial para APIs backend-centric.
* Implementação de DTOs para melhorar a organização e validação dos dados transferidos.
* Organização da lógica de negócios em classes de serviço dedicadas.

### ✨ Melhorias Realizadas (Baseado nas Rotas do Swagger):

* Tabela organizada com todas as rotas e seus propósitos.
* Destaque visual para métodos HTTP.
* Linguagem técnica mas acessível para outros desenvolvedores.
* Agrupamento lógico das informações.
* **Inclusão da explicação e uso de DTOs para requisição (`ProductDTORequest`) e resposta (`ProductDTOResponse`).**
* **Demonstração da utilização de classes de serviço (`UpdateService`, `DeleteAllService`, `DeleteByIdService`, `ReportAllService`, `ReportByIdService`) para encapsular a lógica de negócios.**
* **As rotas foram atualizadas para refletir as encontradas no seu Swagger:**

| Título no Swagger | Método HTTP | Endpoint            | Descrição                                                                  |
|-------------------|-------------|---------------------|----------------------------------------------------------------------------|
| `update-product`  | `POST`      | `/products/update/{id}` | Atualiza os detalhes do produto com o ID especificado. Envie os dados atualizados no corpo da requisição. |
| `create-product`  | `POST`      | `/products/create`    | Cria um novo produto. Envie os dados do produto no corpo da requisição.    |
| `report-by-id`    | `GET`       | `/products/reportById/{id}` | Retorna os detalhes do produto com o ID especificado.                      |
| `report-all-products`| `GET`       | `/products/reportAll`   | Retorna uma lista de todos os produtos.                                  |
| `delete-by-id`    | `DELETE`    | `/products/delete/{id}` | Exclui o produto com o ID especificado.                                  |
| `delete-all-product`| `DELETE`    | `/products/delete/all` | Exclui todos os produtos. **Use com cautela!** |
