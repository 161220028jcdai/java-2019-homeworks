import java.util.Random;

/**
 * @author: ����� ���ӿ�ѧ�빤��ѧԺ 161180068
 * @className: cocktail_sort
 * @description: ˫��ð�����򣬾��Ǵ�������ð�ݺʹ�������ð�ݽ�����С��������ɵĻ����Կ�һ�㡣��Ȼ����Ҳ��Java��ʹ����ϰ��
 * @data: 2019-9-9 22:14
 **/

class HuLuBrothers{
	String name;
	String color;
	String nameList[] = new String[]{"����","����","����","����","����","����","����"};
	String colorList[] = new String[]{"��ɫ","��ɫ","��ɫ","��ɫ","��ɫ","��ɫ","��ɫ"};
	int location;				
	int order;					
	
	// the constructor.
	HuLuBrothers(int order1, int location1){
		this.order = order1;
		this.location = location1;
		this.name = this.nameList[order1];
		this.color = this.colorList[order1];
	}
	HuLuBrothers(){
		this.order = -1;
		this.location = -1;
		this.name = "Initialize";
		this.color = "Initialize";
	}
	
	void broadcast(int loc_before, int loc_after){
		System.out.println(this.name + "��" + loc_before + "->" + loc_after);
	}
}

public class homework2 {
	public static void main(String args[]){
		HuLuBrothers Brothers[] = new HuLuBrothers[7];	// initialize HuLu Brother
		for (int i=0; i<7; i++){
			Brothers[i] = new HuLuBrothers(i,i);
		}
		System.out.print(">>Begin the HuLu-Brother sort game :-)\n>>===============>>\n");
		System.out.print(">>shuffle. Printed by rank: ");
		shuffle(Brothers);
		print(Brothers, true);				// boolean ifRank = true: rank; false: color.
		System.out.print("\n>>Bubble sort: \n");
		sort(Brothers);
		System.out.print("\n>>After sort. Printed by rank: ");
		print(Brothers, true);
		System.out.print("\n>>Shuffle again. Printed by color: ");
		shuffle(Brothers);
		print(Brothers, false);
		System.out.print("\n>>Binary sort: \n");
		binary(Brothers);
		System.out.print("\n>>After sort. Printed by rank: ");
		print(Brothers, true);
		System.out.print("\n>>===============>>\n>>Finish! Congratulated! :-D");
	}
	
	private static void sort(HuLuBrothers[] array) {
		HuLuBrothers tmp = new HuLuBrothers();
		for(int i=0; i<array.length; i++) {
			boolean isSorted = true;
			// �����������Ԫ��û�е���������ǰ������
			for(int j=0; j<array.length-i-1; j++) {
				if(array[j].location > array[j+1].location) {
					tmp.location = array[j].location;
					array[j].location = array[j+1].location;
					array[j+1].location = tmp.location;
					array[j].broadcast(j, j+1);
					isSorted = false;
				}
			}	
			if(isSorted) { break; }
			isSorted = true;
		}
	}
	
	/**	
	private static void initialize(){
		HuLuBrothers[] Brothers = null;	// initialize HuLu Brother
		for (int i=0; i<7; i++){
			Brothers[i] = new HuLuBrothers(i,i+1);
		}
	}**/
	
	private static void shuffle(HuLuBrothers[] Brothers1){
		Random rand=new Random();
		for (int i=0; i<7; i++){
			one_num:
			while(true){
				Brothers1[i].location = rand.nextInt(7);
				for (int j=0; j<i; j++){
					if (Brothers1[i].location==Brothers1[j].location) continue one_num;
				}
				//System.out.print((Brothers1[i].location+1) + " ");
				break;
			}
		}//System.out.println();
	}
	
	private static void print(HuLuBrothers[] a, boolean ifRank){
		if (ifRank){
			for(int i=0; i<a.length; i++){
				for(int j=0;j<a.length; j++)
					if(i==a[j].location){
						System.out.print(a[j].name + " ");
						break;
				}
			}
			System.out.println();
		}
		else{
			for(int i=0; i<a.length; i++){
				for(int j=0;j<a.length; j++)
					if(i==a[j].location){
						System.out.print(a[j].color + " ");
						break;
				}
			}
			System.out.println();
		}
	}
	
	private static void binary(HuLuBrothers[] array){
        int low;
        int high;
        int mid;
        int value;
        for (int i=1; i<7; i++){
        	low = 0;
        	high = i - 1;
        	mid = (low + high)/2;
        	value = array[mid].location;
        	value = array[i].location;
        	while(low <= high)
            {
                mid = (low + high) / 2;
                if(value == array[mid].location)
                {
                	// This is impossible but I want to preserve this structure. Beautiful, isn't it? :-D
                }
                if(value > array[mid].location)
                {
                    low = mid + 1;
                }
                if(value < array[mid].location)
                {
                    high = mid - 1;
                }
            }
        	for (int j=i-1; j>=low; j--){
        		array[j+1].location = array[j].location;
        		array[j].broadcast(j,j+1);
        	}
        	if (low != i){
        		array[low].location=value;
        		array[i].broadcast(i, low);
        	}
        }
    }
}
