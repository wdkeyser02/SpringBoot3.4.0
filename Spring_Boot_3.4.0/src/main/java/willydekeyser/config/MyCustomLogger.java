package willydekeyser.config;

import org.springframework.boot.logging.structured.StructuredLogFormatter;

import ch.qos.logback.classic.spi.ILoggingEvent;

public class MyCustomLogger implements StructuredLogFormatter<ILoggingEvent> {

	@Override
	public String format(ILoggingEvent event) {
		return "level=" + event.getLevel() +
                " time=" + event.getTimeStamp() +
                " message=" + event.getMessage() +
                " timestamp=" + event.getTimeStamp() + "\n";
	}

}
