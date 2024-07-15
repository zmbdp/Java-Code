package ha.xi.biao;
import java.util.Arrays;

public class HashBuck<K, V> {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashBuck<?, ?> hashBuck = (HashBuck<?, ?>) o;
        return hashSize == hashBuck.hashSize && Arrays.equals(array, hashBuck.array);
    }

    static class Node<K, V> {
        private K key;
        private V value;
        Node<K, V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public Node<K, V>[] array;
    public int hashSize;

    /**
     * 初始化哈希桶
     */
    public HashBuck() {
        this.array = (Node<K, V>[]) new Node[8];
    }

    /**
     * 计算负载因子
     * @return 返回负载因子的大小
     */
    private double maxPow() {
        return ((this.hashSize * 1.0) / array.length);
    }

    /**
     * 在哈希表中插入
     * @param key 需要插入的对象
     * @param value 插入对象所对应的value
     * @return 返回666，表示插入成功，如果存在 key，返回所对应的 value
     */
    public V put(K key, V value) {
        Node<K, V> node = (Node<K, V>) new Node(key, value);
        // 先找到下标
        int pow = ((key.hashCode()) % array.length);
        // 先判断一下有没有相同的
        if (pow < 0) {
            pow *= -1;
        }
        Node cur = array[pow];
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return value;
            }
            cur = cur.next;
        }
        // 说明第一个不是空，直接头插
        node.next = array[pow];
        array[pow] = node;
        this.hashSize++;
        // 计算负载因子，如果大于 0.75 就要重新哈希
        if (maxPow() >= 0.75) {
            resize();
        }
        return null;
    }

    /**
     * 重新哈希原来数组到新的数组里去
     */
    private void resize() {
        Node<K, V>[] tmpArr = (Node<K, V>[]) new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node<K, V> cur = array[i];
            while (cur != null) {
                // 说明垓下标是个链表
                // 先要拿到 cur.next 以防等会儿丢了
                Node<K, V> curNext = cur.next;
                int pow = ((cur.key.hashCode()) % tmpArr.length);
                if (pow < 0) {
                    pow *= -1;
                }
                cur.next = tmpArr[pow];
                tmpArr[pow] = cur;
                cur = curNext;
            }
            // 出来之后说明链表走到头了，就不用管了，继续走
        }
        // 最后在让arr = tmp
        array = tmpArr;
    }

    /**
     * 找 key 的值，返回它的 value，没找到返回负的随机值；
     * @param key
     * @return
     */
    public V getValue(K key) {
        int pow = ((key.hashCode()) % array.length);
        if (pow < 0) {
            pow *= -1;
        }
        Node<K, V> cur = array[pow];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 找 key，找到返回对应的 value，找不到返回自己输入的 value
     * @param key 需要寻找的量
     * @param value 找不到返回的量
     * @return 返回 int 类型
     */
    public V getValue(K key, V value) {
        int pow = ((key.hashCode()) % array.length);
        if (pow < 0) {
            pow *= -1;
        }
        Node<K, V> cur = array[pow];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return value;
    }
}
