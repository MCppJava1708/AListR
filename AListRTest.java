import static org.junit.Assert.*;

import org.junit.Test;

public class AListRTest
{
	EList lst = new AListR();
	@Test
	public void Base_1() 
	{
		int [] ini = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
		lst.init(ini);
		assertEquals(36, lst.size());
		int [] act = lst.toArray();              
		int [] exp = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
		assertArrayEquals(exp, act);
		lst.clear();
		assertEquals(0, lst.size());
		act = lst.toArray();
		exp = new int[0];
		assertArrayEquals(exp, act);
	}
	@Test
	public void Base_2() 
	{
		int [] ini = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
		lst.init(ini);
		assertEquals(32, lst.size());
		int [] act = lst.toArray();              
		int [] exp = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
		assertArrayEquals(exp, act);
		lst.clear();
		assertEquals(0, lst.size());
		act = lst.toArray();
		exp = new int[0];
		assertArrayEquals(exp, act);
	}
	@Test
	public void Base_3() 
	{
		int [] ini = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		lst.init(ini);
		assertEquals(31, lst.size());
		int [] act = lst.toArray();              
		int [] exp = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		assertArrayEquals(exp, act);
		lst.clear();
		assertEquals(0, lst.size());
		act = lst.toArray();
		exp = new int[0];
		assertArrayEquals(exp, act);
	}
	@Test
	public void Base_4() 
	{
		int [] ini = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		lst.init(ini);
		assertEquals(30, lst.size());
		int [] act = lst.toArray();              
		int [] exp = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		assertArrayEquals(exp, act);
		lst.clear();
		assertEquals(0, lst.size());
		act = lst.toArray();
		exp = new int[0];
		assertArrayEquals(exp, act);
	}
	//=========================================================================
	@Test
	public void toArray_1() 
	{
		int [] ini = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		lst.init(ini);
		
		assertEquals(30, lst.size());
		int [] act = lst.toArray();              
		int [] exp = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		assertArrayEquals(exp, act);
		lst.clear();
		assertEquals(0, lst.size());
		act = lst.toArray();
		exp = new int[0];
		assertArrayEquals(exp, act);
	}
	
	
	
	
	
}
