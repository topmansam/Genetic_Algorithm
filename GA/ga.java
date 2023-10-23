import java.util.PriorityQueue;

public class ga {
  public static void main (String args[]){
    String test1= "xbwdesmhihslwhkktefvktkktcwfpiibihwmosfilojvooegvefwnochsuuspsureifakbnlalzsrsroiejwzgfpjczldokrceoahzshpbdwpcjstacgbarfwifwohylckafckzwwomlalghrtafchfetcgfpfrgxclwzocdctmjebx";
    double testScore = Evaluation.fitness(String.valueOf("p-a-s-s-w-o-r-d") , test1);    
    String result = Evaluation.encrypt( "password","i believe that at the end of the century the use of words and general educated opinion will have altered so much that one will be able to speak of machines thinking without expecting to be contradicted alan turing");
     

        for(int i = 0; i < Parameters.GENERATION; i++){
          Population pop = new Population();
            //Evalualte fitness of each chromosome
            for(Chromosome chromosome: pop.chromosomes){
              chromosome.fitness = Evaluation.fitness(String.valueOf(chromosome.getGenes()), test1); 
            }
         
          pop.showPopulation();
          System.out.println();

          //Apply Tournament selection. Select 2 parents for crossover
          Chromosome parent1 = Selection.tourmanentSelection(pop);
          Chromosome parent2 = Selection.tourmanentSelection(pop);
    
          // Apply crossover

          //Apply mutation
 }
}
}
