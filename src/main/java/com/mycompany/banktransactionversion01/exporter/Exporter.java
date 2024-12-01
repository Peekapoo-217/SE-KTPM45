/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.banktransactionversion01.exporter;

import com.mycompany.banktransactionversion01.model.SummaryStatistics;

/**
 *
 * @author Huynh Cong Hung
 */
public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
