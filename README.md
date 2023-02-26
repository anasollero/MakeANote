# MakeANote

<hr>

## Endpoints

<h3 style="font-size: 18px"> Usuário </h3>

-   Conta
    -   [Cadastrar](#cadastrar-conta-de-usuário)
    -   [Excluir](#excluir-conta-de-usuário)
    -   [Alterar](#alterar-conta-de-usuário)
    -   [Detalhes](#detalhes-conta-de-usuário)
    -   [Listar todas](#listar-contas-de-usuário)

<h3 style="font-size: 18px"> Tarefas </h3>

-   Tarefa
    -   [Criar](#criar-tarefa)
    -   [Excluir](#excluir-tarefa)
    -   [Alterar](#alterar-tarefa)
    -   [Detalhes](#detalhes-tarefa)
    -   [Listar todas](#listar-tarefas)

<hr>

### Cadastrar Conta de Usuário

`POST` /makeanote/api/usuario/conta

_Campos da requisição_

| Campo | Tipo  | Obrigatório | Descrição                  |
| ----- | ----- | :---------: | -------------------------- |
| nome  | texto |     sim     | Nome do usuário            |
| email | texto |     sim     | Email da conta do usuáriuo |
| senha | texto |     sim     | Senha da conta do usuário  |

_Exemplo de requisição_

```js
{
    "nome": 'José',
    "email": 'jose@gmail.com',
    "senha": '12345'
}
```

_Resposta_

| Código do Status | Descrição                           |
| :--------------: | ----------------------------------- |
|       201        | Conta do usuário criada com sucesso |
|       400        | Conta de usuário inválida           |

<hr>

### Excluir Conta de Usuário

`DELETE` /makeanote/api/usuario/conta/{id}

_Resposta_

| Código do Status | Descrição                             |
| :--------------: | ------------------------------------- |
|       204        | Conta do usuário deletada com sucesso |
|       404        | Conta de usuário não encontrada       |

<hr>

### Alterar Conta de Usuário

`PUT` /makeanote/api/usuario/conta/{id}

_Campos de requisição_

| Campo | Tipo  | Obrigatório | Descrição                 |
| ----- | ----- | :---------: | ------------------------- |
| nome  | texto |     não     | Nome do usuário           |
| email | texto |     não     | Email da conta usuário    |
| senha | texto |     não     | Senha da conta do usuário |

_Exemplo de requisição_

```js
{
    "nome": 'José',
    "email": 'jose@gmail.com',
    "senha": '12345'
}
```

_Resposta_

| Código | Descrição                             |
| :----: | ------------------------------------- |
|  200   | Alteração realizada com sucesso       |
|  400   | Não foi possível concluir a alteração |
|  404   | Conta de usuário não encontrada       |

<hr>

### Detalhes Conta de Usuário

`GET` /makeanote/api/usuario/conta/{id}

_Exemplo de resposta_

```js
{
    "nome": 'José',
    "email": 'jose@gmail.com',
    "senha": '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'
    // Exemplo de retorno de resposta de senha criptografada em SHA-256
}
```

_Resposta_

| Código | Descrição                                         |
| :----: | ------------------------------------------------- |
|  200   | Dados da conta do usuário encontrados com sucesso |
|  404   | Dados da conta do usuário não encontrada          |

<hr>

### Listar Contas de Usuário

`GET` /makeanote/api/usuario/conta/

_Exemplo de resposta_

```
 [
	{
		nome: "José",
		email: "jose@gmail.com",
		senha: "5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5",
		// Exemplo de retorno de resposta de senha criptografada em SHA-256
	},
	{
		nome: "Pedro",
		email: "pedro@gmail.com",
		senha: "9f6cc74b4f511b99806da59b3caf5994471abb01112afcc",
	},
	{
		nome: "Marcos",
		email: "marcos@gmail.com",
		senha: "71abb01112afcc18159f6c1b99806da59b3caf5994471abb",
	},
]
```

_Resposta_

| Código | Descrição                                         |
| :----: | ------------------------------------------------- |
|  200   | Dados da conta do usuário encontrados com sucesso |
|  404   | Dados da conta do usuário não encontrada          |

<hr>

## Tarefas

### Criar Tarefa

`POST` /makeanote/api/usuario/tarefa

_Campos da requisição_

| Campo     | Tipo  | Obrigatório | Descrição           |
| --------- | ----- | :---------: | ------------------- |
| titulo    | texto |     sim     | Título da tarefa    |
| descricao | texto |     não     | Descrição da tarefa |
| data      | data  |     sim     | Data da tarefa      |

_Exemplo de requisição_

```js
{
    "titulo": 'Prova de Matematica',
    "descricao": 'Revisar polinômios, matrizes e gráficos',
    "data": '23-12-2023'
}
```

_Resposta_

| Código do Status | Descrição                 |
| :--------------: | ------------------------- |
|       201        | Tarefa criada com sucesso |
|       400        | Tarefa inválida           |

<hr>

### Excluir Tarefa

`DELETE` /makeanote/api/usuario/{id}/tarefa/{id}

_Resposta_

| Código do Status | Descrição                   |
| :--------------: | --------------------------- |
|       204        | Tarefa deletada com sucesso |
|       404        | Tarefa não encontrada       |

<hr>

### Alterar Tarefa

`PUT` /makeanote/api/usuario/{id}/tarefa/{id}

_Campos de requisição_

| Campo     | Tipo  | Obrigatório | Descrição           |
| --------- | ----- | :---------: | ------------------- |
| titulo    | texto |     não     | Título da tarefa    |
| descricao | texto |     não     | Descrição da tarefa |
| data      | data  |     não     | Data da tarefa      |

_Exemplo de requisição_

```js
{
    "titulo": 'Prova de Matematica',
    "descricao": 'Revisar polinômios, matrizes e gráficos',
    "data": '23-12-2023'
}
```

_Resposta_

| Código | Descrição                                       |
| :----: | ----------------------------------------------- |
|  200   | Alteração de tarefa realizada com sucesso       |
|  400   | Não foi possível concluir a alteração da tarefa |
|  404   | Tarefa não encontrada                           |

<hr>

### Detalhes Tarefa

`GET` /makeanote/api/usuario/{id}/tarefa/{id}

_Exemplo de resposta_

```js
{
    "titulo": 'Prova de Matematica',
    "descricao": 'Revisar polinômios, matrizes e gráficos',
    "data": '23-12-2023'
}
```

_Resposta_

| Código | Descrição                     |
| :----: | ----------------------------- |
|  200   | Tarefa encontrada com sucesso |
|  404   | Tarefa não encontrada         |

<hr>

### Listar Tarefas

`GET` /makeanote/api/usuario/{id}/tarefa/

_Exemplo de resposta_

```
[
	{
		titulo: "Prova de Matematica",
		descricao: "Revisar polinômios, matrizes e gráficos",
		data: "23-12-2023",
	},
	{
		titulo: "Prova de Portugûes",
		descricao: "Revisar acentuação, pronomes e verbos",
		data: "22-12-2023",
	},
	{
		titulo: "Prova de Biologia",
		descricao: "Revisar DNA, reprodução assexuada e reinos",
		data: "25-12-2023",
	},
]
```

_Resposta_

| Código | Descrição                       |
| :----: | ------------------------------- |
|  200   | Tarefas encontradas com sucesso |
|  404   | Nenhuma tarefa encontrada       |

<hr>
