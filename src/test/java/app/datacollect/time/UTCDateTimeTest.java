package app.datacollect.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class UTCDateTimeTest {

  private UTCDateTime time;

  @Before
  public void setup() {
    this.time = UTCDateTime.of("2019-01-01T12:00:00Z");
  }

  @Test
  public void now_should_return_instance_of_class() {
    assertNotNull(UTCDateTime.now());
  }

  @Test
  public void when_nothing_is_changed_should_return_original_value() {
    assertEquals("2019-01-01T12:00:00Z", time.iso8601());
  }

  @Test
  public void year_should_return_expected_value() {
    assertEquals(2019, time.year());
  }

  @Test
  public void month_should_return_expected_value() {
    assertEquals(1, time.month());
  }

  @Test
  public void when_second_is_added_should_return_expected_value() {
    assertEquals("2019-01-01T12:00:01Z", time.plusSeconds(1).iso8601());
  }

  @Test
  public void when_minute_is_added_should_return_expected_value() {
    assertEquals("2019-01-01T12:01:00Z", time.plusMinutes(1).iso8601());
  }

  @Test
  public void when_hour_is_added_should_return_expected_value() {
    assertEquals("2019-01-01T13:00:00Z", time.plusHours(1).iso8601());
  }

  @Test
  public void when_day_is_added_should_return_expected_value() {
    assertEquals("2019-01-02T12:00:00Z", time.plusDays(1).iso8601());
  }

  @Test
  public void when_second_is_subtracted_should_return_expected_value() {
    assertEquals("2019-01-01T11:59:59Z", time.minusSeconds(1).iso8601());
  }

  @Test
  public void when_minute_is_subtracted_should_return_expected_value() {
    assertEquals("2019-01-01T11:59:00Z", time.minusMinutes(1).iso8601());
  }

  @Test
  public void when_hour_is_subtracted_should_return_expected_value() {
    assertEquals("2019-01-01T11:00:00Z", time.minusHours(1).iso8601());
  }

  @Test
  public void when_day_is_subtracted_should_return_expected_value() {
    assertEquals("2018-12-31T12:00:00Z", time.minusDays(1).iso8601());
  }

  @Test
  public void when_second_is_added_should_return_expected_duration() {
    assertEquals(1, UTCDateTime.between(time, time.plusSeconds(1)).toSeconds());
  }

  @Test
  public void when_minute_is_added_should_return_expected_duration() {
    assertEquals(1, UTCDateTime.between(time, time.plusMinutes(1)).toMinutes());
  }

  @Test
  public void when_hour_is_added_should_return_expected_duration() {
    assertEquals(1, UTCDateTime.between(time, time.plusHours(1)).toHours());
  }

  @Test
  public void when_day_is_added_should_return_expected_duration() {
    assertEquals(1, UTCDateTime.between(time, time.plusDays(1)).toDays());
  }

  @Test
  public void when_second_is_subtracted_should_return_expected_duration() {
    assertEquals(-1, UTCDateTime.between(time, time.minusSeconds(1)).toSeconds());
  }

  @Test
  public void when_minute_is_subtracted_should_return_expected_duration() {
    assertEquals(-1, UTCDateTime.between(time, time.minusMinutes(1)).toMinutes());
  }

  @Test
  public void when_hour_is_subtracted_should_return_expected_duration() {
    assertEquals(-1, UTCDateTime.between(time, time.minusHours(1)).toHours());
  }

  @Test
  public void when_day_is_subtracted_should_return_expected_duration() {
    assertEquals(-1, UTCDateTime.between(time, time.minusDays(1)).toDays());
  }

  @Test
  public void when_creating_optional_instance_from_string_should_return_instance() {
    Optional<UTCDateTime> created = UTCDateTime.ofNullable("2019-01-01T12:00:00Z");
    assertTrue(created.isPresent());
    assertEquals(time.getInstant(), created.get().getInstant());
  }

  @Test
  public void when_creating_optional_instance_from_null_string_should_return_optional_empty() {
    assertTrue(UTCDateTime.ofNullable(null).isEmpty());
  }
}
