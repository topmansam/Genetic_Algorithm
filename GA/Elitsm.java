import java.util.PriorityQueue;
import java.util.Queue;
public class Elitsm {
     
    public static void sortByFitness(Population pop){
        Queue<Chromosome> pq = new PriorityQueue<>((a,b) -> Double.compare(a.fitness, b.fitness));
    for(int i = 0; i < pop.chromosomes.length; i++ ){
         Chromosome c = pop.chromosomes[i];
         if(c!=null)pq.add(c);
       }
       int index  = 0;
       while(!pq.isEmpty()){
        pop.chromosomes[index++] = pq.remove();
       }
    }
    public static double average(Population pop){
        double avg = 0.0;
        for(int i = 0; i < pop.chromosomes.length; i++){
            avg += pop.chromosomes[i].fitness;
        }
        return avg / pop.chromosomes.length;
    }
 
}
