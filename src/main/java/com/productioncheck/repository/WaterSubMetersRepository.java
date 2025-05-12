package com.productioncheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productioncheck.beans.*;
import com.productioncheck.beans.*;

public interface WaterSubMetersRepository extends JpaRepository<WaterSubMeter, EnergyPk>{

}
