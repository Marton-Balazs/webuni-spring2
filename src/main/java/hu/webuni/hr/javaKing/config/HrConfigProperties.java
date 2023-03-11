package hu.webuni.hr.javaKing.config;

import hu.webuni.hr.javaKing.model.Employee;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "hr")
@Component
public class HrConfigProperties {

private Employee employee = new Employee();

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static class Employee {
        private Smart smart = new Smart();

        public Smart getSmart() {
            return smart;
        }

        public void setSmart(Smart smart) {
            this.smart = smart;
        }
    }

    public static class Smart {
        private double highPercent;
        private double goodPercent;
        private double lowPercent;
        private double percent;
        private double teenyears;
        private double fiveyears;
        private double twoandhalfyears;

        public double getPercent() {
            return percent;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }

        public double getHighPercent() {
            return highPercent;
        }

        public void setHighPercent(double highPercent) {
            this.highPercent = highPercent;
        }

        public double getGoodPercent() {
            return goodPercent;
        }

        public void setGoodPercent(double goodPercent) {
            this.goodPercent = goodPercent;
        }

        public double getLowPercent() {
            return lowPercent;
        }

        public void setLowPercent(double lowPercent) {
            this.lowPercent = lowPercent;
        }

        public double getTeenyears() {
            return teenyears;
        }

        public void setTeenyears(double teenyears) {
            this.teenyears = teenyears;
        }

        public double getFiveyears() {
            return fiveyears;
        }

        public void setFiveyears(double fiveyears) {
            this.fiveyears = fiveyears;
        }

        public double getTwoandhalfyears() {
            return twoandhalfyears;
        }

        public void setTwoandhalfyears(double twoandhalfyears) {
            this.twoandhalfyears = twoandhalfyears;
        }
    }
}
