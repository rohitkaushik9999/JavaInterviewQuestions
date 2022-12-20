package com.hackerearth.example;
import java.util.*;
public class TopHungryCPU {
    int PID;
    int CPU;
    String PROG;
    TopHungryCPU(int PID, int CPU, String PROG){
        this.PID = PID;
        this.CPU = CPU;
        this.PROG = PROG;
    }
    public int getCPU() { return CPU; }
    public int getPID() { return PID; }

    public static int getTopHungryCPU(List<TopHungryCPU> inputs){
        Optional<TopHungryCPU> output = inputs.stream().max(Comparator.comparing(TopHungryCPU::getCPU));
        return output.isPresent() ? output.get().getPID() : 0;
    }

    public static void main(String[] s){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of inputs that you want to enter: ");
        String[] input = new String [sc.nextInt()];
        sc.nextLine();
        System.out.println("Please enter the "+input.length+" records : \n");
        List<TopHungryCPU> inputs = new ArrayList<>();
        for (int i = 0; i < input.length; i++)
        {
            input[i] = sc.nextLine();
            String[] req = input[i].split("\\s+");
            inputs.add(new TopHungryCPU(Integer.valueOf(req[0]), Integer.valueOf(req[1]), req[2]));
        }

        System.out.println("Output of the above input: "+getTopHungryCPU(inputs));
    }
}


