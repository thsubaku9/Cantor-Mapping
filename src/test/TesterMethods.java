package test;

import java.util.ArrayList;

class TesterMethods {
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
} 