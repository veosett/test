package com.example.quote.validator;

import java.util.*;

public class ValidationFailedResponse {
    private List<ViolationErrors> violations = new ArrayList<>();
    public List<ViolationErrors> getViolations() {
        return violations;
    }
    public void setViolations(List<ViolationErrors> violations) {
        this.violations = violations;
    }
}
