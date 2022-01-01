package com.ants.sccl.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ants.sccl.model.DevicePart;
import com.ants.sccl.model.ReplacementModel;
import com.ants.sccl.projections.ReplacementViewSPModel;

@Repository
public interface DevicePartRepository extends JpaRepository<DevicePart, String> {

//	@Query(value="select * from Device_Runbook where End IS NULL and Device_Sensor_Id=?1", nativeQuery = true)
//	void saveRecord(DevicePart devicepart);

//	@Procedure(procedureName = "SP_GetReplacementView")
//	ResponseEntity<ReplacementViewSPModel> SP_GetReplacementView(String deviceCategory);
	
	@Query(value = "call SP_GetReplacementView(:deviceCategory)",nativeQuery = true)
	List<ReplacementViewSPModel> SP_GetReplacement(@Param("deviceCategory")String deviceCategory);
	
	//List<ReplacementViewSPModel> SP_GetReplacement(String deviceCatagory);
	@Query(value = "call SP_Update_Replacent_Stocks(:p_part_id,:p_stock_id,:p_device_name,:p_part_name,:p_replace_quantity,:p_replacement_date)",nativeQuery = true)
//	//@Procedure(procedureName ="SP_Update_Replacent_Stocks")
//	int saveReplacement( ReplacementModel replacementModel);
	int saveReplacement(int p_part_id, int p_stock_id, String p_device_name, String p_part_name, int p_replace_quantity,
			Date p_replacement_date);
}
