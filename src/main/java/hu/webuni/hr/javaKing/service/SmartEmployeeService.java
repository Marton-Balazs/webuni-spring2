package hu.webuni.hr.javaKing.service;

import hu.webuni.hr.javaKing.config.HrConfigProperties;
import hu.webuni.hr.javaKing.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SmartEmployeeService implements EmployeeService {

    private static final int DAYS = 365;

    @Autowired
    HrConfigProperties config;

//    @Value("${hr.employee.smart.highPercent}")
//    private int highPercent;
//
//    @Value("${hr.employee.smart.goodPercent}")
//    private int goodPercent;
//
//    @Value("${hr.employee.smart.lowPercent}")
//    private int lowPercent;
//
//    @Value("${hr.employee.smart.percent}")
//    private int percent;
//
//    @Value("${hr.employee.smart.teenyears}")
//    private double teenyears;
//
//    @Value("${hr.employee.smart.fiveyears}")
//    private double fiveyears;
//
//    @Value("${hr.employee.smart.twoandhalfyears}")
//    private double twoandhalfyears;
    @Override
    public int getPayRaisePercent(Employee employee) {
        LocalDateTime startDate = employee.getStartDate();
        LocalDateTime now = LocalDateTime.now();

        long diff = ChronoUnit.DAYS.between(startDate, now)  / DAYS;
        System.out.println("years at the company: " + diff);

//        first part of the homework:
//        if (diff >= teenyears) {return highPercent;}
//        if (diff >= fiveyears && diff < teenyears) {return goodPercent;}
//        if (diff >= twoandhalfyears && diff < fiveyears) {return lowPercent;}
//        else {return percent;}

//        if (diff >= config.getEmployee().getSmart().getTeenyears() * DAYS) {
//            return (int) config.getEmployee().getSmart().getHighPercent();
//        }
//        if (diff >= config.getEmployee().getSmart().getFiveyears() * DAYS) {
//            return (int) config.getEmployee().getSmart().getGoodPercent();
//        }
//        if (diff >= config.getEmployee().getSmart().getTwoandhalfyears() * DAYS) {
//            return (int) config.getEmployee().getSmart().getLowPercent();
//        }
//        else {
//            return (int) config.getEmployee().getSmart().getPercent();
//        }

        TreeMap<Double, Integer> years = config.getEmployee().getSmart().getYears();

        Map.Entry<Double, Integer> map = years.floorEntry((double) diff);
        if (map == null) {
            return 0;
        }
        else {
            return map.getValue();
        }
    }
}
