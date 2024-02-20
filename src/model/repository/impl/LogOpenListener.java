package model.repository.impl;

import model.repository.EventListener;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
Логгер наблюдатель
 */
public class LogOpenListener implements EventListener {

    FileWriter writer = new FileWriter("log.txt", false);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public LogOpenListener() throws IOException {
    }

    @Override
    public void update(String eventType) throws IOException {
        Calendar calendar = new GregorianCalendar();
        writer.write(dateFormat.format(calendar.getTime()) + " " + eventType + "\n");
        writer.flush();
    }
}
