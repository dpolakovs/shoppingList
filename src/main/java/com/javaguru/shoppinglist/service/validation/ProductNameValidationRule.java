package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    private ProductInMemoryRepository repository;

    public ProductNameValidationRule(ProductInMemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull ( product );
        nameLengthValidation ( product.getName () );
        startsAndEndsWithValidation ( product.getName () );
        spacesCountValidation ( product.getName () );
        correctUseOfSpacesValidation ( product.getName () );
        invalidCharactersValidation ( product.getName () );
        uniqueNameValidation ( product );
    }

    @Override
    public void checkNotNull(Product product) {
        if (product.getName () == null) {
            throw new ProductValidationException ( "Product name must not be null!" );
        }
    }

    private void nameLengthValidation(String name) {
        if (name.length () < 3) {
            throw new ProductValidationException ( "Error! Name is too short." );
        }
        if (name.length () > 25) {
            throw new ProductValidationException ( "Error! Name is too long." );
        }
    }

    private void startsAndEndsWithValidation(String name) {
        if (name.startsWith ( " " )) {
            throw new ProductValidationException ( "Error! Name starts with a space." );
        }
        if (name.endsWith ( " " )) {
            throw new ProductValidationException ( "Error! Name ends with a space." );
        }
    }

    private void spacesCountValidation(String name) {
        char[] charArray = name.toCharArray ();
        int spacesCount = 0;

        for (char character : charArray) {
            if (character == ' ') {
                spacesCount++;
            }
            if (spacesCount > 3) {
                throw new ProductValidationException ( "Error! Name contains too much spaces." );
            }
        }
    }

    private void correctUseOfSpacesValidation(String name) {
        char[] charArray = name.toCharArray ();
        boolean previousSpace = false;

        for (char character : charArray) {
            if ((character == ' ') && (previousSpace)) {
                throw new ProductValidationException ( "Error! Spaces in the name go one by one" );
            } else {
                previousSpace = character == ' ';
            }
        }
    }

    private void invalidCharactersValidation(String name) {
        char[] charArray = name.toCharArray ();

        for (char character : charArray) {
            if (character > 32 && character < 48) {
                throw new ProductValidationException ( "Error! Name contains invalid characters" );
            }
            if (character > 57 && character < 65) {
                throw new ProductValidationException ( "Error! Name contains invalid characters" );
            }
            if (character > 90 && character < 97) {
                throw new ProductValidationException ( "Error! Name contains invalid characters" );
            }
            if (character > 122) {
                throw new ProductValidationException ( "Error! Name contains invalid characters" );
            }
        }
    }

    private void uniqueNameValidation(Product product) {
        if (repository.existsByName ( product.getName () )) {
            throw new ProductValidationException ( "Error! Product name should be unique" );
        }
    }
}



