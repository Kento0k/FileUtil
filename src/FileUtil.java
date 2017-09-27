import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FileUtil {

	public static void main(String[] args) {
		Pattern cmp= Pattern.compile("^find$");
		Matcher match= cmp.matcher(args[0]);
		if(!match.matches()) {
			System.out.println("Wrong input!");
			return;
		}
		cmp= Pattern.compile("^(-r|-d|--)$");
		match= cmp.matcher(args[1]);
		if(!match.matches()) {
			System.out.println("Wrong input!");
			return;
		}
		cmp= Pattern.compile("^-r$");
		match= cmp.matcher(args[1]);
		if (match.matches())
			Fwork.subdirect(args);
		cmp= Pattern.compile("^--$");
		match= cmp.matcher(args[1]);
		if (match.matches())
			Fwork.defdirect(args);
		cmp= Pattern.compile("^-d$");
		match= cmp.matcher(args[1]);
		if (match.matches())
			Fwork.stdirect(args);
	}

}
