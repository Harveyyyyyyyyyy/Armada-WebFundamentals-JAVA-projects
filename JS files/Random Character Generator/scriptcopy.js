let character = {
    name: "Hero",
    health: 100,
    class: ["Warrior", "Mage", "Archer", "Healer", "Assasin"],
    randomizedHealth(){
        let randomized = Math.floor(Math.random() * 100) + 50
        return randomized;
    },
    specialAbility: ["Fireball", "Healing Touch", "Stealth", "Lightning Strike", "Power Slash"]
}
function generateCharacter(name){
    let names = ["Thorin", "Elara", "Zane", "Ivy", "Dante"];
    let newCharacterObject = {
        randomName : names[Math.floor(Math.random() * names.length)],
        classes : character.class[Math.floor(Math.random() * character.class.length)],
        randomHealth : character.randomizedHealth(),
        randomSpecialAbility : character.specialAbility[Math.floor(Math.random() * character.specialAbility.length)],
    }
    return newCharacterObject
}
// console.log(character.randomizedHealth());
console.log(generateCharacter().randomSpecialAbility)