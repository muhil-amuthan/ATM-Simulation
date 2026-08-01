# 🏧 ATM Simulation System (Java)

A console-based **ATM Simulation** built in Java that mimics real-world ATM operations — account creation, secure login, cash withdrawal, deposits, balance inquiry, PIN management, and transaction receipts.

## 📌 Features
- **Create Account** — Register a new bank account with name, account number, PIN, and initial deposit.
- **Secure Login** — Authenticate using account number and 4-digit PIN.
- **Withdraw Cash** — Withdraw money with balance and daily withdrawal limit checks.
- **Deposit Cash** — Add funds to your account instantly.
- **Balance Inquiry** — Check your current available balance.
- **Change PIN** — Update your PIN after verifying the old one.
- **Transaction Receipt** — Auto-generated receipt with date, time, transaction type, amount, and remaining balance.
- **Daily Withdrawal Limit** — Prevents withdrawals beyond a set daily limit, reset on card removal.

## 🛠️ Tech Stack

- **Language:** Java (JDK 8+)
- **Core Concepts:** OOP (Classes & Objects), Collections (`ArrayList`), `Scanner` for I/O, `SimpleDateFormat` for timestamps

## 📂 Project Structure

```
ATMSimulation/
│
├── ATMSimulation.java   # Main class with menu, login, and account management logic
└── README.md
```

**Classes:**
- `BankAccount` — Models a bank account (holder name, account number, PIN, balance, withdrawal limits) with methods for deposit, withdrawal, balance check, PIN change, and receipt printing.
- `ATMSimulation` — Entry point with the main ATM home screen, account creation, login, and transaction menu.

## 🚀 Getting Started

### Prerequisites
- [Java JDK 8 or above](https://www.oracle.com/java/technologies/downloads/) installed
- A terminal / command prompt

### Compile & Run

```bash
# Clone the repository
git clone https://github.com/<your-username>/ATMSimulation.git
cd ATMSimulation

# Compile
javac ATMSimulation.java

# Run
java ATMSimulation
```

## 💻 Sample Usage

```
==== ATM Home Screen ====
1. Create Account
2. Insert Card (Login)
3. Exit
Select an option: 1

Enter Account Holder Name: Muhil
Enter Account Number: 1234567890
Set 4-digit PIN: 1234
Enter Initial Deposit: ₹5000
Account created successfully!
```

## 📈 Future Enhancements

- [ ] Persist account data using file handling or a database (MySQL/SQLite)
- [ ] Add password/PIN masking for input
- [ ] Support for fund transfers between accounts
- [ ] Mini statement / transaction history log
- [ ] GUI version using JavaFX or Swing

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](../../issues).

## 📄 License

This project is licensed under the [MIT License](LICENSE).

## 👤 Author

**Muhil Amuthan M**
Electronics and Communication Engineering | V.S.B. Engineering College
