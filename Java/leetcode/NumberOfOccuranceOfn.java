public class NumberOfOccuranceOfn {

	public static int first(int[] arr,int start,int last,int num){
		int mid;
		int foundAt=-1;
		while(start<=last){
			mid=(last+start)/2;
			if(arr[mid]>num){
				last=mid-1;;
			}else if(arr[mid]<num){
				start=mid+1;
			}
			//when found number, now we need to find the first occurrence of that repeated number
			else{
				foundAt=mid;
				last=mid-1;
			}
		}
		return foundAt;
	}
	public static int last(int[] arr,int start,int last,int num){
		int mid;
		int foundAt=-1;
		while(start<=last){
			mid=(last+start)/2;
			if(arr[mid]>num){
				last=mid-1;;
			}else if(arr[mid]<num){
				start=mid+1;
			}
			//when found number, now we need to find the first occurrence of that repeated number
			else{		
				foundAt=mid;
				start=mid+1;
			}
		}
		return foundAt;
	}
	public static int NoOfOccurances(int[] arr,int num){
		int start=first(arr, 0, arr.length-1, num);
		int end=last(arr, 0, arr.length-1, num);
		return end-start+1;
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr={9,9,9,9,9,9};
		int[] arr={1,2,3,4,5,5};
		System.out.println(NoOfOccurances(arr, 5));
	}
}