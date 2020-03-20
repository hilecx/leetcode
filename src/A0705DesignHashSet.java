public class A0705DesignHashSet {

    class MyHashSet {
        boolean[] set = new boolean[100000];

        /** Initialize your data structure here. */
        public MyHashSet() {

        }

        private void extend(int size){
            boolean[] newset = new boolean[size];
            System.arraycopy(set,0,newset,0,set.length);
            set =newset;
        }

        public void add(int key) {
            if(key>set.length-1){
                extend(key+1);
            }
            set[key]=true;
        }

        public void remove(int key) {
            if(key<set.length){
                set[key]=false;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            if(key<set.length){
                return set[key];
            }else {
                return false;
            }
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
