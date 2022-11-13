import static org.junit.Assert.*;

import org.junit.Test;

import ac.il.afeka.fsm.DFSM;

public class TestCompute {

	@Test
	public void testCompute1() throws Exception {
		
		String encoding = "0 1/a b/0,a,0;0,b,1;1,a,0;1,b,1/0/1";
		DFSM dfsm = new DFSM(encoding);
		dfsm.prettyPrint(System.out);
		
		assertTrue(dfsm.compute("aab"));
	}
	
	@Test
	public void testCompute2() throws Exception {
		
		String encoding = "0 1/a b/0,b,0;1,b,1;0,a,1;1,a,0/0/1";
		DFSM dfsm = new DFSM(encoding);
		dfsm.prettyPrint(System.out);
		
		assertTrue(dfsm.compute("baababbaa"));
	}
	
	@Test
	public void testCompute3() throws Exception {
		
		String encoding = "0 1/a b/0,b,0;1,b,1;0,a,1;1,a,0/0/1";
		DFSM dfsm = new DFSM(encoding);
		dfsm.prettyPrint(System.out);
		
		assertTrue(!dfsm.compute("baababba"));
	}
	
	@Test
	public void testCompute4() throws Exception {
		
		String encoding = "0 1 2/a b/0,b,0;0,a,1;1,a,1;1,b,2;2,a,2;2,b,2/0/2";
		DFSM dfsm = new DFSM(encoding);
		dfsm.prettyPrint(System.out);
		
		assertTrue(dfsm.compute("baabaaabbb"));
	}
	
	@Test
	public void testCompute5() throws Exception {
		
		String encoding = "0 1 2/a b/0,b,0;0,a,1;1,a,1;1,b,2;2,a,2;2,b,2/0/2";
		DFSM dfsm = new DFSM(encoding);
		dfsm.prettyPrint(System.out);
		
		assertTrue(!dfsm.compute("ebadfabqp"));
	}
	
}
