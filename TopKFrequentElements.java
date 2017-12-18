
/*

Given [1,1,1,2,2,3] and k = 2, return [1,2]

*/

//The standard procedure to find the Top k elements is:
// 1. Maintain a hashmap which contains the frequency of each distinct input
// 2. Make a custom class to hold the input with its frequency (we will put the object of the custom class in a Min Heap)
// 3. Now maintain a Min Heap of size k
// 4. THe Min Heap will order itself based on the frequency of the each input ('count' of each 'num')

//Refer to 'Top K Frequent Words' Problem for a similar problem on word frequency

class Solution {
    
    class Pair{
        int num;
        int count;
        public Pair(int num, int count){
            this.num=num;
            this.count=count;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        //Build a hashmap : Key is number and value is freq
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int n: nums){
            int count = hm.getOrDefault(n, 0);
            hm.put(n, count+1);
        }
        
        //Make a MinHeap of Size k which will order based on the frequency
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.count-b.count;
            }
        });
        
        
        for(int key: hm.keySet()){
            Pair p = new Pair(key, hm.get(key));
            pq.offer(p);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        //Adding contents of min heap into final arraylist
        while(!pq.isEmpty()){
            res.add(0, pq.poll().num);
        }
        return res;
    }
}