import java.util.Random;

public class Mutator {
    //Reciprocal Exchange
    public static Chromosome Reciprocal_Exchange(Chromosome c){
        if(c==null) return c;
        //Swap 2 random cities
        Random rand = new Random();
        int p1 = rand.nextInt(c.genes.length);
        int p2 = rand.nextInt(c.genes.length);
        char temp = c.genes[p1];
        c.genes[p1]= c.genes[p2];
        c.genes[p2]=temp;
        return c;
    }
}
