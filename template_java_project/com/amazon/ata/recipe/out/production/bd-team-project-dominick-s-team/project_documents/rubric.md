# [Dominick's Team] Project Rubric

## Background

*This captures the expectations that we have for your team during the unit.
This is how we will evaluate whether you have demonstrated these expectations.*

## Instructions

*As a team, complete this rubric (everything except for the Appendix) by
answering the questions below. Each question should usually only require one or
two sentences, so please be brief. The remainder of expectations will be
evaluated by instructors, so you don’t need to write anything in the Appendix.
We want you to see the full set of expectations for transparency’s sake.*

## Deliverables

*Provide links to the following project deliverables:*

| Deliverable                                                      |Due Date                  | Date Completed | URL                                                    |
|------------------------------------------------------------------|---                       |----------------|--------------------------------------------------------|
| Team name                                                        |Sprint 1 Module 1         | 6/1/2023       | name:       Dominick's Team                            |
| [Design Document - problem statement](design_document.md)        |Sprint 1 Module 2         | 6/1            |https://github.com/BloomTechBackend/bd-team-project-dominick-s-team/blob/c6204c0cca8f7f0990d86364a603a6d48333e810/template_java_project/com/amazon/ata/recipe/out/production/bd-team-project-dominick-s-team/project_documents/design_document.md |
| [Team Charter](team_charter.md)                                  |Sprint 1 Module 3         | 6/2            | https://github.com/BloomTechBackend/bd-team-project-dominick-s-team/blob/c6204c0cca8f7f0990d86364a603a6d48333e810/template_java_project/com/amazon/ata/recipe/out/production/bd-team-project-dominick-s-team/project_documents/team_charter.md                                                       |
| [Design Document](design_document.md)                            |Sprint 1 REQUIRED TO GO ON| 6/2            |https://github.com/BloomTechBackend/bd-team-project-dominick-s-team/blob/c6204c0cca8f7f0990d86364a603a6d48333e810/template_java_project/com/amazon/ata/recipe/out/production/bd-team-project-dominick-s-team/project_documents/design_document.md                                                        |
| Project Completion (Feature Complete)                            |Sprint 3                  | 6/20           |                                                        |
| [Team Reflection](reflection.md)                                 |Sprint 3                  | 6/20           |                                                        |
| [Accomplishment Tracking Dominick](accomplishment_tracking.md)   |Sprint 3                  | 6/20           |                                                        |
| Self Reflection                                                  |Sprint 3                  |                | n/a (will be submitted via Canvas - "Wrap-up" section) |

## Technical Learning Objectives

### API Design

**Design an API to meet the needs of your application.** Provide a link to the
definition for your endpoints (can be code/configuration, or can be
documentation). List one thing that your team learned about designing a good
API.
https://github.com/BloomTechBackend/bd-team-project-dominick-s-team/blob/1087caa1572c355d01afdda09b45855b56c3b96e/template_java_project/src/com/amazon/ata/recipe/finder/frontend/api.json


*Endpoint definition location:*       
*What we learned:*    

**Develop a service endpoint definition that uses complex inputs and outputs.**
Select one of your endpoints and list the operation’s input and output objects.
Under each, list its attributes.

*GET/GetRecipe:*     
*Input objects:*      
name: name of recipe to be found

*Output object(s):*
* attribute 1 : recipe name
* attribute 2 : recipe author
* attribute 3: recipe ingredients
* attribute 4 : recipe instructions

*GET/GroceryList:*     
*Input objects:*      
date: date grocery list was written

*Output object(s):*
* attribute 1 : grocery list date
* attribute 2 : grocery list items

*PUT/GroceryList:*     
*Input objects:*      
date: date on which list was created

*Output object(s):*
* attribute 1 : grocery list date
* attribute 2 : grocery list items    



**Given a user story that requires a user to provide values to a service
endpoint, design a service endpoint including inputs, outputs, and errors.**
Select one of your endpoints that accepts input values from a client. List the
error cases you identified and how the service responds in each case. Provide at
most 3 error cases.

| **Endpoint:**  |                      |
|----------------|----------------------|
| **Error case** | **Service response** |
| user error     | 400:invalid inputs   |
| server error   | 500: server error     |
|                |                      |

**Develop a service endpoint definition that uses query parameters to determine
how results are sorted or filtered.** List at least one endpoint that allows
sorting or filtering of results. Which attribute(s) can be sorted/filtered on?

*Endpoint:* 
GET/Recipe
*Attribute(s):*  
names of recipes can be sorted by authors
**Determine whether a given error condition should result in a client or server
exception.** List one client exception and one server exception that your
service code throws. List one condition in which this exception is thrown.

|                       | **Exception**            | **One case in which it is thrown**                         |
|---	                |--------------------------|------------------------------------------------------------|
|**Client exception:**  | RecipeNotFoundException	 | if the given recipe doesnt match any in the database	      |
|**Service exception:** | DynamoDBException 	      | the user tries to creat a recipe without gicen authority 	 |

### DynamoDB Table Design

**Decompose a given set of use cases into a set of DynamoDB tables that provides
efficient data access.** List the DynamoDB tables in your project:

1.  Recipe
2.  GroceryList
3. 


**Design a DynamoDB table key schema that allows items to be uniquely
identified.** Describe the primary key structure for your DynamoDB table with
the most interesting primary key. In a sentence or two, explain your choice of
partition/sort key(s).

1. For the groceryList table I decided it would be best to find them by the date. the reason being that a grocery
list doesn't have a label so the ontly way to find one would have tobe with the date

**Design the attributes of a DynamoDB table given a set of use cases.** List a
DynamoDB table with at least 3 attributes. List one relevant use case that uses
the attribute. In one sentence, describe why the attribute is included.
1.Recipe:
* i included the ingredients in the table. i did this so that in the future the table can be used to find a recipe with that list rather than jsut by name
**Table name:**   
 
**Attributes:**

|Attribute name |(One) relevant use case |attribute purpose |
|ingredients           |finding by item list                     |give a list of needed ingredients              |
|recipeName               |finding an item by name                        |keep track of the recipe names                  |
|author               |recipes can be organized by author                        |makes gsi easier                  |

### DynamoDB Indexes

**Design a GSI key schema and attribute projection that optimizes queries not
supported by a provided DynamoDB table.** In one or two sentences, explain why
you created one of the GSIs that your project uses, including one use case that
uses that index.

**Table name:**
Recipe table

**Table keys:**
Partition key: recipeName 
**GSI keys:**
Partition key: author
**Use case for GSI:**
int the case that you hae a specific cook you can sort recipes so their name comes first
**Implement functionality that uses query() to retrieve items from a provided
DynamoDB's GSI.** List one of your use cases that uses `query()` on a GSI.

**Table name:**
Recipe
**Use case for `query()` on GDI:**
aws dynamodb query \
--table-name Recipe \
--index-name author-index \
--key-condition-expression "author = :name" \
--expression-attribute-values  '{":name":{"S":"Tommy"}}'
## Soft(er) Outcomes

**Learn a new technology.** For each team member, list something new that that
team member learned:

|Team Member |Something new the team member learned |   
|Dominick  |I learned how to design on the front end. I also learned how to add dependencies, troubleshoot dynamoDB problems, and write my own app from start to finish(in a total of 86 hours)|


**Identify keywords to research to accomplish a technical goal | Use sources
like sage and stack overflow to solve issues encountered while programming.**
Give an example of a search term that your team might have used to find an
answer to a technical question/obstacle that your team ran into. List the
resource that you found that was helpful.

     
**Helpful resource:**      
Stack overflow and Web3Schools were my main two resources
**Find material online to learn new technical topics.** List one resource that
your team found on your own that helped you on your project.
Web3Schools has some really helpful articles on different functions for writing database apps



