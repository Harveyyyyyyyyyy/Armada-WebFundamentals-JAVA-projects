document.addEventListener('DOMContentLoaded', function() {
    let balance = 1000;
    let balanceElement = document.getElementById("balance");
    let amountInput = document.getElementById("amount");
    let depositButton = document.getElementById("deposit");
    let withdrawButton = document.getElementById("withdraw");
    let feedbackElement = document.getElementById("feedback");

    // balance display
    balanceElement.innerText = `Current Balance: $${balance}`;

    // deposit
    depositButton.addEventListener("click", function() {
        let amount = parseFloat(amountInput.value);
        if (isNaN(amount) || amount <= 0) {
            feedbackElement.innerText = "Please enter a valid amount.";
            feedbackElement.style.color = "red";
            return;
        }

        balance += amount;
        balanceElement.innerText = `Current Balance: $${balance}`;
        feedbackElement.innerText = `Deposited $${amount}`;
        feedbackElement.style.color = "green";
        amountInput.value = "";
    });

    // withdraw
    withdrawButton.addEventListener("click", function() {
        let amount = parseFloat(amountInput.value);
        if (isNaN(amount) || amount <= 0) {
            feedbackElement.innerText = "Please enter a valid amount.";
            feedbackElement.style.color = "red";
            return;
        }

        if (amount > balance) {
            feedbackElement.innerText = "Insufficient funds.";
            feedbackElement.style.color = "red";
            return;
        }

        balance -= amount;
        balanceElement.innerText = `Current Balance: $${balance}`;
        feedbackElement.innerText = `Withdrew $${amount}`
        feedbackElement.style.color = "green";
        amountInput.value = "";
    });
});