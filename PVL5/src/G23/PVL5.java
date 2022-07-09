package NamensPlatzhalter;

import Interface.IPVL5;

import java.util.*;

public class PVL5 implements IPVL5 {
    private final List<Integer> set;

    public PVL5(){
        this.set = new ArrayList<>();
    }

    private boolean isInSet(Integer e, IPVL5 sampleSet) {               //determines if sampleSet contains Element e
        for (Integer e2 : sampleSet) if (e.equals(e2)) return true;
        return false;
    }

    @Override
    public String toString() {
        //returns sorted version of Set for easier readability
        ArrayList<Integer> copy = new ArrayList<>(List.copyOf(set));
        copy.sort(Integer::compareTo);
        return copy.toString();
    }

    @Override
    public void insert(int element) {
        if (!this.isInSet(element, this)) this.set.add(element);
    }

    @Override
    public void union(IPVL5 sampleSet) {
        for (Integer e: sampleSet) this.insert(e);
    }

    @Override
    public void cut(IPVL5 sampleSet) {
        for (Integer e : this) if (!this.isInSet(e, sampleSet)) this.set.remove(e);
    }

    @Override
    public void relativeComplementWith(IPVL5 sampleSet) {
        for (Integer e : this) if (this.isInSet(e, sampleSet)) this.set.remove(e);
    }

    @Override
    public boolean isSubsetOf(IPVL5 sampleSet) {
        for (Integer e : this) if (!this.isInSet(e, sampleSet)) return false;         //is set is a part of sampleSet?
        for (Integer e : sampleSet) if (!this.isInSet(e, this)) return true; //is sampleSet bigger than set?
        return false;
    }



    @Override
    public Iterator<Integer> iterator() {
        //iterates through ArrayList starting from the end to allow removing elements while iterating
        return new Iterator<>() {
            private int indexFromEnd = 0;
            final int size = set.size();

            @Override
            public boolean hasNext() {
                return indexFromEnd < size;
            }

            @Override
            public Integer next() {
                return set.get(size - (++indexFromEnd));
            }
        };
    }
}






