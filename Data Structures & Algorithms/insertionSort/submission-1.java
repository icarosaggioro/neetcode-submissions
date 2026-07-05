// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> rList = new ArrayList<>();
        List<Pair> lstDest = new ArrayList<>();

        System.out.print("insertionSort Pairs: " + pairs + "\n");

        while (pairs.size() != 0) {
            Pair p = pairs.removeFirst();

            if(lstDest.size() == 0) {
                lstDest.addFirst(p);
            } else {
                int destIndex = 0;
                for (destIndex = 0; destIndex < lstDest.size(); destIndex++) {
                    if (p.key < lstDest.get(destIndex).key) {
                        break;
                    }
                }
                lstDest.add(destIndex, p);
            }

            //
            System.out.print(" " + lstDest + " " + pairs + "\n");
            List<Pair> lstState = new ArrayList<>(lstDest);
            lstState.addAll(pairs);
            rList.add(lstState);
       }

        return rList;
    }
}
