
package org.example;

import java.util.*;

public class Escalonador {
    double chanceBlock = 0.10;
    int quantum = 1000;
    Random r = new Random();

    void executarRoundRobin(Queue<Processo> processos) throws InterruptedException {

        System.out.println("Iniciando Escalonamento por Round Robin.");

        while (!processos.isEmpty()) {

            Processo processo = processos.poll();


            if (processo.getEstado() == Estado.PRONTO) {

                processo.setEstado(Estado.EXECUTANDO);
                processos.add(processo);

            }
            else if (processo.getEstado() == Estado.EXECUTANDO) {


                System.out.printf("Executando PID %d (Prioridade: %d). Tempo restante: %d\n",
                        processo.getPid(),
                        processo.getPrioridade(),
                        processo.getTempoExecucao());

                double block = r.nextDouble();


                if (block < chanceBlock) {
                    processo.setEstado(Estado.BLOQUEADO);
                    processos.add(processo);
                    System.out.printf("PID %d Bloqueado (I/O) e movido para a fila.\n", processo.getPid());

                } else {
                    if (processo.getTempoExecucao() > 0) {
                        Thread.sleep(quantum);

                        processo.setTempoExecucao(processo.getTempoExecucao() - (quantum/1000));


                        if (!processos.isEmpty() || processo.getTempoExecucao() >= 0) {

                            processo.setEstado(Estado.PRONTO);
                            processos.add(processo);

                        }

                    } else {

                        processo.setEstado(Estado.TERMINADO);

                        System.out.printf("PID %d terminou (Estado: TERMINADO).\n", processo.getPid());

                    }

                }

            }

            else if (processo.getEstado() == Estado.BLOQUEADO) {

                double block = r.nextDouble();
                double chanceBlock = 0.73;

                Thread.sleep(1000);

                if (block < chanceBlock){
                    processo.setEstado(Estado.PRONTO);
                }

                processos.add(processo);
            }

            else if (processo.getEstado() == Estado.TERMINADO) {
                System.out.printf("PID %d terminou (Estado: TERMINADO).\n", processo.getPid());
            }

        }
        System.out.println("Escalonamento por ROUNDROBIN concluído.");

    }


    void executarPrioridade(Queue<Processo> processos) throws InterruptedException {


        PriorityQueue<Processo> filaPrioridade = new PriorityQueue<>(processos);//tds

        while(!filaPrioridade.isEmpty()){

            Queue<Processo> processoAux = new LinkedList<>();
            Processo processo = filaPrioridade.poll();
            processoAux.add(processo);

            while( (filaPrioridade.peek()!= null) && (processo.getPrioridade() == filaPrioridade.peek().getPrioridade()) ){

                System.out.printf(" AAA Executando PID %d (Prioridade: %d). Tempo restante: %d\n",
                        filaPrioridade.peek().getPid(),
                        filaPrioridade.peek().getPrioridade(),
                        filaPrioridade.peek().getTempoExecucao());

                processoAux.add(filaPrioridade.poll());

            }

            executarRoundRobin(processoAux);

        }


    }


}

