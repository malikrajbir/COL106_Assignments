import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class checker
{
	public static void main ( String args [])
	{
		BufferedReader br = null;
		RoutingMapTree r = new RoutingMapTree();

		try {
			String actionString;
			br = new BufferedReader(new FileReader("actions1.txt"));

			while ((actionString = br.readLine()) != null) {
				String test = r.performAction(actionString);
				if(test.length()!=0)
					System.out.println(test);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}