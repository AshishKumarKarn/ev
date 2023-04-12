package com.veridic.ev.repository;

import com.veridic.ev.pojo.Station;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface EVRepository extends PagingAndSortingRepository<Station, Long>, CrudRepository<Station, Long> {
    @Transactional
    @Modifying
    @Query("""
            update ev_station e set e.stationName = ?1, e.stationImage = ?2, e.stationId = ?3, e.stationAddress = ?4, e.stationPricing = ?5
            where e.stationId in ?6""")
    int updateByField(@NonNull String stationName, @Nullable String stationImage, @NonNull Long stationId, @Nullable String stationAddress, @NonNull String stationPricing, @NonNull Collection<Long> stationIds);

}
