package CantorMapping;

class MapCoverter {
    static float x = 30;
    static float toMult = 100;

    private void declare(){

        String[] sortLater = {"bac","abc","bach","azzzzzzzzzz","azzzzzzzzzb","z","classic","basketcase","basket"};
        double[] cantor_hashed = new double[sortLater.length];

        for(int i=0;i<sortLater.length;i++){
            cantor_hashed[i] = CantorHashing(sortLater[i]);

            System.out.println("String: "+sortLater[i]+" = "+cantor_hashed[i]);
        }


    }

    public double CantorHashing(String s) {

        int toSub = (int)'a' - 1;
        double result = 0.0d;
        double temp;
        double toInternalMult = 1;
        for(char z: s.toCharArray())
        {
            temp = ((int)z - toSub)*toInternalMult;
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