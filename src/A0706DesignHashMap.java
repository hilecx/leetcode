import java.util.Arrays;
import java.util.HashMap;

public class A0706DesignHashMap {


    class MyHashMap4 {
        HashMap<Integer,Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public MyHashMap4() {

        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            map.put(key,value);
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            Integer value = map.get(key);
            return value == null ? -1 : value;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            map.remove(key);

        }
    }



    class MyHashMap2 {
        Integer[] storage;
        Integer size = 100;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap2() {
            storage = new Integer[size];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            extendSize(key);
            storage[key] = value;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            if(key>size){
                return -1;
            }
            Integer value = storage[key];
            return value == null ? -1 : value;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            if(key>size){
                return;
            }
            storage[key] = null;
        }

        private void extendSize(Integer key) {
            while (key > size) {
                if (size < Integer.MAX_VALUE / size) {
                    size = size * size;

                } else {
                    size = Integer.MAX_VALUE;
                    break;
                }

            }
            // storage= Arrays.copyOf(storage,size);

            Integer[] newStorage = new Integer[size];
            System.arraycopy(storage, 0, newStorage, 0, storage.length);
            storage = newStorage;
        }
    }




    class MyHashMap3 {
        Integer[] storage;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap3() {
            storage = new Integer[1000000];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            storage[key] = value;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            Integer value = storage[key];
            return value == null ? -1 : value;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            storage[key] = null;

        }
    }


    class MyHashMap {
        int[] storage;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            storage = new int[1000000];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            storage[key] = value+1;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            return  storage[key] -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            storage[key] = 0;

        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

