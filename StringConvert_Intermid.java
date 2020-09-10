package FastSort;


class StringConvert_Intermid {

    String[] toSort;
    static float x = 30;
    static float toMult = 100;

    private void declare(){

        String[] sortLater = {"bac","abc","bach","azzzzzzzzzz","z","classic","basketcase"};

    }

    public double InvertedHashing(String s) {

        int toSub = (int)'a' - 1;
        double result = 0.0d;
        double temp;
        double toInternalMult = 1;
        for(char z: s.toCharArray())
        {
            temp = ((int)z - toSub)*toInternalMult*toMult;
            toInternalMult/= x;
            result+=temp;
        }
        return result;
    }

    public static void main(String args[]){

        StringConvert_Intermid myCon = new StringConvert_Intermid();

        System.out.println(myCon.InvertedHashing("azzzzzzzzzz"));
        System.out.println(myCon.InvertedHashing("z"));
        System.out.println(myCon.InvertedHashing("basketcase"));
    }
}
