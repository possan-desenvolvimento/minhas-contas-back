# Projeto de Controle de Contas Mensais

Este é um sistema simples para gerenciamento de contas mensais, desenvolvido com um frontend em HTML, CSS e JavaScript puro, e um backend robusto em Spring Boot, utilizando PostgreSQL como banco de dados.

## Visão Geral

O projeto permite aos usuários:
- **Cadastrar** novas contas com descrição, valor, data de vencimento, status (Pendente, Pago, Atrasado) e categoria.
- **Visualizar** todas as contas cadastradas em uma tabela dinâmica.
- **Editar** contas existentes, atualizando seus detalhes.
- **Excluir** contas do sistema.

## Estrutura do Projeto

O repositório é composto por duas partes principais:

1.  **`contas-frontend/`**: Contém o código do frontend (HTML, CSS, JavaScript).
2.  **`contas-backend/`**: Contém o código do backend (Spring Boot).

## Tecnologias Utilizadas

### Frontend (`contas-frontend`)
- HTML5
- CSS3
- JavaScript (ES6+)

### Backend (`contas-backend`)
- Java 17 (ou superior)
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL (banco de dados)
- Maven (gerenciador de dependências)

### Infraestrutura
- Docker / Docker Compose (para PostgreSQL e pgAdmin)

## Pré-requisitos

Para rodar este projeto em sua máquina, você precisará ter instalado:

- [Git](https://git-scm.com/downloads)
- [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/downloads/) (ou compatível com Spring Boot 3.x)
- [Maven](https://maven.apache.org/download.cgi)
- [Node.js](https://nodejs.org/en/download/) (para servir o frontend localmente com Live Server ou similar)
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) (necessário para rodar o banco de dados e o pgAdmin)
    - Certifique-se de que a virtualização (Intel VT-x/AMD-V) está ativada na BIOS/UEFI e os recursos de virtualização do Windows (Hyper-V, Plataforma de Máquina Virtual, WSL2) estão habilitados.

## Como Rodar o Projeto

Siga os passos abaixo para configurar e executar o frontend e o backend.

### 1. Clonar o Repositório

```bash
git clone [https://github.com/seu-usuario/nome-do-repositorio.git](https://github.com/seu-usuario/nome-do-repositorio.git)
cd nome-do-repositorio
