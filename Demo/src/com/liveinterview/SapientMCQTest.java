package com.liveinterview;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
class Node {
    int data;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}

public class SapientMCQTest {
   Node front, rear;
public SapientMCQTest(){
    this.front = this.rear = null;
}
 void put(int key){
    Node temp = new Node(key);
    if(this.rear == null){
        this.front = this.rear = temp;
        return;
    }
    this.rear.next = temp;
    this.rear = temp;
 }

 void get(){
    if(this.front == null)
        return;
    Node temp = this.front;
    this.front = this.front.next;
    if(this.front == null)
        this.rear =null;
 }
  /* void printsomething(){
       Node ptr1 = head;
       Node ptr2 = head;
       while(ptr2 != null && ptr2.next != null){
           ptr2 = ptr2.next.next;
           ptr1 = ptr1.next;
       }
       System.out.println(ptr1.data + "] \n");
   }*/

   public static void main(String[] s){

       SapientMCQTest q = new SapientMCQTest();
       q.put(1);
       q.put(2);
       q.get();;;
       q.get();
       q.put(3);
       q.put(40);
       q.put(50);
       q.get();



while(q.front != null){
    System.out.println(q.front.data);
    q.front = q.front.next;
}

       //new SapientMCQTest().printsomething();


       int[] arr = new int[] {6,3,8,4,9,11};
       int num = 2;
       for(int i=0;i<num;i++){
            int j, first;
            first = arr[0];
            for(j=0;j<arr.length - 1; j++){
                arr[j] = arr[j+1];

            }
            arr[j] = first;

       }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
   }
}
