/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banktransactionversion01.model;

/**
 *
 * @author Huynh Cong Hung
 */
public class SummaryStatistics {
    private final double sum;
    
    private final double max;
    
    private final double min;
    
    private final double average;
    
    public SummaryStatistics (final double sum, final double max, final double min,final double average){
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
    }
    
    public double getSum() {
        return sum;
    }
    public double getMax() {
        return max;
    }
    public double getMin() {
        return min;
    }
    public double getAverage() {
        return average;
    }
}
