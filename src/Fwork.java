import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Fwork {
	public static void findfile(File folder, File aim, int[] flag2)
	{
		File[] folderEntries = folder.listFiles();
	    String cmp= new String();
	    for (File entry : folderEntries)
	    {
	    	if (entry.isDirectory())
	        {
	            findfile(entry, aim, flag2);
	            continue;
	        }
	        else {
	        	Pattern cmp1= Pattern.compile(aim.getName());
	    		Matcher match= cmp1.matcher(entry.getName());
	        	if(match.matches()) {
	        		System.out.println("File is found!");
	        		flag2[0]=1;
	        	}
	        }
	    }
	}
	public static void defdirect(String[] args) {
		String fname= new String();
		fname= args[2];
		String curDir = new File("").getAbsolutePath();
		System.out.println("Current directory"+ '\n'+ curDir);
		File aim= new File(fname);
		if(aim.exists())
			System.out.println("File exists!");
		else
			System.out.println("File doesn`t exist!");
	}
	public static void subdirect(String[] args) {
		String fname= new String();
		String dname= new String();
		int[] flag= new int[1];
		flag[0]=0;
		Pattern cmp= Pattern.compile("^-d$");
		Matcher match= cmp.matcher(args[2]);
		if (match.matches()) {
			dname= args[3];
			fname= args[4];
			File dir= new File(dname);
			File aim= new File(fname);
			if(!dir.isDirectory()) {
				System.out.println("Directory doesn`t exist!");
				return;
			}
			else {
				findfile(dir, aim, flag);
				if(flag[0]==0)
					System.out.println("File doesn`t exist!");
			}
		}
		cmp= Pattern.compile("^--$");
		match= cmp.matcher(args[2]);
		if (match.matches()) {
			String curDir = new File("").getAbsolutePath();
			fname= args[3];
			File dir= new File(curDir);
			File aim= new File(fname);
			findfile(dir, aim, flag);
			if(flag[0]==0)
				System.out.println("File doesn`t exist!");
		}
	}
	public static void stdirect(String[] args) {
		String fname= new String();
		String dname= new String();
		dname= args[2];
		fname= args[3];
		System.out.println(dname);
		File dir= new File(dname);
		if(!dir.isDirectory()) {
			System.out.println("Directory doesn`t exist!");
			return;
		}
		else {
			File aim= new File(dir, fname);
			if(aim.exists())
				System.out.println("File exists!");
			else
				System.out.println("File doesn`t exist!");
		}	
	}
}
