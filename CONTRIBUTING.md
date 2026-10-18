# Guia de Contribuição

Este guia define como o grupo desenvolve o trabalho prático de Práticas de Programação Orientada a Objetos (PPOO, UFLA). O objetivo é manter o código organizado, a branch `main` sempre funcional e garantir que todos os requisitos do enunciado sejam atendidos.

**Prazo de entrega:** 29/11/2026, até 23h50, pelo Campus Virtual.

---

## Ambiente de desenvolvimento

- JDK 8 ou superior
- IDE de preferência (BlueJ, VS Code, IntelliJ ou Eclipse)

Clonar o repositório:

```bash
git clone https://github.com/AlencarAvelar/pratico-ppoo.git
cd pratico-ppoo
```

Compilar e executar pelo terminal:

```bash
javac -d out $(find . -name "*.java")
java -cp out Principal
```

Arquivos gerados (`.class`, `.ctxt`, `out/`) não devem ser versionados. Se a sua IDE criar diretórios próprios (`.idea/`, `.vscode/`, `bin/`), adicione-os ao `.gitignore`.

---

## Fluxo de trabalho com Git

### Branch principal

A `main` contém a versão oficial do trabalho e deve sempre compilar e executar. Não são feitos pushes diretos nela: toda alteração entra por Pull Request.

### Passo a passo

1. Crie ou escolha uma issue no GitHub e atribua-se a ela antes de começar.
2. Atualize a `main` local e crie uma branch a partir dela:
   ```bash
   git checkout main
   git pull
   git checkout -b feat/chave-mestra
   ```
3. Desenvolva com commits pequenos e frequentes, cada um com uma alteração coerente.
4. Antes de abrir o PR, incorpore as últimas alterações da `main` e resolva os conflitos localmente:
   ```bash
   git fetch origin
   git merge origin/main
   ```
5. Envie a branch e abra o Pull Request:
   ```bash
   git push -u origin feat/chave-mestra
   ```

### Nomenclatura de branches

Use letras minúsculas, palavras separadas por hífen e um dos prefixos abaixo:

| Prefixo     | Uso                                       | Exemplo                               |
|-------------|-------------------------------------------|---------------------------------------|
| `feat/`     | Nova funcionalidade                       | `feat/carga-explosiva`                |
| `fix/`      | Correção de bug                           | `fix/contagem-tentativas`             |
| `refactor/` | Melhoria de design sem mudar comportamento | `refactor/encapsular-saidas-ambiente` |
| `gui/`      | Alterações na interface gráfica           | `gui/painel-dicas`                    |
| `docs/`     | Javadoc, README, diagrama UML             | `docs/diagrama-uml`                   |

### Mensagens de commit

Formato: `tipo: descrição`, em português e no imperativo.

```
feat: sorteia durabilidade da chave mestra entre 1 e 10
fix: corrige contagem de tentativas ao usar a chave mestra
refactor: move lógica de saídas para a classe Ambiente
docs: adiciona Javadoc na classe Mapa
```

---

## Pull Requests

Todo PR deve ser revisado e aprovado por todos os integrantes do grupo antes do merge. Assim, todos acompanham a evolução do código e entendem o trabalho como um todo, e não apenas as partes que implementaram.

**Autor do PR**
- Usa um título no mesmo padrão dos commits.
- Descreve o que foi alterado, o motivo e como testar.
- Referencia a issue correspondente (`Closes #12`).
- Mantém o PR pequeno e focado em uma única tarefa.

**Revisor**
- Baixa a branch, compila e testa a funcionalidade.
- Verifica se os requisitos do enunciado foram respeitados (ver seção seguinte).
- Faz comentários objetivos e sugere alternativas quando apontar um problema.

Após a aprovação, o merge é feito com **Squash and merge** e a branch é removida.

---

## Requisitos do enunciado

Os itens abaixo fazem parte da avaliação. PRs que os violem não devem ser aprovados.

### Restrições

**Não usar inferência de tipo (`var`):**

```java
// Incorreto
var ambientes = new ArrayList<Ambiente>();

// Correto
ArrayList<Ambiente> ambientes = new ArrayList<Ambiente>();
```

**Não usar expressões lambda nem method references (`->`, `::`).** Em listeners da GUI, use classes anônimas ou internas:

```java
// Incorreto
botao.addActionListener(e -> processarComando());

// Correto
botao.addActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        processarComando();
    }
});
```

Isso inclui operações de stream que dependem de lambdas (`filter`, `map`, `forEach`). Use laços `for`.

### Itens obrigatórios

- Herança, polimorfismo e composição/agregação aplicados onde fizerem sentido no modelo
- Tratamento de exceções, em especial na leitura de arquivos
- Arquivo texto de gabarito com a posição do tesouro, das dicas e da chave mestra
- Arquivo texto com o mapa (paredes e letreiros) e os dados dos ambientes, sem valores fixos no código
- Jogo executado exclusivamente pela GUI
- Javadoc em todas as classes e métodos públicos
- Diagrama de classes UML em `.pdf`

---

## Padrões de código Java

### Estilo

O projeto segue o estilo do código base fornecido:

- Identificadores e comentários em português
- Chaves de abertura na linha seguinte à declaração
- Indentação de 4 espaços, sem tabulação

```java
public boolean tentarAbrirPorta(String direcao)
{
    if (direcao == null)
    {
        return false;
    }
    // ...
}
```

### Nomenclatura

| Elemento   | Convenção                   | Exemplo                                  |
|------------|-----------------------------|------------------------------------------|
| Classe     | `PascalCase`, substantivo   | `ChaveMestra`, `CargaExplosiva`          |
| Método     | `camelCase`, verbo          | `usarChave()`, `sortearEstadoPortas()`   |
| Booleano   | forma de pergunta           | `estaEmperrada()`, `temTesouro()`        |
| Variável   | `camelCase`, nome descritivo | `tentativasRestantes`                   |
| Constante  | `MAIUSCULAS_COM_UNDERLINE`  | `MAX_TENTATIVAS`                         |

Evite nomes genéricos ou abreviados como `aux`, `temp`, `x` ou `obj`.

### Design de classes

Parte do trabalho consiste em corrigir as falhas de design do código base. Toda alteração deve seguir estes princípios:

- **Encapsulamento:** atributos sempre `private`. Exponha getters apenas quando necessário e evite setters que permitam alterar livremente o estado do objeto.
- **Coesão:** cada classe tem uma responsabilidade bem definida, e cada método executa uma única tarefa.
- **Baixo acoplamento:** uma classe não deve depender da estrutura interna de outra. Por exemplo, `Jogo` não precisa saber como `Ambiente` armazena suas saídas.
- **Design dirigido por responsabilidade:** o comportamento fica na classe que detém os dados.
- **Sem duplicação:** trechos repetidos devem ser extraídos para métodos.
- **Sem números mágicos:** valores fixos devem ser constantes nomeadas (`if (tentativas > MAX_TENTATIVAS)`).

### Tratamento de exceções

- Não deixe blocos `catch` vazios. Trate o erro ou informe o usuário com uma mensagem clara.
- Capture a exceção mais específica possível (`FileNotFoundException`, `IOException`) em vez de `Exception`.
- Garanta o fechamento de arquivos e recursos com `finally` ou try-with-resources.

### Antes de abrir o PR

- Remova `System.out.println` usados para depuração.
- Remova código comentado; o histórico do Git preserva versões anteriores.
- Remova imports não utilizados.
- Confirme que o projeto compila do zero.

---

## Documentação (Javadoc)

Toda classe e todo método público devem ter Javadoc. Métodos privados com lógica não trivial também devem ser comentados. Inclua o autor nas classes que criar.

```java
/**
 * Chave mestra que o jogador pode encontrar na casa.
 * Abre qualquer porta, inclusive emperrada, enquanto tiver durabilidade.
 *
 * @author Nome do Integrante
 * @version 1.0
 */
public class ChaveMestra extends Item
{
    /**
     * Usa a chave para abrir uma porta, reduzindo sua durabilidade em uma unidade.
     *
     * @return true se a chave ainda tinha durabilidade; false caso contrário
     */
    public boolean usar()
    {
        // ...
    }
}
```

Comentários devem explicar o motivo de uma decisão, não descrever o que o código já deixa evidente.

Para gerar a documentação:

```bash
javadoc -d doc -encoding UTF-8 -charset UTF-8 $(find . -name "*.java")
```

---

Dúvidas ou sugestões de mudança neste guia devem ser registradas como issue.
