<html>
  <body>
    <h2>QueryEditor</h2>
    <h4>Editor de querys para aplicações java Desktop</h4>
    <p>
      Este é um editor de querys simples, para aplicações java Desktop, suporta todos os bancos de dados. utilizando conexões JDBC.
      Ideal para ambientes onde é necessário executar consultas direto da maquina do cliente. 
    </p>
    <h2>Features</h2>
    <li>
      <ul>Mapeamento do banco de dados (Tabelas e colunas)</ul>
      <ul>Histórico de querys com buscador</ul>
      <ul>Exportação para Excel</ul>
      <ul>Compatibilade com qualquer BD</ul>
      <ul>Multiplas Abas</ul>
      <ul>Leve</ul>
    </li>
    <h2>Visão Geral</h2>
    <img src="https://github.com/IsraelGomes05/QueryEditor/blob/master/QueryEditor/imgs/tela-principal.PNG">
    <h2>Como Usar</h2>
    <code> // Passando como paramentro O Frame que será associado, Se é modal ou não, conexão com BD, Local do arquivo com as querys (Histórico)
        QueryTelaPrincipal query = new QueryTelaPrincipal(this, true, ConnectionFactory.getConexao(), "C:/Users/Israel Gomes/Documents/teste.txt");</code>
   </body>
</html>
