
public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] riceballs=ReadInput();
		
		System.out.println(getMaxRiceball(riceballs,0,riceballs.length-1));
		

	}
	
	private static int getMaxRiceball(int[] riceballs, int start, int end) {
		// TODO Auto-generated method stub
		if (start==end) return riceballs[start];
		
		
		//case 1.1 : 2 parts are combinable and the sizes are the same;
		for (int i=start;i<end-1;i++) {
			if (isCombinable(riceballs, start,i) && isCombinable(riceballs,i+1,end)) {
				int size1=getMaxRiceball(riceballs,start,i);
				int size2=getMaxRiceball(riceballs,i+1,end);
				if (size1==size2) return size1+size2;
			}
		}
		//case 1.2 : 3 parts are all combinable and the first size is same as the third size
		for (int i=start;i<end-2;i++) {
			for (int j=i;j<end-1;j++) {
				if (isCombinable(riceballs, start,i) && isCombinable(riceballs,i+1,j) && isCombinable(riceballs,j+1,end)) {
					int size1=getMaxRiceball(riceballs,start,1);
					int size3=getMaxRiceball(riceballs,j+1,end);
					if (size1==size3) {
						return size1+getMaxRiceball(riceballs,i+1,j)+size3;
					}
				}
			}
		}
		//case 2: not combinalbe, then should be the max riceball from 0~n-2 or from 1~n-1;
		int riceball1=getMaxRiceball(riceballs,start,end-1);
		int riceball2=getMaxRiceball(riceballs,1,end);
		
		if (riceball1>riceball2) return riceball1;
		else return riceball2;

	}

	private static boolean isCombinable(int[] riceballs, int i, int end) {
		// TODO Auto-generated method stub
		return false;
	}

}
