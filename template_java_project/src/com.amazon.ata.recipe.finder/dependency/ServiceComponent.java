package com.amazon.ata.recipe.finder.dependency;

import com.amazon.ata.recipe.finder.activity.CreateGroceryListActivity;
import com.amazon.ata.recipe.finder.activity.GetGroceryListActivity;
import com.amazon.ata.recipe.finder.activity.GetRecipeActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {

    CreateGroceryListActivity provideCreateGroceryListActivity();

    GetGroceryListActivity provideGetGroceryListActivity();

    GetRecipeActivity provideGetRecipeActivity();
}
