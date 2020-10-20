# Recipe search
## Project goal
This is a non-commercial hobby project that aims to create easy recipe search from "mojewypieki.com" blog based on available ingredients.
You have some flour, eggs, cocoa and don't know what you can bake with it? Search for ingredients and you'll get matching recipes. 
As the target blog is in polish, ingredients have to be in polish too.

## How to run
As this project is based on Spring Boot it will automatically start Tomcat with application when running RecipeSearchApplication class. 

## Current state
Currently crawler will fire every time we press search. It will take a lot of time to crawl through all recipes so crawling is limited to 50 recipes. 
Next step is to add a database and crawl the website once, store results in the database and serve it immediately after search from DB.
You can search by choosing ingredients form the list 
(only "kakao" for now; this is done to cover all form of polish words in the future eg. cukier puder =	puder|pudru) or by typing ingredients yourself.
Example search results:<insert screenshot>

## Milestones 
- [x] Find library and implement crawler - crawler4j chosen and implemented to crawl through mojewypieki.com recipes list
- [x] Create base index.ftlh with search field - select2 chosen based on research
- [x] Create search result cards ftlh
- [x] Connect crawler with frontend through controller
- [ ] Add database and store crawl results to avoid crawling with every request (crawl only on application start)
- [ ] Create regex matchers for most common ingredients to match multiple polish forms (cukier puder =	puder|pudru)
- [ ] Add scheduler to crawler to update results periodically
- [ ] Beautify main page, add header and footer.
- [ ] User accounts (to save favourites etc.)
