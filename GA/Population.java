public class Population {
    //Genereate a population of size population size, of chromosomes of size chomosome size.
    Chromosome [] chromosomes;

     //Generate n amount of arrays of chromosomes. We will use this constructor for initial population.
    public Population(){
         chromosomes = new Chromosome[Parameters.POPULATION_SIZE];
       for(int i = 0; i < chromosomes.length; i++){
             chromosomes[i] = new Chromosome();      
         }
    }
    //Generate n amount of arrays of chromosomes. We will use this constructor for tournament selction.
    public Population(Chromosome [] selectedChromosomes){
        chromosomes = new Chromosome[selectedChromosomes.length];
       for(int i = 0; i <selectedChromosomes.length; i++){
             chromosomes[i] = selectedChromosomes[i];
         }
    }
    //Read in the file and determine the chrome size
    public void readFile(){}

    
    //Evaluate fitness of each chromosome in the population
    public int calculateFitness(){
        int fitness = 0;;
        return fitness;
    }
    // SHow all the chromosomes in the population
    public void showPopulation(){
        //System.out.println(population.length);
        //System.out.println(population[0].genes.length);
        for(int i = 0; i < chromosomes.length; i++){
             Chromosome chrome = chromosomes[i];
             System.out.println("Population " + i + " : ");
             for(int j = 0; j < chrome.genes.length; j++){
                System.out.print(chrome.genes[j] + " ");
             }
                System.out.println();
         }
    }
}
