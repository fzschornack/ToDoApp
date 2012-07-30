/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import model.SubtipoTarefa;
import model.Tarefa;
import model.TipoTarefa;
import model.TiposDeTarefaComposite;

/**
 *
 * @author Felipe Zschornack
 */
public class TarefaDAO {
     
    public static void create(Tarefa tarefa){
        System.out.println(tarefa.toString());
        ConnectorSingleton.connect();
        ConnectorSingleton.update("INSERT INTO tarefa (descricao, data_prevista_inicio,"
                + "data_real_inicio,data_prevista_fim, data_real_fim, duracao_total_prevista,"
                + "duracao_total_real, duracao_maxima_execucao_dia,"
                + "tipo,"
                + "dia_iddia, prioridade)"
                + " VALUES ('" 
                + tarefa.getDescricao()+ "', '"
                + tarefa.getDataPrevistaInicio() + "','"
                + tarefa.getDataRealInicio() + "','"
                + tarefa.getDataPrevistaFim() + "','"
                + tarefa.getDataRealFim() + "',"
                + tarefa.getDuracaoTotalPrevista() + ","
                + tarefa.getDuracaoTotalReal() + ","
                + tarefa.getDuracaoMaximaExecucaoDia() + ",'"
                + tarefa.getTipo().getNome() + "',"
                + tarefa.getDia().getIdDia() + ","
                + tarefa.getPrioridade()+"); " );   
                
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
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setDataPrevistaInicio(resultSet.getDate("data_prevista_inicio"));
                tarefa.setDataPrevistaFim(resultSet.getDate("data_prevista_fim"));
                tarefa.setDataRealInicio(resultSet.getDate("data_real_inicio"));
                tarefa.setDataRealFim(resultSet.getDate("data_real_fim"));
                tarefa.setDuracaoTotalPrevista(resultSet.getInt("duracao_total_prevista"));
                tarefa.setDuracaoTotalReal(resultSet.getInt("duracao_total_real"));
                tarefa.setDuracaoMaximaExecucaoDia(resultSet.getInt("duracao_maxima_execucao_dia"));
                tarefa.setPrioridade(resultSet.getInt("prioridade"));
                tarefa.setDia(DiaDAO.read(resultSet.getLong("dia_iddia")));
                String tipo = resultSet.getString("tipo");
                for(TipoTarefa t: TipoTarefaDAO.getAll()) {
                    if(t.getNome().toString().equals(tipo))
                        tarefa.setTipo(t);
                }
                for(SubtipoTarefa s: SubtipoTarefaDAO.getAll()) {
                    if(s.getNome().toString().equals(tipo))
                        tarefa.setTipo(s);
                }
                
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return tarefa;
    }
    
    public static Tarefa read(String descricao){
        Tarefa tarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM tarefa WHERE descricao LIKE '%"
                + descricao + "%';");
        try{
            if(resultSet.next())
            {
                tarefa = new Tarefa();
                tarefa.setIdTarefa(resultSet.getLong("idtarefa"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setDataPrevistaInicio(resultSet.getDate("data_prevista_inicio"));
                tarefa.setDataPrevistaFim(resultSet.getDate("data_prevista_fim"));
                tarefa.setDataRealInicio(resultSet.getDate("data_real_inicio"));
                tarefa.setDataRealFim(resultSet.getDate("data_real_fim"));
                tarefa.setDuracaoTotalPrevista(resultSet.getInt("duracao_total_prevista"));
                tarefa.setDuracaoTotalReal(resultSet.getInt("duracao_total_real"));
                tarefa.setDuracaoMaximaExecucaoDia(resultSet.getInt("duracao_maxima_execucao_dia"));
                tarefa.setPrioridade(resultSet.getInt("prioridade"));
                tarefa.setDia(DiaDAO.read(resultSet.getLong("dia_iddia")));
                String tipo = resultSet.getString("tipo");
                for(TipoTarefa t: TipoTarefaDAO.getAll()) {
                    if(t.getNome().toString().equals(tipo))
                        tarefa.setTipo(t);
                }
                for(SubtipoTarefa s: SubtipoTarefaDAO.getAll()) {
                    if(s.getNome().toString().equals(tipo))
                        tarefa.setTipo(s);
                }
                
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
        ConnectorSingleton.update("UPDATE tarefa SET descricao='"
                + tarefa.getDescricao() + "', data_prevista_inicio =" 
                + tarefa.getDataPrevistaInicio() + ", data_prevista_fim =" 
                + tarefa.getDataPrevistaFim() + ", data_real_inicio =" 
                + tarefa.getDataRealInicio() + ", data_real_fim =" 
                + tarefa.getDataRealFim() + ", duracao_total_prevista =" 
                + tarefa.getDuracaoTotalPrevista() + ", duracao_total_real =" 
                + tarefa.getDuracaoTotalReal() + ", duracao_maxima_execucao_dia =" 
                + tarefa.getDuracaoMaximaExecucaoDia() + ", dia_iddia =" 
                + tarefa.getDia().getIdDia() + ", tipo = '" 
                + tarefa.getTipo().getNome() +"', prioridade = " 
                + tarefa.getPrioridade() + ";"); 
             
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
                tarefa.setIdTarefa(resultSet.getLong("idtarefa"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setDataPrevistaInicio(resultSet.getDate("data_prevista_inicio"));
                tarefa.setDataPrevistaFim(resultSet.getDate("data_prevista_fim"));
                tarefa.setDataRealInicio(resultSet.getDate("data_real_inicio"));
                tarefa.setDataRealFim(resultSet.getDate("data_real_fim"));
                tarefa.setDuracaoTotalPrevista(resultSet.getInt("duracao_total_prevista"));
                tarefa.setDuracaoTotalReal(resultSet.getInt("duracao_total_real"));
                tarefa.setDuracaoMaximaExecucaoDia(resultSet.getInt("duracao_maxima_execucao_dia"));
                tarefa.setPrioridade(resultSet.getInt("prioridade"));
                tarefa.setDia(DiaDAO.read(resultSet.getLong("dia_iddia")));
                String tipo = resultSet.getString("tipo");
                for(TipoTarefa t: TipoTarefaDAO.getAll()) {
                    if(t.getNome().toString().equals(tipo))
                        tarefa.setTipo(t);
                }
                for(SubtipoTarefa s: SubtipoTarefaDAO.getAll()) {
                    if(s.getNome().toString().equals(tipo))
                        tarefa.setTipo(s);
                }
                lista.add(tarefa);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return lista;
    }
    
    //FIFO por padrão
    public static ArrayList<Tarefa> getAllIdDia(long idDia){
        ArrayList<Tarefa> lista = new ArrayList<Tarefa>();
        Tarefa tarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM tarefa WHERE dia_iddia = "+
                idDia+" ;"); //implementar orderby FIFO
        try{
            while(resultSet.next())
            {
                tarefa = new Tarefa();
                tarefa.setIdTarefa(resultSet.getLong("idtarefa"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setDataPrevistaInicio(resultSet.getDate("data_prevista_inicio"));
                tarefa.setDataPrevistaFim(resultSet.getDate("data_prevista_fim"));
                tarefa.setDataRealInicio(resultSet.getDate("data_real_inicio"));
                tarefa.setDataRealFim(resultSet.getDate("data_real_fim"));
                tarefa.setDuracaoTotalPrevista(resultSet.getInt("duracao_total_prevista"));
                tarefa.setDuracaoTotalReal(resultSet.getInt("duracao_total_real"));
                tarefa.setDuracaoMaximaExecucaoDia(resultSet.getInt("duracao_maxima_execucao_dia"));
                tarefa.setPrioridade(resultSet.getInt("prioridade"));
                tarefa.setDia(DiaDAO.read(resultSet.getLong("dia_iddia")));
                String tipo = resultSet.getString("tipo");
                for(TipoTarefa t: TipoTarefaDAO.getAll()) {
                    if(t.getNome().toString().equals(tipo))
                        tarefa.setTipo(t);
                }
                for(SubtipoTarefa s: SubtipoTarefaDAO.getAll()) {
                    if(s.getNome().toString().equals(tipo))
                        tarefa.setTipo(s);
                }
                lista.add(tarefa);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ConnectorSingleton.close();
        return lista;
    }
    
    public static ArrayList<Tarefa> getAllIdDiaSjf(long idDia){
        ArrayList<Tarefa> lista = new ArrayList<Tarefa>();
        Tarefa tarefa = null;
        ConnectorSingleton.connect();
        ResultSet resultSet = ConnectorSingleton.query("SELECT * FROM tarefa WHERE dia_iddia = "+
                idDia+" ;");//implementar SJF
        try{
            while(resultSet.next())
            {
                tarefa = new Tarefa();
                tarefa.setIdTarefa(resultSet.getLong("idtarefa"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setDataPrevistaInicio(resultSet.getDate("data_prevista_inicio"));
                tarefa.setDataPrevistaFim(resultSet.getDate("data_prevista_fim"));
                tarefa.setDataRealInicio(resultSet.getDate("data_real_inicio"));
                tarefa.setDataRealFim(resultSet.getDate("data_real_fim"));
                tarefa.setDuracaoTotalPrevista(resultSet.getInt("duracao_total_prevista"));
                tarefa.setDuracaoTotalReal(resultSet.getInt("duracao_total_real"));
                tarefa.setDuracaoMaximaExecucaoDia(resultSet.getInt("duracao_maxima_execucao_dia"));
                tarefa.setPrioridade(resultSet.getInt("prioridade"));
                tarefa.setDia(DiaDAO.read(resultSet.getLong("dia_iddia")));
                String tipo = resultSet.getString("tipo");
                for(TipoTarefa t: TipoTarefaDAO.getAll()) {
                    if(t.getNome().toString().equals(tipo))
                        tarefa.setTipo(t);
                }
                for(SubtipoTarefa s: SubtipoTarefaDAO.getAll()) {
                    if(s.getNome().toString().equals(tipo))
                        tarefa.setTipo(s);
                }
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
