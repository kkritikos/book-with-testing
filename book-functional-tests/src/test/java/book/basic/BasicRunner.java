package book.basic;

import com.intuit.karate.junit5.Karate;

public class BasicRunner
{
	@Karate.Test
    Karate testBasic() {
        return Karate.run("first").relativeTo(getClass());
    } 
}
