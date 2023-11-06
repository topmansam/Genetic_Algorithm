public class Population {
    //Genereate a population of size population size, of chromosomes of size chomosome size.
    Chromosome [] chromosomes;
    int index = 0;
    
     //Generate n amount of arrays of chromosomes. We will use this constructor for initial population.
    public Population(boolean init){
         
         chromosomes = new Chromosome[Parameters.POPULATION_SIZE];
         //If set to true, initliaze pop with random chromosmes
         if(init){
       for(int i = 0; i < chromosomes.length; i++){
             chromosomes[i] = new Chromosome(true);      
         }
        }
    }
    //Generate n amount of arrays of chromosomes. We will use this constructor for tournament selction.
    public Population(Chromosome [] selectedChromosomes){
        chromosomes = new Chromosome[selectedChromosomes.length];
       for(int i = 0; i <selectedChromosomes.length; i++){
             chromosomes[i] = selectedChromosomes[i];
         }
    }

    public void addToPopulation(Chromosome c){
        chromosomes[index++]=c;   
    }
    public boolean isFull(){
        return index == chromosomes.length;

    }
    // Show all the chromosomes in the population
    public void showPopulation(){
       
        for(int i = 0; i < chromosomes.length; i++){
             Chromosome chrome = chromosomes[i];
             if(chrome==null){
                System.out.println("Popuylation " + i + " : null");
             } else{
             System.out.println("Chromosome " + i + " " + chrome.fitness + " : ");
             for(int j = 0; j < chrome.genes.length; j++){
                System.out.print(chrome.genes[j] + " ");
             }

            }
                System.out.println();
         }
    }
}
