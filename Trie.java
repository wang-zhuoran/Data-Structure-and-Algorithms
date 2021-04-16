import java.util.*;

public class Trie {
    private TrieNode root = new TrieNode();

    static class TrieNode {
        TrieNode preNode = null;
        boolean isEnd = false;
        int deep = 0;//做hash使用，防止一个单词里面有多个char的时候hash是一样的，可能导致删除出错
        char content = 0;
        LinkedList<TrieNode> child = new LinkedList<>();


        TrieNode() {
        }

        TrieNode(char content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "\n" + "{" +
                    "End=" + isEnd +
                    ", d=" + deep +
                    ", c=" + content +
                    ", c=" + child +
                    '}';
        }

        @Override
        public int hashCode() {
            return content + deep;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof TrieNode && (((TrieNode) obj).content == content);
        }

        void setPreNode(TrieNode node) {
            preNode = node;
        }

        TrieNode getPreNode() {
            return preNode;
        }

        /**
         * child中删掉某个Node
         *
         * @param node 需要删掉的node
         */
        void removeChild(TrieNode node) {
            for (TrieNode aChild : child) {
                if (aChild.content == node.content) {
                    child.remove(aChild);
                    break;
                }
            }
        }

        /**
         * child中是否有此Node
         *
         * @param character 保存的char
         * @return 存在返回不存在返回Null
         */
        TrieNode getNode(Character character) {
            for (TrieNode aChild : child) {
                if (aChild.content == character) {
                    return aChild;
                }
            }
            return null;
        }
    }

    /**
     * 添加一个word
     * apple
     *
     * @param word 需要添加的词
     */
    public void addWord(String word) {
        int deep = 0;
        TrieNode currNode = root;
        while (deep < word.length()) {
            /*
             * 判断当前node的child，如果为空直接添加，不为空，查找是否含有，不含有则添加并设为currNode，含有则找到并设置为currNode
             */
            char c = word.charAt(deep);
            if (currNode.child.contains(new TrieNode(c))) {
                currNode = currNode.getNode(c);
            } else {
                TrieNode node = new TrieNode(c);
                node.setPreNode(currNode);
                node.deep = deep + 1;
                currNode.child.add(node);
                currNode = node;
            }
            if (deep == word.length() - 1) {
                currNode.isEnd = true;
            }
            deep++;
        }
    }

    /**
     * word在map中是否存在
     *
     * @param word 需要查找的word
     * @return 是否存在
     */
    public boolean hasWord(String word) {
        int deep = 0;
        TrieNode currNode = root;
        while (deep < word.length()) {
            char c = word.charAt(deep);
            if (currNode.child.contains(new TrieNode(c))) {
                currNode = currNode.getNode(c);
            } else {
                return false;
            }
            if (deep == word.length() - 1) {
                return currNode.isEnd;
            }
            deep++;
        }
        return false;
    }


    /**
     * 移除word，几种情况：
     * 1、word在list中不存在，直接返回失败
     * 2、word最后一个char 没有child，则删掉此节点并朝 root 查找没有child && isEnd=false 的节点都删掉
     * 3、word最后一个char 有child，则把isEnd置为false
     *
     * @param word 需要移除的word
     * @return 是否移除成功
     */
    public boolean removeWord(String word) {
        if (word == null || word.trim().equals("")) {
            return false;
        }
        if (hasWord(word)) {
            return false;
        }
        int deep = 0;
        TrieNode currNode = root;
        while (deep < word.length()) {
            char c = word.charAt(deep);
            if (currNode.child.contains(new TrieNode(c))) {
                currNode = currNode.getNode(c);
            } else {
                return false;
            }
            if (deep == word.length() - 1) {
                if (currNode.child.size() > 0) {
                    //3、word最后一个char 有child，则把isEnd置为false
                    currNode.isEnd = false;
                    return true;
                } else {
                    //2、word最后一个char 没有child，则删掉此节点并朝 root 查找没有child && isEnd=false 的节点都删掉
                    TrieNode parent = currNode.getPreNode();
                    while (parent != null) {
                        if (parent.child.size() == 0 && !parent.isEnd) {
                            parent.removeChild(currNode);
                            currNode = parent;
                        } else {
                            return true;
                        }
                    }
                }
            }
            deep++;
        }

        return false;
    }

    public int getLevels(TrieNode node) {
        int lev = 0;
        if(node != null) {
            TrieNode current = node;
            for(TrieNode child : node.child) {
                lev = Math.max(lev, 1 + getLevels(child));
            }
        }
        return lev;
    }

    public static void main(String[] args)
    {
        Trie trie = new Trie();
        //Step 1
        trie.addWord("to");
        trie.addWord("tea");
        trie.addWord("ted");
        trie.addWord("test");
        trie.addWord("a");
        trie.addWord("abstract");
        trie.addWord("in");
        trie.addWord("inn");
        trie.addWord("indoor");
        trie.addWord("zoo");

        //Step 2
        if (trie.hasWord("the"))
        {
            System.out.println("Output: the");
        }else {
            System.out.println("Output: false");
        }

        //Step 3
        trie.removeWord("ted");
        boolean is_removed = trie.hasWord("ted");
        if (is_removed)
        {
            System.out.println("Output: success");
        }else
        {
            System.out.println("Output: false");
        }

        //Step 4
        System.out.println(trie.getLevels(trie.root));

        //Step 5
        trie.addWord("in the end");

        //Step 7
        boolean has_word = trie.hasWord("end");
        if (has_word)
        {
            System.out.println("Output: end");
        }else
        {
            System.out.println("Output: false");
        }


        //Step 8
        trie.removeWord("in");
        is_removed = trie.hasWord("in");
        if (is_removed)
        {
            System.out.println("Output: success");
        }else {
            System.out.println("Output: false");
        }

        //Step 9
        System.out.println();

        //Step 10
        trie.addWord("i love data structure and java.");

        //Step 11
        System.out.println(trie.getLevels(trie.root));


    }


}
