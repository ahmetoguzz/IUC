#include <iostream>
using namespace std;

int main(){
    
    cout << "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" << endl;
    cout << "* Please enter the number of one of the following operations: *" << endl;
    cout << "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n" << endl;
    cout << "1 - Addition" << endl;
    cout << "2 - Subtraction" << endl;
    cout << "3 - Multiplication" << endl;
    cout << "4 - Division" << endl;
    cout << "5 - Modulo" << endl;
    
    int operation_num {0};
    cout << "\nOperation that I want to run: ";
    cin >> operation_num;
    
    cout << "\nPlease enter the first number: ";
    double first_number {0.0};
    cin >> first_number;
    cout << "\nPlease enter the second number: ";
    double second_number {0.0};
    cin >> second_number;
    
    double addition = first_number + second_number;
    double subtraction = first_number - second_number;
    double multiplication = first_number * second_number;
    double division = first_number / second_number; 
    int modulo = static_cast<int>(first_number) % static_cast<int>(second_number); // modulo only works with integers so I demoted double numbers to integers. 
    
    if (operation_num == 1) { 
        cout << endl << first_number << " + " << second_number << " = " << addition << endl;
    }   else if (operation_num == 2){ 
        cout << endl << first_number << " - " << second_number << " = " << subtraction << endl;
    }   else if (operation_num == 3){  
        cout << endl << first_number << " * " << second_number << " = " << multiplication << endl;
    }   else if (operation_num == 4){
        cout << endl << first_number << " / " << second_number << " = " << division << endl;
    }   else if (operation_num == 5){
        cout << endl << first_number << " mod " << second_number << " = " << modulo << endl;
    }   else {
        cout << "\nPlease restart the program and enter a number from 1 to 5 in the part of operation you want to run.\n";
    
    }
    
    return 0;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

#include <iostream>
using namespace std;

int main() {
  cout << "****** CALCULATE TEMPERATURE ******" << endl;
  cout << "Please select the temperature unit: \n" << endl;
  cout << "1 - Celcius\n2 - Fahrenheit\n3 - Kelvin\n" << endl;

  int unit{};
  double c{}, f{}, k{}, temperature{};

  cout << "I will use unit: ";
  cin >> unit;
  cout << "\nPlease enter the temperature value: ";
  cin >> temperature;

  switch (unit) {
  case 1:
    f = (temperature * 9 / 5 + 32);
    k = (temperature + 273.15);
    cout << endl
         << temperature << " Celcius = " << f << " Fahrenheit = " << k
         << " Kelvin" << endl;
    break;
  case 2:
    c = ((temperature - 32) * 5 / 9);
    k = ((temperature - 32) * 5 / 9 + 273.15);
    cout << endl
         << temperature << " Fahrenheit = " << c << " Celcius = " << k
         << "Kelvin" << endl;
    break;
  case 3:
    c = (temperature - 273.15);
    f = ((temperature - 273.15) * 9 / 5 + 32);
    cout << endl
         << temperature << " Kelvin = " << c << " Celcius = " << f
         << "Fahrenheit";
    break;
  default:
    cout << "\nInvalid number. Please try selecting a unit 1 to 3.";
  }
  return 0;
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>

using namespace std;

int main() {

  int n{};

  cout << "Please enter the length of spiral: ";
  cin >> n;
  cout << endl << endl;

  for (int i = 1; i <= n / 2; i++) {

    int t = i % 2;

    if (t == 1) {
      for (int j = 1; j < i; j++) {
        cout << "x ";
      }
      cout << endl;
    }

    for (int j = 1; j < i; j++) {
      cout << "x ";
    }

    for (int j = i; j < n / 2; j++) {
      cout << "xx";
    }

    for (int j = i; j <= n / 2; j++) {
      cout << "xx";
    }

    for (int j = 1; j <= i; j++) {
      cout << "x ";
    }

    if (t == 1) {
      cout << endl;
      for (int j = 1; j <= i; j++) {
        cout << "x ";
      }
    }

    cout << endl;
  }

  for (int i = 0; i <= n / 2; i++) {

    int t = i % 2;

    if (t == 1) {
      cout << endl;
    }
    for (int j = i; j < n / 2; j++) {
      cout << "x ";
    }
    for (int j = 1; j <= i; j++) {
      cout << "xx";
    }
    for (int j = 1; j < i + 1;
         j++) { 
      cout << "xx";
    }
    for (int j = i; j < n / 2; j++) {
      cout << "x ";
    }

    if (t == 1) {
      cout << endl;
    }
    cout << endl;
  }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  for (int i{1}; i <= (n + 1) / 2; i++) {
    for (int j = i; j < (n + 1) / 2; j++) {
      cout << "  ";
    }
    for (int j{1}; j <= i; j++) {
      cout << "*";
    }
    cout << endl;
  }

  if (n % 2 == 0) {
    for (int j{1}; j <= n / 2; j++) {
      cout << "*";
    }
    cout << endl;
  }

  for (int i{2}; i <= (n + 1) / 2; i++) {
    for (int j = 1; j < i; j++) {
      cout << "  ";
    }
    for (int j = i; j <= (n + 1) / 2; j++) {
      cout << "*";
    }
    cout << endl;
  }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>

using namespace std;

int main() {

  cout << "Please enter the lenghth of the pattern: ";
  int num{}, tekrar{};
  cin >> num;
  cout << endl << endl;

  for (int i{1}; i <= num; i++) {
    tekrar = i % 4; // 4 satırda bir tekrara bindiği için modunu alıyoruz

    if (tekrar == 1) {
      cout << "   ";
      for (int stars{6}; stars > 0; stars--)
        cout << "*";

    } else if (tekrar == 2) {
      cout << " ";
      for (int stars{10}; stars > 0; stars--)
        cout << "*";

    } else if (tekrar == 3) {
      for (int stars{12}; stars > 0; stars--)
        cout << "*";

    } else if (tekrar == 0) {
      cout << " ";
      for (int stars{10}; stars > 0; stars--)
        cout << "*";
    }
    cout << endl;
  }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>

using namespace std;

int main() {

  int numbers[10];
  int *numbers_ptr[10];

  cout << "Please enter 10 integers." << endl;

  for (int i = 0; i <= 9; i++) {
    numbers_ptr[i] = &numbers[i];
  }

  for (int i = 0; i <= 9; i++) {
    cin >> numbers[i];
  }

  cout << "\nBefore sorting the array: " << endl << endl;

  for (int i = 0; i <= 9; i++) {
    cout << *numbers_ptr[i] << " ";
  }

  for (int i = 0; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      if (j > i) {
        if (*numbers_ptr[j] > *numbers_ptr[i]) {
          int temp = *numbers_ptr[j];
          *numbers_ptr[j] = *numbers_ptr[i];
          *numbers_ptr[i] = temp;
        }
      }
    }
  }

  cout << endl;

  cout << "\nAfter sorting the array: " << endl << endl;

  for (int i = 0; i <= 9; i++) {
    cout << *numbers_ptr[i] << " ";
  }

  cout << endl;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>

using namespace std;

class Tool {
protected:
  int strength;
  char type;

public:
  void setStrength(int s) {
    strength = s; 
  }

  char getType() const {
    return type; 
  }

  int getStrength() const {
    return strength; 
  }
};

class Rock : public Tool {
public:
  Rock(int s) {
    setStrength(s);
    type = 'r';
  }

  bool fight(Tool opponent) {
    int temp_strength = strength;
    if (opponent.getType() == 's') {
      temp_strength *= 2;
    } else if (opponent.getType() == 'p') {
      temp_strength /= 2;
    }
    return temp_strength > opponent.getStrength();
  }
};

class Paper : public Tool {
public:
  Paper(int s) {
    setStrength(s);
    type = 'p';
  }

  bool fight(Tool opponent) {
    int temp_strength = strength;
    if (opponent.getType() == 'r') {
      temp_strength *= 2;
    } else if (opponent.getType() == 's') {
      temp_strength /= 2;
    }
    return temp_strength > opponent.getStrength();
  }
};

class Scissors : public Tool {
public:
  Scissors(int s) {
    setStrength(s);
    type = 's';
  }

  bool fight(Tool opponent) {
    int temp_strength = strength;
    if (opponent.getType() == 'p') {
      temp_strength *= 2;
    } else if (opponent.getType() == 'r') {
      temp_strength /= 2;
    }
    return temp_strength > opponent.getStrength();
  }
};

int main() {
  Scissors s1(8);
  Paper p1(3);
  Rock r1(14);

  cout << "s1 vs p1: " << s1.fight(p1) << " | p1 vs s1: " << p1.fight(s1)
       << endl;
  cout << "p1 vs r1: " << p1.fight(r1) << " | r1 vs p1: " << r1.fight(p1)
       << endl;
  cout << "r1 vs s1: " << r1.fight(s1) << " | s1 vs r1: " << s1.fight(r1)
       << endl;

  return 0;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>
using namespace std;

class MathClass {
public:
  int mathOperation(int a, int b) { return a + b; }

  int mathOperation(int a, int b, int c) { return a - b; }

  int mathOperation(int a, int b, int c, int d) { return a * b; }

  double mathOperation(double a, double b, double c, double d, double e) {
    return a / b;
  }
};

int main() {
  MathClass m;
  int operation, a, b;
  cout << "Please select a math operation: Addition (0) / Subtraction (1) / "
          "Multiplication (2) / Division (3)?\n";
  cin >> operation;
  cout << "Please enter two integer numbers:\n";
  cin >> a >> b;

  if (operation == 0) {
    cout << "Result: " << a << "+" << b << "=" << m.mathOperation(a, b) << "\n";
  } else if (operation == 1) {
    cout << "Result: " << a << "-" << b << "=" << m.mathOperation(a, b, 1)
         << "\n";
  } else if (operation == 2) {
    cout << "Result: " << a << "*" << b << "=" << m.mathOperation(a, b, 1, 1)
         << "\n";
  } else if (operation == 3) {
    if (b == 0) {
      cout << "Error: Division by zero is not allowed.\n";
    } else {
      cout << "Result: " << a << "/" << b << "="
           << m.mathOperation((double)a, (double)b, 1.0, 1.0, 1.0) << "\n";
    }
  } else {
    cout << "Invalid operation selected.\n";
  }

  return 0;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>
#include <string>

using namespace std;

class Student {
private:
  string name;
  int grades[3];

public:
  void setName(string studentName) { name = studentName; }

  string getName() { return name; }

  void setGrades(int grade1, int grade2, int grade3) {
    grades[0] = grade1;
    grades[1] = grade2;
    grades[2] = grade3;
  }

  double Average() { return (grades[0] + grades[1] + grades[2]) / 3; }
};

Student highestAverage(Student students[], int n) {
  int highestIndex = 0;
  for (int i = 1; i < n; i++) {
    if (students[i].Average() > students[highestIndex].Average()) {
      highestIndex = i;
    }
  }
  return students[highestIndex];
}

int main() {
  Student students[5]; // 5 yerine input alabilirdim fakat 5 dediği için sınavda
                       // dokunmadım
  string name;
  int grade1, grade2, grade3;

  cout << "Welcome to the super amazing application that is calculating the "
          "grades of each of every student!"
       << endl
       << endl;

  cout << "Please enter the name of the student first, then leave 1 space "
          "between every statement."
       << endl
       << endl;

  cout << "An example input should look like 'Ahmet 40 30 20' then click "
          "enter. You'll do that for 5 times"
       << endl
       << endl;

  for (int i = 0; i < 5; i++) {
    cout << "Enter name and grades for student " << (i + 1) << ": ";
    cin >> name >> grade1 >> grade2 >>
        grade3; // vakit kalırsa name yerini getline() ile değiştir
    students[i].setName(name);
    students[i].setGrades(grade1, grade2, grade3);
  }

  cout << "\nName:\t\tAverage Grade:\n";
  cout << "---------------------------" << endl;
  for (int i = 0; i < 5; i++) {
    cout << students[i].getName() << "\t\t" << students[i].Average() << "\n";
  }

  Student highest = highestAverage(students, 5);
  cout << "\nThe student with the highest average grade: " << highest.getName()
       << "\t" << highest.Average() << "\n";

  return 0;
}
