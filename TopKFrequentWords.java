
/* Top K Frequent Words

Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

*/


//Cleaner code. Use this

public class Solution {
    
    class Node{
        int freq;
        String str;
        
        public Node(String s, int f){
            freq = f;
            str = s;
        }
    }

    public List<String> topKFrequent(String[] words, int k){

        if(words == null || words.length == 0 || k <= 0){
            return null;
        }

        HashMap<String, Node> map = new HashMap<String, Node>();
        for(String curt : words){
            if(!map.containsKey(curt)){
                map.put(curt, new Node(curt, 1));
            }
            map.get(curt).freq = map.get(curt).freq + 1;
        }

        PriorityQueue<Node> queue = new PriorityQueue<Node>(k, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                if(n1.freq == n2.freq)
                    return n1.str.compareTo(n2.str);
                else
                    return n2.freq - n1.freq;
            }
        });

        for(String key : map.keySet()){
            queue.offer(map.get(key));
        }

        List<String> res = new ArrayList<String>();
        for(int i = 0; i < k; i++){
            res.add(queue.poll().str);
        }

        return res;
    }
}




//1st Attempt


/*
class Solution {
    
    
    class WordFreq{ //implements Comparable<WordFreq>{
        
        String word;
        int freq;
        
        WordFreq(String w, int f){
            word = w;
            freq = f;
        }
        
        @Override
        public int compareTo(WordFreq a){
            
            if(this.freq == a.freq)
                return(a.word.compareTo(this.word));
            return(this.freq - a.freq);
        }
        
    }

    
    public List<String> topKFrequent(String[] words, int k) {
        
        //First thing we do is create a hashmap which with a word as key and its frequency as value
        
        List<String> res = new ArrayList<String>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String word: words){
            
            if(hm.containsKey(word))
                hm.put(word, hm.get(word) + 1);
            else
                hm.put(word, 1);
        }
        
        
        
        PriorityQueue<WordFreq> pq = new PriorityQueue<>(new Comparator<WordFreq>(){
            @Override
            public int compare(WordFreq a, WordFreq b){

                if(a.freq == b.freq)
                    return(a.word.compareTo(b.word));
                return(b.freq - a.freq);
            }
        });
        
        //Keep adding all the words and associated frequency into the priority queue
        for(String word: hm.keySet()){
            WordFreq wf = new WordFreq(word, hm.get(word));
            //if(pq.size() < k)
                pq.add(wf);
            
            else{
                //Before evicting you need to check if frequency of incoming element is greater than outgoing
                //If they are the same then we order lexicographically
                //Thankfully this is done by my custom implementation of compareTo
                //if(wf.compareTo(pq.peek()) > 0){ //Meaning wf gets preference wrt our custom implementation of compareTo
                    pq.poll();
                    pq.add(wf);
                
                
            }
            
        }
        
        //Empty the elements from the MinHeap and put them in the final ArrayList
        while(!pq.isEmpty()){
            res.add(0, pq.poll().word);
        }
        
        return res;
    }
    
    
    
}

*/