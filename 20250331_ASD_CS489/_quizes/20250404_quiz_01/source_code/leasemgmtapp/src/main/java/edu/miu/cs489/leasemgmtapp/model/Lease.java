package edu.miu.cs489.leasemgmtapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Lease {
    private Long       leaseNo;
    private BigDecimal monthlyRentalRate;
    private String    tenant;
    private LocalDate startDate;
    private LocalDate endDate;

    public Lease() {
    }

    public Lease(Long leaseNo, BigDecimal monthlyRentalRate, String tenant, LocalDate startDate, LocalDate endDate) {
        this.leaseNo           = leaseNo;
        this.monthlyRentalRate = monthlyRentalRate;
        this.tenant            = tenant;
        this.startDate         = startDate;
        this.endDate           = endDate;
    }

    public Long getLeaseNo() {
        return leaseNo;
    }

    public void setLeaseNo(Long leaseNo) {
        this.leaseNo = leaseNo;
    }

    public BigDecimal getMonthlyRentalRate() {
        return monthlyRentalRate;
    }

    public void setMonthlyRentalRate(BigDecimal monthlyRentalRate) {
        this.monthlyRentalRate = monthlyRentalRate;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
