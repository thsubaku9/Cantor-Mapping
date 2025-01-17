package CantorMapping;

public class Sorting {

    public int[] init_index(int size){
        int[] res = new int[size];
        for (int a = 0; a<size; a++){
            res[a] = a;
        }
        return  res;
    }    
    
    public <T> void printIndexToValues(int[] index, T[] values){

        for (Integer i: index){
            System.out.println(values[i.intValue()]);
        }   
    }

    public <T> int[] mergeSort(int[] index_arr, T[] values, ComparatorInterface<T> compare)
    {        
        if(index_arr.length >1){            
            int midPt = (int)(index_arr.length/2);
            int[] left = new int[midPt];
            int[] right = new int[index_arr.length - midPt];

            for (int a = 0; a<midPt; a++){
                left[a] = index_arr[a];
            }

            for (int a = 0; a<index_arr.length - midPt; a++){
                right[a] = index_arr[midPt +a];
            }

            int[] resL =mergeSort(left,values,compare);
            int[] resR = mergeSort(right,values,compare);

            int[] res = new int[resL.length + resR.length];
            
            int l_loc=0,r_loc=0,current_loc=0;

            while((r_loc<resR.length) && (l_loc<resL.length)) {
                if(compare.compare(values[resL[l_loc]], values[resR[r_loc]]) <= 0 ){
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
        } else {
            return index_arr;
        }
    }        
}
