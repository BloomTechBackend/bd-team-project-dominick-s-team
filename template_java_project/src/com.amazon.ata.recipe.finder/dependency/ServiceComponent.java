package com.amazon.ata.recipe.finder.dependency;

import com.amazon.ata.recipe.finder.activity.CreateGroceryListActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {

    CreateGroceryListActivity provideCreateGroceryListActivity();
}
