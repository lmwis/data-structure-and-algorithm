package exp2;

public class Methods {
//	实现两个字符串数组的逆序排序，输出结果为字符串数组
	public static void reverseString(String str) {
		String[] strArr = str.split(",");
		String result="";
		for(int i=strArr.length-1;i>=0;i--) {
			result+=strArr[i];
			result += " ";
		}
		System.out.print(result);
	}
	

//	求两个整形数组的交集；
	public static void interSection(int[] a ,int[] b){
		for(int i = 0;i<a.length;i++){
			for(int j=0;j<b.length;j++){
				if(a[i] == b[j]){
					System.out.print(a[i] + " ");
				}
			}
		}
	}

//	求两个浮点型数组的并集；
	public static void floatSum(float[] a ,float[] b){
		float[] c = new float[a.length+b.length];
		int k = 0;
		for(int i = 0;i<a.length;i++){
			c[k]=a[i];
			k++;
		}
		for(int j=0;j<b.length;j++){
			boolean flag = true;
			for(int i=0;i<a.length;i++){
				if(c[i]==b[j]){
					flag = false;
				}
				else
					continue;
			}
			if(flag){
				c[k]=b[j];
				k++;
			}
		}
		float sum[] = new float[k];
		for(int n =0;n<k;n++){
			sum[n] = c[n];
			System.out.print(sum[n] + " ");
		}
	}
}
