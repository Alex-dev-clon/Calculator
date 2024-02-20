package model.repository;

import java.io.IOException;

public interface EventListener {
    void update (String eventType) throws IOException;
}
