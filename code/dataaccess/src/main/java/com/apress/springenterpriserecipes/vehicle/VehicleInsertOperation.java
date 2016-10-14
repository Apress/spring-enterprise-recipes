package com.apress.springenterpriserecipes.vehicle;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class VehicleInsertOperation extends SqlUpdate {

    public VehicleInsertOperation(DataSource dataSource) {
        setDataSource(dataSource);
        setSql("INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
                + "VALUES (?, ?, ?, ?)");
        declareParameter(new SqlParameter(Types.VARCHAR));
        declareParameter(new SqlParameter(Types.VARCHAR));
        declareParameter(new SqlParameter(Types.INTEGER));
        declareParameter(new SqlParameter(Types.INTEGER));
        compile();
    }

    public void perform(Vehicle vehicle) {
        update(new Object[] { vehicle.getVehicleNo(), vehicle.getColor(),
                vehicle.getWheel(), vehicle.getSeat() });
    }
}
