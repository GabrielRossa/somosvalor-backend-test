# Teste Backend - Gabriel Rossa

Teste realizado para admissão na vaga de Desenvolvedor na empresa Somos Valor

## Fazendo o código funcionar:

1. Você precisa ter o maven e o JDK devidamente configurados em sua máquina
2. execute o comando ```mvn spring-boot:run```
3. Pronto! Seu servidor backend já está sendo executado!

## Sobre os objetivos do teste:

Os três objetivos principais foram cumpridos.

## Sobre os diferenciais
Foi implementado o segundo diferencial, que exigia a criação de um serviço adicional para consulta da categoria com a maior ocorrência de uma determinada letra em seu nome. Por exemplo, se tivermos a categoria Brinquedos e a categoria Medicamentos e eu chamar este serviço passando como parâmetro a letra "e" o retorno do serviço deverá ser a categoria Medicamentos.

Além disso, todos os endpoints de CRUD foram implementados. Por fim, um endpoint foi criado para listagem de todos os produtos cadastrados.

## Lista dos endpoints
## Endpoints de Categoria

### Listagem de todas as categorias de produtos (GET)

- **URL:** `http://localhost:8080/api/category/listAll`
- **Descrição:** Retorna todas as categorias de produtos.

### Listagem da categoria com mais ocorrência de uma letra específica (GET)

- **URL:** `http://localhost:8080/api/category/most-common-letter/{letter}`
- **Descrição:** Retorna a categoria com a maior ocorrência de uma determinada letra em seu nome.

### Listagem de uma categoria por ID (GET)

- **URL:** `http://localhost:8080/api/category/{id}`
- **Descrição:** Retorna a categoria correspondente ao ID fornecido.

### Criação de nova categoria (POST)

- **URL:** `http://localhost:8080/api/category/newCategory`
- **JSON esperado:**
    ```json
    {
      "name": "Nome da sua categoria"
    }
    ```
- **Descrição:** Cria uma nova categoria com o nome fornecido.

### Edição de uma categoria (PUT)

- **URL:** `http://localhost:8080/api/category/{id}`
- **JSON esperado:**
    ```json
    {
      "name": "Novo nome para sua categoria"
    }
    ```
- **Descrição:** Atualiza a categoria existente com o ID fornecido.

### Exclusão de uma categoria (DELETE)

- **URL:** `http://localhost:8080/api/category/{id}`
- **Descrição:** Exclui a categoria correspondente ao ID fornecido.

## Endpoints de Produto

### Listagem de todos os produtos filtrados por categoria

- **URL:** `http://localhost:8080/api/product/listByCategory/{categoryId}`
- **Descrição:** Retorna todos os produtos pertencentes à categoria especificada.

### Listagem de todos os produtos (GET)

- **URL:** `http://localhost:8080/api/product/listAll`
- **Descrição:** Retorna todos os produtos.

### Listagem de um produto por ID (GET)

- **URL:** `http://localhost:8080/api/product/{id}`
- **Descrição:** Retorna o produto correspondente ao ID fornecido.

### Criação de novo produto (POST)

- **URL:** `http://localhost:8080/api/product/newProduct`
- **JSON esperado:**
    ```json
    {
      "name": "Nome do produto",
      "category": {
        "id": {categoryID da categoria desejada}
      }
    }
    ```
- **Descrição:** Cria um novo produto com o nome e categoria fornecidos.

### Edição de um produto (PUT)

- **URL:** `http://localhost:8080/api/product/{id}`
- **JSON esperado:**
    ```json
    {
      "name": "Novo nome do produto",
      "category": {
        "id": {categoryID da nova categoria desejada}
      }
    }
    ```
- **Descrição:** Atualiza o produto existente com o ID fornecido.

### Exclusão de um produto (DELETE)

- **URL:** `http://localhost:8080/api/product/{id}`
- **Descrição:** Exclui o produto correspondente ao ID fornecido.

## Como rodar os testes

Os testes JUnit estão localizados na pasta `test` e podem ser executados para garantir que as funcionalidades da API estejam corretas. Certifique-se de ter todas as dependências necessárias instaladas e configure seu ambiente de desenvolvimento conforme necessário para rodar os testes.

Além disso, os endpoints não contemplados pelos testes unitários podem ser testados através de uma ferramenta como o **Postman** ou o **ThunderClient**.