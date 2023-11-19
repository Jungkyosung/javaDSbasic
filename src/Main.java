import practice.TreeMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        TreeMap<String, String> tree = new TreeMap<>();

        tree.put("루트","루트");
        tree.put("노드1", "노드1");
        tree.put("노드2", "노드2");
        tree.put("가","가");
        tree.put("나","나");
        tree.put("다","다");
        tree.put("ㄱ","ㄱ");
        tree.put("난","난");
        tree.put("ㄴ","ㄴ");
        tree.put("고드1","고드1");
        tree.remove("다");
        tree.getFirstEntry();
        tree.printAll();

    }
}