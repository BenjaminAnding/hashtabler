/*
 * Benjamin Anding
 * C00171534
 * CMPS 261 Sec 02 Project 7
 * I certify that this assignment is entirely my own work.
 */
package hashtabler;
import java.util.*;

/**
 *
 * @author benanding
 */
public class Hashtabler {

    public static void main(String[] args) {
        int[] values = {43, 71, 13, 23, 61, 73, 39, 99, 44, 16};
        int[] keys = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        
        Map<Integer, Integer> hashTable = linearProbe(keys, values);
        System.out.println("Linear Probing");
        System.out.println(hashTable);
        System.out.println();
        
        hashTable = quadraticProbe(keys, values);
        System.out.println("Quadratic Probing");
        System.out.println(hashTable);
        System.out.println();
        
        hashTable = doubleHash(keys, values);
        System.out.println("Double Hashing");
        System.out.println(hashTable);
        System.out.println();
        
        Map<Integer, ArrayList<Integer>> hashTable0 = separateChain(keys, values);
        System.out.println("Separate Chaining");
        System.out.println(hashTable0);
        System.out.println();
        
    }
    
    public static Map<Integer, Integer> linearProbe(int[] keys, int[] values) {
        Map<Integer, Boolean> tableIdx = new HashMap<>();
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int key : keys) {
            tableIdx.put(key, false);
            hashTable.put(key, 0);
        }

        for (int i = 0; i < values.length; i++) {
            int idx = values[i] % 17;
            if (!tableIdx.get(idx)) {
                tableIdx.replace(idx, true);
                hashTable.replace(idx, values[i]);
            } 
            else {
                while (tableIdx.get(idx)) {
                    idx = (idx+1) % 17;
                }
                tableIdx.replace(idx, true);
                hashTable.replace(idx, values[i]);
            }
        }
        return hashTable;
    }
    
    
    public static Map<Integer, Integer> quadraticProbe(int[] keys, int[] values) {
        Map<Integer, Boolean> tableIdx = new HashMap<>();
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int key : keys) {
            tableIdx.put(key, false);
            hashTable.put(key, 0);
        }
        
        for (int i = 0; i < values.length; i++) {
            int j = 1;
            int idx = values[i] % 17;
            int origIdx = idx;
            if (!tableIdx.get(idx)) {
                tableIdx.replace(idx, true);
                hashTable.replace(idx, values[i]);
            } 
            else {
                while (tableIdx.get(idx)) {
                    idx = (origIdx+(j*j)) % 17;
                    j++;
                }
                tableIdx.replace(idx, true);
                hashTable.replace(idx, values[i]);
            }
        }
        return hashTable;
    }
    
    public static Map<Integer, Integer> doubleHash(int[] keys, int[] values) {
        Map<Integer, Boolean> tableIdx = new HashMap<>();
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int key : keys) {
            tableIdx.put(key, false);
            hashTable.put(key, 0);
        }
        
        for (int i = 0; i < values.length; i++) {
            int j = 1;
            int idx = values[i] % 17;
            int origIdx = idx;
            if (!tableIdx.get(idx)) {
                tableIdx.replace(idx, true);
                hashTable.replace(idx, values[i]);
            } 
            else {
                while (tableIdx.get(idx)) {
                    idx = (origIdx + (j * (7 - (values[i] % 17)))) % 17;
                    j++;
                }
                tableIdx.replace(idx, true);
                hashTable.replace(idx, values[i]);
            }
        }
        return hashTable;
    }
    
    public static Map<Integer, ArrayList<Integer>> separateChain(int[] keys, int[] values) {
        Map<Integer, Boolean> tableIdx = new HashMap<>();
        Map<Integer, ArrayList<Integer>> hashTable = new HashMap<>();
        for (int key : keys) {
            ArrayList<Integer> array = new ArrayList<>();
            tableIdx.put(key, false);
            hashTable.put(key, array);
        }
        
        for (int i = 0; i < values.length; i++) {
            int idx = values[i] % 17;
            hashTable.get(idx).add(values[i]);
        }
        return hashTable;
    }
    
    
    
}
