package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.action.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
class ConsoleUiConfiguration {
    private final Action createProductAction;
    private final Action findProductByIdAction;
    private final Action changeProductNameAction;
    private final Action changeProductPriceAction;
    private final Action deleteProductAction;
    private final Action exitAction;

    @Autowired
    public ConsoleUiConfiguration(Action createProductAction ,
                                  Action findProductByIdAction ,
                                  Action changeProductNameAction ,
                                  Action changeProductPriceAction ,
                                  Action deleteProductAction ,
                                  Action exitAction) {
        this.createProductAction = createProductAction;
        this.findProductByIdAction = findProductByIdAction;
        this.changeProductNameAction = changeProductNameAction;
        this.changeProductPriceAction = changeProductPriceAction;
        this.deleteProductAction = deleteProductAction;
        this.exitAction = exitAction;
    }


    @Bean
    ConsoleUi consoleUi() {
        List<Action> actions = new ArrayList<> ();
        actions.add ( createProductAction );
        actions.add ( findProductByIdAction );
        actions.add ( changeProductNameAction );
        actions.add ( changeProductPriceAction );
        actions.add ( deleteProductAction );
        actions.add ( exitAction );
        return new ConsoleUi ( actions );
    }
}
