package FastSort;

import java.util.ArrayList;

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

    private void generate_lexi_internal(int size,int min_size,int max_size,ArrayList<String> all_strings,String current_gen){

        if(all_strings.size() > size) return;
        if (current_gen.length() > max_size) return;
        if (current_gen.length() >= min_size){
            all_strings.add(current_gen);
        }
        for(int i=(int)'a' ;i<=(int)'z';i++){
            generate_lexi_internal(size,min_size,max_size,all_strings,current_gen+ (char)i );
        }

    }

    public String[] generate_lexi(int size, int min_size, int max_size){
        ArrayList<String> all_strings = new ArrayList<>();
        generate_lexi_internal(size,min_size,max_size,all_strings,"");

        return (String[])all_strings.toArray();
    }

    public static void main(String args[]){

        StringConvert_Intermid myCon = new StringConvert_Intermid();

        myCon.declare();
    }
}