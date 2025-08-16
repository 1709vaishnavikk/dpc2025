public class Day2{
   public static int missingNum(int [] arr){
          int n=arr.length+1;
          int sum1=(n*(n+1))/2;
          int sum2=0;
          for(int i=0;i<arr.length;i++){
              sum2+=arr[i];
          }
          int missing=sum1-sum2;
          return missing;
  }
 public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5}; // 3 is missing
        System.out.println("Missing number: " + missingNum(arr)); // Output: 3
    }
}
