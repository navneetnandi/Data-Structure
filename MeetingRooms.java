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

 Given [[0, 30],[5, 10],[15, 20]],
 return false.


 */

 
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        
        if(intervals == null)
            return false;
        
        Comparator<Interval> comp = new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return(a.start - b.start);
            }
        };
        
        Arrays.sort(intervals, comp);
        
        if( intervals.length == 1){
            if(intervals[0].end > intervals[0].start)
                return true;
            return false;
        }
        for(int i=0; i<intervals.length - 1; i++) {
            if(intervals[i + 1].start < intervals[i].end)
                return false;
            
        }
        return true;
        
        
        //Arrays.sort(starts);
        //Arrays.sort(ends);
    
        
    }
}