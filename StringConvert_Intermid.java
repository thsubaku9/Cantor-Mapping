package FastSort;


class StringConvert_Intermid {
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

    public String[] generate_lexi(int size, int min_size, int max_size){
        String all_strings[] = new String[size];


        return all_strings;
    }

    public static void main(String args[]){

        StringConvert_Intermid myCon = new StringConvert_Intermid();

        myCon.declare();
    }
}
