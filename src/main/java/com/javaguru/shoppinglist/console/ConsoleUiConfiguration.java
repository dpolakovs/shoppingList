package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.action.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
class ConsoleUiConfiguration {
    @Autowired
    private Action createProductAction;
    @Autowired
    private Action findProductByIdAction;
    @Autowired
    private  Action changeProductNameAction;
    @Autowired
    private  Action changeProductPriceAction;
    @Autowired
    private  Action deleteProductAction;
    @Autowired
    private  Action exitAction;
    @Autowired
    private Action createShoppingCartAction;
    @Autowired
    private Action assignProductAction;


    @Bean
    ConsoleUi consoleUi() {
        List<Action> actions = new ArrayList<> ();
        actions.add ( createProductAction );
        actions.add ( findProductByIdAction );
        actions.add ( changeProductNameAction );
        actions.add ( changeProductPriceAction );
        actions.add ( deleteProductAction );
        actions.add (createShoppingCartAction);
        actions.add(assignProductAction);
        actions.add ( exitAction );
        return new ConsoleUi ( actions );
    }
}
