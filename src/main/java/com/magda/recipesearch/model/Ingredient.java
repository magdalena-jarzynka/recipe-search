package com.magda.recipesearch.model;

public enum Ingredient {

    MILK("mleko", "mleka( ? ! [A-z])"),
    SUGAR("cukier", " (?<!(wego|bez|jego) )cukru((?! [A-z])| do)"),
    BUTTER("masło", "masła(?! [A-z])"),
    WHEAT_FLOUR("mąka pszenna", "mąki\\n|(pszennej|tortowej)"),
    EGGS("jajka", "jaj(ka|ko|ek)"),
    HEAVY_CREAM("śmietana kremówka 30%/36%", "śmietany kremówki"),
    COTTAGE_CHEESE("twaróg", "twarogu"),
    COCOA("kakao", "\bkakao\b"),
    POTATO_FLOUR("mąka ziemniaczana", "ziemniaczanej"),
    MILK_CHOCOLATE("czekolada mleczna", "mlecznej|mleczna"),
    WHITE_CHOCOLATE("czekolada biała", "białej.+czekolady|czekolady.+białej"),
    DARK_CHOCOLATE("czekolada gorzka", "gorzkiej.+czekolady|czekolady.+gorzkiej"),
    POWDERED_SUGAR("cukier puder", "puder|pudru"),
    VANILLA_EXTRACT("ekstrakt z wanilii", "ekstrakt.+ wanilii"),
    MASCARPONE("mascarpone", "mascarpone"),
    BAKING_POWDER("proszek do pieczenia", "proszku do pieczenia"),
    YOGHURT("jogurt naturalny/grecki", "jogurt"),
    NUTELLA("nutella", "nutell");

    private final String displayName;
    private final String regex;

    Ingredient(String displayName, String regex) {
        this.displayName = displayName;
        this.regex = regex;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getRegex() {
        return regex;
    }

    public static Ingredient mapDisplayNameToIngredient (String displayName) {
        for (Ingredient ingredient : values()) {
            if (ingredient.displayName.equals(displayName)) {
                return ingredient;
            }
        }
        return null;
    }
}
