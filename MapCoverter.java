package CantorMapping;

import java.util.ArrayList;

class MapCoverter {
    final float x = 30;
    final float mulFactor = 10;


    public ArrayList<Object> convertArray(ArrayList<Object> array){
        ArrayList<Object> retArr = new ArrayList<Object>(array.size());

        for(Object obj : array){
            retArr.add(CantorHashing(obj.toString()));
        }

        return retArr;
    }

    private void declare(){

        String[] sortLater = {"bac","abc","bach","azzzzzzzzzz","azzzzzzzzzb","z","classic","basketcase","basket"};
        double[] cantor_hashed = new double[sortLater.length];

        for(int i=0;i<sortLater.length;i++){
            cantor_hashed[i] = CantorHashing(sortLater[i]);

            System.out.println("String: "+sortLater[i]+" = "+cantor_hashed[i]);
        }


    }

    public double CantorHashing(String s) {

        int baseValue = (int)'a' - 1;
        double result = 0.0d;
        double temp;
        double toInternalMult = 1;
        for(char character: s.toCharArray())
        {
            temp = ((int)character - baseValue)*toInternalMult;
            toInternalMult/= x;
            result+=temp;
        }
        return result;
    }

    /*
        0.) Alternative for creation
        1.) Generate n-gram (sequenced by creation)
        2.) Create a function that maps n-gram space to a number (sequence sensitive)
        3.) Utilize number for comparision
     */
}