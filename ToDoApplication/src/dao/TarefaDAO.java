/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.SubtipoTarefa;
import model.Tarefa;
import model.TipoTarefa;

/**
 *
 * @author Felipe Zschornack
 */
public class TarefaDAO {
     
    public static void create(Tarefa tarefa){
        
        ConnectorSingleton.connect();
        ConnectorSingleton.update("INSERT INTO tarefa (descricao, data_prevista_inicio,"
                + "data_real_inicio,data_prevista_fim, data_real_fim, duracao_total_prevista,"
                + "duracao_total_real, duracao_maxima_execucao_dia, tarefa_urgente,"
                + "tarefa_importante, arquivo_to_do_application_idarquivo_to_do_application,"
                + "tipo)"
                + " VALUES ('" 
                + tarefa.getDescricao()+ "', "
                + new java.sql.Date(tarefa.getDataPrevistaInicio().getTime()) + ","
                + new java.sql.Date(tarefa.getDataRealInicio().getTime()) + ","
                + new java.sql.Date(tarefa.getDataPrevistaFim().getTime()) + ","
                + new java.sql.Date(tarefa.getDataRealFim().getTime()) + ","
                + tarefa.getDuracaoTotalPrevista() + ","
                + tarefa.getDuracaoTotalReal() + ","
                + tarefa.getDuracaoMaximaExecucaoDia() + ","
                + tarefa.isTarefaUrgente() + ","
                + tarefa.isTarefaImportante() + ","
                + tarefa.getArquivoToDoApplication().getIdArquivoToDoApplication() + ",'"
                + tarefa.getTipo().getNome() + "'); " );   
                
        ConnectorSingleton.close();    
    }
    
    public static Tarefa read(long idTarefa){
        Tarefa tarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM tarefa WHERE idtarefa ="
                + idTarefa + ";");
        try{
            if(resultSet.next())
            {
                tarefa = new Tarefa();
                tarefa.setIdTarefa(idTarefa);
                tarefa.setNomeTarefa(resultSet.getString("nome_tarefa"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setStatus(resultSet.getInt("status"));
                tarefa.setInicioTarefa(resultSet.getDate("data_inicio"));
                tarefa.setFimTarefa(resultSet.getDate("data_termino"));
                tarefa.setResponsavel(resultSet.getLong("idresponsavel"));
                
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return tarefa;
    }
    
    public static void update(Tarefa tarefa){
        ConnectorSingleton.connect();
        ConnectorSingleton.update("UPDATE tarefa SET nome_tarefa = '" 
                + tarefa.getNomeTarefa() + "',descricao='"
                + tarefa.getDescricao() + "', status =" 
                + tarefa.getStatus() + ", idresponsavel='" 
                + tarefa.getResponsavel() +"', data_inicio = '" 
                + new java.sql.Date(tarefa.getInicioTarefa().getTime()) + "', data_termino = '" 
                + new java.sql.Date(tarefa.getFimTarefa().getTime()) + "' WHERE idtarefa = " 
                + tarefa.getIdTarefa()+";"); 
             
        ConnectorSingleton.close();
    
    } 
    
    public static void delete(long idTarefa)
    {
        ConnectorSingleton.connect();
        ConnectorSingleton.update("DELETE FROM tarefa WHERE idtarefa =" +
                idTarefa + ";");
        ConnectorSingleton.close();
    }
    
    public static ArrayList<Tarefa> getAll(){
        ArrayList<Tarefa> lista = new ArrayList<Tarefa>();
        Tarefa tarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM tarefa;");
        try{
            while(resultSet.next())
            {
                tarefa = new Tarefa();
                tarefa.setNomeTarefa(resultSet.getString("nome_tarefa"));
                tarefa.setIdTarefa(resultSet.getLong("idtarefa"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setStatus(resultSet.getInt("status"));
                tarefa.setInicioTarefa(resultSet.getDate("data_inicio"));
                tarefa.setFimTarefa(resultSet.getDate("data_termino"));
                tarefa.setResponsavel(resultSet.getLong("idresponsavel"));
                lista.add(tarefa);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return lista;
    }
    
}
