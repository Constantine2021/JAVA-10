package by.bsu.lab10;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class SetSum {
    public Integer sumAll(Set<Integer> set){
        while(set.size() != 1){
            set = sumNeighbourElements(set);
            System.out.println(set);
        }
        return set.iterator().next();
    }

    public Set<Integer> sumNeighbourElements(Set<Integer> set){
        Iterator<Integer> iterator = set.iterator();
        Set<Integer> summedSet = new HashSet<>();

        while(iterator.hasNext()){
            Integer currentElement = iterator.next();
            if (iterator.hasNext()){
                summedSet.add(currentElement + iterator.next());
            }
            else{
                summedSet.add(currentElement);
            }
        }

        return summedSet;
    }
}
