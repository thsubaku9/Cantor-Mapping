package CantorMapping;

public class radixToMap {
    
    private int chunkSize;
    private MapConverter internalMC;
    radixToMap(int chunkSize){
        this.chunkSize = chunkSize;
        internalMC = new MapConverter();
    }

    public Double[][] createRadixArray(String[] words){
        int max_len = 0;
        for (int j = 0; j< words.length; j++){
            if(words[j].length() > max_len) max_len = words[j].length();
        }

        max_len =(int)( max_len%chunkSize == 0 ? max_len/chunkSize : max_len/chunkSize +1 );
        Double[][] returnArray = new Double[words.length][max_len];

        for (int j = 0; j< words.length; j++){
            for (int k=0;k <max_len; k++){
            returnArray[j][k] = 0.0d;
        }
    }
        for (int j = 0; j< words.length; j++){
            for(int k=0;k<chunkSize && k*chunkSize<words[j].length();k++){
                int startingpos = chunkSize * k;
                int endingpos = chunkSize * (k+1) - 1 < words[j].length()? chunkSize * (k+1) - 1 : words[j].length() -1;
                Double chunkValue = internalMC.CantorMap(words[j].substring(startingpos,endingpos+1));
                returnArray[j][k] = chunkValue;
            }
        }
        return returnArray;
    }
}
