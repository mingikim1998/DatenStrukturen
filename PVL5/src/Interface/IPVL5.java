package Interface;
public interface IPVL5 extends Iterable<Integer>{
    void insert(int element);

    void union(IPVL5 sampleSet);

    void cut(IPVL5 sampleSet);

    void relativeComplementWith(IPVL5 sampleSet);

    boolean isSubsetOf(IPVL5 sampleSet);
}
