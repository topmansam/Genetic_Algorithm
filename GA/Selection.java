// This class receives a population and performs tourmanent selection on the population

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Selection{
    // K must be less than pop size
    public static Chromosome tourmanentSelection(Population pop){
        Queue<Chromosome> pq = new PriorityQueue<>((a,b) -> Double.compare(a.fitness, b.fitness));
        Random rand = new Random();
        //Select K random chromosomes. Use a max heap to keep it sorted in asending order.
        for(int i = 0; i < Parameters.K; i++ ){
           
        // K random chrosomosomes from the population
         int j = rand.nextInt(Parameters.POPULATION_SIZE);
         Chromosome c = pop.chromosomes[j];
         pq.add(c);
       }
       // return fittest chromosome
       return pq.remove();
    }
}