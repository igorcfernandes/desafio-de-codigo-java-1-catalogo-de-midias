# Sistema de Gerenciamento de Catálogo de Mídia em Java

## Descrição do Projeto

Este projeto consiste em um **Sistema de Gerenciamento de Catálogo de Mídia** desenvolvido em Java.  
O objetivo é criar uma aplicação que permita gerenciar diferentes tipos de mídias (como filmes, músicas e episódios) dentro de um catálogo unificado, utilizando conceitos avançados de **Programação Orientada a Objetos (POO)**, **interfaces**, **singleton**, **observer**, e técnicas de validação de dados.

O sistema permite:
- Adicionar mídias ao catálogo;
- Listar todas as mídias cadastradas;
- Recuperar uma mídia específica a partir do seu identificador único;
- Notificar componentes observadores quando uma nova mídia é adicionada.

<br>

## Recursos e Conceitos Utilizados

Durante o desenvolvimento do projeto, foram aplicados os seguintes conceitos e padrões de programação:

1. **Programação Orientada a Objetos (POO)**
   - Uso de classes abstratas (`Media`) e herança (`Movie`, `Song`);
   - Encapsulamento de atributos e métodos;
   - Sobrescrita de métodos (`displayDetails()`).

2. **Interface**
   - Criação da interface `CatalogObserver` para implementação do padrão Observer;
   - Observadores (`LoggingObserver`, `ApiCallObserver`) implementam a interface para receber notificações de mudanças no catálogo.

3. **Singleton**
   - A classe `MediaCatalog` é implementada como **singleton**, garantindo que apenas uma instância do catálogo exista durante a execução do programa.

4. **Observer**
   - O catálogo atua como **subject**, gerenciando observadores;
   - Observadores são notificados automaticamente sempre que uma nova mídia é adicionada.

5. **Exceções personalizadas**
   - `DuplicateMediaIdException` para tratar tentativas de adicionar mídias com IDs duplicados;
   - `MediaNotFoundException` para tratar pesquisas de mídias inexistentes no catálogo.

6. **Coleções Java**
   - Uso de `Map` para armazenar mídias garantindo IDs únicos;
   - Uso de `List` para gerenciar observadores e listar mídias.

7. **Sobrecarga de métodos**
   - A classe `MediaCatalog` permite adicionar mídias tanto diretamente como via parâmetros simples (`String`, `int`) usando métodos sobrecarregados.

<br>

## Passo a Passo do Desafio

### Parte 1 – Criação e gerenciamento do catálogo

1. Criar a classe base `Media` com os atributos:
   - `mediaId` (identificador único)
   - `title` (título)
   - `durationInSeconds` (duração em segundos)
2. Adicionar um método abstrato `displayDetails()` para exibir detalhes da mídia.
3. Criar pelo menos duas classes derivadas, por exemplo:
   - `Movie` (com atributos adicionais: `genre`, `year`, `director`);
   - `Song` (com atributos adicionais: `artist`, `album`);
4. Implementar o método `displayDetails()` nas classes derivadas.
5. Criar a classe `MediaCatalog`:
   - Deve ser **singleton** (uma única instância);
   - Métodos principais:
     - `addMedia(Media media)` – adiciona uma mídia ao catálogo;
     - `addMedia(String type, String mediaId, String title, int durationInSeconds)` – método sobrecarregado;
     - `listMedia()` – retorna todas as mídias;
     - `getMedia(String mediaId)` – busca uma mídia pelo ID;
   - Garantir que IDs duplicados não sejam aceitos.
6. Adicionar 2 ou 3 itens de cada tipo utilizando diferentes métodos.
7. Tentar adicionar uma mídia com ID duplicado para testar exceção.
8. Listar todas as mídias e exibir seus detalhes.
9. Recuperar e exibir uma mídia específica pelo seu ID.

### Parte 2 – Implementação do padrão Observer

1. Criar a interface `CatalogObserver` com método `onMediaAdd(Media media)`.
2. Modificar `MediaCatalog` para gerenciar observadores:
   - Registrar observadores (`registerObserver()`);
   - Notificar todos os observadores ao adicionar uma nova mídia (`notifyObservers()`).
3. Criar pelo menos dois observadores:
   - `LoggingObserver` – registra logs no console;
   - `ApiCallObserver` – simula envio de dados para um sistema externo.
4. Registrar os observadores antes de adicionar mídias no `Main`.
