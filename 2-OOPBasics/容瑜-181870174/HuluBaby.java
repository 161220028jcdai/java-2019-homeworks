import java.util.Random;
public class HuluBaby {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AhuluBaby Baby1 = new AhuluBaby(1,"��ɫ","�ϴ�");
		AhuluBaby Baby2 = new AhuluBaby(2,"��ɫ","�϶�");
		AhuluBaby Baby3 = new AhuluBaby(3,"��ɫ","����");
		AhuluBaby Baby4 = new AhuluBaby(4,"��ɫ","����");
		AhuluBaby Baby5 = new AhuluBaby(5,"��ɫ","����");
		AhuluBaby Baby6 = new AhuluBaby(6,"��ɫ","����");
		AhuluBaby Baby7 = new AhuluBaby(7,"��ɫ","����");
		AhuluBaby[] BabyList = new AhuluBaby[7];
		BabyList[0] = Baby4;
		BabyList[1] = Baby1;
		BabyList[2] = Baby7;
		BabyList[3] = Baby5;
		BabyList[4] = Baby2;
		BabyList[5] = Baby3;
		BabyList[6] = Baby6;
		int i=0;
		int j=0;
		System.out.println("��ʼ��˳��Ϊ��");
		for(i=0;i<7;i++)
		{
			System.out.println(BabyList[i].rank);
		}
		for(i=0;i<7-1;i++)
		{
			for(j=0;j<7-1-i;j++)
			{
				if(BabyList[j].num>BabyList[j+1].num)
				{
					System.out.println(BabyList[j].rank+":"+" "+(j+1)+"->"+(j+2));
					System.out.println(BabyList[j+1].rank+":"+" "+(j+2)+"->"+(j+1));
					AhuluBaby tem;
					tem = BabyList[j];
					BabyList[j] = BabyList[j+1];
					BabyList[j+1] = tem;
				}
			}
		}
		System.out.println("������ϣ���ʼ������");
		for(i=0;i<7;i++)
		{
			System.out.println(BabyList[i].rank);
		}
		
		int n = 6;
		int a = 0;
		while(n>1)
		{
			Random rand1 = new Random();
			a = rand1.nextInt(n);
			AhuluBaby temp;
			temp = BabyList[n];
			BabyList[n] = BabyList[a];
			BabyList[a] = temp;
			n--;
		}
		System.out.println("����˳��������£�");
		for(i=0;i<7;i++)
		{
			System.out.println(BabyList[i].rank);
		}
		BinarySort(BabyList);
		System.out.println("����ɫ������ϣ���ʼ������");
		for(i=0;i<7;i++)
		{
			System.out.println(BabyList[i].color);
		}
		
	}
	
	public static void BinarySort(AhuluBaby[] arr) {
	    for (int i = 1; i < arr.length; i++) {
	    	AhuluBaby temp = arr[i];
	        int low = 0, high = i - 1;
	        int mid = -1;
	        while (low <= high) {            
	            mid = low + (high - low) / 2;            
	            if (arr[mid].num > temp.num) {               
	                high = mid - 1;            
	            } 
	            else { // Ԫ����ͬʱ��Ҳ�����ں����λ��                
	                low = mid + 1;            
	            }        
	        }        
	        for(int j = i - 1; j >= low; j--) { 
	        	System.out.println(arr[j].rank+":"+" "+(j+1)+"->"+(j+2));
	            arr[j + 1] = arr[j];       
	        }
	        if(i!=low)
	        {
	        	System.out.println(temp.rank+":"+" "+(i+1)+"->"+(low+1));
	        }
	        arr[low] = temp; 
	    }
	}
	
}


class AhuluBaby{
	int num;
	String color;
	String rank;
	
	AhuluBaby(){
		num = 1;
		color = "Red";
		rank = "�ϴ�";
	}
	
	AhuluBaby(int renum,String recol,String rerank){
		num = renum;
		color = recol;
		rank = rerank;
	}
	
}

