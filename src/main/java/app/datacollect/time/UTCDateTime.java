package app.datacollect.time;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class UTCDateTime {
  private final Instant instant;

  public UTCDateTime() {
    this.instant = Instant.now();
  }

  public UTCDateTime(Instant instant) {
    this.instant = instant;
  }

  public static UTCDateTime now() {
    return new UTCDateTime();
  }

  public static UTCDateTime of(String iso8601String) {
    return new UTCDateTime(Instant.parse(iso8601String));
  }

  public static Optional<UTCDateTime> ofNullable(String iso8601String) {
    if (iso8601String == null) {
      return Optional.empty();
    }
    return Optional.of(new UTCDateTime(Instant.parse(iso8601String)));
  }

  public static Duration between(UTCDateTime from, UTCDateTime to) {
    return Duration.between(from.getInstant(), to.getInstant());
  }

  public int year() {
    return instant.atZone(ZoneId.of("UTC")).getYear();
  }

  public int month() {
    return instant.atZone(ZoneId.of("UTC")).getMonthValue();
  }

  public Instant getInstant() {
    return instant;
  }

  public String iso8601() {
    return instant.toString();
  }

  public UTCDateTime minusDays(int days) {
    return new UTCDateTime(instant.minus(days, ChronoUnit.DAYS));
  }

  public UTCDateTime minusHours(int hours) {
    return new UTCDateTime(instant.minus(hours, ChronoUnit.HOURS));
  }

  public UTCDateTime minusMinutes(int minutes) {
    return new UTCDateTime(instant.minus(minutes, ChronoUnit.MINUTES));
  }

  public UTCDateTime minusSeconds(int seconds) {
    return new UTCDateTime(instant.minusSeconds(seconds));
  }

  public UTCDateTime minusMilliseconds(int milliseconds) {
    return new UTCDateTime(instant.minusMillis(milliseconds));
  }

  public UTCDateTime plusDays(int days) {
    return new UTCDateTime(instant.plus(days, ChronoUnit.DAYS));
  }

  public UTCDateTime plusHours(int hours) {
    return new UTCDateTime(instant.plus(hours, ChronoUnit.HOURS));
  }

  public UTCDateTime plusMinutes(int minutes) {
    return new UTCDateTime(instant.plus(minutes, ChronoUnit.MINUTES));
  }

  public UTCDateTime plusSeconds(int seconds) {
    return new UTCDateTime(instant.plusSeconds(seconds));
  }

  public UTCDateTime plusMilliseconds(int milliseconds) {
    return new UTCDateTime(instant.plusMillis(milliseconds));
  }
}
