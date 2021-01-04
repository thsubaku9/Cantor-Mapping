package CantorMapping;

/**
 * This interface exists only for enabling comparator fn passing as argument into sorting fn
 */

public interface ComparatorInterface<T>{
    int compare(T a, T b);        
    }