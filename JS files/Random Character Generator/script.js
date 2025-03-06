let character = {
    name: "Hero",
    health: 100,
    class: ["Warrior", "Mage","Archer", "Healer", "Assasin"],
    randomizedHealth() {
        let randomHealth = Math.floor(Math.random() * 100) + 50
        return randomHealth;
    },
    specialAbility: ["Fireball", "Healing Touch", "Stealth", "Lightning Strike", "Power Slash"],
}
function generateCharacter(nameInput) {
    let names = ["Thorin", "Elara", "Zane", "Ivy", "Dante"];
    let newCharacterObject = {
        randomNames: nameInput ? nameInput : names[Math.floor(Math.random() * names.length)],
        randomHealth: character.randomizedHealth(),
        randomSpecialAbility: character.specialAbility[Math.floor(Math.random() * character.specialAbility.length)],
        battle(otherCharacter) {
            console.log(`Character ${this.randomNames} attacked Character ${otherCharacter.randomNames} with ${this.randomSpecialAbility}`)
        }
    }
    return newCharacterObject;
}
let character1 = generateCharacter("Zane");
let character2 = generateCharacter("Elara");
character1.battle(character2);

function generateMultipleCharacter(x) {
    let multipleCharacter = [];
    for (let i = 0; i < x; i++) {
        multipleCharacter.push(generateCharacter());
    }
    return multipleCharacter;
}

let party = generateMultipleCharacter(5);
console.log(party);