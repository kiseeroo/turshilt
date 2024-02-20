
import java.util.Arrays;
import dataStructures.*;
  public class MyChain extends Chain {
	public MyChain(int initialCapacity)
	{
		super(initialCapacity);
	}
	public MyChain()
	{
		super(0);
	}
	public MyChain(MyChain mychain)
	{
		super(mychain.size());
		for(int i=0 ; i<mychain.size(); i++) 
			this.add(i, mychain.get(i));
	}
	public MyChain(String ss)
	{
		super(0);
		String[] strval;
		strval= ss.split(" ");
		for(int i=0; i<strval.length; i++)
		{
			this.add(i, Integer.parseInt(strval[i]));
		}
	}
	
	public Object[] toArray()
	{
		Object[] x = new Object[this.size()];
		for(int i=0 ; i<this.size(); i++)
			x[i]=this.get(i);
		return x;
	}
	public void addRange(Object[] elements)// jagsaalt nemeh
	{
		for(int i=0; i<elements.length; i++)
		{
			this.add(this.size(), elements[i]);
		}
	}
	public MyChain union(MyChain chain) // 
	{
		 MyChain a = new MyChain();
		for(int i=0; i<chain.size(); i++)
			a.add(i, chain.get(i) );
		
		return a; 
		
		
	} 
	public MyChain intersection(MyChain chain)
	{
		MyChain o = new MyChain();
		int k=0;
		for(int i=0; i<size(); i++) {
			for(int j=0 ; j<chain.size(); j++) {
				if(get(i)==chain.get(j)) {
					o.add(k,chain.get(j));
					 k++;
				}
				
			}
		}
		return o;
	}
	public MyChain intersection2(MyChain mlist) // massive ruu hurvuulj baigaad sortloj baigaad adilhan elementuudig olno
	{
		Object[] arr1 = this.toArray();
		Object[] arr2 = mlist.toArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		MyChain o2=new MyChain();
		int x=0, y=0, k=0;
		while(x<arr1.length && y<arr2.length)
		{
			if((int)arr1[x]<(int)arr2[y])
				x++;
			else if((int)arr1[x]>(int)arr2[y])
				y++;
			else
			{
				o2.add(k, arr1[x]);
				x++;
				y++;
				k++; // o2 geed uusgesgesen obect deeree tentsuu elementuudee nemne
			}
	    }
	  return o2;
	
	}
	public static void MergeSort(MyChain mlist) {
		int q, i, j, k; 
		MyChain lefthalf, righthalf;
		if(mlist.size()>1) {
			q=mlist.size()/2;
			lefthalf = new MyChain();
			righthalf = new MyChain();
			for(i = 0; i < mlist.size(); i++ )
				if(i<q)
					lefthalf.add(i,  mlist.get(i));
				else 
					righthalf.add(i-lefthalf.size(),mlist.get(i));
			MergeSort(lefthalf);
			MergeSort(righthalf);
			i=j=k=0;
			mlist.empty();
			while(i<lefthalf.size()&& j<righthalf.size()) {
				if ((int)lefthalf.get(i)<(int)righthalf.get(j))
				{
					mlist.add(k , lefthalf.get(i));
					i++;
				}
				else {
					mlist.add(k,  righthalf.get(i));
					j++;
				}
				k++;
			}
			while( i<lefthalf.size()) {
				mlist.add(k, lefthalf.get(i));
				i++; k++;
			}
			while(j<righthalf.size()) {
				mlist.add(k, righthalf.get(j));
				j++; k++;
			}
		}
	}
	public void empty()
	{
		while(!this.isEmpty()) 
		{
			this.remove(0);
		}
	}
	public MyChain intersection3(MyChain mlist)
	{
		MyChain ch1= new MyChain(this);
		MyChain ch2= new MyChain(mlist);
		MergeSort(ch1);
		MergeSort(ch2);
		int x=0, y=0, k=0;
		MyChain intersectch = new MyChain();
		while(x<ch1.size() && y<ch2.size())
		{
			if((int)ch1.get(x)<(int)ch2.get(y))
				x++;
			else if((int)ch1.get(x)<(int)ch2.get(y))
				y++;
			else
			{
				intersectch.add(k, ch1.get(x));
				x++;
				y++;
				k++;
			}
		}
		return intersectch;
	}
}
  
  //13:15
  