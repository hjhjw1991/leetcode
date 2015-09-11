import java.util.*;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
      // note: this is not so hard as the problem of dropping eggs. It is easy.

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=1,right=n,mid;
        boolean bad;
        while(left<=right){
            mid=left+(right-left)/2;
            
            bad=isBadVersion(mid);
            if(bad&&(mid==1||!isBadVersion(mid-1)))
            return mid;
            else if(bad){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return 0;
    }
}