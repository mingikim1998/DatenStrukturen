package G23;

import java.util.Arrays;
import java.util.Comparator;

public class Node {

    char symbol;
    Node leftChild;
    Node rightChild;
    float probability;

    public Node(float probability, char symbol, Node leftChild, Node rightChild) {
        this.probability = probability;
        this.symbol = symbol;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(float probability, char symbol) {
        this.probability = probability;
        this.symbol = symbol;
    }

    public boolean is_leaf() {
        return this.leftChild == null;
    }

    public static Comparator<Node> comparator(char [] alphabet) {
        return (n1, n2) -> {
            if (n1 == null || n2 == null) throw new NullPointerException();

            if (n1.probability < n2.probability) return -1;
            else if (n1.probability > n2.probability) return 1;

            String lexicon = Arrays.toString(alphabet);
            return Integer.compare(lexicon.indexOf(n1.symbol), lexicon.indexOf(n2.symbol));
        };
    }
}









