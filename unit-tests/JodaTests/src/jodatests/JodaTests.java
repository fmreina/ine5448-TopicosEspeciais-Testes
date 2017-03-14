package jodatests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.joda.time.DateTimeConstants;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.junit.Test;

public class JodaTests {
	
	@Test (expected = IllegalFieldValueException.class)
	public void criarDataInvalida() throws Exception {
		new LocalDate(2017, 3, -5);
	}
	
	@Test
	public void criarDataValida() throws Exception {
		LocalDate data = new LocalDate(2017, 3, 14);
		assertEquals(14, data.getDayOfMonth());
		assertEquals(DateTimeConstants.MARCH, data.getMonthOfYear());
		assertEquals(2017, data.getYear());
	}
	
	@Test
	public void meiaNoite() throws Exception {
		LocalTime meiaNoite = new LocalTime(00,00, 00, 000);
		assertEquals(00, meiaNoite.getHourOfDay());
		assertEquals(00, meiaNoite.getMinuteOfHour());
		assertEquals(00, meiaNoite.getSecondOfMinute());
		assertEquals(000, meiaNoite.getMillisOfSecond());
	}
	
	@Test
	public void meioDia() throws Exception {
		LocalTime meioDia = new LocalTime(12,0);
		assertEquals("12:00:00.000", meioDia.toString());
	}
	
	@Test
	public void ultimaHora() throws Exception {
		LocalTime meiaNoite = new LocalTime(23,59, 59, 999);
		assertEquals(23, meiaNoite.getHourOfDay());
		assertEquals(59, meiaNoite.getMinuteOfHour());
		assertEquals(59, meiaNoite.getSecondOfMinute());
		assertEquals(999, meiaNoite.getMillisOfSecond());
	}
	
	@Test
	public void somaUmMinuto() throws Exception {
		LocalTime meioDia = new LocalTime(12,0);
		LocalTime meioDiaEUm = new LocalTime(12,1);
		assertEquals(meioDiaEUm, meioDia.plusMinutes(1));
	}
	
	@Test
	public void subtraiUmMinuto() throws Exception {
		LocalTime meioDia = new LocalTime(12,0);
		LocalTime meioDiaMenosUm = new LocalTime(11,59);
		assertEquals(meioDiaMenosUm, meioDia.minusMinutes(1));
	}
	
	@Test
	public void beforeDate() throws Exception {
		LocalDate date1 = new LocalDate(2017,3,14);
		LocalDate date2 = new LocalDate(2017,3,10);
		assertTrue(date1.isAfter(date2));
	}
	
	@Test
	public void dentroDoIntervalo() throws Exception {
		LocalDateTime min = new LocalDateTime(2017,3,1,0,0,0,001);
		LocalDateTime max = new LocalDateTime(2017,3,31,23,59,59,999);
		LocalDateTime data = new LocalDateTime(2017,3,12,10,0,0,0);
		assertTrue(data.isAfter(min));
		assertTrue(data.isBefore(max));
//		Interval intervalo = new Interval(min, max);
	}
}
