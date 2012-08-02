package model;

/**
*
* @author Felipe Zschornack
* 
* Aqui é utilizado o padrão de projeto "Composite": 
* 	
* 	Ao criar uma tarefa, o usuario deve escolher o "tipo" da tarefa. Existem "tipos" e "subtipos" e eles
* sao apresentados ao usuario em uma estrutura de "arvore" para que o usuario escolha o "tipo" da tarefa. Porem, o usuario pode escolher
* tanto um "TipoTarefa" quanto um "SubtipoTarefa" para designar o "tipo" de sua tarefa. O padrao Composite resolve esse problema ao permitir, 
* atraves de uma superclasse, que tanto um objeto "TipoTarefa" quanto um objeto "SubtipoTarefa" sejam selecionados como o "tipo" da tarefa.   
* 
*/
public abstract class TiposDeTarefaComposite{
	
        String nome;
        
        public abstract String getNome();
        
        public abstract void setNome(String nome);
}
