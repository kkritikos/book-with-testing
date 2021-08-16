package book.search;

import com.intuit.karate.junit5.Karate;

public class SearchRunner
{
	@Karate.Test
    Karate testBasic() {
        return Karate.run("second").relativeTo(getClass());
    } 
}
