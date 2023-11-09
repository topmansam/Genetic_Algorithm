import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;
 // 0.08
  //0.40
public class ga {
  public static void main (String args[]) throws FileNotFoundException, IOException{
    // Read in the data file
    String text= ReadFile.readFile();

    System.out.println(Parameters.CHROMOSOME_SIZE);
    System.out.println("ORIGINAL TEXT: " + text);

     
     System.out.println("Chromosome size is set to: " + Parameters.CHROMOSOME_SIZE);
     System.out.println("Population size is set to: " + Parameters.POPULATION_SIZE);
      //Initialize a random population
    Population pop = new Population(true);
    // Initialize a chrosome to keep track off the global best chromosome seen so far.
    Chromosome globalBestChromosome = new Chromosome(false);
   globalBestChromosome.fitness = Double.MAX_VALUE;

        for(int i = 0; i < Parameters.GENERATION; i++){
            //Create a new population with initlally 0 chromosomes
          Population newPop = new Population(false);
            //Evalualte fitness of each chromosome
            for(Chromosome chromosome: pop.chromosomes){
              chromosome.fitness = Evaluation.fitness(String.valueOf(chromosome.genes), text); 
            }
    
          System.out.println();
          
          Helper.sortByFitness(pop);
          Chromosome bestFittest = pop.chromosomes[0];
          //Print out best chromosome in current generation
          //  System.out.println("Best chromosome fitness in this generation: " +
          //  Evaluation.fitness(String.valueOf(bestFittest.genes) , text) + " " + " The average is : " + Elitsm.average(pop));

           // Keep track of global best fitness found
           if(bestFittest.fitness < globalBestChromosome.fitness){
            globalBestChromosome = bestFittest;
  
           }
          //Using Elitsm get K fittest chromosomes that are gurranted a spot in new generation
          newPop.addToPopulation(pop.chromosomes[0]);
          newPop.addToPopulation(pop.chromosomes[1]);
          newPop.addToPopulation(pop.chromosomes[2]);

            // We will repeat tournament selection, crossover and mutation untill new popluation is full
            while(!newPop.isFull()){
              
          // Apply tournament selection to get our 2 parents
           
          //Ensure they are 2 different chromosomes
             Chromosome parent1 = Selection.tourmanentSelection(pop);
            Chromosome parent2;
            do{
            parent2 = Selection.tourmanentSelection(pop);
            } while(parent1.equals(parent2));
            
            Random rand = new Random();
            double valueCrossover = rand.nextDouble();
            double valueMutation = rand.nextDouble();
            //System.out.println("Crossover rate: " + valueCrossover + " " + "Value rate : " + valueMutation);
            Chromosome[] offspring1 = {new Chromosome(false), new Chromosome(false)};
            Chromosome[] offspring2 = {new Chromosome(false), new Chromosome(false)};
            
              

            // if value is less than our rate, we will perform Crossover
            if(valueCrossover < Parameters.CROSSOVER_RATE){
          
              // Apply 2  crossover techniques. Each technique returns 2 children.
         offspring1 = Crossover.Uniform(parent1, parent2);
         offspring2 = Crossover.Uniform(parent1, parent2);
            } else{
              offspring1[0].genes=parent1.genes;
              offspring1[1].genes=parent2.genes;
              offspring2[0].genes=parent1.genes;
              offspring2[1].genes=parent2.genes;
                
            }

             // if value is less than our rate, we will perform Mutation
            if(valueMutation < Parameters.MUTATION_RATE){
         //Apply mutation
              offspring1[0]=Mutator.Reciprocal_Exchange(offspring1[0]);
              offspring1[1]=Mutator.Reciprocal_Exchange(offspring1[1]);
              offspring2[0]=Mutator.Reciprocal_Exchange(offspring2[0]);
              offspring2[1]=Mutator.Reciprocal_Exchange(offspring2[1]);
            } else{
              offspring1[0].genes=parent1.genes;
              offspring1[1].genes=parent2.genes;
              offspring2[0].genes=parent1.genes;
              offspring2[1].genes=parent2.genes;
            }
            
               // Add offspring to population
         if(!newPop.isFull())  newPop.addToPopulation(offspring1[0]);
         if(!newPop.isFull())  newPop.addToPopulation(offspring1[1]);
         if(!newPop.isFull())  newPop.addToPopulation(offspring2[0]);
         if(!newPop.isFull())  newPop.addToPopulation(offspring2[1]);
           
         
 }
 //set population to new popluation
 pop = newPop;
 //pop.showPopulation();
}
pop.showPopulation();
//  Elitsm.sortByFitness(pop);
 
   System.out.println("FINAL SCORE: " + Evaluation.fitness(String.valueOf(globalBestChromosome.genes), text));
   System.out.println("Decryped text: " + Evaluation.decrypt(String.valueOf(globalBestChromosome.genes), text));

  }
}
