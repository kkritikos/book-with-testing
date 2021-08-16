package book.remove;

import com.intuit.karate.junit5.Karate;

public class RemoveRunner
{
	@Karate.Test
    Karate testBasic() {
        return Karate.run("second").relativeTo(getClass());
    } 
}
