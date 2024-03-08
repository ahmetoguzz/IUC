#include <iostream>
#include <vector>

using namespace std;

int main(){ 
    
    char selection {};
    vector<int> numbers {};
    
    cout << "Enter your choice: ";
    
    
    do {
        cout << "\n----------------" <<endl;
        cout << "P - Print numbers"<<endl;
        cout << "A - Add a number"<<endl;
        cout << "M - Display mean of the numbers"<<endl;
        cout << "S - Display the smallest number"<<endl;
        cout << "L - Display the largest number"<<endl;
        cout << "Q - Quit\n" << endl;
        
        
        cin >> selection;
        cout << endl;
        
        if (selection == 'p' || selection == 'P')
            if (numbers.size() == 0)
                cout << "There is no value in the list.";
            else{
            for (auto all_numbers: numbers)
                cout << all_numbers << " ";
            }    
        else if (selection == 'a' || selection == 'A'){
            cout << "\nPlease enter the number you want to add to the list: ";
            int add {};
            cin >> add;
            numbers.push_back(add);
            
        } else if (selection == 'm' || selection == 'M'){
            if (numbers.size() == 0)
                cout << "There is no value in the list.";
            else {
            double sum {}, mean {};
            for (auto all_numbers: numbers)
                sum = sum + all_numbers;
            mean = sum / numbers.size();
            cout << "Mean is: " << mean;
            }
        } else if (selection == 's' || selection == 'S'){
            if (numbers.size() == 0)
                cout << "There is no value in the list.";
            else {
            int smallest = numbers.at(0);
            for (auto all_numbers: numbers)
                if (all_numbers < smallest)
                    smallest = all_numbers;
            cout << "The smallest number is: " << smallest;
            }
        } else if (selection == 'l' || selection == 'L'){
            if (numbers.size() == 0)
                cout << "There is no value in the list.";
            else {
            int largest = numbers.at(0);
            for (auto all_numbers: numbers)
                if (all_numbers > largest)
                    largest = all_numbers;
            cout << "The largest number is: " << largest;
            }
        } else {
            if (selection == 'q' || selection == 'Q')
                cout << "Goodbye!";
            else
            cout << "Invalid value. Please try again.";
        }
        
        
        
        
        
    } while (selection != 'q' && selection != 'Q');
    
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <string>


using namespace std;

int main (){
    string alphabet {"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"};
    string key {"XZNLWEBGJHQDYVTKFUOMPCIASRxznlwebgjhqdyvtkfuompciasr"};
    string word {};
    
    cout << "Please enter a secret message.\n" << endl;
    
    
    string message {};
    getline(cin, message);
    
    cout << endl << "Encrypting message...\n" << endl;
    
    for (auto mes: message){
        if (mes == ' ') {
            cout << ' ';
            word += ' ';
        }
        else {
            int y = alphabet.find(mes);
            cout << key.substr(y,1);
            word += key.substr(y,1);
            
        }
    }    
    
    
    cout << endl << endl << "Decrypting message...\n" << endl;
        
    for (auto mes: word){
        if (mes == ' ') {
            cout << ' ';
        }
        else {
            int y = key.find(mes);
            cout << alphabet.substr(y,1);
        }
    }
    
    cout << endl;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <string>


using namespace std;

class Shallow{
private:
    int *data;
public:
    void set_data_value(int d) { *data = d; }
    int get_data_value() { return *data; }
    // constructor
    Shallow(int d);
    // copy constructor
    Shallow(const Shallow &source);
    // destructor
    ~Shallow();
};

Shallow::Shallow(int d) {
    data = new int;
    *data = d;
}

Shallow::Shallow(const Shallow &source)
    : data (source.data){
        cout << "Copy constructor - shallow copy" << endl;
}

Shallow::~Shallow(){
    delete data;
    cout << "Destructor freeinmg data" << endl;
}

void display_shallow(Shallow s){
    cout << s.get_data_value() << endl;
}

int main(){
    
    Shallow obj1 {100};
    display_shallow(obj1);
    
    Shallow obj2 {obj1};
    obj2.set_data_value(1000);
    
    return 0;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <string>

using namespace std;

class Account {
private:
    // attributes
    string name;
    double balance;
    
public:
    //methods
    //declared inline
    void set_balance(double bal) {balance = bal;}
    double get_balance() { return balance; }
    
    // methods will be declared outside the class declaration
    void set_name(string n);
    string get_name();
    
    bool deposit(double amount);
    bool withdraw(double amount);
};


void Account::set_name(string n){
    name = n;
}

string Account::get_name(){
    return name;
}

bool Account::deposit(double amount) {
    balance += amount;
    return true;
}

bool Account::withdraw(double amount) {
  if(balance-amount >= 0){  
    balance -= amount;
    return true;
  }else {
      return false;
  }
}

int main (){
    Account frank_account;
    frank_account.set_name("Frank's account");
    frank_account.set_balance(1000.00);
    
    if(frank_account.deposit(200.0))
        cout << "Deposit OK" << endl;
    else
        cout << "Deposit now allowed" << endl;
        
    if(frank_account.withdraw(500.0))
        cout << "Withdraw OK" << endl;
    else
        cout << "Not sufficient funds" << endl;
        
    if(frank_account.withdraw(1500.0))
        cout << "Withdraw OK" << endl;
    else
        cout << "Not sufficient funds" << endl;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////

#include <iostream>
#include <string>

using namespace std;

class Player {
public:    
    string name;
    int health;
    int xp;
    
    void talk(string text_to_say){cout << name << " says " << text_to_say << endl;}
    bool is_dead();
};

class Account {
public:
    string name;
    double balance;
    
    bool deposit(double bal) {balance += bal; cout << "In deposit" << endl;}
    bool withdraw(double bal) {balance -= bal; cout << "In withdraw" << endl;}
};

int main (){
    
    Account frank_account;
    frank_account.name = "Frank's account";
    frank_account.balance = 5000.0;
    
    frank_account.deposit(1000.0);
    frank_account.withdraw(500.0);
    
    
    Player frank;
    frank.name = "Frank";
    frank.health = 100;
    frank.xp = 12;
    frank.talk("Hi there");
    
    Player *enemy = new Player;
    (*enemy).name = "Enemy";
    (*enemy).health = 100;
    enemy->xp = 15;
    
    enemy->talk("I will destroy you!");
    
    return 0;
}
