package be.bstorm.springbookmvc.il.validators;

import be.bstorm.springbookmvc.bll.models.BookFormBusiness;
import be.bstorm.springbookmvc.pl.models.book.BookForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BookWithAuthorValidator implements ConstraintValidator<BookWithAuthor, BookForm> {

    @Override
    public void initialize(BookWithAuthor constraintAnnotation) {
    }

    @Override
    public boolean isValid(BookForm b, ConstraintValidatorContext constraintValidatorContext) {
        return !(b.getAuthorId() == null && b.getAuthor() == null);
    }
}
