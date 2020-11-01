package CantorMapping;

class Sorting {

    public static int[] init_index(int[] values){
        int[] res = new int[values.length];
        for (int a = 0; a<values.length; a++){
            res[a] = a;
        }
        return  res;
    }
            
    static public int[] mergeSort(int[] arr, int[] values)
    {        
        if(arr.length >1)
        {            
            int midPt = (int)(arr.length/2);
            int[] left = new int[midPt];
            int[] right = new int[arr.length - midPt];

            for (int a = 0; a<midPt; a++){
                left[a] = arr[a];
            }

            for (int a = 0; a<arr.length - midPt; a++){
                right[a] = arr[midPt +a];
            }

            int[] resL =mergeSort(left,values);
            int[] resR = mergeSort(right,values);

            int[] res = new int[resL.length + resR.length];
            
            int l_loc=0,r_loc=0,current_loc=0;

            while((r_loc<resR.length) && (l_loc<resL.length)) {
                if(values[resL[l_loc]]<=values[resR[r_loc]]) {
                    res[current_loc] = resL[l_loc];
                    l_loc++;
                } else {
                    res[current_loc] = resR[r_loc];
                    r_loc++;
                }
                current_loc++;
            }

            while (r_loc<resR.length){   
                res[current_loc] = resR[r_loc];
                current_loc++; r_loc++;
            }


            while (l_loc<resL.length){   
                res[current_loc] = resL[l_loc];
                current_loc++; l_loc++;
            }

            return res;
        }

        else
        {
            return arr;
        }
    }

    
    public static void main(String args[]){

        int[] values = {10,-9,8,2,-11,23,14};

        int[] indexedArray = init_index(values);
        int[] orderedArray = mergeSort(indexedArray,values);

        for(int i=0;i<orderedArray.length;i++)
        {
            System.out.print(values[orderedArray[i]]+"\t");
        }
    }
    
}
