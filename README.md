# Password Validator API

Esta é uma API simples para validar senhas com base em regras específicas. A API foi desenvolvida utilizando **Spring Boot** e documentada com **SpringDoc (Swagger)**.

---

## Regras de Validação de Senha

A senha é considerada válida se atender às seguintes regras:
1. Ter nove ou mais caracteres.
2. Conter pelo menos 1 dígito.
3. Conter pelo menos 1 letra minúscula.
4. Conter pelo menos 1 letra maiúscula.
5. Conter pelo menos 1 caractere especial (`!@#$%^&*()-+`).
6. Não conter caracteres repetidos.
7. Não conter espaços em branco.

---

## Como Executar o Projeto

### Pré-requisitos
- Java 17 ou superior.
- Maven 3.x.

### Passos para Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/password-validator.git
   cd password-validator
   ```

2. Compile e execute o projeto com Maven:
   ```bash
   mvn spring-boot:run
   ```

3. A API estará disponível em `http://localhost:8080`.

---

## Como Usar a API

### Endpoint de Validação de Senha

- **Método:** POST
- **URL:** `http://localhost:8080/api/password/validate`
- **Corpo da Requisição (JSON):**
  ```json
  {
      "password": "SuaSenhaAqui"
  }
  ```
- **Resposta:**
   - Status `200 OK` com `true` se a senha for válida.
   - Status `400 Bad Request` com `false` se a senha for inválida ou nula.

### Exemplo de Requisição

**Requisição:**
```bash
curl -X POST http://localhost:8080/api/password/validate \
-H "Content-Type: application/json" \
-d '{"password": "AbTp9!fok"}'
```

**Resposta:**
```json
true
```

---

## Documentação da API

A documentação da API está disponível via **Swagger UI**. Após executar a aplicação, acesse:

```
http://localhost:8080/swagger-ui.html
```

Na interface do Swagger, você poderá:
- Visualizar todos os endpoints.
- Testar a API diretamente no navegador.
- Ver exemplos de requisições e respostas.

---

## Testes

### Executando Testes Unitários

Para rodar os testes unitários, execute:

```bash
mvn test
```

### Casos de Teste

Os testes cobrem os seguintes cenários:
- Senha válida.
- Senha com menos de 9 caracteres.
- Senha sem dígitos.
- Senha sem letras minúsculas.
- Senha sem letras maiúsculas.
- Senha sem caracteres especiais.
- Senha com caracteres repetidos.
- Senha com espaços em branco.
- Senha nula.

---

## Decisões de Projeto

- **Spring Boot**: Escolhido por ser uma framework robusta e amplamente utilizada para APIs REST em Java.
- **SpringDoc (Swagger)**: Utilizado para documentação automática da API, facilitando o uso e a compreensão dos endpoints.
- **Logging**: Adicionado para rastrear o fluxo da aplicação e facilitar a depuração.
- **Validação**: Implementada no controller e no serviço para garantir que a senha não seja nula e atenda às regras especificadas.

---

## Melhorias Futuras

1. Adicionar autenticação à API para restringir o acesso.
2. Permitir a customização das regras de validação via configuração.
3. Internacionalizar as mensagens de erro.
4. Adicionar suporte a banco de dados para armazenar senhas válidas.

---

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## Contato

Para dúvidas ou sugestões, entre em contato:

- **Nome**: Renato Nakamura
- **GitHub**: [rynakamura](https://github.com/rynakamura)