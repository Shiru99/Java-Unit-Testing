package io.fall.setup;

import java.time.LocalDate;

public interface ReferenceIdsManager {
    String obtainId(String firstName, String middleName, String lastName, String taxId, LocalDate dob);
}
