import java.util.*;
class sol{
    public static int maxsum(int arr[],int l,int m,int h){
        int sum=0;
        int l_sum=Integer.MIN_VALUE;
        for(int i=m;i>=l;i--){
            sum=sum+arr[i];
            if(sum>l_sum){
                l_sum=sum;
            }
        }
        sum=0;
        int r_sum=Integer.MIN_VALUE;
        for(int i=m;i<=h;i++){
            sum=sum+arr[i];
            if(sum>r_sum)
                r_sum=sum;
        }
        return Math.max(l_sum+r_sum-arr[m],Math.max(l_sum,r_sum));
        
    }
    public static int maxsubarr(int arr[],int l,int h){
        if(l>h)
            return Integer.MIN_VALUE;
        if(l==h)
            return arr[l];
        int m=(l+h)/2;
        return Math.max(Math.max(maxsubarr(arr,l,m-1),maxsubarr(arr,m+1,h)),maxsum(arr,l,m,h));
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int msum=maxsubarr(arr,0,n-1);
        System.out.println(msum);
    }
}
