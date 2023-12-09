# PharmaSystem - Sistema de Gerenciamento de Farmácias

O PharmaSystem é um projeto backend desenvolvido utilizando a linguagem Java, com o objetivo de fornecer uma solução eficiente e intuitiva para o gerenciamento das farmácias pertencentes ao grupo do cliente. Com uma variedade de funcionalidades, desde o cadastro e consulta de farmácias e medicamentos, até a manipulação dos estoques, o PharmaSystem oferece uma plataforma abrangente para facilitar a gestão de informações farmacêuticas.

## Principais Funcionalidades

### Cadastro de Farmácias

É possível realizar o cadastro de farmácias, sendo uma ferramenta essencial para manter a base de dados atualizada. Os usuários podem adicionar detalhes específicos sobre cada farmácia, como nome, endereço e informações de contato. Além disso, existe a possibilidade de adicionar informações geográficas (longitude e latitude) ajuda a melhorar a precisão de sua localização.

### Cadastro de Medicamentos

Como o cadastro de farmácias, é possível realizar também o cadastro de medicamentos, de maneira eficaz para futuramente gerenciar o estoque das farmácias. Os usuários podem inserir detalhes importantes, como nome do medicamento, dosagem, laboratório/fabricante e descrição do medicamento, a fim de garantir que a equipe esteja sempre ciente dos produtos farmacêuticos disponíveis.

### Consulta de Farmácias de Medicamentos

É possível realizar a consulta de farmácias pelo CNPJ e medicamentos pelo número de registro, ou, ainda, pesquisar de forma rápida, todas as farmácias ou medicamentos cadastrados no banco de dados.

### Alteração de Estoque

Também, é possível administrar o estoque de cada farmácia, com a compra e venda de medicamentos, que será somado ou subtraído ao estoque, bem como, poderá ser realizada a transferência de medicamentos de uma farmácia para outra, de forma eficaz.


## Como Visualizar o Projeto

1. **Clonar o repositório:**

   ```bash
   git clone https://github.com/netoacpn/m02projeto
   cd pharmasystem
   ```

2. **Instalar Dependências:**

   Certifique-se de que possui o Maven instalado. Em seguida execute o seguinte código:   
```bash
   mvn clean install
   ```
   
3. **Iniciar o Servidor de Desenvolvimento:**

   ```bash
   mvn spring-boot:run
   ```

   O aplicativo estará disponível em http://localhost:8080/. Certifique-se de que a porta 8080 esteja disponível, ou ajuste conforme necessário no arquivo de configuração do Spring Boot (application.properties).

## Contribuição

Contribuições são bem-vindas! Se você deseja participar do desenvolvimento do PharmaSystem, sinta-se à vontade para criar pull requests ou abrir issues relacionadas a recursos, melhorias ou correções de bugs.

## Tecnologias Utilizadas

- Java SpringBoot;
- PostgreSQL;
- Lombok;
- ModelMapper;
- Validation.

## Desenvolvedor

O PharmaSystem é desenvolvido e mantido por Antonio Carlos Pereira Neto, comprometido com a qualidade e a utilidade do sistema.

---

Com o PharmaSystem, a gestão das farmácias do grupo do cliente se torna uma tarefa simplificada e eficiente. Seja no cadastro de farmácias ou na administração de medicamentos e estoques, o sistema oferece as ferramentas necessárias para otimizar os processos farmacêuticos.