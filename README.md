# acme-back

<div>
 <b>Inicialização do projeto</b>
  <p>Necessário criar o <strong>schema</strong> com o nome <b>acme</b>.<br>
</div>
<br>
<div>
  <b>Rotas</b>
  <p>
    <br>
    <b>POST:</b> http://localhost:8080/listas<br>
    <b>JSON:</b>
    	{
        "listaNome": "Lista 2",
        "tarefas": [
          {
            "dataCadastro": "28/12/2020",
            "dataAtualizacao": "28/12/2020",
            "concluido": true,
            "dataTarefa": "10/01/2021",
            "tarefa": "Tarefa 01"
          },
            {
             "dataCadastro": "28/12/2020",
             "dataAtualizacao": "28/12/2020",
             "concluido": true,
             "dataTarefa": "10/01/2021",
             "tarefa": "Tarefa 02"
          }
    	]
	  }
<br><br>
    <b>DELETE:</b> http://localhost:8080/listas/1<br><br>
    <b>PUT:</b> http://localhost:8080/listas/1<br>
    <b>JSON</b>
    {
      "id": 1,
      "tarefa": "Tarefa 01",
      "dataCadastro": "28/12/2020",
      "dataAtualizacao": "28/12/2020",
      "concluido": false,
      "dataTarefa": "10/01/2021"
    }<br><br>
    <b>GET</b>
    URL:http://localhost:8080/listas<br>
    URL:http:/localhost:8080/listas?listaNome=lista
   </p>
</div>

<br>
<div>
 <b>Bibliotecas e tecnologias</b>
  <p>
    Foram utilizadas as tecnologias: 
    <ul>
      <li>Java 8</li>
      <li>SpringBoot 2.2.6.RELEASE</li>
      <li>lombok 1.18.12</li>
      <li>Hibernate 5.4.12</li>
      <li>MySQL</li>
    </ul>
   </p>
</div>
<br>
<div>
<b>Arquitetura</b>
<p>
  Foi dividida em controller, dto, form, model, repository e service.<br>
  Sendo delegada cada responsabilidade para um pacote especifico. Por exemplo:
  O <b>service</b> cuidando da regra de negócio, o <b>contoller</b> consumindo o <b>service</b>.
  DTO sendo usado em vez de mandar a entidade, entre outras.
  </p>
</div>
