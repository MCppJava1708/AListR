
public class AListR implements EList
{
	int [] ar = new int [30];
	int start = ar.length/2;
	int end = ar.length/2;
	int indexS = 0;
	int indexE = 0;
	@Override
	public void init(int ini [])
	{
		if(ini == null)
		{
			clear();
			return;
		}
		if(ini.length > ar.length)
		{
			ar = new int [ini.length + ((ini.length/100)*30)];
		}
		start = ar.length/2 - ini.length/2;
		end = ar.length/2 + ini.length/2;
		if(ini.length%2!=0)
		{
			end = end+1;
		}
		for (int i = 0; i < size(); i++)
		{
			ar[start+i] = ini [i];
		}
	}
	@Override
	public int size()
	{
		return (end+indexE)-(start+indexS);
	}	
	@Override
	public void clear()
	{
		start = end = ar.length/2;
		indexS = indexE = 0;
	}
	@Override
	public int [] toArray ()
	{
		int[] ret = new int [size()];
		if(indexS == 0 && indexE == 0)
		{
			for (int i = 0; i < size(); i++)
			{
				ret [i] = ar [start+i];
			}
			return ret;
		}
		if(indexS != 0)
		{
			int count = 0;
			for (int i = ar.length - indexS + 1; i < ar.length; i++)
			{
				ret [count] = ar [i];
				count++;
			}
			for (int i = start; i < end; i++)
			{
				ret [count + i] = ar [start+i];
			}

		} else if(indexE != 0)
		{
			for (int i = 0; i <= end; i++)
			{
				ret [i] = ar [start+i];
			}
			for (int i = 0; i < indexE; i++)
			{
				ret [start + end + i] = ar [i];
			}
			return ret;
		}
		return ret;
	}	
	@Override
	public String toString()
	{
		String rez = "";
		for (int i = start; i < end; i++)
		{
			rez += ar[i];
			if(i<end-1)
			{
				rez += ",";
			}
		}
		return rez;
	}
	@Override
	public void addStart(int val)
	{
		if(ar.length != size())
		{
			ar[--start] = val;
		}
		
	}
	@Override
	public void addEnd(int val)
	{
		ar[end++] = val;
	}
	@Override
	public void addPos(int pos, int val)
	{
		if(pos>size()||pos<0)
		{
			throw new IllegalArgumentException();
		}
		if(pos>size()/2)
		{
			for (int i = end; i > start + pos; i--)
			{
				ar [i] = ar [i-1];
			}
			ar[start + pos] = val;
			end++;
		}else
		{
			for (int i = --start; i <= start + pos; i++)
			{
				ar [i] = ar [i+1];
			}
			ar [start + pos] = val;
		}

	}
	@Override
	public int delStart()//удал€ет первый элемент
	{
		if(size()==0)
		{
			throw new ListEmptyException();
		}
		return ar[start++];
	}
	@Override
	public int delEnd()//удал€ет последний элемент
	{
		if(size()==0)
		{
			throw new ListEmptyException();
		}
		return ar[--end];
	}
	@Override
	public int delPos(int pos)//удал€ет элемент с заданной позиции
	{
		if(size()==0)
		{
			throw new ListEmptyException();
		}
		if(pos>=size()||pos<0)
		{
			throw new IllegalArgumentException();
		}
		int res = ar [start + pos];
		for (int i = start + pos; i <end; i++)
		{	
			ar [i] = ar [i+1];
		}
		end--;
		return res;
	}
	@Override
	public int min()//возвращ€ет значение минимального элемента
	{
		return ar[minPos()+start];
	}
	@Override
	public int max()//возвращ€ет значение максимального элемента
	{
		return ar[maxPos()+start];
	}
	@Override
	public int minPos()//возвращ€ет индекс минималього элента 
	{
		if(size()==0)
		{
			throw new ListEmptyException();
		}
		int min = ar[start];
		int ind = 0;
		for(int i = start; i != end; i ++)
		{
			if(ar[i] < min)
			{
				min = ar[i];
				ind =i-start;
			}
		}
		return ind;

	}
	@Override
	public int maxPos()//возвращ€ет индекс максимального элента
	{
		if(size()==0)
		{
			throw new ListEmptyException();
		}
		int max = ar[start];
		int ind = 0;
		for(int i = start; i != end; i ++)
		{
			if(ar[i] > max)
			{
				max = ar[i];
				ind =i-start;
			}
		}
		return ind;
	}
	@Override
	public void reverse()//переворачивает массив
	{
		for (int i = 0; i < (size()/2); i++) 
		{
			int tmp = ar[start + i];
			ar[start + i] = ar[end - i - 1];
			ar[end - i - 1] = tmp;
		}
	}
	@Override
	public void halfReverse()//мен€ет местами первую и вторую половину массива
	{
		if (size()==0)
		{
			return;
		}
		for (int i = 0;i < size()/2; i++) 
		{
			int tmp = ar[start + i];
			ar[start + i] = ar[end - size()/2 + i];
			ar[end - size()/2 + i] = tmp;
		}
	}
	@Override
	public void sort ()//сортирует массив
	{
		for (int i = 0; i <= size(); i++) 
		{
			for (int tmp, j = start; j < end-i-1; j++)
			{
				if(ar[j] > ar[j+1])
				{
					tmp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = tmp;
				}
			} 
		}
	}
	@Override
	public int get(int pos)//возвращ€ет значение заданного элемента
	{
		if(size()==0)
		{
			throw new ListEmptyException();
		}
		if(pos>=size()||pos<0)
		{
			throw new IllegalArgumentException();
		}
		return ar[start + pos];
	}
	@Override
	public void set (int pos, int val)//замен€ет заданный элемент
	{
		if(size()==0&pos!=0)
		{
			throw new ListEmptyException();
		}
		if(pos>size()||pos<0)
		{
			throw new IllegalArgumentException();
		}
		if(pos==size())
		{
			addEnd(val);
		}
		ar[start + pos] = val;
	}

	private void Start(int val)
	{

	}

	private void End(int val)
	{

	}

	private void sipl()
	{
		int length = ar.length;
		int [] artmp = ar;
		ar = new int [ar.length + ((ar.length * 30) / 100)];
		start = ar.length/2 - artmp.length/2;
		end = ar.length/2 + artmp.length/2;
		if(artmp.length%2!=0)
		{
			end = end+1;
		}
		for (int i = 0; i < size(); i++)
		{
			ar[start+i] = artmp [i];
		}
	}
}
