package com.example.quote.validator;

import com.example.quote.enitity.Quote;
import org.springframework.stereotype.Component;

import javax.validation.*;

/**
 TODO add java docs
 */
@Component
public class QuoteValidator implements ConstraintValidator<QuoteConstraint, Quote> {
    private static final int NUMBER_OF_ISIN = 12;

    /**
     * This Validator validates Quote instances
     */
    @Override
    public boolean isValid(Quote quote, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (quote == null) {
            context.buildConstraintViolationWithTemplate("quote равно null.")
                    .addConstraintViolation();
            return false;
        }

        boolean valid = true;
        if (quote.getIsin() == null) {
            context.buildConstraintViolationWithTemplate("isin равно null.")
                    .addConstraintViolation();
            return false;
        }
        if (quote.getIsin().length() != NUMBER_OF_ISIN) {
            context.buildConstraintViolationWithTemplate( "isin должно быть 12 символов." )
                    .addConstraintViolation();
            valid = false;
        }
        if (quote.getBid() == null) {
            context.buildConstraintViolationWithTemplate("bid равно null.")
                    .addConstraintViolation();
            return false;
        }
        if (quote.getAsk() == null) {
            context.buildConstraintViolationWithTemplate("ask равно null.")
                    .addConstraintViolation();
            return false;
        }
        if (quote.getBid() > quote.getAsk()) {
            context.buildConstraintViolationWithTemplate("ask должно быть больше чем bid.")
                    .addConstraintViolation();
            valid = false;
        }

        return valid;
    }
}
