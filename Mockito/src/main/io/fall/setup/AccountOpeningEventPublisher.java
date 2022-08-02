package io.fall.setup;

public interface AccountOpeningEventPublisher {

    void notify(String accountId);
}
