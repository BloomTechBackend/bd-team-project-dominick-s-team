const container = document.querySelector(".wrapper");
const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');


window.onload = function(evt) {
  const staticRecipe = {
    id: 1,
    name: "tacos",
    author: "tommy",
    ingredients: "meat, torillas, sauce",
    instructions: [
      "cook meat",
      "add sauce",
      "put into tortillas and enjoy"
    ]
  }
    evt.preventDefault();
    console.log("Getting Recipe Data...");
    axios.get("http://localhost:8080/recipe/"+id)
    .then(res => {
      console.log(res);

        populateRecipe(res.data);
    })
     populateContact(staticRecipe);
  }

{ <div class="recipe-card">
<h2>Tacos</h2>
<p>tommy</p>
<p>meat, pasta, sauce</p>
<div class="instructions">
    <h2>instructions</h2>
    <ul>
        <li>boil noodles</li>
        <li>cook meat</li>
        <li>combine sauce with meat and noodle</li>
    </ul>   
</div>
</div> }
function populateContact(recipe) {
    const recipeDiv = document.createElement("div");
    const instructionsDiv = document.createElement("div");
    const ingredientsDiv = document.createElement("div");
    const recipeH2 = document.createElement("h2");
    const instructionsP = document.createElement("p");
    const instructionsText = document.createTextNode("instructions");
    const recipeText = document.createTextNode(recipe.recipe);
    const authorText = document.createTextNode(recipe.author);
    const ingredientsText = document.createTextNode(recipe.ingredients);
    const authorH2 = document.createElement("h2");
    const ingredientsP = document.createElement("p");
    const ul = document.createElement("ul");
    const instructions = [...recipe.instructions];

    for (let i = 0; i < instructions.length; i++) {
        let li = document.createElement("li");
        let text = document.createTextNode(instructions[i]);

        li.appendChild(text);
        ul.appendChild(li);
    }

    instructionsH2.appendChild(instructionsText);
    instructionsDiv.appendChild(ul);

    authorP.appendChild(authorText);
    ingredientsP.appendChild(ingredientsText);
    recipeH2.appendChild(recipeText);
    instructionsH2.appendChild(instructionsText);  


    // styles

    recipeDiv.setAttribute("class", "item recipe-card");
    authorP.setAttribute("class", "ui instructions");
    ingredientsDiv.setAttribute("class", "paragraph");
    instructionsDiv.setAttribute("class", "description");
    





    recipeDiv.appendChild(recipeH2);
    recipeDiv.appendChild(authorH2);
    recipeDiv.appendChild(ingredientsP);
    recipeDiv.appendChild(instructionsP);
    
    container.appendChild(recipeDiv);

}
