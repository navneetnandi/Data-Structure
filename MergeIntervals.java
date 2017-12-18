
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/*

 Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        Comparator<Interval> comp = new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return(a.start - b.start);
            }
        };
        
        Collections.sort(intervals, comp);
        
        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        for(Interval inter: intervals){
            
            if(prev == null || inter.start > prev.end){
                res.add(inter);
                prev = inter;
            }
            else if(inter.end > prev.end){
                //Modify the last entry into res
                prev.end = inter.end;
            }       
        }
        
        return(res);
    }
}