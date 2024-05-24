# ATM Simulation Program

This Java program simulates a simple ATM machine where users can perform basic banking operations such as checking their balance, crediting (depositing) money, debiting (withdrawing) money, and printing a receipt of their last transaction. The program includes basic security features like PIN verification and allows multiple attempts for the user to input the correct PIN.

## Features

- **PIN Verification**: Ensures secure access to the ATM functions. Users have three attempts to enter the correct PIN.
- **Balance Inquiry**: Users can check their current account balance.
- **Credit Amount**: Users can deposit money into their account. Negative values are not allowed.
- **Debit Amount**: Users can withdraw money from their account, provided they have sufficient balance. Negative values are not allowed.
- **Receipt Generation**: Users can print a receipt showing their current balance and the last transaction performed.
- **User-Friendly Prompts**: Clear instructions and feedback for user actions.

## Security Considerations

- **PIN Hashing**: PINs are hashed using SHA-256 for secure storage and comparison.
- **Multiple Attempts**: Users are allowed up to three attempts to enter the correct PIN before the program exits.
- **Input Validation**: Ensures only valid inputs are processed to avoid unexpected behavior or crashes.

## How to Run

1. **Clone the repository**:
    ```sh
    git clone https://github.com/your-username/atm-simulation.git
    cd atm-simulation
    ```

2. **Compile the Java program**:
    ```sh
    javac ATM_MAIN.java
    ```

3. **Run the program**:
    ```sh
    java ATM_MAIN
    ```

## Example Usage

Upon running the program, you will be prompted to enter your PIN and name. Once authenticated, you can choose from the following options:

1. **Check Balance**: Displays the current account balance.
2. **Credit Amount**: Prompts you to enter an amount to deposit into your account.
3. **Debit Amount**: Prompts you to enter an amount to withdraw from your account.
4. **Get Receipt**: Displays a receipt of your current balance and the last transaction.
5. **Exit**: Ends the session.

```sh
Enter your pin number:
1234
Enter your name:
John
Welcome John
Press 1 to check balance
Press 2 to credit amount
Press 3 to debit amount
Press 4 to get receipt
Press 5 to exit
