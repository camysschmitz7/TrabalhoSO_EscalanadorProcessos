package org.example;

public class Processo implements Comparable<Processo> {

    private int pid;
    private int prioridade;
    private int tempoExecucao;
    private Estado estado;

    public Processo(int pid, int prioridade, int tempoExecucao, Estado estado) {
        this.pid = pid;
        this.prioridade = prioridade;
        this.tempoExecucao = tempoExecucao;
        this.estado = estado;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int compareTo(Processo outro) {
        // Se a prioridade for igual, o desempate na PriorityQueue será FIFO/FCFS por
        // ordem de inserção (comportamento padrão do Java para elementos com compareTo == 0),
        // o que simula o Round-Robin.
        return Integer.compare(outro.prioridade,this.prioridade);
    }

}
