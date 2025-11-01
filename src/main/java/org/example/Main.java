package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue<Processo> processos = new LinkedList<>();
        System.out.println("Hello world!");
        Processo p1= new Processo(4,15,10,Estado.PRONTO);
        Processo p2= new Processo(5,15,10,Estado.EXECUTANDO);
        Processo p3= new Processo(6,13,10,Estado.EXECUTANDO);
        Processo p4= new Processo(7,12,10,Estado.PRONTO);

        processos.add(p1);
        processos.add(p2);
        processos.add(p3);
        processos.add(p4);


        Escalonador escalonador = new Escalonador();
        
        escalonador.executarPrioridade(processos);
    }
}