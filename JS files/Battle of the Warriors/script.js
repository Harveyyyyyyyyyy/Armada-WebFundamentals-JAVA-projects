let luffy = {
    name: "Luffy",
    hp: 100,
    strength: 10,
    attack: function () {
        return Math.floor(Math.random() * (this.strength));
    }
}

let kaido = {
    name: "Kaido",
    hp: 100,
    strength: 10,
    attack: function () {
        return Math.floor(Math.random() * (this.strength));
    }
}

for (let round = 1; round <= 10; round++) {
    console.log(`=== Round ${round} ===`);

    let luffyAttack = luffy.attack();
    kaido.hp = kaido.hp - luffyAttack;
    if (kaido.hp < 0) {
        kaido.hp = 0;
    }
    console.log(`${luffy.name} attacks ${kaido.name} and does ${luffyAttack} damage!`);
    console.log(`${luffy.name} HP: ${luffy.hp} | ${kaido.name} HP: ${kaido.hp}`);

    console.log(` `)

    let kaidoAttack = kaido.attack();
    luffy.hp = luffy.hp - kaidoAttack;
    if (luffy.hp < 0) {
        luffy.hp = 0;
    }
    console.log(`${kaido.name} attacks ${luffy.name} and does ${kaidoAttack} damage!`);
    console.log(`${luffy.name} HP: ${luffy.hp} | ${kaido.name} HP: ${kaido.hp}`);

    if (luffy.hp === 0 || kaido.hp === 0) break;
    console.log(` `)
}

if (luffy.hp > kaido.hp) {
    console.log(`🏆 ${luffy.name} WINS the battle! 🏆`);
} else if (kaido.hp > luffy.hp) {
    console.log(`🏆 ${kaido.name} WINS the battle! 🏆`);
} else {
    console.log(`It's a draw!`);
}