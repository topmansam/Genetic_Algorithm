import java.util.Random;

public class Crossover {
    //Return  the offspring of the 2 parents
   
    public static Chromosome [] Uniform(Chromosome parent1, Chromosome parent2){
        Random rand = new Random();
        // Array holding the 2 offspring we will return
         Chromosome offspring [] = new Chromosome[2];
        offspring[0] = new Chromosome(false);
        offspring[1] = new Chromosome(false);
          Chromosome chromosome1 = offspring[0];
        Chromosome chromosome2 = offspring[1];
         
         //Generate a random binary mask
         int mask [] = new int[parent1.genes.length];
         for(int i = 0; i < mask.length; i++){
            mask[i] = rand.nextInt(2);
         }
         // copy genes corresponding to 1 in the mask from p1 to offspring 1
         for(int i = 0; i < parent1.genes.length; i++){
            if(mask[i]==1)chromosome1.genes[i]=parent1.genes[i];   
            else chromosome1.genes[i]=parent2.genes[i];   
            
         }
          // copy genes corresponding to 1 in the mask from p2 to offspring 2
         for(int i = 0; i < parent2.genes.length; i++){
            if(mask[i]==1)  chromosome2.genes[i]=parent2.genes[i];
            else chromosome2.genes[i]=parent1.genes[i];   
         }
           return offspring;

    }
    //Return  the offspring of the 2 parents
    public static Chromosome [] onePoint(Chromosome parent1, Chromosome parent2){
        Random rand = new Random();
          // Array holding the 2 offspring we will return
         Chromosome offspring [] = new Chromosome[2];
        offspring[0] = new Chromosome(false);
        offspring[1] = new Chromosome(false);
          Chromosome chromosome1 = offspring[0];
        Chromosome chromosome2 = offspring[1];
        int crossover_point = rand.nextInt(parent1.genes.length);

        // Copy the genes from parent 1 before crossover point
         for(int i = 0; i < crossover_point; i++){
            chromosome1.genes[i]=parent1.genes[i];    
        }
        // Copy the genes from parent 2 before crossover point
        for(int i = 0; i < crossover_point; i++){
            chromosome2.genes[i]=parent2.genes[i];   
        }
         //Take genes from parent 2 beoynd crossover point
        for(int i = crossover_point; i < parent1.genes.length; i++){
            chromosome1.genes[i]=parent2.genes[i];   
        }
        //Take genes from parent 1 beoynd crossover point
        for(int i = crossover_point; i < parent2.genes.length; i++){
            chromosome2.genes[i]=parent1.genes[i];   
        }
       
           return offspring;
 
    }
}
