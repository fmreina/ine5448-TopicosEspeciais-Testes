package hamcrestTests;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.hamcrest.number.BigDecimalCloseTo;
import org.junit.Test;


public class HamcrestTests {

	// basic hamcrest matchers
	@Test
	public void objectMatcher(){
		// string
		assertThat("João", is(equalTo("João")));
	}
	
	@Test
	public void objectMatcherFail(){
		// string
		assertThat("João", is(equalTo("João")));
	}
	
	@Test
	public void numberMatcher(){
		Integer valor = 10;
		assertThat(valor, allOf(lessThan(12), greaterThan(6)));
	}
	
	@Test
	public void numberMatcher2(){
		BigDecimal _315 = new BigDecimal(315);
		BigDecimal _314 = new BigDecimal(314);
		assertThat(_314, new BigDecimalCloseTo(_315, new BigDecimal(1)));
	}
	
	@Test
	public void textMatcher(){
		assertThat("João Maria", equalToIgnoringCase("joãO mariA"));
	}
	
	@Test
	public void arraymatcher(){
	}
	
	@Test
	public void testAnyOf(){
		String frase = "teste do anyOf";
		assertThat(frase, anyOf(equalToIgnoringCase("blah blah"), containsString("anyOf")));
	}
	
	// Custom hamcrest matchers
	// ...
}

