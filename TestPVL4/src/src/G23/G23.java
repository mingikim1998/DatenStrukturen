package G23;

import PVL.PVL4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class G23 implements PVL4 {

    Tree tree;
    HashMap<Character, String> map = new HashMap<>();

    @Override
    public void set_alphabet(char[] alphabet, float[] probabilities) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < alphabet.length; ++i) nodes.add(new Node(probabilities[i], alphabet[i]));
        nodes.sort(Node.comparator(alphabet));

        while (nodes.size()> 1) {
            Node c1 = nodes.remove(0);
            Node c2 = nodes.remove(0);
            float p = c1.probability + c2.probability;
            Node c12 = new Node(p, c1.symbol, c1, c2);
            int i = 0;
            while (i < nodes.size() && 0 < Node.comparator(alphabet).compare(c12, nodes.get(i))) ++i;
            nodes.add(i, c12);
        }
        this.tree = new Tree(nodes.get(0));
        generateMap();
    }

    @Override
    public List<List<String>> get_codes() {
        if (this.tree == null) return null;
        List<List<String>> lst = new ArrayList<>();
        get_codes(this.tree.root, lst, "");
        return lst;
    }

    public void get_codes(Node node, List<List<String>> lst, String code) {
        if (node.is_leaf()) lst.add(new ArrayList<>(List.of(new String[]{String.valueOf(node.symbol), code})));
        else {
            get_codes(node.leftChild, lst,  code + "1");
            get_codes(node.rightChild, lst, code + "0");
        }
    }

    @Override
    public String encode(String plain_text) {
        StringBuilder out = new StringBuilder();
        for (char c: plain_text.toCharArray()) {
            out.append(map.get(c));
        }
        return out.toString();
    }

    @Override
    public String decode(String huffman_text) {
        Node node = this.tree.root;
        StringBuilder out = new StringBuilder();
        for (char c:huffman_text.toCharArray()) {
            if (c == '0') node = node.rightChild;
            else node = node.leftChild;

            if (node.is_leaf()) {
                out.append(node.symbol);
                node = this.tree.root;
            }
        }
        return out.toString();
    }

    private void generateMap(){
        if (this.tree.root != null) generateMap(this.tree.root, "");
    }

    private void generateMap(Node node, String code) {
        if (node.is_leaf()) this.map.put(node.symbol, code);
        else {
            generateMap(node.leftChild, code + "1");
            generateMap(node.rightChild,code + "0");
        }
    }

}
