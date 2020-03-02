package leetcode;

/**
 * @author Ryan
 * @date 2020/2/29 13:05
 */
public class _605canPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        if(flowerbed.length<n) return false;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                if(flowerbed.length==1&&flowerbed[0]==0) return true;
                if(i-1<0){
                    if(flowerbed[i+1]==0){
                        flowerbed[i]=1;
                        count++;
                    }
                }else if(i+1>flowerbed.length-1){
                    if(flowerbed[i-1]==0){
                        flowerbed[i]=1;
                        count++;
                    }
                }else if(flowerbed[i-1]==0&&flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}
