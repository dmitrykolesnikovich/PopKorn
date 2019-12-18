package cc.popkorn.example;

import cc.popkorn.core.Scope;
import cc.popkorn.annotations.InjectableProvider;

@InjectableProvider(scope=Scope.BY_USE)
public class MyInteger {

    public int create(){
        return 54;
    }

}
