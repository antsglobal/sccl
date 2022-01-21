package com.ants.sccl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.ants.sccl.model.DeviceMapping;
import com.ants.sccl.projections.ReplacementViewSPModel;

@Repository
public interface DeviceMappingRepository extends JpaRepository<DeviceMapping, String> {

	@Query(value="select Category from IOT_Device_Mapping where Device_Id=?1 ",nativeQuery = true)
	DeviceMapping getBlePair(String ble_pair_Id);

	@Query(value="select * from \r\n"
			+ "(select  \r\n"
			+ "       sum(case when IOT_Device_Mapping.Category = \"Dumper\" then 1 else 0 end) as Total_Dumpers,\r\n"
			+ "       sum(case when IOT_Device_Mapping.Category = \"Shovel\" then 1 else 0 end) as Total_Shovels,\r\n"
			+ "       sum(case when IOT_Device_Mapping.Category = \"Unloading\" then 1 else 0 end) as Total_Unloading_points\r\n"
			+ "                              from IOT_Device_Mapping\r\n"
			+ "        )  TotalCount\r\n"
			+ "",nativeQuery=true)
	List<?> getCountofDumperShovels();

	@Query(value="select * from IOT_Device_Mapping where IOT_Device_Mapping.Category=?1",nativeQuery = true)
	List<DeviceMapping> getAllDumpers(String deviceCategory);

	@Query(value=" select * from SCCL_Demo.IOT_Device_Mapping where Category in ('Loader', 'Driller')",nativeQuery = true)
	List<DeviceMapping> findLoaderDriller();

	//@Query(value="select * from Dumper_Device_Mapping where Dumper_Device_Mapping.Category=?1",nativeQuery = true)

	//@Procedure("SP_GetReplacementView")
//	@Query(value = "call SP_GetReplacementView(:deviceCategory)",nativeQuery = true)
//	List<ReplacementViewSPModel> SP_GetReplacement(@Param("deviceCategory")String deviceCategory);

}
