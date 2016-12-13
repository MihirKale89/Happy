class TDMatrixUniqueElementChecker
{
	
	static boolean anyequal(int[][] multi){
		for(int i=0;i<multi[0].length;i++)
			for(int j=0;j<multi[0].length;j++)
				for(int k=0;k<multi[0].length;k++)
					for(int m=0;m<multi[0].length;m++)
						if (multi[i][j]==multi[k][m] && !(i==k && j==m))
							return true;
		return false;
	}
	
	static boolean anyequalfaster2(int[][] multi){
		for(int i=0;i<multi[0].length;i++)
			for(int j=0;j<multi[0].length;j++)
				for(int k=i;k<multi[0].length;k++){
					for(int m=0;m<multi[0].length;m++){
						//System.out.println("Element values being compared "+multi[i][j]+ " and "+multi[k][m]);
						if (multi[i][j]==multi[k][m] && !(i==k && j==m))
							return true;
					}
					//System.out.println("\n");
				}
		return false;
	}
	static boolean anyequalfaster(int[][] multi){
		int [][] temp = multi;
		for(int i=0;i<multi[0].length;i++)
			for(int j=0;j<multi[0].length;j++)
				if (multi[i][j]==temp[i][j])
					return true;
		return false;
	}
	
	public static void main(String[] args){
		int[][] multi = new int[][]{
			{1,2,3,4,5},
			{4,7,8,9,0},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25}
		};
		System.out.println("  anyequal: "+anyequal(multi));
		System.out.println("  anyequalfaster: "+anyequalfaster(multi));
		System.out.println("  anyequalfaster2: "+anyequalfaster2(multi));
		
	} // end main()
} // end class BubbleSortApp
