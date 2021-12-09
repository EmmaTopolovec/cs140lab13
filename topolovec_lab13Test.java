import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class topolovec_lab13Test 
{
	topolovec_lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "lab13_input_data.txt";
	String expectedResultsFilename = "lab13_expected_results.txt";

	@Before
	public void setUp() throws Exception 
	{
		// instantiate an instance of lab13
		lab = new topolovec_lab13();
		
		// read the input value and populate the ArrayList<Integer> in the lab13 class
		lab.readData(inputFilename);
		
		// testData.get(0) has the expected results for getResult1()
		// testData.get(1) has the expected results for getResult2()
		// testData.get(2) has the expected results for getResult3()
		ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
		for( int i = 0; i < 3; i++ )
		{
			testData.add(new ArrayList<Integer>());
		}
		
		try
		{
			System.out.println("reading " + expectedResultsFilename);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
			for( int i = 0; i < testData.size(); i++ )
			{
				ArrayList<Integer> currentTestData = testData.get(i); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentTestData.add(Integer.valueOf(inn));
					}
					else
					{
						break;
					}
				}
				testData.set(i, currentTestData);
				System.out.println("testData.get(" + i + ").size() = " + testData.get(i).size());
			}
			input.close();
			
			// put code here to populate expectedResult1 with the values in testData.get(0)
			// so that you can use "assertArrayEquals" to verify expectedResult1 and lab.getResult1() are the same
			expectedResult1 = (Integer[]) testData.get(0).toArray();
			
			
			// put code here to populate expectedResult2 with the values in testData.get(1)
			// so that you can use "assertArrayEquals" to verify expectedResult2 and lab.getResult2() are the same
			expectedResult2 = (Integer[]) testData.get(1).toArray();
			
			
			// put code here to populate expectedResult3 with the values in testData.get(2)
			// so that you can use "assertArrayEquals" to verify expectedResult3 and lab.getResult3() are the same
			expectedResult3 = (Integer[]) testData.get(2).toArray();
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}		
	}

	@Test
	public void testGetTotalCount() {
		assertTrue(lab.getTotalCount() == 1000);
	}
	@Test
	public void testGetOddCount() {
		assertTrue(lab.getOddCount() == 507);
	}
	@Test
	public void testGetEvenCount() {
		assertTrue(lab.getEvenCount() == 493);
	}
	@Test
	public void testGetDistinctGreaterThanFiveCount() {
		assertTrue(lab.getDistinctGreaterThanFiveCount() == 94);
	}
	@Test
	public void testGetResult1() {
		assertArrayEquals(lab.getResult1(), expectedResult1);
	}
	@Test
	public void testGetResult2() {
		assertArrayEquals(lab.getResult2(), expectedResult2);
	}
	@Test
	public void testGetResult3() {
		assertArrayEquals(lab.getResult3(), expectedResult3);
	}
}