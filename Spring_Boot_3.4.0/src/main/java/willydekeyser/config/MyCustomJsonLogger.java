package willydekeyser.config;

import org.springframework.boot.json.JsonWriter;
import org.springframework.boot.logging.structured.StructuredLogFormatter;

import ch.qos.logback.classic.spi.ILoggingEvent;

public class MyCustomJsonLogger implements StructuredLogFormatter<ILoggingEvent> {

	private final JsonWriter<ILoggingEvent> writer = JsonWriter.<ILoggingEvent>of((logItems) -> {
        logItems.add("level", ILoggingEvent::getLevel);
        logItems.add("time", ILoggingEvent::getTimeStamp);
        logItems.add("message", ILoggingEvent::getFormattedMessage);
        logItems.add("applicationInfo").usingMembers((applicationInfo) -> {
            applicationInfo.add("name", "StructuredLoggingApplication");
            applicationInfo.add("version", "1.0.0");
        });

    }).withNewLineAtEnd();
	
	@Override
	public String format(ILoggingEvent event) {
		return this.writer.writeToString(event);
	}

}
