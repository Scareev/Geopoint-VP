# 📍 Geopoint VP

## Sobre o projeto

Geopoint VP é uma aplicação desktop desenvolvida em Java com JavaFX que permite ao usuário cadastrar e visualizar pontos geográficos em um mapa estático. Após fazer login, o usuário pode clicar no mapa para marcar coordenadas e salvá-las no banco de dados vinculadas à sua conta.

## Imagens do projeto

<div align="center">
  <img width="49%" alt="Screenshot_51" src="https://github.com/user-attachments/assets/52d09a8a-2cef-413f-b758-f3b22d3e008c" />
  <img width="49%" alt="Screenshot_52" src="https://github.com/user-attachments/assets/2190dae7-c003-4f87-b545-573ef2c3f997" />
</div>

---

## Funcionalidades

- Login (NOME: Admin / SENHA: 123123)
- Marcação de pontos no mapa via clique do mouse
- Salvamento de coordenadas no banco de dados
- Visualização do ponto marcado em tempo real no canvas

---

## Tecnologias

- Java
- JavaFX 
- MySQL 

---

## Como rodar

### 1. Pré-requisitos

- [Java JDK 25](https://www.oracle.com/java/technologies/downloads/)
- [JavaFX SDK 26](https://gluonhq.com/products/javafx/)
- [MySQL 8.0](https://dev.mysql.com/downloads/mysql/)
- [MySQL Connector/J 9.6.0](https://dev.mysql.com/downloads/connector/j/)

### 2. Banco de dados

Execute os comandos abaixo no seu MySQL:

```sql
CREATE DATABASE Geopoint_VP;
USE Geopoint_VP;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL
);

CREATE TABLE ponto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    municipio VARCHAR(50) NOT NULL,
    eixoX DOUBLE NOT NULL,
    eixoY DOUBLE NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);
```

### 3. Configurar conexão

Edite o arquivo `src/factory/ConnectionFactory.java` com suas credenciais:

```java
private static final String URL = "jdbc:mysql://localhost:3306/Geopoint_VP";
private static final String USER = "root";
private static final String PASSWORD = "sua_senha_do_mysql";
```

### 4. VM Options

Nas configurações de execução do projeto, adicione as VM Options:

```
--module-path "CAMINHO_DO_JAVAFX/lib" --add-modules javafx.controls,javafx.fxml
```

### 5. Dependências no classpath

Adicione ao classpath do projeto:
- Todos os `.jar` da pasta `lib` do JavaFX SDK
- `mysql-connector-j-9.6.0.jar`

---

## Estrutura do projeto

```
src/
├── Main.java
├── dao/
│   ├── PontoDAO.java
│   └── UsuarioDAO.java
├── factory/
│   └── ConnectionFactory.java
├── gui/
│   ├── TelaLoginController.java
│   └── TelaPrincipalController.java
├── modelo/
│   ├── Ponto.java
│   └── Usuario.java
├── session/
│   └── Session.java
└── view/
    ├── TelaLogin.fxml
    └── TelaPrincipal.fxml
```

---

## Status

🚧 Versão 1.0.1 — em desenvolvimento recreativo.
