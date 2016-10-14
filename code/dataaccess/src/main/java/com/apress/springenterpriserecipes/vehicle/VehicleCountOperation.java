package com.apress.springenterpriserecipes.vehicle;

import javax.sql.DataSource;

import org.springframework.jdbc.object.SqlFunction;

public class VehicleCountOperation extends SqlFunction {

    public VehicleCountOperation(DataSource dataSource) {
        setDataSource(dataSource);
        setSql("SELECT COUNT(*) FROM VEHICLE");
        compile();
    }

    public int perform() {
        return run();
    }
}
