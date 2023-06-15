# Cellular Automata


<p align="center">Criado para atender o projeto de Estrutura de Dados do Curso de Análise e Desenvolvimento de Sistemas - (IFSP) Instituto Federal de Educação, Ciência e Tecnologia de São Paulo (2º semestre).</p>
<p align="center">O projeto tem como objetivo aplicar os conhecimentos obtidos em Estrutura de Dados e Orientação a Objetos, utilizando a linguagem de programação Java.
<p align="center">O projeto consiste na criação de um automato celular (cellular automata), modelo computacional composto por um conjunto de células interconectadas (matriz multidimensional). Cada célula pode estar em diferentes estados(I- Infectado, S-Suscetível, R-Recuperado), e as células evoluem ao longo do tempo de acordo com regras predefinidas. Essas regras determinam como o estado de uma célula é atualizado assim como sua taxa de infecção com base nos estados das células vizinhas.


Tabela de conteúdos
=================
<!--ts-->
* [Sobre](#Sobre)

[//]: # (* [Tabela de Conteudo]&#40;#tabela-de-conteudo&#41;)
[//]: # (* [Instalação]&#40;#instalacao&#41;)

[//]: # (* [Como usar]&#40;#como-usar&#41;)

[//]: # (    * [Pre Requisitos]&#40;#pre-requisitos&#41;)

[//]: # (    * [Local files]&#40;#local-files&#41;)

[//]: # (    * [Manual do Usuario]&#40;#user-manual&#41;)

[//]: # (    * [Multiple files]&#40;#multiple-files&#41;)

[//]: # (    * [Combo]&#40;#combo&#41;)
* [Tests](#testes)
* [Requisitos](#requisitos)
* [Tecnologias](#-tecnologias)
* [Status](#status-do-projeto)
* [Features](#features)
* [Autores](#autores)
<!--te-->

### Sobre


Estruturas de Dados utilizadas: Matrizes; Vetores;\
BigO: O(n²)

### User Manual
Manual do Usuário - Regras para Taxa de Infecção


Estados possíveis:
* S - Suscetível (Não Infectado, suscetível a infecções)
* I - Infectada (Infectado pelo vírus, podendo infectar seus vizinhos/células adjacentes)
* C - Curada (Célula já infectada anteriormente e que foi curada)

### Requisitos
Para auxílio no levantamento de requisitos assim como entendimento do contexto em questão, foram utilizadas algumas fontes, incluindo alguns papers de artigos/pesquisas voltadas ao assunto.
* [The impact of imported cases on the persistence of contagious diseases - Science Direct](https://www.sciencedirect.com/science/article/abs/pii/S1476945X19300972?via%3Dihub)
* [Diagrama de Classe Cellular Automata (Prof. Gustavo Fortunato Puga)](img.png)
* [Cellular Automata - The Nature of Code](https://natureofcode.com/book/chapter-7-cellular-automata/)


### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Java](https://www.java.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Maven]()
- [xChart](https://knowm.org/open-source/xchart/)
- [jFree Chart](https://www.jfree.org/jfreechart/)


### Status do Projeto

<h4 align="center"> 
	🦠  Cellular Automata - Finalizado ✅  🦠
</h4>

### Features

- [x] Elicitação de Requisitos
- [x] Criação Taxa de Infecção
- [x] Criação de Gerações
- [x] Projetar gráfico


### Autores
* [Sergio Gabriel](https://www.linkedin.com/in/sergio-gabriel-234583223/)
* [Ana Julia]()
* [Lucas Melo](https://www.linkedin.com/in/lucas-melo-gs/)
* [Lucas Albertini]()
* [Klaus Barbosa](https://www.linkedin.com/in/klaus-barbosa-707b8a185/)

