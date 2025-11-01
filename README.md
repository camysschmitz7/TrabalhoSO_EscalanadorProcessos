Implementação de um Escalonador de Processos com Threads em Java 

 

O objetivo deste trabalho é fornecer aos alunos a oportunidade de aprofundar seus conhecimentos em sistemas operacionais, especialmente na área de escalonamento de processos. Os alunos devem implementar um escalonador de processos simples usando threads em Java, aplicando conceitos de escalonamento de processos e sincronização de threads. 
Você deve criar um programa em Java que simula o escalonamento de processos em um sistema operacional de forma concorrente usando threads. O programa deve ser capaz de criar e escalonar processos simulados, aplicando um dos seguintes algoritmos de escalonamento: Round Robin, Prioridade ou Múltiplas Filas.  
Os principais componentes do trabalho incluem: 

 
1.     Criação de Processos Simulados: crie uma classe que represente um processo simulado. Cada processo deve conter informações como identificador (ID), prioridade, tempo de execução, estado (pronto, em execução, suspenso, etc.) e outras informações relevantes estudadas em sala. 


2.     Escalonador de Processos: implemente um escalonador de processos que seja responsável por gerenciar a execução dos processos simulados. O escalonador deve ter disponível pelo menos dois algoritmos de escalonamento (por exemplo, Round Robin, Prioridade ou Múltiplas Filas) para decidir qual processo deve ser executado em um determinado momento. 

3.     Sincronização de Threads: Como o escalonamento de processos é uma operação concorrente, garanta que as threads que representam os processos simulados sejam sincronizadas de forma adequada para evitar problemas como condições de corrida e deadlocks. 

4.     Interface Gráfica: crie uma interface gráfica simples para visualizar o escalonamento de processos em tempo real. O grupo deve definir e implementar uma rotina de avaliação automática do escalonador. A análise deve: 

Gerar cargas de trabalho reprodutíveis (seed): 
Coletar métricas (mínimo obrigatório): throughput, tempo médio de espera, tempo médio de retorno (turnaround), tempo de resposta, número de trocas de contexto, utilização da CPU. 
Gerar gráficos (podem ser embutidos no relatório ou salvos como PNG): linha/boxplot por métrica vs. cenário; histograma de tempos; timeline/Gantt por execução. A definição da análise é parte do critério de avaliação 
