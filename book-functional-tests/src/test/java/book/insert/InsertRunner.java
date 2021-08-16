package book.insert;

import com.intuit.karate.junit5.Karate;

public class InsertRunner
{
	@Karate.Test
    Karate testBasic() {
        return Karate.run("second").relativeTo(getClass());
    } 
}
