package array;

/**
 * Created by einez on 2017/5/26.
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length<1)
            return 0;
        int total=duration;
        for(int i=0;i<timeSeries.length-1;i++){
            if(timeSeries[i+1]-timeSeries[i]<duration)
                total+=timeSeries[i+1]-timeSeries[i];
            else total+=duration;
        }
        return total;
    }
}
