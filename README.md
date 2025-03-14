# SucoDoceMel - Projeto Banca Sucos

Este projeto é um sistema para gestão de sucos, desenvolvido utilizando **Java EE** e **PrimeFaces**. O sistema foi estruturado como um WAR (Web Archive) e utiliza **Hibernate** para persistência de dados, **JSF** para a interface de usuário e **MySQL** como banco de dados.

## Tecnologias Utilizadas

- **Java 8**: Versão do JDK utilizada.
- **Hibernate 5.0.7**: Framework ORM para persistência de dados.
- **MySQL 8.0**: Banco de dados relacional.
- **JSF 2.2.13**: Framework para a criação da interface de usuário.
- **PrimeFaces 7.0**: Biblioteca de componentes para JSF.
- **Weld 2.3.3.Final**: Implementação do CDI (Contexts and Dependency Injection) para gerenciar a injeção de dependências.
- **JUnit 4.13**: Framework para testes unitários.

## Requisitos

- Java 8
- MySQL 8.0 ou superior
- Maven 3.8.1 ou superior
- Servidor de Aplicação (Tomcat, JBoss, WildFly)

## Configuração do Banco de Dados

A aplicação utiliza **MySQL** como banco de dados. A configuração do banco de dados pode ser feita no arquivo de configuração do Hibernate (geralmente `hibernate.cfg.xml`), que deve incluir as credenciais de acesso:

```xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/sucodocemel</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">senha</property>
    </session-factory>
</hibernate-configuration>
```

## Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/sucodocemel.git
cd sucodocemel
```

### 2. Compilar e empacotar a aplicação

Este projeto é configurado como um WAR (Web Archive). Você pode empacotar a aplicação utilizando o Maven:

```bash
mvn clean package
```

Após empacotar, você pode fazer o deploy do arquivo WAR no servidor de aplicação (Tomcat, JBoss, WildFly).

### 3. Executar no servidor

Copie o arquivo `SucoDoceMel.war` para o diretório `webapps` do Tomcat ou configure o deploy no JBoss/WildFly, conforme o servidor de sua escolha.

## Testes

A aplicação inclui dependências para testes com o **JUnit**. Você pode executar os testes com o seguinte comando:

```bash
mvn test
```

## Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── br
│   │       └── com
│   │           └── suco
│   │               └── doce
│   │                   └── mel
│   └── resources
│       ├── hibernate.cfg.xml
├── test
│   └── java
│       └── br
│           └── com
│               └── suco
│                   └── doce
│                       └── mel
└── target
```
