
import java.io.*;
import java.util.*;
public class function6 {

	public static void main(String[] args) {
		
	
	int number, element;
		Scanner sc= new Scanner(System.in);
		System.out.println("Элементийн тоог оруулна уу:");
		number=sc.nextInt();
		MyChain chn= new MyChain();
		MyChain chn2 = new MyChain();
		MyChain chn1 = new MyChain();
		for(int i=0; i<number ; i++) {
			System.out.print("Элемент[" +i+"]=");
			element=sc.nextInt();
			chn.add(i, element);
			chn2.add(i, element);
			
		}
		
		System.out.println("жагсаалт1:" + chn.toString());
		System.out.println("Хийх үйлдэлээ сонгоно уу: "
				+ "\n1 Массив хөрвүүлэх "
				+ "\n2 Жагсаалт нэмэх "
				+ "\n3 Нэмсэн жагсаалт харуулах "
				+ "\n4  Жагсаалтад байгаа давхардсан элемент харуулах "
				+ "\n5 Хоёр жагсаалтыг эрэмбэлэх "
				+ "\n6 Нэг жагсаалт эрэмбэлэх \n7 Гарах");
		while(true) 
		{
			int songolt=sc.nextInt();
			switch(songolt){
			case 1:
				for(int i=0;  i<number ; i++) {
					Object[] xx = chn.toArray();
					System.out.println("x["+i+"]="+xx[i]);	}
				break;
			case 2:
				System.out.println("Залгах элементийн уртыг оруулна уу=");
				int urt=sc.nextInt();
				
				for(int j=0; j<urt ; j++) {
					System.out.print("элемент["+j+"]=");
					int element1= sc.nextInt();
					chn1.add(j, element1);
					chn.add(chn.size(), element1);
				
					Object[] a = new Object[urt-urt];
					chn.addRange(a); }
				System.out.println("жагсаалт2"+ chn1.toString());
				break ;
			case 3:
				System.out.println("Нэмсэн жагсаалт:"+ chn.union(chn));
				
				break;
			case 4:
				MyChain w =chn1.intersection(chn2);
				
				System.out.println("Давтагдсан элементүүд --"+ w.toString());
			
				break;
			case 5:
				MyChain w1=chn1.intersection2(chn2);
				System.out.println("Давтагдсан элементүүд -- =" +w1.toString());
				break;
			case 6:	
			  MyChain w2=chn1.intersection3(chn2);
			  System.out.println("Давтагдсан элементүүд -- =" +w2.toString());
			case 7:
				System.exit(0);
				default:
					System.out.println("Алдаа! Зөв сонголт хийнэ үү");
					
					
					}
			 
	
			} 
		
	}
}