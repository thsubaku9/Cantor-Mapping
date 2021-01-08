package test;

import java.util.ArrayList;
import java.lang.Math;

/**
 * This class contains the generating methods for performing finesse tests
 */
class TesterMethods {
    private void generate_lexi_internal(int size,int min_size,int max_size,ArrayList<String> all_strings,String current_gen){
        if(all_strings.size() > size || current_gen.length() > max_size) return;        
        else if (current_gen.length() >= min_size){
            all_strings.add(current_gen);
        }
        for(int i=(int)'a' ;i<=(int)'z';i++){
            generate_lexi_internal(size,min_size,max_size,all_strings,current_gen + (char)i );
        }

    }

    /**
     * Returns an Object[]. Please type cast to String type. This is a depth first function not a breath first one
     * 
     * @param size The total number of strings to be generated
     * @param min_size The minimum size of each string
     * @param max_size The maximum size of each string
     * @return Object[]
     */
    public Object[] generate_lexi(int size, int min_size, int max_size){
        ArrayList<String> all_strings = new ArrayList<>();        
        generate_lexi_internal(size,min_size,max_size,all_strings,"");
        return all_strings.toArray();
    }

    /**
     * 
     * @param index_size - the size of the array
     * @return int[] - the randomized index based array
     */
    public int[] createRandomizedIndexArray(int index_size){
        int[] randomizedIndex = new int[index_size];
        for (int i=index_size -1;i >=0; i-- ){
            randomizedIndex[i] = i;
        }
        for (int i=index_size -1;i >=0; i-- ){
            double f = Math.random()/Math.nextDown(1.0);            
            int j = (int)((i)*f);            
            int k = randomizedIndex[i];randomizedIndex[i] = randomizedIndex[j]; randomizedIndex[j] = k;
        }
        return randomizedIndex;
    }
} 