document.addEventListener('DOMContentLoaded', function() {
    let balance = 1000;
    let balanceElement = document.getElementById("balance");
    let amountInput = document.getElementById("amount");
    let depositButton = document.getElementById("deposit");
    let withdrawButton = document.getElementById("withdraw");
    let feedbackElement = document.getElementById("feedback");
    let transactionHistoryElement = document.getElementById("transaction-history");
    let dailyWithdrawalLimit = 500;
    let today = new Date().toLocaleDateString();
    let withdrawalsToday = 0;

    // Balance display
    balanceElement.innerText = `Current Balance: $${balance}`;

    // Transaction history
    function addTransactionToHistory(type, amount) {
        let listItem = document.createElement("li");
        listItem.innerText = `${type}: $${amount}`;
        transactionHistoryElement.appendChild(listItem);
    }

    // Deposit
    depositButton.addEventListener("click", function() {
        let amount = parseFloat(amountInput.value);
        if (isNaN(amount) || amount <= 0) {
            feedbackElement.innerText = "Please enter a valid amount.";
            feedbackElement.style.color = "red";
            return;
        }

        balance += amount;
        balanceElement.innerText = `Current Balance: $${balance}`;
        feedbackElement.innerText = `Deposited $${amount}.`;
        feedbackElement.style.color = "green";
        addTransactionToHistory("Deposit", amount);
        amountInput.value = "";
    });

    // Withdraw
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

        if (amount + withdrawalsToday > dailyWithdrawalLimit) {
            feedbackElement.innerText = "Daily withdrawal limit exceeded.";
            feedbackElement.style.color = "red";
            return;
        }

        balance -= amount;
        balanceElement.innerText = `Current Balance: $${balance}`;
        feedbackElement.innerText = `Withdrew $${amount}.`;
        feedbackElement.style.color = "green";
        addTransactionToHistory("Withdrawal", amount);
        withdrawalsToday += amount;
        amountInput.value = "";
    });
});
