/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baglilisteimpl;

/**
 *
 * @author CASPER
 */
public class Node {
    int data;
    Node next;
    
    public Node(int d){
        data = d;
        next=null;
    }
    
    @Override
    public String toString(){
        return "[" + data + ","+ next+'}';
    }
    
}
