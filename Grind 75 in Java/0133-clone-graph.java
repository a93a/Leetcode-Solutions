class Solution {
    HashMap<Node, Node> clones = new HashMap<Node, Node>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node old) {
        if (old == null) return old;
        
        if (clones.containsKey(old))
            return clones.get(old);

        var newNode = new Node(old.val);
        clones.put(old, newNode);

        for (Node nei : old.neighbors) {
            var newNei = dfs(nei);
            newNode.neighbors.add(newNei);
        }

        return newNode;
    }
}
