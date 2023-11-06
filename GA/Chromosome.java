// This file is responsible for generating the chromosomes.

import java.util.Random;
// Generates an array of chromosomes each element being a gene (character) ranging from a-z
public class Chromosome{
    char [] genes = new  char[Parameters.CHROMOSOME_SIZE];
     
    // Use a random function to genrate  random chromosomes of length size with values a-z
    Random rand = new Random();
    //Store the chromosomes fitness value
    double fitness;

    // If we want to initalize the chromosome with random jenes set it to true, but sometimes we dont want this when we are doing crossover so i nthat case we will set to fasle
    public Chromosome(boolean init){
           //Typically to capture all the characters fro a - z we only need to loop from 0- 26 but we need to include '-'.
    // We can loop from 0 27 and if the character is a 26 assign a dash . 
        if(init){
        for(int i = 0; i < genes.length; i++){
            int k = rand.nextInt(27);
             genes[i] = k == 26 ? '-' : (char) (k + 'a');
        }
    }
}

    //Return the Chrosome array
    public void printGenes(){
   
        for(int i = 0; i < genes.length; i++){
            System.out.print(genes[i] + " ");
        }
    }
     
}