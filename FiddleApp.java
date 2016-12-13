public class FiddleApp{
	public static void main(String[] args){
		int[] list = {14,10,11, 13};
		for(int i=0; i < list.length; i++){
			System.out.print("\t "+list[i]);
		}
		System.out.println("\n");
		fiddle(list);
	}
	static void fiddle(int[] list){
		int i,j, im, temp, cnt;
		cnt=0;
		for(i=0;i<list.length -1;i++){
			im = i;
			for(j = i+1; j < list.length; j++){
				System.out.println("Comparing if "+list[j]+" < "+list[im]);
				cnt++;
				if (list[j] < list[im]){
					im = j;
				}
				System.out.println("Comparing if "+im+" != "+i);
				//cnt++;
				if (im != i){
					temp = list[i];
					list[i] = list[im];
					list[im] = temp;
					System.out.println("Swapped " +list[i]+" with "+list[im]);
					System.out.println("\n");
				}
				for(int w=0; w < list.length; w++){
					System.out.print("\t "+list[w]);
				}
				System.out.println("\n");
				System.out.println(" Number of comparisons "+cnt);
			}
		}
		
	} 
}