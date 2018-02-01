package Task2;
import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
    static Stack<Integer> carA = new Stack<Integer>();
    static Stack<Integer> carB = new Stack<Integer>();
    static Stack<Integer> carC = new Stack<Integer>();
    static int move_number = 0;
            
    public static char getCarLetter(Stack<Integer> tower) {
        if (tower == carA)
            return 'A';
        else if (tower == carB)
            return 'B';
        else if (tower == carC)
            return 'C';
            
        return 'C'; 
    }
    
    public static void CarCargo(Stack<Integer> tower) {
        Stack<Integer> temp_car = new Stack<Integer>();
        
        for (Stack<Integer> i = (Stack<Integer>)tower.clone(); !i.empty(); i.pop()) 
            temp_car.push(new Integer(i.peek()));
            
        System.out.print("[");
        
        while (!temp_car.empty()) {
            System.out.print("" + temp_car.pop());
            
            if (!temp_car.empty()) 
                System.out.print(", ");
        }
        
        System.out.println("]");
    }                              
   
    public static void CurrentState(Stack<Integer> t1, Stack<Integer> t2, Stack<Integer> t3) {
        System.out.println("<-- Move Number: " + move_number);
      
        for (char i = 'A'; i < 'D'; i++) {
            System.out.print("" + i + ": ");
            if (getCarLetter(t1) == i)
                CarCargo(t1);
            else if (getCarLetter(t2) == i)
                CarCargo(t2);
            else
                CarCargo(t3);
        }
        
        System.out.println("");                
    }
    
    public static void CurrentState(Stack<Integer> t1, Stack<Integer> t2, Stack<Integer> t3, char to, char from) {
        System.out.println("" + from + " -> " + to);
        CurrentState(t1, t2, t3);
    }    
    
    public static void moveDisks(int stack_size, Stack<Integer> source, Stack<Integer> location, Stack<Integer> repository) {
        if (stack_size == 1) {
            location.push(new Integer(source.pop()));
            
            move_number++;
            char to = getCarLetter(location);
            char from = getCarLetter(source);
            CurrentState(source, location, repository, to, from);
        }
        else {
            moveDisks(stack_size - 1, source, repository, location);
            
            location.push(source.pop());
            
            move_number++;
            char to = getCarLetter(location);
            char from = getCarLetter(source);
            CurrentState(source, location, repository, to, from);
            
            moveDisks(stack_size - 1, repository, location, source);
        }
    }        
            
    public static void main(String[] args) {
        System.out.print("How many disks on the car? ");
        Scanner scanner = new Scanner(System.in);											
        int num_disks = scanner.nextInt();	
      
        for (int i = num_disks; i>= 1; i--)
            carA.push(new Integer(i));
         
        CurrentState(carA, carB, carC);  
        moveDisks(carA.size(), carA, carC, carB);
        
        System.out.println("Number of Moves: " + move_number);
   }
} 