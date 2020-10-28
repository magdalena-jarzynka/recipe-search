# Recipe search
## Project goal
This is a non-commercial hobby project that aims to create easy recipe search from "mojewypieki.com" blog based on available ingredients.
You have some flour, eggs, cocoa and don't know what you can bake with it? Search for ingredients and you'll get matching recipes. 
As the target blog is in polish, ingredients have to be in polish too.

## How to run
As this project is based on Spring Boot it will automatically start Tomcat with application when running RecipeSearchApplication class. 

## Current state
Currently crawler will fire every time we press search. It will take a lot of time to crawl through all recipes so crawling is limited to ~90 recipes. 
Next step is to add a database and crawl the website once, store results in the database and serve it immediately after search from DB.

At this point you can search by choosing ingredients from the list.
Example search results:
  
![Screenshot from 2020-10-28 18-18-44](https://user-images.githubusercontent.com/63010423/97472519-3573fc00-194a-11eb-85c7-a7517d8665a6.png)
![Screenshot from 2020-10-28 18-19-21](https://user-images.githubusercontent.com/63010423/97472541-3ad14680-194a-11eb-87ad-72248e90f300.png)


## Milestones 
- [x] Find library and implement crawler - crawler4j chosen and implemented to crawl through mojewypieki.com recipes list
- [x] Create base index.ftlh with search field - select2 chosen based on research
- [x] Create search result cards ftlh
- [x] Connect crawler with frontend through controller
- [ ] Add database and store crawl results to avoid crawling with every request (crawl only on application start)
- [x] Create regex matchers for most common ingredients to match multiple polish forms (cukier puder =	puder|pudru)
- [ ] Add scheduler to crawler to update results periodically
- [x] Beautify main page, add header.
- [ ] User accounts (to save favourites etc.)
